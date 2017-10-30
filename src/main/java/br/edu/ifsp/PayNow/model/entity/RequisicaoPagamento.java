package br.edu.ifsp.PayNow.model.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
public class RequisicaoPagamento {
    String redirecionarPara;
    Date dataDeRequisicao;
    Pagamento pagamento;
    BigDecimal valor;
}
