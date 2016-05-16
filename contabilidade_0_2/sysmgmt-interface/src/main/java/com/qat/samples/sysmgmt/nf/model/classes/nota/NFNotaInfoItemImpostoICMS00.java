package com.qat.samples.sysmgmt.nf.model.classes.nota;

import com.qat.samples.sysmgmt.nf.model.classes.NFBase;
import com.qat.samples.sysmgmt.nf.model.classes.NFNotaInfoImpostoTributacaoICMS;
import com.qat.samples.sysmgmt.nf.model.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalculo;
import com.qat.samples.sysmgmt.nf.model.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS00 extends NFBase {

    //@Element(name = "orig", required = true)
    private NFOrigem origem;

    //@Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    //@Element(name = "modBC", required = true)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidadeBaseCalculo;

    //@Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    //@Element(name = "pICMS", required = true)
    private String percentualAliquota;

    //@Element(name = "vICMS", required = true)
    private String valorTributo;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_INTEGRALMENTE)) {
            throw new IllegalStateException("Situacao tributaria invalida");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setModalidadeBaseCalculo(final NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidadeBaseCalculo) {
        this.modalidadeBaseCalculo = modalidadeBaseCalculo;
    }

//    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
//        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
//    }
//
//    public void setPercentualAliquota(final BigDecimal aliquota) {
//        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota);
//    }
//
//    public void setValorTributo(final BigDecimal valorTributo) {
//        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
//    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public NFNotaInfoItemImpostoICMSModalidadeBaseCalculo getModalidadeBaseCalculo() {
        return this.modalidadeBaseCalculo;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }
}
