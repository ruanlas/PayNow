package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Usuario;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.sessao.SessaoUsuario;

import javax.inject.Inject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class IndexController  {
    @Inject
    private Result result;



    @Inject
    private SessaoUsuario sessaoUsuario;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Get("/")
    public void index() {
        result.redirectTo(IndexController.class).home();
    }


    public void home() {

    }

    public void login() {

    }

    public void entra(String email, String senha ) {
        Usuario usuario = usuarioRepository.buscaPorEmail(email);
        if(usuario == null) {
            result.notFound();
        }
        if(usuario.getSenha().equals(convertToMD5(senha))) {
            sessaoUsuario.fazerLogin(usuario.getEmail());
        }
        result.redirectTo(IndexController.class).home();
    }

    public void adiciona() {

    }

    public void salva(Usuario usuario) {

        if(usuarioRepository.buscaPorEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("Usuário já existente!");
        }
        usuario.setSenha(convertToMD5(usuario.getSenha()));
        usuarioRepository.salvar(usuario);
        result.redirectTo(IndexController.class).resumo(usuario);
    }

    public void resumo(Usuario usuario) {
        result.include("resumo", usuario);
    }

    private String  convertToMD5(String text)  {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(text.getBytes(),0,text.length());
        System.out.println("MD5: " + new BigInteger(1,md5.digest()).toString(16));
        return new BigInteger(1,md5.digest()).toString(16);
    }

}
