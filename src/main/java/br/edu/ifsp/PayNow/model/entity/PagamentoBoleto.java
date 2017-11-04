package br.edu.ifsp.PayNow.model.entity;

import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoBoleto extends FormaPagamento {
    String numeroBoleto;
     Date dataVencimento;

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
