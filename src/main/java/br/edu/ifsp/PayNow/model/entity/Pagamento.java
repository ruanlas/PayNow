package br.edu.ifsp.PayNow.model.entity;

import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamento;

import java.math.BigDecimal;

/**
 * Created by renato on 25/10/17.
 */
public class Pagamento {
    Usuario recebedor;
    Usuario pagador;
    FormaPagamento metodoPagamento;
    StatusDoPagamento status;
    BigDecimal valor;

}
