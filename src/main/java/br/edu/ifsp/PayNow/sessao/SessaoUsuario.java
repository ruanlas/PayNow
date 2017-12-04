package br.edu.ifsp.PayNow.sessao;



import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
public class SessaoUsuario implements Serializable {

	private long serialVersionUID;

	private String usuario;


	public void fazerLogin(String usuario) {
		this.usuario = usuario;
	}

	public void fazerLogout() {
		usuario = null;
	}

	public boolean estahLogado() {
		return usuario != null;
	}

	public String getUsuario() {
		return usuario;
	}




}
