package br.edu.ifsp.PayNow.model.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
public class RequisicaoPagamento {
    Usuario recebedor;
    String redirecionarPara;
    Date dataDeRequisicao;
    Pagamento pagamento;

    public RequisicaoPagamento() {
    }

    public RequisicaoPagamento(Usuario recebedor, String redirecionarPara, Date dataDeRequisicao, Pagamento pagamento, BigDecimal valor) {
        this.recebedor = recebedor;
        this.redirecionarPara = redirecionarPara;
        this.dataDeRequisicao = dataDeRequisicao;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    BigDecimal valor;

    public Usuario getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Usuario recebedor) {
        this.recebedor = recebedor;
    }

    public String getRedirecionarPara() {
        return redirecionarPara;
    }

    public void setRedirecionarPara(String redirecionarPara) {
        this.redirecionarPara = redirecionarPara;
    }

    public Date getDataDeRequisicao() {
        return dataDeRequisicao;
    }

    public void setDataDeRequisicao(Date dataDeRequisicao) {
        this.dataDeRequisicao = dataDeRequisicao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
