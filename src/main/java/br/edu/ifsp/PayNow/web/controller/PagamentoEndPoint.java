package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.sessao.CacheRepository;
import br.edu.ifsp.PayNow.sessao.SessaoUsuario;
import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import javax.inject.Inject;

@Controller
public class PagamentoEndPoint {
    @Inject
    private Result result;


    @Consumes("application/json")
    @Post("/api/nova_compra")
    public void novaCompra(PagamentoRequest pagamentoRequest) {
       CacheRepository.registrarPagamentoNaSessao(pagamentoRequest);
        result.redirectTo(PagamentoController.class).selecionaPagamento();
    }
}
