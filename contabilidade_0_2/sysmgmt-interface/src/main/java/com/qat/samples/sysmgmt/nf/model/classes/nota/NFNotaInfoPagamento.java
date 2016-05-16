package com.qat.samples.sysmgmt.nf.model.classes.nota;

import java.math.BigDecimal;

import com.qat.samples.sysmgmt.nf.model.classes.NFBase;

public class NFNotaInfoPagamento extends NFBase {

    //@Element(name = "tPag", required = true)
    private NFFormaPagamentoMoeda formaPagamentoMoeda;

    //@Element(name = "vPag", required = true)
    private String valorPagamento;

    //@Element(name = "card", required = false)
    private NFNotaInfoCartao cartao;

    public void setCartao(final NFNotaInfoCartao cartao) {
        this.cartao = cartao;
    }

    public void setFormaPagamentoMoeda(final NFFormaPagamentoMoeda formaPagamentoMoeda) {
        this.formaPagamentoMoeda = formaPagamentoMoeda;
    }

//    public void setValorPagamento(final BigDecimal valorPagamento) {
//        this.valorPagamento = BigDecimalParser.tamanho15Com2CasasDecimais(valorPagamento);
//    }

    public NFFormaPagamentoMoeda getFormaPagamentoMoeda() {
        return this.formaPagamentoMoeda;
    }

    public String getValorPagamento() {
        return this.valorPagamento;
    }

    public NFNotaInfoCartao getCartao() {
        return this.cartao;
    }
}