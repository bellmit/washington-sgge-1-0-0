package com.qat.samples.sysmgmt.nf.model.classes;

import com.fincatto.nfe310.classes.NFNotaInfoItemProdutoVeiculoCondicao;

public enum NFNotaInfoItemProdutoVeiculoCondicao {

    ACABADO("1"),
    INACABADO("2"),
    SEMI_ACABADO("3");

    private final String codigo;

    private NFNotaInfoItemProdutoVeiculoCondicao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoVeiculoCondicao valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoVeiculoCondicao tipo : NFNotaInfoItemProdutoVeiculoCondicao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
