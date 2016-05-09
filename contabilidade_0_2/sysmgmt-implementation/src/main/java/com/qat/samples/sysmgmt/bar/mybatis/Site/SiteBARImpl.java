/** create by system gera-java version 1.0.0 07/05/2016 18:30 : 34*/
package com.qat.samples.sysmgmt.bar.mybatis.Site;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResponse.BusinessErrorCategory;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.util.MyBatisBARHelper;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.bar.Site.ISiteBAR;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.ContatoItensBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.EnderecoBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.InsertHistBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.SociosBARD;
import com.qat.samples.sysmgmt.contabilidade.model.Plano;
import com.qat.samples.sysmgmt.contato.model.Contato;
import com.qat.samples.sysmgmt.contato.model.ContatoItens;
import com.qat.samples.sysmgmt.contato.model.request.ContatoInquiryRequest;
import com.qat.samples.sysmgmt.ordemServico.model.OrdemServico;
import com.qat.samples.sysmgmt.ordemServico.model.OrdemServicoItens;
import com.qat.samples.sysmgmt.ordemServico.model.request.OrdemServicoInquiryRequest;
import com.qat.samples.sysmgmt.produto.model.Servico;
import com.qat.samples.sysmgmt.produto.model.request.PlanoInquiryRequest;
import com.qat.samples.sysmgmt.produto.model.request.ServicoInquiryRequest;
import com.qat.samples.sysmgmt.site.model.Site;
import com.qat.samples.sysmgmt.site.model.request.SiteInquiryRequest;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.util.model.request.PagedInquiryRequest;

/**
 * The Class CountyBARImpl. (Business Access Repository - BAR)
 */
@Repository
public class SiteBARImpl extends SqlSessionDaoSupport implements ISiteBAR
{

/** The Constant ZERO. */
	private static final int ZERO = 0;


///===================================### SERVICO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_SERVICO = "ServicoMap.";

/** The Constant STMT_INSERT_SERVICO. */
private static final String STMT_INSERT_SERVICO = NAMESPACE_SERVICO + "insertServico";

/** The Constant STMT_UPDATE_SERVICO. */
private static final String STMT_UPDATE_SERVICO = NAMESPACE_SERVICO + "updateServico";

/** The Constant STMT_DELETE_SERVICO. */
private static final String STMT_DELETE_SERVICO = NAMESPACE_SERVICO + "deleteServicoById";

	/** The Constant STMT_DELETE_SERVICO_ALL. */
	private static final String STMT_DELETE_SERVICO_ALL = NAMESPACE_SERVICO + "deleteAllServicos";

	/** The Constant STMT_FETCH_SERVICO. */
	private static final String STMT_FETCH_SERVICO = NAMESPACE_SERVICO + "fetchServicoById";

	/** The Constant STMT_FETCH_SERVICO_ALL. */
	private static final String STMT_FETCH_SERVICO_ALL = NAMESPACE_SERVICO + "fetchAllServicos";

	/** The Constant STMT_FETCH_SERVICO_COUNT. */
	private static final String STMT_FETCH_SERVICO_COUNT = NAMESPACE_SERVICO + "fetchServicoRowCount";

	/** The Constant STMT_FETCH_SERVICO_ALL_REQUEST. */
	private static final String STMT_FETCH_SERVICO_ALL_REQUEST = NAMESPACE_SERVICO + "fetchAllServicosRequest";

///===================================### SITE ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_SITE = "SiteMap.";

/** The Constant STMT_INSERT_SITE. */
private static final String STMT_INSERT_SITE = NAMESPACE_SITE + "insertSite";

/** The Constant STMT_UPDATE_SITE. */
private static final String STMT_UPDATE_SITE = NAMESPACE_SITE + "updateSite";

/** The Constant STMT_DELETE_SITE. */
private static final String STMT_DELETE_SITE = NAMESPACE_SITE + "deleteSiteById";

	/** The Constant STMT_DELETE_SITE_ALL. */
	private static final String STMT_DELETE_SITE_ALL = NAMESPACE_SITE + "deleteAllSites";

	/** The Constant STMT_FETCH_SITE. */
	private static final String STMT_FETCH_SITE = NAMESPACE_SITE + "fetchSiteById";

	/** The Constant STMT_FETCH_SITE_ALL. */
	private static final String STMT_FETCH_SITE_ALL = NAMESPACE_SITE + "fetchAllSites";

	/** The Constant STMT_FETCH_SITE_COUNT. */
	private static final String STMT_FETCH_SITE_COUNT = NAMESPACE_SITE + "fetchSiteRowCount";

	/** The Constant STMT_FETCH_SITE_ALL_REQUEST. */
	private static final String STMT_FETCH_SITE_ALL_REQUEST = NAMESPACE_SITE + "fetchAllSitesRequest";

///===================================### CONTATO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONTATO = "ContatoMap.";

/** The Constant STMT_INSERT_CONTATO. */
private static final String STMT_INSERT_CONTATO = NAMESPACE_CONTATO + "insertContato";

/** The Constant STMT_UPDATE_CONTATO. */
private static final String STMT_UPDATE_CONTATO = NAMESPACE_CONTATO + "updateContato";

/** The Constant STMT_DELETE_CONTATO. */
private static final String STMT_DELETE_CONTATO = NAMESPACE_CONTATO + "deleteContatoById";

	/** The Constant STMT_DELETE_CONTATO_ALL. */
	private static final String STMT_DELETE_CONTATO_ALL = NAMESPACE_CONTATO + "deleteAllContatos";

	/** The Constant STMT_FETCH_CONTATO. */
	private static final String STMT_FETCH_CONTATO = NAMESPACE_CONTATO + "fetchContatoById";

	/** The Constant STMT_FETCH_CONTATO_ALL. */
	private static final String STMT_FETCH_CONTATO_ALL = NAMESPACE_CONTATO + "fetchAllContatos";

	/** The Constant STMT_FETCH_CONTATO_COUNT. */
	private static final String STMT_FETCH_CONTATO_COUNT = NAMESPACE_CONTATO + "fetchContatoRowCount";

	/** The Constant STMT_FETCH_CONTATO_ALL_REQUEST. */
	private static final String STMT_FETCH_CONTATO_ALL_REQUEST = NAMESPACE_CONTATO + "fetchAllContatosRequest";

///===================================### CONTATOITENS ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONTATOITENS = "ContatoItensMap.";

/** The Constant STMT_INSERT_CONTATOITENS. */
private static final String STMT_INSERT_CONTATOITENS = NAMESPACE_CONTATOITENS + "insertContatoItens";

/** The Constant STMT_UPDATE_CONTATOITENS. */
private static final String STMT_UPDATE_CONTATOITENS = NAMESPACE_CONTATOITENS + "updateContatoItens";

/** The Constant STMT_DELETE_CONTATOITENS. */
private static final String STMT_DELETE_CONTATOITENS = NAMESPACE_CONTATOITENS + "deleteContatoItensById";

	/** The Constant STMT_DELETE_CONTATOITENS_ALL. */
	private static final String STMT_DELETE_CONTATOITENS_ALL = NAMESPACE_CONTATOITENS + "deleteAllContatoItenss";

	/** The Constant STMT_FETCH_CONTATOITENS. */
	private static final String STMT_FETCH_CONTATOITENS = NAMESPACE_CONTATOITENS + "fetchContatoItensById";

	/** The Constant STMT_FETCH_CONTATOITENS_ALL. */
	private static final String STMT_FETCH_CONTATOITENS_ALL = NAMESPACE_CONTATOITENS + "fetchAllContatoItenss";

	/** The Constant STMT_FETCH_CONTATOITENS_COUNT. */
	private static final String STMT_FETCH_CONTATOITENS_COUNT = NAMESPACE_CONTATOITENS + "fetchContatoItensRowCount";

	/** The Constant STMT_FETCH_CONTATOITENS_ALL_REQUEST. */
	private static final String STMT_FETCH_CONTATOITENS_ALL_REQUEST = NAMESPACE_CONTATOITENS + "fetchAllContatoItenssRequest";

///===================================### ORDEMSERVICO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_ORDEMSERVICO = "OrdemServicoMap.";

/** The Constant STMT_INSERT_ORDEMSERVICO. */
private static final String STMT_INSERT_ORDEMSERVICO = NAMESPACE_ORDEMSERVICO + "insertOrdemServico";

/** The Constant STMT_UPDATE_ORDEMSERVICO. */
private static final String STMT_UPDATE_ORDEMSERVICO = NAMESPACE_ORDEMSERVICO + "updateOrdemServico";

/** The Constant STMT_DELETE_ORDEMSERVICO. */
private static final String STMT_DELETE_ORDEMSERVICO = NAMESPACE_ORDEMSERVICO + "deleteOrdemServicoById";

	/** The Constant STMT_DELETE_ORDEMSERVICO_ALL. */
	private static final String STMT_DELETE_ORDEMSERVICO_ALL = NAMESPACE_ORDEMSERVICO + "deleteAllOrdemServicos";

	/** The Constant STMT_FETCH_ORDEMSERVICO. */
	private static final String STMT_FETCH_ORDEMSERVICO = NAMESPACE_ORDEMSERVICO + "fetchOrdemServicoById";

	/** The Constant STMT_FETCH_ORDEMSERVICO_ALL. */
	private static final String STMT_FETCH_ORDEMSERVICO_ALL = NAMESPACE_ORDEMSERVICO + "fetchAllOrdemServicos";

	/** The Constant STMT_FETCH_ORDEMSERVICO_COUNT. */
	private static final String STMT_FETCH_ORDEMSERVICO_COUNT = NAMESPACE_ORDEMSERVICO + "fetchOrdemServicoRowCount";

	/** The Constant STMT_FETCH_ORDEMSERVICO_ALL_REQUEST. */
	private static final String STMT_FETCH_ORDEMSERVICO_ALL_REQUEST = NAMESPACE_ORDEMSERVICO + "fetchAllOrdemServicosRequest";

///===================================### ORDEMSERVICOITENS ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_ORDEMSERVICOITENS = "OrdemServicoItensMap.";

/** The Constant STMT_INSERT_ORDEMSERVICOITENS. */
private static final String STMT_INSERT_ORDEMSERVICOITENS = NAMESPACE_ORDEMSERVICOITENS + "insertOrdemServicoItens";

/** The Constant STMT_UPDATE_ORDEMSERVICOITENS. */
private static final String STMT_UPDATE_ORDEMSERVICOITENS = NAMESPACE_ORDEMSERVICOITENS + "updateOrdemServicoItens";

/** The Constant STMT_DELETE_ORDEMSERVICOITENS. */
private static final String STMT_DELETE_ORDEMSERVICOITENS = NAMESPACE_ORDEMSERVICOITENS + "deleteOrdemServicoItensById";

	/** The Constant STMT_DELETE_ORDEMSERVICOITENS_ALL. */
	private static final String STMT_DELETE_ORDEMSERVICOITENS_ALL = NAMESPACE_ORDEMSERVICOITENS + "deleteAllOrdemServicoItenss";

	/** The Constant STMT_FETCH_ORDEMSERVICOITENS. */
	private static final String STMT_FETCH_ORDEMSERVICOITENS = NAMESPACE_ORDEMSERVICOITENS + "fetchOrdemServicoItensById";

	/** The Constant STMT_FETCH_ORDEMSERVICOITENS_ALL. */
	private static final String STMT_FETCH_ORDEMSERVICOITENS_ALL = NAMESPACE_ORDEMSERVICOITENS + "fetchAllOrdemServicoItenss";

	/** The Constant STMT_FETCH_ORDEMSERVICOITENS_COUNT. */
	private static final String STMT_FETCH_ORDEMSERVICOITENS_COUNT = NAMESPACE_ORDEMSERVICOITENS + "fetchOrdemServicoItensRowCount";

	/** The Constant STMT_FETCH_ORDEMSERVICOITENS_ALL_REQUEST. */
	private static final String STMT_FETCH_ORDEMSERVICOITENS_ALL_REQUEST = NAMESPACE_ORDEMSERVICOITENS + "fetchAllOrdemServicoItenssRequest";

///===================================### PLANO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_PLANO = "PlanoMap.";

/** The Constant STMT_INSERT_PLANO. */
private static final String STMT_INSERT_PLANO = NAMESPACE_PLANO + "insertPlano";

/** The Constant STMT_UPDATE_PLANO. */
private static final String STMT_UPDATE_PLANO = NAMESPACE_PLANO + "updatePlano";

/** The Constant STMT_DELETE_PLANO. */
private static final String STMT_DELETE_PLANO = NAMESPACE_PLANO + "deletePlanoById";

	/** The Constant STMT_DELETE_PLANO_ALL. */
	private static final String STMT_DELETE_PLANO_ALL = NAMESPACE_PLANO + "deleteAllPlanos";

	/** The Constant STMT_FETCH_PLANO. */
	private static final String STMT_FETCH_PLANO = NAMESPACE_PLANO + "fetchPlanoById";

	/** The Constant STMT_FETCH_PLANO_ALL. */
	private static final String STMT_FETCH_PLANO_ALL = NAMESPACE_PLANO + "fetchAllPlanos";

	/** The Constant STMT_FETCH_PLANO_COUNT. */
	private static final String STMT_FETCH_PLANO_COUNT = NAMESPACE_PLANO + "fetchPlanoRowCount";

	/** The Constant STMT_FETCH_PLANO_ALL_REQUEST. */
	private static final String STMT_FETCH_PLANO_ALL_REQUEST = NAMESPACE_PLANO + "fetchAllPlanosRequest";

//===================================### SERVICO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IServicoBAR#insertServico(com.qat.samples.sysmgmt.base.model.Servico)
 */
@Override
public InternalResponse insertServico(Servico servico)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.SERVICO, getHistoricoBAR(), response);
		Integer processId = 1;
		servico.setProcessId(historicoId);
		
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_SERVICO, servico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SERVICO, AcaoEnum.INSERT, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getPrecos()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getPrecos(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
				
	
	
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IServicoBAR#updateServico(com.qat.samples.sysmgmt.base.model.Servico)
 */
@Override
public InternalResponse updateServico(Servico servico)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_SERVICO, servico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SERVICO, AcaoEnum.UPDATE, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getPrecos()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getPrecos(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IServicoBAR#deleteServico(com.qat.samples.sysmgmt.base.model.Servico)
 */
@Override
public InternalResponse deleteServicoById(Servico servico)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_SERVICO, servico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SERVICO, AcaoEnum.DELETE, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getPrecos()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getPrecos(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IServicoBAR#deleteAllServicos()
 */
@Override
public InternalResponse deleteAllServicos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_SERVICO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IServicoBAR#fetchServicoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Servico fetchServicoById(FetchByIdRequest request)
{
return (Servico)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_SERVICO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IServicoBAR#fetchAllServicosCache()
 */
@Override
public InternalResultsResponse<Servico> fetchAllServicos(Servico servico)
{
	InternalResultsResponse<Servico> response = new InternalResultsResponse<Servico>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_SERVICO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IServicoBAR#fetchServicosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Servico> fetchServicosByRequest(ServicoInquiryRequest request)
{
	InternalResultsResponse<Servico> response = new InternalResultsResponse<Servico>();
	fetchServicosByRequest(getSqlSession(), request, STMT_FETCH_SERVICO_COUNT, STMT_FETCH_SERVICO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchServicosByRequest ####======================================

public static void fetchServicosByRequest(SqlSession sqlSession, ServicoInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### SITE ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ISiteBAR#insertSite(com.qat.samples.sysmgmt.base.model.Site)
 */
@Override
public InternalResponse insertSite(Site site)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.SITE, getHistoricoBAR(), response);
		Integer processId = 1;
		servico.setProcessId(historicoId);
		
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_SITE, site, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SITE, AcaoEnum.INSERT, historicoId,
				getHistoricoBAR(), response, site.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getServicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getServicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(empresa.getPlanoList()))
	{
		a +=
				EnderecoBARD.maintainEnderecoAssociations(empresa.getPlanoList(), response, site.getId(), null,
						null,
						tabela, enderecoBAR, statusBAR, historicoBAR, site.getId(),
						site.getCreateUser(), processId, historicoId, cadastroBAR);
	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ISiteBAR#updateSite(com.qat.samples.sysmgmt.base.model.Site)
 */
@Override
public InternalResponse updateSite(Site site)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_SITE, site, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SITE, AcaoEnum.UPDATE, historicoId,
				getHistoricoBAR(), response, site.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getServicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getServicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(empresa.getPlanoList()))
	{
		a +=
				EnderecoBARD.maintainEnderecoAssociations(empresa.getPlanoList(), response, site.getId(), null,
						null,
						tabela, enderecoBAR, statusBAR, historicoBAR, site.getId(),
						site.getCreateUser(), processId, historicoId, cadastroBAR);
	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ISiteBAR#deleteSite(com.qat.samples.sysmgmt.base.model.Site)
 */
@Override
public InternalResponse deleteSiteById(Site site)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_SITE, site, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.SITE, AcaoEnum.DELETE, historicoId,
				getHistoricoBAR(), response, site.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getServicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getServicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(empresa.getPlanoList()))
	{
		a +=
				EnderecoBARD.maintainEnderecoAssociations(empresa.getPlanoList(), response, site.getId(), null,
						null,
						tabela, enderecoBAR, statusBAR, historicoBAR, site.getId(),
						site.getCreateUser(), processId, historicoId, cadastroBAR);
	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ISiteBAR#deleteAllSites()
 */
@Override
public InternalResponse deleteAllSites()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_SITE_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.ISiteBAR#fetchSiteById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Site fetchSiteById(FetchByIdRequest request)
{
return (Site)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_SITE, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ISiteBAR#fetchAllSitesCache()
 */
@Override
public InternalResultsResponse<Site> fetchAllSites(Site site)
{
	InternalResultsResponse<Site> response = new InternalResultsResponse<Site>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_SITE_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.ISiteBAR#fetchSitesByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Site> fetchSitesByRequest(SiteInquiryRequest request)
{
	InternalResultsResponse<Site> response = new InternalResultsResponse<Site>();
	fetchSitesByRequest(getSqlSession(), request, STMT_FETCH_SITE_COUNT, STMT_FETCH_SITE_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchSitesByRequest ####======================================

public static void fetchSitesByRequest(SqlSession sqlSession, SiteInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### CONTATO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoBAR#insertContato(com.qat.samples.sysmgmt.base.model.Contato)
 */
@Override
public InternalResponse insertContato(Contato contato)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.CONTATO, getHistoricoBAR(), response);
		Integer processId = 1;
		servico.setProcessId(historicoId);
	
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTATO, contato, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.CONTATO, AcaoEnum.INSERT, historicoId,
				getHistoricoBAR(), response, contato.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getContatoItensList()))
	{
		a +=
				ContatoItensBARD.maintainContatoItensAssociations(servico.getContatoItensList(), response, servico.getId(), null, null,
						TabelaEnum.CONTATO, getContatoItensBAR(), getStatusBAR(), getHistoricoBAR(), servico.getId(),
						servico.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoBAR#updateContato(com.qat.samples.sysmgmt.base.model.Contato)
 */
@Override
public InternalResponse updateContato(Contato contato)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTATO, contato, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.CONTATO, AcaoEnum.UPDATE, historicoId,
				getHistoricoBAR(), response, contato.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getContatoItensList()))
	{
		a +=
				ContatoItensBARD.maintainContatoItensAssociations(servico.getContatoItensList(), response, servico.getId(), null, null,
						TabelaEnum.CONTATO, getContatoItensBAR(), getStatusBAR(), getHistoricoBAR(), servico.getId(),
						servico.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoBAR#deleteContato(com.qat.samples.sysmgmt.base.model.Contato)
 */
@Override
public InternalResponse deleteContatoById(Contato contato)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTATO, contato, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.CONTATO, AcaoEnum.DELETE, historicoId,
				getHistoricoBAR(), response, contato.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getContatoItensList()))
	{
		a +=
				ContatoItensBARD.maintainContatoItensAssociations(servico.getContatoItensList(), response, servico.getId(), null, null,
						TabelaEnum.CONTATO, getContatoItensBAR(), getStatusBAR(), getHistoricoBAR(), servico.getId(),
						servico.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoBAR#deleteAllContatos()
 */
@Override
public InternalResponse deleteAllContatos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTATO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IContatoBAR#fetchContatoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Contato fetchContatoById(FetchByIdRequest request)
{
return (Contato)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTATO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoBAR#fetchAllContatosCache()
 */
@Override
public InternalResultsResponse<Contato> fetchAllContatos(Contato contato)
{
	InternalResultsResponse<Contato> response = new InternalResultsResponse<Contato>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTATO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IContatoBAR#fetchContatosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Contato> fetchContatosByRequest(ContatoInquiryRequest request)
{
	InternalResultsResponse<Contato> response = new InternalResultsResponse<Contato>();
	fetchContatosByRequest(getSqlSession(), request, STMT_FETCH_CONTATO_COUNT, STMT_FETCH_CONTATO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContatosByRequest ####======================================

public static void fetchContatosByRequest(SqlSession sqlSession, ContatoInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### CONTATOITENS ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoItensBAR#insertContatoItens(com.qat.samples.sysmgmt.base.model.ContatoItens)
 */
@Override
public InternalResponse insertContatoItens(ContatoItens contatoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTATOITENS, contatoitens, response);
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoItensBAR#updateContatoItens(com.qat.samples.sysmgmt.base.model.ContatoItens)
 */
@Override
public InternalResponse updateContatoItens(ContatoItens contatoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTATOITENS, contatoitens, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoItensBAR#deleteContatoItens(com.qat.samples.sysmgmt.base.model.ContatoItens)
 */
@Override
public InternalResponse deleteContatoItensById(ContatoItens contatoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTATOITENS, contatoitens, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoItensBAR#deleteAllContatoItenss()
 */
@Override
public InternalResponse deleteAllContatoItenss()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTATOITENS_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IContatoItensBAR#fetchContatoItensById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public ContatoItens fetchContatoItensById(FetchByIdRequest request)
{
return (ContatoItens)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTATOITENS, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContatoItensBAR#fetchAllContatoItenssCache()
 */
@Override
public InternalResultsResponse<ContatoItens> fetchAllContatoItenss(ContatoItens contatoitens)
{
	InternalResultsResponse<ContatoItens> response = new InternalResultsResponse<ContatoItens>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTATOITENS_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IContatoItensBAR#fetchContatoItenssByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<ContatoItens> fetchContatoItenssByRequest(PagedInquiryRequest request)
{
	InternalResultsResponse<ContatoItens> response = new InternalResultsResponse<ContatoItens>();
	fetchContatoItenssByRequest(getSqlSession(), request, STMT_FETCH_CONTATOITENS_COUNT, STMT_FETCH_CONTATOITENS_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContatoItenssByRequest ####======================================

public static void fetchContatoItenssByRequest(SqlSession sqlSession, PagedInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### ORDEMSERVICO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoBAR#insertOrdemServico(com.qat.samples.sysmgmt.base.model.OrdemServico)
 */
@Override
public InternalResponse insertOrdemServico(OrdemServico ordemservico)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.ORDEMSERVICO, getHistoricoBAR(), response);
		Integer processId = 1;
		servico.setProcessId(historicoId);
	
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_ORDEMSERVICO, ordemservico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICO, AcaoEnum.INSERT, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getOrdemServicoItemList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getOrdemServicoItemList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoBAR#updateOrdemServico(com.qat.samples.sysmgmt.base.model.OrdemServico)
 */
@Override
public InternalResponse updateOrdemServico(OrdemServico ordemservico)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_ORDEMSERVICO, ordemservico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICO, AcaoEnum.UPDATE, ordemservico.getProcessId(),
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getOrdemServicoItemList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getOrdemServicoItemList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoBAR#deleteOrdemServico(com.qat.samples.sysmgmt.base.model.OrdemServico)
 */
@Override
public InternalResponse deleteOrdemServicoById(OrdemServico ordemservico)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ORDEMSERVICO, ordemservico, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICO, AcaoEnum.UPDATE, ordemservico.getProcessId(),
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.getOrdemServicoItemList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.getOrdemServicoItemList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoBAR#deleteAllOrdemServicos()
 */
@Override
public InternalResponse deleteAllOrdemServicos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ORDEMSERVICO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IOrdemServicoBAR#fetchOrdemServicoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public OrdemServico fetchOrdemServicoById(FetchByIdRequest request)
{
return (OrdemServico)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_ORDEMSERVICO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoBAR#fetchAllOrdemServicosCache()
 */
@Override
public InternalResultsResponse<OrdemServico> fetchAllOrdemServicos(OrdemServico ordemservico)
{
	InternalResultsResponse<OrdemServico> response = new InternalResultsResponse<OrdemServico>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_ORDEMSERVICO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IOrdemServicoBAR#fetchOrdemServicosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<OrdemServico> fetchOrdemServicosByRequest(OrdemServicoInquiryRequest request)
{
	InternalResultsResponse<OrdemServico> response = new InternalResultsResponse<OrdemServico>();
	fetchOrdemServicosByRequest(getSqlSession(), request, STMT_FETCH_ORDEMSERVICO_COUNT, STMT_FETCH_ORDEMSERVICO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchOrdemServicosByRequest ####======================================

public static void fetchOrdemServicosByRequest(SqlSession sqlSession, OrdemServicoInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### ORDEMSERVICOITENS ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoItensBAR#insertOrdemServicoItens(com.qat.samples.sysmgmt.base.model.OrdemServicoItens)
 */
@Override
public InternalResponse insertOrdemServicoItens(OrdemServicoItens ordemservicoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_ORDEMSERVICOITENS, ordemservicoitens, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICOITENS, AcaoEnum.INSERT, ordemservicoitens.getProcessId(),
				getHistoricoBAR(), response, servico.getId());
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoItensBAR#updateOrdemServicoItens(com.qat.samples.sysmgmt.base.model.OrdemServicoItens)
 */
@Override
public InternalResponse updateOrdemServicoItens(OrdemServicoItens ordemservicoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_ORDEMSERVICOITENS, ordemservicoitens, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICOITENS, AcaoEnum.UPDATE, ordemservicoitens.getProcessId(),
				getHistoricoBAR(), response, servico.getId());
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoItensBAR#deleteOrdemServicoItens(com.qat.samples.sysmgmt.base.model.OrdemServicoItens)
 */
@Override
public InternalResponse deleteOrdemServicoItensById(OrdemServicoItens ordemservicoitens)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ORDEMSERVICOITENS, ordemservicoitens, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.ORDEMSERVICOITENS, AcaoEnum.DELETE, ordemservicoitens.getProcessId(),
				getHistoricoBAR(), response, servico.getId());
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoItensBAR#deleteAllOrdemServicoItenss()
 */
@Override
public InternalResponse deleteAllOrdemServicoItenss()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ORDEMSERVICOITENS_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IOrdemServicoItensBAR#fetchOrdemServicoItensById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public OrdemServicoItens fetchOrdemServicoItensById(FetchByIdRequest request)
{
return (OrdemServicoItens)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_ORDEMSERVICOITENS, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IOrdemServicoItensBAR#fetchAllOrdemServicoItenssCache()
 */
@Override
public InternalResultsResponse<OrdemServicoItens> fetchAllOrdemServicoItenss(OrdemServicoItens ordemservicoitens)
{
	InternalResultsResponse<OrdemServicoItens> response = new InternalResultsResponse<OrdemServicoItens>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_ORDEMSERVICOITENS_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IOrdemServicoItensBAR#fetchOrdemServicoItenssByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<OrdemServicoItens> fetchOrdemServicoItenssByRequest(PagedInquiryRequest request)
{
	InternalResultsResponse<OrdemServicoItens> response = new InternalResultsResponse<OrdemServicoItens>();
	fetchOrdemServicoItenssByRequest(getSqlSession(), request, STMT_FETCH_ORDEMSERVICOITENS_COUNT, STMT_FETCH_ORDEMSERVICOITENS_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchOrdemServicoItenssByRequest ####======================================

public static void fetchOrdemServicoItenssByRequest(SqlSession sqlSession, PagedInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}


//===================================### PLANO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IPlanoBAR#insertPlano(com.qat.samples.sysmgmt.base.model.Plano)
 */
@Override
public InternalResponse insertPlano(Plano plano)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.PLANO, getHistoricoBAR(), response);
		Integer processId = 1;
		servico.setProcessId(historicoId);
	
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_PLANO, plano, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.PLANO, AcaoEnum.INSERT, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.precoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.precoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(servico.servicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.servicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IPlanoBAR#updatePlano(com.qat.samples.sysmgmt.base.model.Plano)
 */
@Override
public InternalResponse updatePlano(Plano plano)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_PLANO, plano, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.PLANO, AcaoEnum.UPDATE, historicoId,
				getHistoricoBAR(), response, servico.getId());
	
	if (!ValidationUtil.isNullOrEmpty(servico.precoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.precoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(servico.servicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.servicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IPlanoBAR#deletePlano(com.qat.samples.sysmgmt.base.model.Plano)
 */
@Override
public InternalResponse deletePlanoById(Plano plano)
{
	InternalResponse response = new InternalResponse();
	
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_PLANO, plano, response);
	
	Integer a = InsertHistBARD.maintainInsertHistoricoItens(TabelaEnum.PLANO, AcaoEnum.DELETE, plano.getProcessId(),
				getHistoricoBAR(), response, plano.getId());
	
	if (!ValidationUtil.isNullOrEmpty(plano.precoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(plano.precoList(), response, plano.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), plano.getId(),
						plano.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	if (!ValidationUtil.isNullOrEmpty(servico.servicoList()))
	{
		a +=
				SociosBARD.maintainPrecoAssociations(empresa.servicoList(), response, empresa.getId(), null, null,
						TabelaEnum.EMPRESA, getPrecoBAR(), getStatusBAR(), getHistoricoBAR(), empresa.getId(),
						empresa.getCreateUser(), historicoId, historicoId, getDocumentosBAR());

	}
	
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IPlanoBAR#deleteAllPlanos()
 */
@Override
public InternalResponse deleteAllPlanos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_PLANO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IPlanoBAR#fetchPlanoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Plano fetchPlanoById(FetchByIdRequest request)
{
return (Plano)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_PLANO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IPlanoBAR#fetchAllPlanosCache()
 */
@Override
public InternalResultsResponse<Plano> fetchAllPlanos(Plano plano)
{
	InternalResultsResponse<Plano> response = new InternalResultsResponse<Plano>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_PLANO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IPlanoBAR#fetchPlanosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Plano> fetchPlanosByRequest(PlanoInquiryRequest request)
{
	InternalResultsResponse<Plano> response = new InternalResultsResponse<Plano>();
	fetchPlanosByRequest(getSqlSession(), request, STMT_FETCH_PLANO_COUNT, STMT_FETCH_PLANO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchPlanosByRequest ####======================================

public static void fetchPlanosByRequest(SqlSession sqlSession, PlanoInquiryRequest request, String countStatement,
			String fetchPagedStatement,
			InternalResultsResponse<?> response)
	{

		// If the user requested the total rows/record count
		if (request.isPreQueryCount())
		{
			// set the total rows available in the response
			response.getResultsSetInfo().setTotalRowsAvailable(
					(Integer)MyBatisBARHelper.doQueryForObject(sqlSession, countStatement, request));

			if (response.getResultsSetInfo().getTotalRowsAvailable() == ZERO)
			{
				response.setStatus(BusinessErrorCategory.NoRowsFound);
				return;
			}
		}

		// Fetch Objects by InquiryRequest Object, paged of course
		response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(sqlSession, fetchPagedStatement, request));

		// move request start page to response start page
		response.getResultsSetInfo().setStartPage(request.getStartPage());

		// move request page size to response page size
		response.getResultsSetInfo().setPageSize(request.getPageSize());

		// calculate correct startPage for more rows available comparison, since it is zero based, we have to offset by
		// 1.
		int startPage = (request.getStartPage() == 0) ? 1 : (request.getStartPage() + 1);

		// set moreRowsAvailable in response based on total rows compared to (page size * start page)
		// remember if the count was not requested the TotalRowsAvailable will be false because the assumption
		// is that you your own logic to handle this.
		if (response.getResultsSetInfo().getTotalRowsAvailable() > (response.getResultsSetInfo().getPageSize() * startPage))
		{
			response.getResultsSetInfo().setMoreRowsAvailable(true);
		}

	}

}
