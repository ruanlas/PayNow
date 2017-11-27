package br.edu.ifsp.PayNow.web.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Gerente;
import br.edu.ifsp.PayNow.model.repository.GerenteRespository;

@Controller
public class GerenteController {

	@Inject
    private Result result;
	
	@Inject
	private GerenteRespository gerenteRespository;
	
	public void lista() {
        result.include("gerentes", gerenteRespository.todos());
    }

    public void adiciona() {

    }
    
    public void salva(Gerente gerente) {
        gerenteRespository.salvar(gerente);
        result.redirectTo(GerenteController.class).resumo(gerente);
    }

    public void resumo(Gerente gerente) {
        result.include("resumo", gerente);
    }
}
