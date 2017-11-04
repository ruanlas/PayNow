package br.edu.ifsp.PayNow.web.request;

import br.edu.ifsp.PayNow.model.entity.Pagamento;
import br.edu.ifsp.PayNow.model.entity.PagamentoBoleto;
import br.edu.ifsp.PayNow.model.entity.PagamentoCredito;
import br.edu.ifsp.PayNow.model.enuns.MetodoPagamento;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renato on 25/10/17.
 */
public class PagamentoRequest {
    public Long idRequest;
    public BigDecimal valor;
    public String redirecionarPara;
    public String recebedor;
    public String pagador;
    public String metodoPagamento;
    public String numeroCartao;
    public String dataVencimento;
    public String digitosVerificadores;

    @Inject
    private UsuarioRepository usuarioRepository;

    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getRedirecionarPara() {
        return redirecionarPara;
    }

    public void setRedirecionarPara(String redirecionarPara) {
        this.redirecionarPara = redirecionarPara;
    }

    public Pagamento toPagamento(UsuarioRepository usuarioRepository) {
        Pagamento pagamento = new Pagamento();;
        pagamento.setId(null);
        pagamento.setDataDeRequisicao(new Date());
        pagamento.setPagador(usuarioRepository.comId(Long.parseLong(this.pagador)));
        pagamento.setRecebedor(usuarioRepository.comId(Long.parseLong(this.pagador)));
        if(MetodoPagamento.valueOf(this.metodoPagamento) == MetodoPagamento.CARTAO_DE_CREDITO) {
            PagamentoCredito pagamentoCredito = new PagamentoCredito();
            pagamentoCredito.setNumeroCartao(this.numeroCartao);
            pagamentoCredito.setVencimento(this.dataVencimento);
            pagamentoCredito.setDigitosVerificadores(this.digitosVerificadores);
            pagamento.setMetodoPagamento(pagamentoCredito);
        } else {
            if(MetodoPagamento.valueOf(this.metodoPagamento) == MetodoPagamento.BOLETO){
                PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
                final Long tresDiasInMills  = new Long(1000 * 60 * 60 * 24 * 3);
                final Date dataVencimento = new Date(new Date().getTime() + tresDiasInMills);
                pagamentoBoleto.setDataVencimento(dataVencimento);
                pagamento.setMetodoPagamento(pagamentoBoleto);
            }
        }
        pagamento.setValor(this.valor);

        return pagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDigitosVerificadores() {
        return digitosVerificadores;
    }

    public void setDigitosVerificadores(String digitosVerificadores) {
        this.digitosVerificadores = digitosVerificadores;
    }
}
