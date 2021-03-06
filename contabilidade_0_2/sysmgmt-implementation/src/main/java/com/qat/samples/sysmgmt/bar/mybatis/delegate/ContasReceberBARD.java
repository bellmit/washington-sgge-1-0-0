package com.qat.samples.sysmgmt.bar.mybatis.delegate;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.bar.Financeiro.IFinanceiroBAR;
import com.qat.samples.sysmgmt.bar.Historico.IHistoricoBAR;
import com.qat.samples.sysmgmt.bar.Status.IStatusBAR;
import com.qat.samples.sysmgmt.entidade.model.Empresa;
import com.qat.samples.sysmgmt.financeiro.model.ContasReceber;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.TypeEnum;

/**
 * Delegate class for the SysMgmt DACs. Note this is a final class with ONLY static methods so everything must be
 * passed into the methods. Nothing injected.
 */
public final class ContasReceberBARD extends SqlSessionDaoSupport
{

	/** The Constant ZERO. */
	private static final Integer ZERO = 0;

	/**
	 * Fetch objects by request.
	 *
	 * @param sqlSession the sql session
	 * @param request the request
	 * @param countStatement the count statement
	 * @param fetchPagedStatement the fetch paged statement
	 * @param response the response
	 */
	@SuppressWarnings("unchecked")
	public static Integer maintainContasReceberAssociations(List<ContasReceber> contasReceberList,
			InternalResponse responsew, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, IFinanceiroBAR contasReceberDAC, IStatusBAR statusDAC, IHistoricoBAR historicoDAC,
			Integer empId, String UserId, Integer processId, Integer historicoId)
	{
		Boolean count = false;
		// First Maintain Empresa
		InternalResultsResponse<Empresa> response  = new InternalResultsResponse<Empresa>();
		if (ValidationUtil.isNullOrEmpty(contasReceberList))
		{
			return 0;
		}
		// For Each Contact...
		for (ContasReceber contasReceber : contasReceberList)
		{
			// Make sure we set the parent key
			contasReceber.setParentId(parentId);

			if (ValidationUtil.isNull(contasReceber.getModelAction()))
			{
				continue;
			}
			switch (contasReceber.getModelAction())
			{
				case INSERT:
					count = contasReceberDAC.insertContasReceber(contasReceber).hasSystemError();

					break;
				case UPDATE:
					count = contasReceberDAC.updateContasReceber(contasReceber).hasSystemError();

					break;
				case DELETE:
					count = contasReceberDAC.deleteContasReceberById(contasReceber).hasSystemError();

					break;
			}


		}
		return 1;
	}
}
