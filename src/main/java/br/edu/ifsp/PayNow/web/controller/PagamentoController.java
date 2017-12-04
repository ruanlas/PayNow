package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.Usuario;
import br.edu.ifsp.PayNow.model.enuns.MetodoPagamento;
import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamento;
import br.edu.ifsp.PayNow.model.repository.PagamentoRepository;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.sessao.CacheRepository;
import br.edu.ifsp.PayNow.sessao.SessaoUsuario;
import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by renato on 25/10/17.
 */
@Controller
public class PagamentoController {

    @Inject
    private Result result;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private PagamentoRepository pagamentoRepository;

    @Inject
    private SessaoUsuario sessaoUsuario;


    @Transactional
    public void selecionaPagamento() {
        PagamentoRequest pagamentoRequest = CacheRepository.getPagamentoRequestMap(sessaoUsuario.getUsuario());
        if(pagamentoRequest  == null) {
            result.redirectTo(IndexController.class).home();
        }
        result.include("usuarios", usuarioRepository.todas());
        result.include("pagamentoRequest",pagamentoRequest);

    }

    public void confirmacao(PagamentoRequest pagamentoRequest) throws ParseException {
        if(pagamentoRequest == null) {
            result.redirectTo(IndexController.class).home();
        }
        CacheRepository.retirarPagamentoDaSessao(sessaoUsuario.getUsuario());
        Pagamento pagamento = pagamentoRequest.toPagamento(usuarioRepository);
        if (pagamento.getRecebedor() == null) {
            throw new IllegalArgumentException("Recebedor inválido");
        }
        List<StatusDoPagamento> statusDoPagamentosCredito = new ArrayList<>();
        statusDoPagamentosCredito.add(StatusDoPagamento.APROVADA);
        statusDoPagamentosCredito.add(StatusDoPagamento.NAO_AUTORIZADO);
        statusDoPagamentosCredito.add(StatusDoPagamento.PENDENTE);
        List<StatusDoPagamento> statusDoPagamentosDebito = new ArrayList<>();
        statusDoPagamentosDebito.add(StatusDoPagamento.APROVADA);
        statusDoPagamentosDebito.add(StatusDoPagamento.PENDENTE);
        statusDoPagamentosDebito.add(StatusDoPagamento.PAGA_PARCIALMENTE);
        statusDoPagamentosDebito.add(StatusDoPagamento.VENCIDA);

        if(pagamentoRequest.metodoPagamento.equals(MetodoPagamento.CARTAO_DE_CREDITO.toString())) {
            pagamento.setStatus(statusDoPagamentosCredito.get(Math.abs(new Random().nextInt(statusDoPagamentosCredito.size()))));
        } else {
            pagamento.setStatus(statusDoPagamentosDebito.get(Math.abs(new Random().nextInt(statusDoPagamentosDebito.size()))));
        }

        if (pagamento.getStatus() == StatusDoPagamento.APROVADA) {
            Usuario recebedor = pagamento.getRecebedor();
            recebedor.setSaldo(recebedor.getSaldo().add(pagamento.getValor()));
            recebedor.setEhRecebedor(true);
            usuarioRepository.salvar(recebedor);
        }
        pagamentoRepository.salvar(pagamento);
        result.redirectTo(PagamentoController.class).statusPagamentos();

    }

    public void statusPagamentos() {
        result.include("pagamentos", pagamentoRepository.todas());
    }



}
