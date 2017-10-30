package br.edu.ifsp.PayNow.web.request;

import java.math.BigDecimal;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoRequest {
    Long idRequest;
    BigDecimal valor;
    String redirectTo;
}
