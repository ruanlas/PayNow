package br.edu.ifsp.PayNow.model.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensalidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date dataFechamento;
	private Date dataVencimento;
	private double valorMensalidade;
	private String obs;
	private boolean mensalidadePaga;
	private Usuario recebedor;
	private Gerente gerente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public double getValorMensalidade() {
		return valorMensalidade;
	}
	public void setValorMensalidade(double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public boolean isMensalidadePaga() {
		return mensalidadePaga;
	}
	public void setMensalidadePaga(boolean mensalidadePaga) {
		this.mensalidadePaga = mensalidadePaga;
	}
	public Usuario getRecebedor() {
		return recebedor;
	}
	public void setRecebedor(Usuario recebedor) {
		this.recebedor = recebedor;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
}
