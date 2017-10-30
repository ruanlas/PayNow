package br.edu.ifsp.PayNow.model.entity;

import br.edu.ifsp.PayNow.model.enuns.StatusDoPagamentoBoleto;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoBoleto extends Pagamento {
    String numeroBoleto;
    StatusDoPagamentoBoleto status;
}
