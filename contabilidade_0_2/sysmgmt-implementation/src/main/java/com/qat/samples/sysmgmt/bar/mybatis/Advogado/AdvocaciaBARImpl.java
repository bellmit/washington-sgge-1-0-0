/** create by system gera-java version 1.0.0 28/04/2016 20:35 : 28*/
package com.qat.samples.sysmgmt.bar.mybatis.Advogado;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResponse.BusinessErrorCategory;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.util.MyBatisBARHelper;
import com.qat.samples.sysmgmt.advocacia.Advogado;
import com.qat.samples.sysmgmt.advocacia.Audiencia;
import com.qat.samples.sysmgmt.advocacia.Processo;
import com.qat.samples.sysmgmt.advocacia.request.AdvogadoInquiryRequest;
import com.qat.samples.sysmgmt.advocacia.request.AudienciaInquiryRequest;
import com.qat.samples.sysmgmt.advocacia.request.ProcessoInquiryRequest;
import com.qat.samples.sysmgmt.bar.Advogado.IAdvocaciaBAR;
import com.qat.samples.sysmgmt.util.model.request.FetchByIdRequest;

/**
 * The Class CountyBARImpl. (Business Access Repository - BAR)
 */
@Repository
public class AdvocaciaBARImpl extends SqlSessionDaoSupport implements IAdvocaciaBAR
{

/** The Constant ZERO. */
	private static final int ZERO = 0;


///===================================### ADVOGADO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_ADVOGADO = "AdvogadoMap.";

/** The Constant STMT_INSERT_ADVOGADO. */
private static final String STMT_INSERT_ADVOGADO = NAMESPACE_ADVOGADO + "insertAdvogado";

/** The Constant STMT_UPDATE_ADVOGADO. */
private static final String STMT_UPDATE_ADVOGADO = NAMESPACE_ADVOGADO + "updateAdvogado";

/** The Constant STMT_DELETE_ADVOGADO. */
private static final String STMT_DELETE_ADVOGADO = NAMESPACE_ADVOGADO + "deleteAdvogadoById";

	/** The Constant STMT_DELETE_ADVOGADO_ALL. */
	private static final String STMT_DELETE_ADVOGADO_ALL = NAMESPACE_ADVOGADO + "deleteAllAdvogados";

	/** The Constant STMT_FETCH_ADVOGADO. */
	private static final String STMT_FETCH_ADVOGADO = NAMESPACE_ADVOGADO + "fetchAdvogadoById";

	/** The Constant STMT_FETCH_ADVOGADO_ALL. */
	private static final String STMT_FETCH_ADVOGADO_ALL = NAMESPACE_ADVOGADO + "fetchAllAdvogados";

	/** The Constant STMT_FETCH_ADVOGADO_COUNT. */
	private static final String STMT_FETCH_ADVOGADO_COUNT = NAMESPACE_ADVOGADO + "fetchAdvogadoRowCount";

	/** The Constant STMT_FETCH_ADVOGADO_ALL_REQUEST. */
	private static final String STMT_FETCH_ADVOGADO_ALL_REQUEST = NAMESPACE_ADVOGADO + "fetchAllAdvogadosRequest";

///===================================### AUDIENCIA ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_AUDIENCIA = "AudienciaMap.";

/** The Constant STMT_INSERT_AUDIENCIA. */
private static final String STMT_INSERT_AUDIENCIA = NAMESPACE_AUDIENCIA + "insertAudiencia";

/** The Constant STMT_UPDATE_AUDIENCIA. */
private static final String STMT_UPDATE_AUDIENCIA = NAMESPACE_AUDIENCIA + "updateAudiencia";

/** The Constant STMT_DELETE_AUDIENCIA. */
private static final String STMT_DELETE_AUDIENCIA = NAMESPACE_AUDIENCIA + "deleteAudienciaById";

	/** The Constant STMT_DELETE_AUDIENCIA_ALL. */
	private static final String STMT_DELETE_AUDIENCIA_ALL = NAMESPACE_AUDIENCIA + "deleteAllAudiencias";

	/** The Constant STMT_FETCH_AUDIENCIA. */
	private static final String STMT_FETCH_AUDIENCIA = NAMESPACE_AUDIENCIA + "fetchAudienciaById";

	/** The Constant STMT_FETCH_AUDIENCIA_ALL. */
	private static final String STMT_FETCH_AUDIENCIA_ALL = NAMESPACE_AUDIENCIA + "fetchAllAudiencias";

	/** The Constant STMT_FETCH_AUDIENCIA_COUNT. */
	private static final String STMT_FETCH_AUDIENCIA_COUNT = NAMESPACE_AUDIENCIA + "fetchAudienciaRowCount";

	/** The Constant STMT_FETCH_AUDIENCIA_ALL_REQUEST. */
	private static final String STMT_FETCH_AUDIENCIA_ALL_REQUEST = NAMESPACE_AUDIENCIA + "fetchAllAudienciasRequest";

///===================================### PROCESSO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_PROCESSO = "ProcessoMap.";

/** The Constant STMT_INSERT_PROCESSO. */
private static final String STMT_INSERT_PROCESSO = NAMESPACE_PROCESSO + "insertProcesso";

/** The Constant STMT_UPDATE_PROCESSO. */
private static final String STMT_UPDATE_PROCESSO = NAMESPACE_PROCESSO + "updateProcesso";

/** The Constant STMT_DELETE_PROCESSO. */
private static final String STMT_DELETE_PROCESSO = NAMESPACE_PROCESSO + "deleteProcessoById";

	/** The Constant STMT_DELETE_PROCESSO_ALL. */
	private static final String STMT_DELETE_PROCESSO_ALL = NAMESPACE_PROCESSO + "deleteAllProcessos";

	/** The Constant STMT_FETCH_PROCESSO. */
	private static final String STMT_FETCH_PROCESSO = NAMESPACE_PROCESSO + "fetchProcessoById";

	/** The Constant STMT_FETCH_PROCESSO_ALL. */
	private static final String STMT_FETCH_PROCESSO_ALL = NAMESPACE_PROCESSO + "fetchAllProcessos";

	/** The Constant STMT_FETCH_PROCESSO_COUNT. */
	private static final String STMT_FETCH_PROCESSO_COUNT = NAMESPACE_PROCESSO + "fetchProcessoRowCount";

	/** The Constant STMT_FETCH_PROCESSO_ALL_REQUEST. */
	private static final String STMT_FETCH_PROCESSO_ALL_REQUEST = NAMESPACE_PROCESSO + "fetchAllProcessosRequest";

//===================================### ADVOGADO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAdvogadoBAR#insertAdvogado(com.qat.samples.sysmgmt.base.model.Advogado)
 */
@Override
public InternalResponse insertAdvogado(Advogado advogado)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_ADVOGADO, advogado, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAdvogadoBAR#updateAdvogado(com.qat.samples.sysmgmt.base.model.Advogado)
 */
@Override
public InternalResponse updateAdvogado(Advogado advogado)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_ADVOGADO, advogado, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAdvogadoBAR#deleteAdvogado(com.qat.samples.sysmgmt.base.model.Advogado)
 */
@Override
public InternalResponse deleteAdvogadoById(Advogado advogado)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ADVOGADO, advogado, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAdvogadoBAR#deleteAllAdvogados()
 */
@Override
public InternalResponse deleteAllAdvogados()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_ADVOGADO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IAdvogadoBAR#fetchAdvogadoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Advogado fetchAdvogadoById(FetchByIdRequest request)
{
return (Advogado)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_ADVOGADO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAdvogadoBAR#fetchAllAdvogadosCache()
 */
@Override
public InternalResultsResponse<Advogado> fetchAllAdvogados(Advogado advogado)
{
	InternalResultsResponse<Advogado> response = new InternalResultsResponse<Advogado>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_ADVOGADO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IAdvogadoBAR#fetchAdvogadosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Advogado> fetchAdvogadosByRequest(AdvogadoInquiryRequest request)
{
	InternalResultsResponse<Advogado> response = new InternalResultsResponse<Advogado>();
	fetchAdvogadosByRequest(getSqlSession(), request, STMT_FETCH_ADVOGADO_COUNT, STMT_FETCH_ADVOGADO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchAdvogadosByRequest ####======================================

public static void fetchAdvogadosByRequest(SqlSession sqlSession, AdvogadoInquiryRequest request, String countStatement,
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


//===================================### AUDIENCIA ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAudienciaBAR#insertAudiencia(com.qat.samples.sysmgmt.base.model.Audiencia)
 */
@Override
public InternalResponse insertAudiencia(Audiencia audiencia)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_AUDIENCIA, audiencia, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAudienciaBAR#updateAudiencia(com.qat.samples.sysmgmt.base.model.Audiencia)
 */
@Override
public InternalResponse updateAudiencia(Audiencia audiencia)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_AUDIENCIA, audiencia, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAudienciaBAR#deleteAudiencia(com.qat.samples.sysmgmt.base.model.Audiencia)
 */
@Override
public InternalResponse deleteAudienciaById(Audiencia audiencia)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_AUDIENCIA, audiencia, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAudienciaBAR#deleteAllAudiencias()
 */
@Override
public InternalResponse deleteAllAudiencias()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_AUDIENCIA_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IAudienciaBAR#fetchAudienciaById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Audiencia fetchAudienciaById(FetchByIdRequest request)
{
return (Audiencia)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_AUDIENCIA, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IAudienciaBAR#fetchAllAudienciasCache()
 */
@Override
public InternalResultsResponse<Audiencia> fetchAllAudiencias(Audiencia audiencia)
{
	InternalResultsResponse<Audiencia> response = new InternalResultsResponse<Audiencia>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_AUDIENCIA_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IAudienciaBAR#fetchAudienciasByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Audiencia> fetchAudienciasByRequest(AudienciaInquiryRequest request)
{
	InternalResultsResponse<Audiencia> response = new InternalResultsResponse<Audiencia>();
	fetchAudienciasByRequest(getSqlSession(), request, STMT_FETCH_AUDIENCIA_COUNT, STMT_FETCH_AUDIENCIA_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchAudienciasByRequest ####======================================

public static void fetchAudienciasByRequest(SqlSession sqlSession, AudienciaInquiryRequest request, String countStatement,
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


//===================================### PROCESSO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IProcessoBAR#insertProcesso(com.qat.samples.sysmgmt.base.model.Processo)
 */
@Override
public InternalResponse insertProcesso(Processo processo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_PROCESSO, processo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IProcessoBAR#updateProcesso(com.qat.samples.sysmgmt.base.model.Processo)
 */
@Override
public InternalResponse updateProcesso(Processo processo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_PROCESSO, processo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IProcessoBAR#deleteProcesso(com.qat.samples.sysmgmt.base.model.Processo)
 */
@Override
public InternalResponse deleteProcessoById(Processo processo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_PROCESSO, processo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IProcessoBAR#deleteAllProcessos()
 */
@Override
public InternalResponse deleteAllProcessos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_PROCESSO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IProcessoBAR#fetchProcessoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Processo fetchProcessoById(FetchByIdRequest request)
{
return (Processo)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_PROCESSO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IProcessoBAR#fetchAllProcessosCache()
 */
@Override
public InternalResultsResponse<Processo> fetchAllProcessos(Processo processo)
{
	InternalResultsResponse<Processo> response = new InternalResultsResponse<Processo>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_PROCESSO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IProcessoBAR#fetchProcessosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Processo> fetchProcessosByRequest(ProcessoInquiryRequest request)
{
	InternalResultsResponse<Processo> response = new InternalResultsResponse<Processo>();
	fetchProcessosByRequest(getSqlSession(), request, STMT_FETCH_PROCESSO_COUNT, STMT_FETCH_PROCESSO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchProcessosByRequest ####======================================

public static void fetchProcessosByRequest(SqlSession sqlSession, ProcessoInquiryRequest request, String countStatement,
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
