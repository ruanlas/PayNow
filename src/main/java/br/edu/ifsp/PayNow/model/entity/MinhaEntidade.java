package br.edu.ifsp.PayNow.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MinhaEntidade {

	@Id
	@GeneratedValue
	private Long id;

	private Integer numero;
	private String texto;

	MinhaEntidade() {
	}

	public MinhaEntidade(int numero, String texto) {
		this.numero = numero;
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
