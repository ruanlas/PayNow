package br.edu.ifsp.PayNow.sessao;

import br.edu.ifsp.PayNow.web.request.PagamentoRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Idéia era colocar um redis, na verdade
 */
public class CacheRepository {
    private static Map<String, PagamentoRequest> pagamentoRequestMap = new HashMap<>();

    public static void registrarPagamentoNaSessao(PagamentoRequest pagamentoRequest) {
       pagamentoRequestMap.put(pagamentoRequest.pagador, pagamentoRequest);
    }

    public static void retirarPagamentoDaSessao(String pagador) {
        pagamentoRequestMap.remove(pagador);
    }

    public static PagamentoRequest getPagamentoRequestMap(String pagador) {
        return pagamentoRequestMap.get(pagador);
    }
}
