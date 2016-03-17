package com.qat.samples.sysmgmt.pessoa.dacd;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.beneficios.BeneficioPessoa;
import com.qat.samples.sysmgmt.beneficios.Beneficios;
import com.qat.samples.sysmgmt.entidade.dacd.StatusDACD;
import com.qat.samples.sysmgmt.pessoa.dac.IBeneficiosDAC;
import com.qat.samples.sysmgmt.util.AcaoEnum;
import com.qat.samples.sysmgmt.util.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.Status;
import com.qat.samples.sysmgmt.util.TabelaEnum;
import com.qat.samples.sysmgmt.util.TypeEnum;
import com.qat.samples.sysmgmt.util.dac.IHistoricoDAC;
import com.qat.samples.sysmgmt.util.dac.IStatusDAC;

/**
 * Delegate class for the SysMgmt DACs. Note this is a final class with ONLY static methods so everything must be
 * passed into the methods. Nothing injected.
 */
public final class BeneficiosDACD extends SqlSessionDaoSupport
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
	public static Integer maintainBeneficiosAssociations(List<BeneficioPessoa> beneficioPessoaList,
			InternalResultsResponse<?> response, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, IBeneficiosDAC beneficioPessoaDAC, IStatusDAC statusDAC, IHistoricoDAC historicoDAC,
			Integer empId,
			String UserId, Integer processId, Integer historiId)
	{
		Integer count = 0;
		// First Maintain Empresa
		if (ValidationUtil.isNullOrEmpty(beneficioPessoaList))
		{
			return count;
		}
		// For Each Contact...
		for (BeneficioPessoa beneficioPessoa : beneficioPessoaList)
		{
			// Make sure we set the parent key
			beneficioPessoa.setParentId(parentId);
			beneficioPessoa.setIdFunc(parentId);
			beneficioPessoa.setProcessId(processId);

			if (ValidationUtil.isNull(beneficioPessoa.getModelAction()))
			{
				continue;
			}
			switch (beneficioPessoa.getModelAction())
			{
				case INSERT:
				
					count =
							maintainBeneficioAssociationsA(beneficioPessoa.getBenefId(), response, null, null,
									null,
									TabelaEnum.PESSOA, beneficioPessoaDAC, statusDAC, historicoDAC,
									beneficioPessoa.getEmprId(),
									beneficioPessoa.getCreateUser(), processId, historiId);
				
					count = beneficioPessoaDAC.insertBeneficioPessoa(beneficioPessoa);
					if (count > 0)
					{
						Status status = new Status();
						status.setStatus(CdStatusTypeEnum.ATIVO);
						List<Status> statusList = new ArrayList<Status>();
						count =
								StatusDACD.maintainStatusAssociations(statusList, response, count, null,
										AcaoEnum.INSERT, UserId, empId, TabelaEnum.BENEFICIOS, statusDAC, historicoDAC,
										processId, historiId);
					}

					break;
				case UPDATE:
				
				count =
							maintainBeneficioAssociationsA(beneficioPessoa.getBenefId(), response, null, null,
									null,
									TabelaEnum.PESSOA, beneficioPessoaDAC, statusDAC, historicoDAC,
									beneficioPessoa.getEmprId(),
									beneficioPessoa.getCreateUser(), processId, historiId);
					count = beneficioPessoaDAC.updateBeneficioPessoa(beneficioPessoa);
					if (count > 0)
					{
						count =
								StatusDACD.maintainStatusAssociations(beneficioPessoa.getStatusList(), response,
										beneficioPessoa.getId(),
										null, AcaoEnum.UPDATE, UserId, empId, TabelaEnum.BENEFICIOS, statusDAC,
										historicoDAC, processId, historiId);
					}

					break;
				case DELETE:
					count = beneficioPessoaDAC.deleteBeneficioPessoa(beneficioPessoa);
					Status status = new Status();
					status.setStatus(CdStatusTypeEnum.DELETADO);
					List<Status> statusList = new ArrayList<Status>();
					count =
							StatusDACD.maintainStatusAssociations(statusList, response, beneficioPessoa.getId(), null,
									AcaoEnum.DELETE, UserId, empId, TabelaEnum.BENEFICIOS, statusDAC, historicoDAC,
									processId, historiId);

					break;
				case NONE:

							count = beneficioPessoaDAC.insertBeneficioPessoa(beneficioPessoa);
					if (count > 0)
					{
						Status status = new Status();
						status.setStatus(CdStatusTypeEnum.ATIVO);
						List<Status> statusList = new ArrayList<Status>();
						count =
								StatusDACD.maintainStatusAssociations(statusList, response, count, null,
										AcaoEnum.INSERT, UserId, empId, TabelaEnum.BENEFICIOS, statusDAC, historicoDAC,
										processId, historiId);
					}
					break;

			}
		}

		return count;
	}

	public static Integer maintainBeneficioAssociationsA(Beneficios beneficio,
			InternalResultsResponse<?> response, Integer parentId, TypeEnum type, AcaoEnum acaoType,
			TabelaEnum tabelaEnum, IBeneficiosDAC beneficioDAC, IStatusDAC statusDAC, IHistoricoDAC historicoDAC,
			Integer empId,
			String UserId, Integer processId, Integer historicoId)
	{

		Integer count = 0;
		// First Maintain Empresa
		if (ValidationUtil.isNull(beneficio))
		{
			return count;
		}

		// Make sure we set the parent key
		beneficio.setParentId(parentId);
		beneficio.setProcessId(processId);

		switch (beneficio.getModelAction())
		{
			case INSERT:
				count = beneficioDAC.insertBeneficios(beneficio);
				if (count > 0)
				{
					Status status = new Status();
					status.setStatus(CdStatusTypeEnum.ATIVO);
					List<Status> statusList = new ArrayList<Status>();
					count =
							StatusDACD.maintainStatusAssociations(statusList, response, count, null,
									AcaoEnum.INSERT, UserId, empId, TabelaEnum.BANCO, statusDAC, historicoDAC,
									processId, historicoId);
				}
				break;
			case UPDATE:
				count = beneficioDAC.updateBeneficios(beneficio);
				if (count > 0)
				{
					count =
							StatusDACD
									.maintainStatusAssociations(beneficio.getStatusList(), response, beneficio.getId(),
											null, AcaoEnum.UPDATE, UserId, empId, TabelaEnum.BANCO, statusDAC,
											historicoDAC, processId, historicoId);
				}
				break;
			case DELETE:
				count = beneficioDAC.deleteBeneficios(beneficio);
				Status status = new Status();
				status.setStatus(CdStatusTypeEnum.DELETADO);
				List<Status> statusList = new ArrayList<Status>();
				count =
						StatusDACD.maintainStatusAssociations(statusList, response, beneficio.getId(), null,
								AcaoEnum.DELETE, UserId, empId, TabelaEnum.BANCO, statusDAC, historicoDAC,
								processId, historicoId);

				break;
		}

		return count;
	}
}
