package com.qat.samples.sysmgmt.bar.mybatis.delegate;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.bar.Historico.IHistoricoBAR;
import com.qat.samples.sysmgmt.bar.Site.ISiteBAR;
import com.qat.samples.sysmgmt.bar.Status.IStatusBAR;
import com.qat.samples.sysmgmt.site.model.ServicoAndPlano;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.model.Status;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.TypeEnum;

/**
 * Delegate class for the SysMgmt DACs. Note this is a final class with ONLY static methods so everything must be
 * passed into the methods. Nothing injected.
 */
public final class PlanoAndServicoBARD extends SqlSessionDaoSupport
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
	public static Integer maintainServicoAndPlanoAssociations(List<ServicoAndPlano> emailList,
			InternalResponse response, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, ISiteBAR emailDAC, IStatusBAR statusDAC, IHistoricoBAR historicoDAC, Integer empId,
			String UserId, Integer processId, Integer historicoId)
	{
		Boolean count = false;
		// First Maintain Empresa
		if (ValidationUtil.isNullOrEmpty(emailList))
		{
			return 0;
		}
		// For Each Contact...
		for (ServicoAndPlano email : emailList)
		{
			// Make sure we set the parent key
			email.setParentId(parentId);
			email.setTabelaEnum(tabelaEnum);
			email.setProcessId(processId);

			if (ValidationUtil.isNull(email.getModelAction()))
			{
				continue;
			}
			switch (email.getModelAction())
			{
				case INSERT:
					count = emailDAC.insertServicoAndPlano(email).hasSystemError();

					break;
				case UPDATE:
					count = emailDAC.updateServicoAndPlano(email).hasSystemError();

					break;
				case DELETE:
					count = emailDAC.deleteServicoAndPlanoById(email).hasSystemError();

					break;
			}
		}

		return 1;
	}
}
