package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.*;
import javax.inject.Inject;

import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.model.entity.Usuario;

@Controller
public class UsuarioController {

    @Inject
    private Result result;

    @Inject
    UsuarioRepository usuarioRepository;

    public void lista() {
        result.include("pagandores", usuarioRepository.todas());
    }



}
