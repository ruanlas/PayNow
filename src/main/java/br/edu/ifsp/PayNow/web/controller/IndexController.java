package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Usuario;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;

import javax.inject.Inject;

@Controller
public class IndexController {
    @Inject
    private Result result;

    @Inject
    UsuarioRepository usuarioRepository;

    @Get("/")
    public void index() {
        result.redirectTo(IndexController.class).home();
    }

    public void home() {

    }

    public void login() {

    }

    public void adiciona() {

    }

    public void salva(Usuario usuario) {
        usuarioRepository.salvar(usuario);
        result.redirectTo(IndexController.class).resumo(usuario);
    }

    public void resumo(Usuario usuario) {
        result.include("resumo", usuario);
    }

}
