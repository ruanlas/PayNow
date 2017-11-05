package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.RequisicaoPagamento;
import br.edu.ifsp.PayNow.model.entity.Usuario;
import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamento;
import br.edu.ifsp.PayNow.model.repository.PagamentoRepository;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
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
        while (valor < 0) {
            valor = new Random().nextInt(2000);
        }
        PagamentoRequest pagamentoRequest = new PagamentoRequest();
        pagamentoRequest.setRedirecionarPara("http://www.uol.com.br");
        pagamentoRequest.setValor(new BigDecimal(valor/100));

        //Cria Mock
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Usuário 1");
        usuario1.setId(null);
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Usuário 2");
        usuario2.setId(null);
        usuarioRepository.salvar(usuario1);
        usuarioRepository.salvar(usuario2);

        result.include("usuarios", usuarioRepository.todas());
        result.include("pagamentoRequest", pagamentoRequest);

    }

    public void confirmacao(PagamentoRequest pagamentoRequest) {
        Pagamento pagamento = pagamentoRequest.toPagamento(usuarioRepository);
        Integer randomIndex = Math.abs(new Random().nextInt(StatusDoPagamento.values().length));
        pagamento.setStatus(StatusDoPagamento.values()[randomIndex]);
        pagamentoRepository.salvar(pagamento);
        result.redirectTo(PagamentoController.class).statusPagamentos();

    }

    public void statusPagamentos() {
        result.include("pagamentos", pagamentoRepository.todas());
    }


}
