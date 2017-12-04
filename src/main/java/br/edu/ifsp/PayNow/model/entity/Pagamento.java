package br.edu.ifsp.PayNow.model.entity;

import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Usuario recebedor;
    @ManyToOne
    private Usuario pagador;
    @Embedded
    private FormaPagamento metodoPagamento;
    @Enumerated(EnumType.STRING)
    private StatusDoPagamento status;
    private BigDecimal valor;
    private Date dataDeRequisicao = new Date();
    private String idVendaRecebedor;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Usuario recebedor) {
        this.recebedor = recebedor;
    }

    public Usuario getPagador() {
        return pagador;
    }

    public void setPagador(Usuario pagador) {
        this.pagador = pagador;
    }

    public FormaPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(FormaPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusDoPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusDoPagamento status) {
        this.status = status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataDeRequisicao() {
        return dataDeRequisicao;
    }

    public void setDataDeRequisicao(Date dataDeRequisicao) {
        this.dataDeRequisicao = dataDeRequisicao;
    }
}
