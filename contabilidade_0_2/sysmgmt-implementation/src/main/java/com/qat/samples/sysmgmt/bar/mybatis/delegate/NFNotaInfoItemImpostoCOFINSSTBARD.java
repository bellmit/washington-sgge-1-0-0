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
import com.qat.samples.sysmgmt.nfeItens.model.NFNotaInfoItemImpostoCOFINSST;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.model.Status;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.TypeEnum;

/**
 * Delegate class for the SysMgmt DACs. Note this is a final class with ONLY static methods so everything must be
 * passed into the methods. Nothing injected.
 */
public final class NFNotaInfoItemImpostoCOFINSSTBARD extends SqlSessionDaoSupport
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
	public static Integer maintainNFNotaInfoItemImpostoCOFINSSTAssociations(NFNotaInfoItemImpostoCOFINSST nfnotainfoitemimpostocofinsst,
			InternalResponse response, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, INFNotaInfoItemBAR nfnotainfoitemimpostocofinsstDAC, IStatusBAR statusDAC, IHistoricoBAR historicoDAC, Integer empId,
			String UserId, Integer processId, Integer historicoId)
	{
		Boolean count = false;
		// First Maintain Empresa
		if (ValidationUtil.isNull(nfnotainfoitemimpostocofinsst))
		{
			return 0;
		}
		// For Each Contact...
			// Make sure we set the parent key
			nfnotainfoitemimpostocofinsst.setParentId(parentId);
			nfnotainfoitemimpostocofinsst.setTabelaEnum(tabelaEnum);
			nfnotainfoitemimpostocofinsst.setProcessId(processId);

		//	if (ValidationUtil.isNull(nfnotainfoitemimpostocofinsst.getModelAction()))
		//	{
		//		continue;
		//	}
			switch (nfnotainfoitemimpostocofinsst.getModelAction())
			{
				case INSERT:
					count = nfnotainfoitemimpostocofinsstDAC.insertNFNotaInfoItemImpostoCOFINSST(nfnotainfoitemimpostocofinsst).hasSystemError();

					break;
				case UPDATE:
					count = nfnotainfoitemimpostocofinsstDAC.updateNFNotaInfoItemImpostoCOFINSST(nfnotainfoitemimpostocofinsst).hasSystemError();

					break;
				case DELETE:
					count = nfnotainfoitemimpostocofinsstDAC.deleteNFNotaInfoItemImpostoCOFINSSTById(nfnotainfoitemimpostocofinsst).hasSystemError();

					break;
			}

		if(count == true ){
			return 1;
		}else{
			return 0;
		}

	}
}
