package com.qat.samples.sysmgmt.nf.model.classes.nota;

import com.qat.samples.sysmgmt.nf.model.classes.NFBase;

public class NFNotaInfoCartao extends NFBase {

    //@Element(name = "tpIntegra", required = true)
    private NFTipoIntegracaoPagamento tipoIntegracao;

    //@Element(name = "CNPJ", required = true)
    private String cnpj;

    //@Element(name = "tBand", required = true)
    private NFOperadoraCartao operadoraCartao;

    //@Element(name = "cAut", required = true)
    private String numeroAutorizacaoOperacaoCartao;

    public void setCnpj(final String cnpj) {
    //    StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setNumeroAutorizacaoOperacaoCartao(final String numeroAutorizacaoOperacaoCartao) {
     //   StringValidador.tamanho20(numeroAutorizacaoOperacaoCartao);
        this.numeroAutorizacaoOperacaoCartao = numeroAutorizacaoOperacaoCartao;
    }

    public void setOperadoraCartao(final NFOperadoraCartao operadoraCartao) {
        this.operadoraCartao = operadoraCartao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getNumeroAutorizacaoOperacaoCartao() {
        return this.numeroAutorizacaoOperacaoCartao;
    }

    public NFOperadoraCartao getOperadoraCartao() {
        return this.operadoraCartao;
    }

    public NFTipoIntegracaoPagamento getTipoIntegracao() {
        return tipoIntegracao;
    }

    public void setTipoIntegracao(NFTipoIntegracaoPagamento tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }
}