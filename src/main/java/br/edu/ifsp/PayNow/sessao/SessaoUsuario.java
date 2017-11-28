package br.edu.ifsp.PayNow.sessao;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessaoUsuario implements Serializable {

	private long serialVersionUID;

	private boolean logado = false;

	public void fazerLogin() {
		logado = true;
	}

	public void fazerLogout() {
		logado = false;
	}

	public boolean estahLogado() {
		return logado;
	}

}
