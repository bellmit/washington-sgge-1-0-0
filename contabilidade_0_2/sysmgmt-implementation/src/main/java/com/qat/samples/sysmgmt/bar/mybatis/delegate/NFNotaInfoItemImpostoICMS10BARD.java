/** create by system gera-java version 1.0.0 05/12/2016 22:20 : 14*/


package com.qat.samples.sysmgmt.bar.mybatis.delegate;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.bar.Historico.IHistoricoBAR;
import com.qat.samples.sysmgmt.bar.Nfe.INFNotaInfoItemBAR;
import com.qat.samples.sysmgmt.bar.Status.IStatusBAR;
import com.qat.samples.sysmgmt.nfeItens.model.NFNotaInfoItemImpostoICMS10;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.model.Status;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.TypeEnum;

/**
 * Delegate class for the SysMgmt DACs. Note this is a final class with ONLY static methods so everything must be
 * passed into the methods. Nothing injected.
 */
public final class NFNotaInfoItemImpostoICMS10BARD extends SqlSessionDaoSupport
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
	public static Integer maintainNFNotaInfoItemImpostoICMS10Associations(NFNotaInfoItemImpostoICMS10 nfnotainfoitemimpostoicms10,
			InternalResponse response, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, INFNotaInfoItemBAR nfnotainfoitemimpostoicms10DAC, IStatusBAR statusDAC, IHistoricoBAR historicoDAC, Integer empId,
			String UserId, Integer processId, Integer historicoId)
	{
		Boolean count = false;
		// First Maintain Empresa
		if (ValidationUtil.isNull(nfnotainfoitemimpostoicms10))
		{
			return 0;
		}
		// For Each Contact...
			// Make sure we set the parent key
			nfnotainfoitemimpostoicms10.setParentId(parentId);
			nfnotainfoitemimpostoicms10.setTabelaEnum(tabelaEnum);
			nfnotainfoitemimpostoicms10.setProcessId(processId);

		//	if (ValidationUtil.isNull(nfnotainfoitemimpostoicms10.getModelAction()))
		//	{
		//		continue;
		//	}
			switch (nfnotainfoitemimpostoicms10.getModelAction())
			{
				case INSERT:
					count = nfnotainfoitemimpostoicms10DAC.insertNFNotaInfoItemImpostoICMS10(nfnotainfoitemimpostoicms10).hasSystemError();
					if (count == true)
					{
						Status status = new Status();
						status.setStatus(CdStatusTypeEnum.ATIVO);
						List<Status> statusList = new ArrayList<Status>();
						statusList.add(status);
						count =
								StatusBARD.maintainStatusAssociations(statusList, response, parentId, null,
										AcaoEnum.INSERT, UserId, empId, TabelaEnum.NFNOTAINFOITEMIMPOSTOICMS10, statusDAC, historicoDAC,
										processId, historicoId);
					}
					break;
				case UPDATE:
					count = nfnotainfoitemimpostoicms10DAC.updateNFNotaInfoItemImpostoICMS10(nfnotainfoitemimpostoicms10).hasSystemError();
					if (count == true)
					{
						count =
								StatusBARD.maintainStatusAssociations(nfnotainfoitemimpostoicms10.getStatusList(), response, nfnotainfoitemimpostoicms10.getId(),
										null,
										AcaoEnum.UPDATE, UserId, empId, TabelaEnum.NFNOTAINFOITEMIMPOSTOICMS10, statusDAC, historicoDAC,
										processId, historicoId);
					}
					break;
				case DELETE:
					count = nfnotainfoitemimpostoicms10DAC.deleteNFNotaInfoItemImpostoICMS10ById(nfnotainfoitemimpostoicms10).hasSystemError();
					

					break;
			}
		
		if(count == true ){
			return 1;
		}else{
			return 0;
		}
		
	}
}
