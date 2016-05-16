package com.qat.samples.sysmgmt.nf.model.classes.nota;

import com.qat.samples.sysmgmt.nf.model.classes.NFBase;
import com.qat.samples.sysmgmt.nf.model.classes.NFNotaInfoSituacaoTributariaPIS;

public class NFNotaInfoItemImpostoPISNaoTributado extends NFBase {

    //@Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaPIS situacaoTributaria;

    public NFNotaInfoItemImpostoPISNaoTributado() {
        this.situacaoTributaria = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaPIS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaPIS.OPERACAO_ISENTA_CONTRIBUICAO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaPIS.OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaPIS.OPERACAO_COM_SUSPENSAO_CONTRIBUICAO.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalida");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public NFNotaInfoSituacaoTributariaPIS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }
}