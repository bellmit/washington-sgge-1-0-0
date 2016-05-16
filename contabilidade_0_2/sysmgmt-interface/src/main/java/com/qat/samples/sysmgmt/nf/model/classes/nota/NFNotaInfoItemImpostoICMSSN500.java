package com.qat.samples.sysmgmt.nf.model.classes.nota;

import java.math.BigDecimal;

import com.qat.samples.sysmgmt.nf.model.classes.NFBase;
import com.qat.samples.sysmgmt.nf.model.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.qat.samples.sysmgmt.nf.model.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN500 extends NFBase {
    //@Element(name = "orig", required = true)
    private NFOrigem origem;

    //@Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    //@Element(name = "vBCSTRet", required = false)
    private String valorBCICMSSTRetido;

    //@Element(name = "vICMSSTRet", required = false)
    private String valorICMSSTRetido;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

//    public void setValorBCICMSSTRetido(final BigDecimal valorBCICMSSTRetido) {
//        this.valorBCICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSSTRetido);
//    }
//
//    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
//        this.valorICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTRetido);
//    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public String getValorBCICMSSTRetido() {
        return this.valorBCICMSSTRetido;
    }

    public String getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
    }
}