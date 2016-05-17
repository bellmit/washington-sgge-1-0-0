package com.qat.samples.sysmgmt.nf.model.classes;

import com.fincatto.nfe310.classes.NFTipo;

public enum NFTipo {

    ENTRADA("0"),
    SAIDA("1");

    private final String codigo;

    private NFTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipo valueOfCodigo(final String codigo) {
        for (final NFTipo tipo : NFTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}