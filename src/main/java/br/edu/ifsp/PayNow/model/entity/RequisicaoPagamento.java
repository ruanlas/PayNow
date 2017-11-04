package br.edu.ifsp.PayNow.model.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
public class RequisicaoPagamento {
//    Usuario recebedor;
    String redirecionarPara;
    Pagamento pagamento;


    public RequisicaoPagamento(String redirecionarPara, Pagamento pagamento) {
//        this.recebedor = recebedor;
        this.redirecionarPara = redirecionarPara;
        this.pagamento = pagamento;
    }


//    public Usuario getRecebedor() {
//        return recebedor;
//    }
//
//    public void setRecebedor(Usuario recebedor) {
//        this.recebedor = recebedor;
//    }

    public String getRedirecionarPara() {
        return redirecionarPara;
    }

    public void setRedirecionarPara(String redirecionarPara) {
        this.redirecionarPara = redirecionarPara;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }



}
