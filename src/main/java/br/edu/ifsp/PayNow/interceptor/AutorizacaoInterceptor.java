package br.edu.ifsp.PayNow.interceptor;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerInstance;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.ifsp.PayNow.sessao.SessaoUsuario;
import br.edu.ifsp.PayNow.web.controller.IndexController;
import br.edu.ifsp.PayNow.web.controller.PagamentoController;
import br.edu.ifsp.PayNow.web.controller.UsuarioController;

import javax.inject.Inject;

@Intercepts
public class AutorizacaoInterceptor {

	@Inject
	private PagamentoController pagamentoController;

	@Inject
	private UsuarioController usuarioController;

	@Inject
	private IndexController indexController;

	@Inject
	private SessaoUsuario sessao;

	@Inject
	private Result result;

	@AroundCall
	public void intercept(SimpleInterceptorStack stack,
			ControllerInstance controllerInstance) {
		System.out.println("Passou pelo intercept!");
		if (controllerInstance.getController().equals(indexController) ||
				sessao.estahLogado()) {
			stack.next();
		} else {
			result.redirectTo(IndexController.class).login();
		}
	}

}
