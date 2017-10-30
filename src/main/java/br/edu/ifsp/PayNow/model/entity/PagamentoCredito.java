package br.edu.ifsp.PayNow.model.entity;

import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamentoBoleto;
import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamentoCredito;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoCredito extends Pagamento {
    String numeroCartao;
    StatusDoPagamentoCredito status;
}
