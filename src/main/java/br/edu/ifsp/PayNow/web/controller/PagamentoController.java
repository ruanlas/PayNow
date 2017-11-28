package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.RequisicaoPagamento;
import br.edu.ifsp.PayNow.model.entity.Usuario;
import br.edu.ifsp.PayNow.model.enuns.MetodoPagamento;
import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamento;
import br.edu.ifsp.PayNow.model.repository.PagamentoRepository;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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



//    consumes("application/json")
//    produces("application/json")
//    @Post("/api/requerer_pagamento")
//    public void requererPagamento() {
//        result.header("ID DA REQUISIÇÃO");
////        result.redirectTo(PagamentoController.class).selecionaPagamento();
//    }

    @Transactional
    public void selecionaPagamento() {
        Integer valor = new Random().nextInt(2000);
        while (valor <= 0) {
            valor = new Random().nextInt(2000);
        }
        PagamentoRequest pagamentoRequest = new PagamentoRequest();
        pagamentoRequest.setRedirecionarPara("http://www.uol.com.br");
        pagamentoRequest.setValor(new BigDecimal(valor/100));
        result.include("usuarios", usuarioRepository.todas());
        result.include("pagamentoRequest", pagamentoRequest);

    }

    public void confirmacao(PagamentoRequest pagamentoRequest) throws ParseException {
        Pagamento pagamento = pagamentoRequest.toPagamento(usuarioRepository);
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
        pagamentoRepository.salvar(pagamento);
        result.redirectTo(PagamentoController.class).statusPagamentos();

    }

    public void statusPagamentos() {
        result.include("pagamentos", pagamentoRepository.todas());
    }


}
