package br.edu.ifsp.PayNow.model.entity;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoCredito extends FormaPagamento {
    private String numeroCartao;
    private String vencimento;
    private String digitosVerificadores;


    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getDigitosVerificadores() {
        return digitosVerificadores;
    }

    public void setDigitosVerificadores(String digitosVerificadores) {
        this.digitosVerificadores = digitosVerificadores;
    }

}
