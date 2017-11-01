package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.RequisicaoPagamento;
import br.edu.ifsp.PayNow.model.entity.Usuario;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by renato on 25/10/17.
 */
@Controller
public class PagamentoController {

    @Inject
    private Result result;

//    consumes("application/json")
//    produces("application/json")
//    @Post("/api/requerer_pagamento")
//    public void requererPagamento() {
//        result.header("ID DA REQUISIÇÃO");
////        result.redirectTo(PagamentoController.class).selecionaPagamento();
//    }

    public void selecionaPagamento() {
        RequisicaoPagamento requisicaoPagamento = new RequisicaoPagamento(new Usuario(), new String(), new Date(), new Pagamento(), new BigDecimal(11));
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Usuário 1");
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Usuário 2");
        usuario2.setId(2L);
        usuarios.add((usuario1));
        usuarios.add(usuario2);
        result.include("usuarios", usuarios);
        result.include("pagamento", requisicaoPagamento);

    }

    public void confirmacao() {
        //Persist

    }


}
