package br.edu.ifsp.PayNow.web.controller;

import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifsp.PayNow.model.entity.Mensalidade;
import br.edu.ifsp.PayNow.model.repository.MensalidadesRepository;

@Controller
public class MensalidadeController {
	@Inject
    private Result result;
	
	@Inject
	private MensalidadesRepository mensalidadesRepository;
	
	public void lista() {
		result.include("mensalidades", mensalidadesRepository.todas());
	}
	
	public void adciona() {
		
	}
	
	public void salva(Mensalidade mensalidade) {
		mensalidadesRepository.salvar(mensalidade);
		result.redirectTo(MensalidadeController.class).resumo(mensalidade);
	}
	
	public void resumo(Mensalidade mensalidade) {
		result.include("resumo", mensalidade);
	}
	
	public void listamensalidadesmes(Date date) {
		result.include("mensalidades", mensalidadesRepository.vencimentoDoMesAno(date));
	}
}
