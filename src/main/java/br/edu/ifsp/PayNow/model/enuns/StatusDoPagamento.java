package br.edu.ifsp.PayNow.model.enuns;

/**
 * Created by renato on 25/10/17.
 */
public enum StatusDoPagamento {
    PENDENTE("PENDENTE"), VENCIDA("VENCIDA"), APROVADA("APROVADA"), NAO_AUTORIZADO("NÃO AUTORIZADO"), PAGA_PARCIALMENTE("PAGA PARCIALMENTE");
    private final String text;

    private StatusDoPagamento(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
