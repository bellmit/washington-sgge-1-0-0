/** create by system gera-java version 1.0.0 11/05/2016 23:5 : 6*/
package com.qat.samples.sysmgmt.bar.mybatis.Financeiro;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResponse.BusinessErrorCategory;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.util.MyBatisBARHelper;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.agencia.model.Agencia;
import com.qat.samples.sysmgmt.agencia.model.request.AgenciaInquiryRequest;
import com.qat.samples.sysmgmt.banco.model.Banco;
import com.qat.samples.sysmgmt.banco.model.request.BancoInquiryRequest;
import com.qat.samples.sysmgmt.bar.Email.IEmailBAR;
import com.qat.samples.sysmgmt.bar.Endereco.IEnderecoBAR;
import com.qat.samples.sysmgmt.bar.Financeiro.IFinanceiroBAR;
import com.qat.samples.sysmgmt.bar.Historico.IHistoricoBAR;
import com.qat.samples.sysmgmt.bar.Status.IStatusBAR;
import com.qat.samples.sysmgmt.bar.Telefone.ITelefoneBAR;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.BaixaTituloBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.ContaCorrenteBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.EmailBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.EnderecoBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.InsertHistBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.StatusBARD;
import com.qat.samples.sysmgmt.bar.mybatis.delegate.TelefoneBARD;
import com.qat.samples.sysmgmt.condpag.model.CondPag;
import com.qat.samples.sysmgmt.condpag.model.FormaPg;
import com.qat.samples.sysmgmt.conta.model.Conta;
import com.qat.samples.sysmgmt.conta.model.ContaCorrente;
import com.qat.samples.sysmgmt.financeiro.model.BaixaTitulo;
import com.qat.samples.sysmgmt.financeiro.model.Caixa;
import com.qat.samples.sysmgmt.financeiro.model.ContasPagar;
import com.qat.samples.sysmgmt.financeiro.model.ContasReceber;
import com.qat.samples.sysmgmt.financeiro.model.TipoBaixa;
import com.qat.samples.sysmgmt.financeiro.model.Titulo;
import com.qat.samples.sysmgmt.financeiro.model.request.CaixaInquiryRequest;
import com.qat.samples.sysmgmt.financeiro.model.request.CondPagInquiryRequest;
import com.qat.samples.sysmgmt.financeiro.model.request.ContaCorrenteInquiryRequest;
import com.qat.samples.sysmgmt.financeiro.model.request.ContasPagarInquiryRequest;
import com.qat.samples.sysmgmt.financeiro.model.request.ContasReceberInquiryRequest;
import com.qat.samples.sysmgmt.financeiro.model.request.FormaPgInquiryRequest;
import com.qat.samples.sysmgmt.pessoa.model.request.ContaInquiryRequest;
import com.qat.samples.sysmgmt.util.model.AcaoEnum;
import com.qat.samples.sysmgmt.util.model.AcaoTypeEnum;
import com.qat.samples.sysmgmt.util.model.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.model.Status;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.TypeEnum;
import com.qat.samples.sysmgmt.util.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.util.model.request.PagedInquiryRequest;

/**
 * The Class CountyBARImpl. (Business Access Repository - BAR)
 */
@Repository
public class FinanceiroBARImpl extends SqlSessionDaoSupport implements IFinanceiroBAR
{

/** The Constant ZERO. */
	private static final int ZERO = 0;


///===================================### CONTASPAGAR ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONTASPAGAR = "ContasPagarMap.";

/** The Constant STMT_INSERT_CONTASPAGAR. */
private static final String STMT_INSERT_CONTASPAGAR = NAMESPACE_CONTASPAGAR + "insertContasPagar";

/** The Constant STMT_UPDATE_CONTASPAGAR. */
private static final String STMT_UPDATE_CONTASPAGAR = NAMESPACE_CONTASPAGAR + "updateContasPagar";

/** The Constant STMT_DELETE_CONTASPAGAR. */
private static final String STMT_DELETE_CONTASPAGAR = NAMESPACE_CONTASPAGAR + "deleteContasPagarById";

	/** The Constant STMT_DELETE_CONTASPAGAR_ALL. */
	private static final String STMT_DELETE_CONTASPAGAR_ALL = NAMESPACE_CONTASPAGAR + "deleteAllContasPagars";

	/** The Constant STMT_FETCH_CONTASPAGAR. */
	private static final String STMT_FETCH_CONTASPAGAR = NAMESPACE_CONTASPAGAR + "fetchContasPagarById";

	/** The Constant STMT_FETCH_CONTASPAGAR_ALL. */
	private static final String STMT_FETCH_CONTASPAGAR_ALL = NAMESPACE_CONTASPAGAR + "fetchAllContasPagars";

	/** The Constant STMT_FETCH_CONTASPAGAR_COUNT. */
	private static final String STMT_FETCH_CONTASPAGAR_COUNT = NAMESPACE_CONTASPAGAR + "fetchContasPagarRowCount";

	/** The Constant STMT_FETCH_CONTASPAGAR_ALL_REQUEST. */
	private static final String STMT_FETCH_CONTASPAGAR_ALL_REQUEST = NAMESPACE_CONTASPAGAR + "fetchAllContasPagarsRequest";

///===================================### TITULO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_TITULO = "TituloMap.";

/** The Constant STMT_INSERT_TITULO. */
private static final String STMT_INSERT_TITULO = NAMESPACE_TITULO + "insertTitulo";

/** The Constant STMT_UPDATE_TITULO. */
private static final String STMT_UPDATE_TITULO = NAMESPACE_TITULO + "updateTitulo";

/** The Constant STMT_DELETE_TITULO. */
private static final String STMT_DELETE_TITULO = NAMESPACE_TITULO + "deleteTituloById";

	/** The Constant STMT_DELETE_TITULO_ALL. */
	private static final String STMT_DELETE_TITULO_ALL = NAMESPACE_TITULO + "deleteAllTitulos";

	/** The Constant STMT_FETCH_TITULO. */
	private static final String STMT_FETCH_TITULO = NAMESPACE_TITULO + "fetchTituloById";

	/** The Constant STMT_FETCH_TITULO_ALL. */
	private static final String STMT_FETCH_TITULO_ALL = NAMESPACE_TITULO + "fetchAllTitulos";

	/** The Constant STMT_FETCH_TITULO_COUNT. */
	private static final String STMT_FETCH_TITULO_COUNT = NAMESPACE_TITULO + "fetchTituloRowCount";

	/** The Constant STMT_FETCH_TITULO_ALL_REQUEST. */
	private static final String STMT_FETCH_TITULO_ALL_REQUEST = NAMESPACE_TITULO + "fetchAllTitulosRequest";

///===================================### BAIXATITULO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_BAIXATITULO = "BaixaTituloMap.";

/** The Constant STMT_INSERT_BAIXATITULO. */
private static final String STMT_INSERT_BAIXATITULO = NAMESPACE_BAIXATITULO + "insertBaixaTitulo";

/** The Constant STMT_UPDATE_BAIXATITULO. */
private static final String STMT_UPDATE_BAIXATITULO = NAMESPACE_BAIXATITULO + "updateBaixaTitulo";

/** The Constant STMT_DELETE_BAIXATITULO. */
private static final String STMT_DELETE_BAIXATITULO = NAMESPACE_BAIXATITULO + "deleteBaixaTituloById";

	/** The Constant STMT_DELETE_BAIXATITULO_ALL. */
	private static final String STMT_DELETE_BAIXATITULO_ALL = NAMESPACE_BAIXATITULO + "deleteAllBaixaTitulos";

	/** The Constant STMT_FETCH_BAIXATITULO. */
	private static final String STMT_FETCH_BAIXATITULO = NAMESPACE_BAIXATITULO + "fetchBaixaTituloById";

	/** The Constant STMT_FETCH_BAIXATITULO_ALL. */
	private static final String STMT_FETCH_BAIXATITULO_ALL = NAMESPACE_BAIXATITULO + "fetchAllBaixaTitulos";

	/** The Constant STMT_FETCH_BAIXATITULO_COUNT. */
	private static final String STMT_FETCH_BAIXATITULO_COUNT = NAMESPACE_BAIXATITULO + "fetchBaixaTituloRowCount";

	/** The Constant STMT_FETCH_BAIXATITULO_ALL_REQUEST. */
	private static final String STMT_FETCH_BAIXATITULO_ALL_REQUEST = NAMESPACE_BAIXATITULO + "fetchAllBaixaTitulosRequest";

///===================================### TIPOBAIXA ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_TIPOBAIXA = "TipoBaixaMap.";

/** The Constant STMT_INSERT_TIPOBAIXA. */
private static final String STMT_INSERT_TIPOBAIXA = NAMESPACE_TIPOBAIXA + "insertTipoBaixa";

/** The Constant STMT_UPDATE_TIPOBAIXA. */
private static final String STMT_UPDATE_TIPOBAIXA = NAMESPACE_TIPOBAIXA + "updateTipoBaixa";

/** The Constant STMT_DELETE_TIPOBAIXA. */
private static final String STMT_DELETE_TIPOBAIXA = NAMESPACE_TIPOBAIXA + "deleteTipoBaixaById";

	/** The Constant STMT_DELETE_TIPOBAIXA_ALL. */
	private static final String STMT_DELETE_TIPOBAIXA_ALL = NAMESPACE_TIPOBAIXA + "deleteAllTipoBaixas";

	/** The Constant STMT_FETCH_TIPOBAIXA. */
	private static final String STMT_FETCH_TIPOBAIXA = NAMESPACE_TIPOBAIXA + "fetchTipoBaixaById";

	/** The Constant STMT_FETCH_TIPOBAIXA_ALL. */
	private static final String STMT_FETCH_TIPOBAIXA_ALL = NAMESPACE_TIPOBAIXA + "fetchAllTipoBaixas";

	/** The Constant STMT_FETCH_TIPOBAIXA_COUNT. */
	private static final String STMT_FETCH_TIPOBAIXA_COUNT = NAMESPACE_TIPOBAIXA + "fetchTipoBaixaRowCount";

	/** The Constant STMT_FETCH_TIPOBAIXA_ALL_REQUEST. */
	private static final String STMT_FETCH_TIPOBAIXA_ALL_REQUEST = NAMESPACE_TIPOBAIXA + "fetchAllTipoBaixasRequest";

///===================================### CONTASRECEBER ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONTASRECEBER = "ContasReceberMap.";

/** The Constant STMT_INSERT_CONTASRECEBER. */
private static final String STMT_INSERT_CONTASRECEBER = NAMESPACE_CONTASRECEBER + "insertContasReceber";

/** The Constant STMT_UPDATE_CONTASRECEBER. */
private static final String STMT_UPDATE_CONTASRECEBER = NAMESPACE_CONTASRECEBER + "updateContasReceber";

/** The Constant STMT_DELETE_CONTASRECEBER. */
private static final String STMT_DELETE_CONTASRECEBER = NAMESPACE_CONTASRECEBER + "deleteContasReceberById";

	/** The Constant STMT_DELETE_CONTASRECEBER_ALL. */
	private static final String STMT_DELETE_CONTASRECEBER_ALL = NAMESPACE_CONTASRECEBER + "deleteAllContasRecebers";

	/** The Constant STMT_FETCH_CONTASRECEBER. */
	private static final String STMT_FETCH_CONTASRECEBER = NAMESPACE_CONTASRECEBER + "fetchContasReceberById";

	/** The Constant STMT_FETCH_CONTASRECEBER_ALL. */
	private static final String STMT_FETCH_CONTASRECEBER_ALL = NAMESPACE_CONTASRECEBER + "fetchAllContasRecebers";

	/** The Constant STMT_FETCH_CONTASRECEBER_COUNT. */
	private static final String STMT_FETCH_CONTASRECEBER_COUNT = NAMESPACE_CONTASRECEBER + "fetchContasReceberRowCount";

	/** The Constant STMT_FETCH_CONTASRECEBER_ALL_REQUEST. */
	private static final String STMT_FETCH_CONTASRECEBER_ALL_REQUEST = NAMESPACE_CONTASRECEBER + "fetchAllContasRecebersRequest";

///===================================### CONDPAG ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONDPAG = "CondPagMap.";

/** The Constant STMT_INSERT_CONDPAG. */
private static final String STMT_INSERT_CONDPAG = NAMESPACE_CONDPAG + "insertCondPag";

/** The Constant STMT_UPDATE_CONDPAG. */
private static final String STMT_UPDATE_CONDPAG = NAMESPACE_CONDPAG + "updateCondPag";

/** The Constant STMT_DELETE_CONDPAG. */
private static final String STMT_DELETE_CONDPAG = NAMESPACE_CONDPAG + "deleteCondPagById";

	/** The Constant STMT_DELETE_CONDPAG_ALL. */
	private static final String STMT_DELETE_CONDPAG_ALL = NAMESPACE_CONDPAG + "deleteAllCondPags";

	/** The Constant STMT_FETCH_CONDPAG. */
	private static final String STMT_FETCH_CONDPAG = NAMESPACE_CONDPAG + "fetchCondPagById";

	/** The Constant STMT_FETCH_CONDPAG_ALL. */
	private static final String STMT_FETCH_CONDPAG_ALL = NAMESPACE_CONDPAG + "fetchAllCondPags";

	/** The Constant STMT_FETCH_CONDPAG_COUNT. */
	private static final String STMT_FETCH_CONDPAG_COUNT = NAMESPACE_CONDPAG + "fetchCondPagRowCount";

	/** The Constant STMT_FETCH_CONDPAG_ALL_REQUEST. */
	private static final String STMT_FETCH_CONDPAG_ALL_REQUEST = NAMESPACE_CONDPAG + "fetchAllCondPagsRequest";

///===================================### FORMAPG ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_FORMAPG = "FormaPgMap.";

/** The Constant STMT_INSERT_FORMAPG. */
private static final String STMT_INSERT_FORMAPG = NAMESPACE_FORMAPG + "insertFormaPg";

/** The Constant STMT_UPDATE_FORMAPG. */
private static final String STMT_UPDATE_FORMAPG = NAMESPACE_FORMAPG + "updateFormaPg";

/** The Constant STMT_DELETE_FORMAPG. */
private static final String STMT_DELETE_FORMAPG = NAMESPACE_FORMAPG + "deleteFormaPgById";

	/** The Constant STMT_DELETE_FORMAPG_ALL. */
	private static final String STMT_DELETE_FORMAPG_ALL = NAMESPACE_FORMAPG + "deleteAllFormaPgs";

	/** The Constant STMT_FETCH_FORMAPG. */
	private static final String STMT_FETCH_FORMAPG = NAMESPACE_FORMAPG + "fetchFormaPgById";

	/** The Constant STMT_FETCH_FORMAPG_ALL. */
	private static final String STMT_FETCH_FORMAPG_ALL = NAMESPACE_FORMAPG + "fetchAllFormaPgs";

	/** The Constant STMT_FETCH_FORMAPG_COUNT. */
	private static final String STMT_FETCH_FORMAPG_COUNT = NAMESPACE_FORMAPG + "fetchFormaPgRowCount";

	/** The Constant STMT_FETCH_FORMAPG_ALL_REQUEST. */
	private static final String STMT_FETCH_FORMAPG_ALL_REQUEST = NAMESPACE_FORMAPG + "fetchAllFormaPgsRequest";

///===================================### BANCO ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_BANCO = "BancoMap.";

/** The Constant STMT_INSERT_BANCO. */
private static final String STMT_INSERT_BANCO = NAMESPACE_BANCO + "insertBanco";

/** The Constant STMT_UPDATE_BANCO. */
private static final String STMT_UPDATE_BANCO = NAMESPACE_BANCO + "updateBanco";

/** The Constant STMT_DELETE_BANCO. */
private static final String STMT_DELETE_BANCO = NAMESPACE_BANCO + "deleteBancoById";

	/** The Constant STMT_DELETE_BANCO_ALL. */
	private static final String STMT_DELETE_BANCO_ALL = NAMESPACE_BANCO + "deleteAllBancos";

	/** The Constant STMT_FETCH_BANCO. */
	private static final String STMT_FETCH_BANCO = NAMESPACE_BANCO + "fetchBancoById";

	/** The Constant STMT_FETCH_BANCO_ALL. */
	private static final String STMT_FETCH_BANCO_ALL = NAMESPACE_BANCO + "fetchAllBancos";

	/** The Constant STMT_FETCH_BANCO_COUNT. */
	private static final String STMT_FETCH_BANCO_COUNT = NAMESPACE_BANCO + "fetchBancoRowCount";

	/** The Constant STMT_FETCH_BANCO_ALL_REQUEST. */
	private static final String STMT_FETCH_BANCO_ALL_REQUEST = NAMESPACE_BANCO + "fetchAllBancosRequest";

///===================================### CONTACORRENTE ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CONTACORRENTE = "ContaCorrenteMap.";

/** The Constant STMT_INSERT_CONTACORRENTE. */
private static final String STMT_INSERT_CONTACORRENTE = NAMESPACE_CONTACORRENTE + "insertContaCorrente";

/** The Constant STMT_UPDATE_CONTACORRENTE. */
private static final String STMT_UPDATE_CONTACORRENTE = NAMESPACE_CONTACORRENTE + "updateContaCorrente";

/** The Constant STMT_DELETE_CONTACORRENTE. */
private static final String STMT_DELETE_CONTACORRENTE = NAMESPACE_CONTACORRENTE + "deleteContaCorrenteById";

	/** The Constant STMT_DELETE_CONTACORRENTE_ALL. */
	private static final String STMT_DELETE_CONTACORRENTE_ALL = NAMESPACE_CONTACORRENTE + "deleteAllContaCorrentes";

	/** The Constant STMT_FETCH_CONTACORRENTE. */
	private static final String STMT_FETCH_CONTACORRENTE = NAMESPACE_CONTACORRENTE + "fetchContaCorrenteById";

	/** The Constant STMT_FETCH_CONTACORRENTE_ALL. */
	private static final String STMT_FETCH_CONTACORRENTE_ALL = NAMESPACE_CONTACORRENTE + "fetchAllContaCorrentes";

	/** The Constant STMT_FETCH_CONTACORRENTE_COUNT. */
	private static final String STMT_FETCH_CONTACORRENTE_COUNT = NAMESPACE_CONTACORRENTE + "fetchContaCorrenteRowCount";

	/** The Constant STMT_FETCH_CONTACORRENTE_ALL_REQUEST. */
	private static final String STMT_FETCH_CONTACORRENTE_ALL_REQUEST = NAMESPACE_CONTACORRENTE + "fetchAllContaCorrentesRequest";

	
	///===================================### CONTA ####======================================
	/** The Constant NAMESPACE. */
	private static final String NAMESPACE_CONTA = "ContaMap.";

	/** The Constant STMT_INSERT_CONTA. */
	private static final String STMT_INSERT_CONTA = NAMESPACE_CONTA + "insertConta";

	/** The Constant STMT_UPDATE_CONTA. */
	private static final String STMT_UPDATE_CONTA = NAMESPACE_CONTA + "updateConta";

	/** The Constant STMT_DELETE_CONTA. */
	private static final String STMT_DELETE_CONTA = NAMESPACE_CONTA + "deleteContaById";

		/** The Constant STMT_DELETE_CONTA_ALL. */
		private static final String STMT_DELETE_CONTA_ALL = NAMESPACE_CONTA + "deleteAllContas";

		/** The Constant STMT_FETCH_CONTA. */
		private static final String STMT_FETCH_CONTA = NAMESPACE_CONTA + "fetchContaById";

		/** The Constant STMT_FETCH_CONTA_ALL. */
		private static final String STMT_FETCH_CONTA_ALL = NAMESPACE_CONTA + "fetchAllContas";

		/** The Constant STMT_FETCH_CONTA_COUNT. */
		private static final String STMT_FETCH_CONTA_COUNT = NAMESPACE_CONTA + "fetchContaRowCount";

		/** The Constant STMT_FETCH_CONTA_ALL_REQUEST. */
		private static final String STMT_FETCH_CONTA_ALL_REQUEST = NAMESPACE_CONTA + "fetchAllContasRequest";

///===================================### CAIXA ####======================================
/** The Constant NAMESPACE. */
private static final String NAMESPACE_CAIXA = "CaixaMap.";

/** The Constant STMT_INSERT_CAIXA. */
private static final String STMT_INSERT_CAIXA = NAMESPACE_CAIXA + "insertCaixa";

/** The Constant STMT_UPDATE_CAIXA. */
private static final String STMT_UPDATE_CAIXA = NAMESPACE_CAIXA + "updateCaixa";

/** The Constant STMT_DELETE_CAIXA. */
private static final String STMT_DELETE_CAIXA = NAMESPACE_CAIXA + "deleteCaixaById";

	/** The Constant STMT_DELETE_CAIXA_ALL. */
	private static final String STMT_DELETE_CAIXA_ALL = NAMESPACE_CAIXA + "deleteAllCaixas";

	/** The Constant STMT_FETCH_CAIXA. */
	private static final String STMT_FETCH_CAIXA = NAMESPACE_CAIXA + "fetchCaixaById";

	/** The Constant STMT_FETCH_CAIXA_ALL. */
	private static final String STMT_FETCH_CAIXA_ALL = NAMESPACE_CAIXA + "fetchAllCaixas";

	/** The Constant STMT_FETCH_CAIXA_COUNT. */
	private static final String STMT_FETCH_CAIXA_COUNT = NAMESPACE_CAIXA + "fetchCaixaRowCount";

	/** The Constant STMT_FETCH_CAIXA_ALL_REQUEST. */
	private static final String STMT_FETCH_CAIXA_ALL_REQUEST = NAMESPACE_CAIXA + "fetchAllCaixasRequest";
	
	
	///===================================### AGENCIA ####======================================
	/** The Constant NAMESPACE. */
	private static final String NAMESPACE_AGENCIA = "AgenciaMap.";

	/** The Constant STMT_INSERT_AGENCIA. */
	private static final String STMT_INSERT_AGENCIA = NAMESPACE_AGENCIA + "insertAgencia";

	/** The Constant STMT_UPDATE_AGENCIA. */
	private static final String STMT_UPDATE_AGENCIA = NAMESPACE_AGENCIA + "updateAgencia";

	/** The Constant STMT_DELETE_AGENCIA. */
	private static final String STMT_DELETE_AGENCIA = NAMESPACE_AGENCIA + "deleteAgenciaById";

		/** The Constant STMT_DELETE_AGENCIA_ALL. */
		private static final String STMT_DELETE_AGENCIA_ALL = NAMESPACE_AGENCIA + "deleteAllAgencias";

		/** The Constant STMT_FETCH_AGENCIA. */
		private static final String STMT_FETCH_AGENCIA = NAMESPACE_AGENCIA + "fetchAgenciaById";

		/** The Constant STMT_FETCH_AGENCIA_ALL. */
		private static final String STMT_FETCH_AGENCIA_ALL = NAMESPACE_AGENCIA + "fetchAllAgencias";

		/** The Constant STMT_FETCH_AGENCIA_COUNT. */
		private static final String STMT_FETCH_AGENCIA_COUNT = NAMESPACE_AGENCIA + "fetchAgenciaRowCount";

		/** The Constant STMT_FETCH_AGENCIA_ALL_REQUEST. */
		private static final String STMT_FETCH_AGENCIA_ALL_REQUEST = NAMESPACE_AGENCIA + "fetchAllAgenciasRequest";

	IStatusBAR statusBAR;

	IHistoricoBAR historicoBAR;

	IFinanceiroBAR financeiroBAR;
	
	
	IEnderecoBAR enderecoBAR;
	IEmailBAR emailBAR;
	ITelefoneBAR telefoneBAR;


	public IStatusBAR getStatusBAR() {
		return statusBAR;
	}

	public void setStatusBAR(IStatusBAR statusBAR) {
		this.statusBAR = statusBAR;
	}

	public IHistoricoBAR getHistoricoBAR() {
		return historicoBAR;
	}

	public void setHistoricoBAR(IHistoricoBAR historicoBAR) {
		this.historicoBAR = historicoBAR;
	}

	public IFinanceiroBAR getFinanceiroBAR() {
		return financeiroBAR;
	}

	public void setFinanceiroBAR(IFinanceiroBAR financeiroBAR) {
		this.financeiroBAR = financeiroBAR;
	}

	public IEnderecoBAR getEnderecoBAR() {
		return enderecoBAR;
	}

	public void setEnderecoBAR(IEnderecoBAR enderecoBAR) {
		this.enderecoBAR = enderecoBAR;
	}

	public IEmailBAR getEmailBAR() {
		return emailBAR;
	}

	public void setEmailBAR(IEmailBAR emailBAR) {
		this.emailBAR = emailBAR;
	}

	public ITelefoneBAR getTelefoneBAR() {
		return telefoneBAR;
	}

	public void setTelefoneBAR(ITelefoneBAR telefoneBAR) {
		this.telefoneBAR = telefoneBAR;
	}

	//===================================### CONTASPAGAR ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasPagarBAR#insertContasPagar(com.qat.samples.sysmgmt.base.model.ContasPagar)
 */
@Override
public InternalResponse insertContasPagar(ContasPagar contaspagar)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.CONTA, getHistoricoBAR(), response);
	
	contaspagar.setProcessId(historicoId);
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTASPAGAR, contaspagar, response);
	
	BaixaTituloBARD.maintainBaixaTituloAssociations(contaspagar.getListBaixa(), response, contaspagar.getId(), TypeEnum.HIGH, AcaoTypeEnum.INSERT, TabelaEnum.CONTASPAGAR, getFinanceiroBAR(), statusBAR, historicoBAR, contaspagar.getEmprId(), contaspagar.getUserId(), historicoId, historicoId);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasPagarBAR#updateContasPagar(com.qat.samples.sysmgmt.base.model.ContasPagar)
 */
@Override
public InternalResponse updateContasPagar(ContasPagar contaspagar)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTASPAGAR, contaspagar, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasPagarBAR#deleteContasPagar(com.qat.samples.sysmgmt.base.model.ContasPagar)
 */
@Override
public InternalResponse deleteContasPagarById(ContasPagar contaspagar)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTASPAGAR, contaspagar, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasPagarBAR#deleteAllContasPagars()
 */
@Override
public InternalResponse deleteAllContasPagars()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTASPAGAR_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IContasPagarBAR#fetchContasPagarById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public ContasPagar fetchContasPagarById(FetchByIdRequest request)
{
return (ContasPagar)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTASPAGAR, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasPagarBAR#fetchAllContasPagarsCache()
 */
@Override
public InternalResultsResponse<ContasPagar> fetchAllContasPagars(ContasPagar contaspagar)
{
	InternalResultsResponse<ContasPagar> response = new InternalResultsResponse<ContasPagar>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTASPAGAR_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IContasPagarBAR#fetchContasPagarsByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<ContasPagar> fetchContasPagarsByRequest(ContasPagarInquiryRequest request)
{
	InternalResultsResponse<ContasPagar> response = new InternalResultsResponse<ContasPagar>();
	fetchContasPagarsByRequest(getSqlSession(), request, STMT_FETCH_CONTASPAGAR_COUNT, STMT_FETCH_CONTASPAGAR_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContasPagarsByRequest ####======================================

public static void fetchContasPagarsByRequest(SqlSession sqlSession, ContasPagarInquiryRequest request, String countStatement,
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


//===================================### TITULO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITituloBAR#insertTitulo(com.qat.samples.sysmgmt.base.model.Titulo)
 */
@Override
public InternalResponse insertTitulo(Titulo titulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_TITULO, titulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITituloBAR#updateTitulo(com.qat.samples.sysmgmt.base.model.Titulo)
 */
@Override
public InternalResponse updateTitulo(Titulo titulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_TITULO, titulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITituloBAR#deleteTitulo(com.qat.samples.sysmgmt.base.model.Titulo)
 */
@Override
public InternalResponse deleteTituloById(Titulo titulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_TITULO, titulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITituloBAR#deleteAllTitulos()
 */
@Override
public InternalResponse deleteAllTitulos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_TITULO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.ITituloBAR#fetchTituloById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Titulo fetchTituloById(FetchByIdRequest request)
{
return (Titulo)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_TITULO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITituloBAR#fetchAllTitulosCache()
 */
@Override
public InternalResultsResponse<Titulo> fetchAllTitulos(Titulo titulo)
{
	InternalResultsResponse<Titulo> response = new InternalResultsResponse<Titulo>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_TITULO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.ITituloBAR#fetchTitulosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Titulo> fetchTitulosByRequest(PagedInquiryRequest request)
{
	InternalResultsResponse<Titulo> response = new InternalResultsResponse<Titulo>();
	fetchTitulosByRequest(getSqlSession(), request, STMT_FETCH_TITULO_COUNT, STMT_FETCH_TITULO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchTitulosByRequest ####======================================

public static void fetchTitulosByRequest(SqlSession sqlSession, PagedInquiryRequest request, String countStatement,
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


//===================================### BAIXATITULO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBaixaTituloBAR#insertBaixaTitulo(com.qat.samples.sysmgmt.base.model.BaixaTitulo)
 */
@Override
public InternalResponse insertBaixaTitulo(BaixaTitulo baixatitulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_BAIXATITULO, baixatitulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBaixaTituloBAR#updateBaixaTitulo(com.qat.samples.sysmgmt.base.model.BaixaTitulo)
 */
@Override
public InternalResponse updateBaixaTitulo(BaixaTitulo baixatitulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_BAIXATITULO, baixatitulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBaixaTituloBAR#deleteBaixaTitulo(com.qat.samples.sysmgmt.base.model.BaixaTitulo)
 */
@Override
public InternalResponse deleteBaixaTituloById(BaixaTitulo baixatitulo)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_BAIXATITULO, baixatitulo, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBaixaTituloBAR#deleteAllBaixaTitulos()
 */
@Override
public InternalResponse deleteAllBaixaTitulos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_BAIXATITULO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IBaixaTituloBAR#fetchBaixaTituloById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public BaixaTitulo fetchBaixaTituloById(FetchByIdRequest request)
{
return (BaixaTitulo)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_BAIXATITULO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBaixaTituloBAR#fetchAllBaixaTitulosCache()
 */
@Override
public InternalResultsResponse<BaixaTitulo> fetchAllBaixaTitulos(BaixaTitulo baixatitulo)
{
	InternalResultsResponse<BaixaTitulo> response = new InternalResultsResponse<BaixaTitulo>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_BAIXATITULO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IBaixaTituloBAR#fetchBaixaTitulosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<BaixaTitulo> fetchBaixaTitulosByRequest(PagedInquiryRequest request)
{
	InternalResultsResponse<BaixaTitulo> response = new InternalResultsResponse<BaixaTitulo>();
	fetchBaixaTitulosByRequest(getSqlSession(), request, STMT_FETCH_BAIXATITULO_COUNT, STMT_FETCH_BAIXATITULO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchBaixaTitulosByRequest ####======================================

public static void fetchBaixaTitulosByRequest(SqlSession sqlSession, PagedInquiryRequest request, String countStatement,
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


//===================================### TIPOBAIXA ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITipoBaixaBAR#insertTipoBaixa(com.qat.samples.sysmgmt.base.model.TipoBaixa)
 */
@Override
public InternalResponse insertTipoBaixa(TipoBaixa tipobaixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_TIPOBAIXA, tipobaixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITipoBaixaBAR#updateTipoBaixa(com.qat.samples.sysmgmt.base.model.TipoBaixa)
 */
@Override
public InternalResponse updateTipoBaixa(TipoBaixa tipobaixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_TIPOBAIXA, tipobaixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITipoBaixaBAR#deleteTipoBaixa(com.qat.samples.sysmgmt.base.model.TipoBaixa)
 */
@Override
public InternalResponse deleteTipoBaixaById(TipoBaixa tipobaixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_TIPOBAIXA, tipobaixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITipoBaixaBAR#deleteAllTipoBaixas()
 */
@Override
public InternalResponse deleteAllTipoBaixas()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_TIPOBAIXA_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.ITipoBaixaBAR#fetchTipoBaixaById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public TipoBaixa fetchTipoBaixaById(FetchByIdRequest request)
{
return (TipoBaixa)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_TIPOBAIXA, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ITipoBaixaBAR#fetchAllTipoBaixasCache()
 */
@Override
public InternalResultsResponse<TipoBaixa> fetchAllTipoBaixas(TipoBaixa tipobaixa)
{
	InternalResultsResponse<TipoBaixa> response = new InternalResultsResponse<TipoBaixa>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_TIPOBAIXA_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.ITipoBaixaBAR#fetchTipoBaixasByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<TipoBaixa> fetchTipoBaixasByRequest(PagedInquiryRequest request)
{
	InternalResultsResponse<TipoBaixa> response = new InternalResultsResponse<TipoBaixa>();
	fetchTipoBaixasByRequest(getSqlSession(), request, STMT_FETCH_TIPOBAIXA_COUNT, STMT_FETCH_TIPOBAIXA_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchTipoBaixasByRequest ####======================================

public static void fetchTipoBaixasByRequest(SqlSession sqlSession, PagedInquiryRequest request, String countStatement,
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


//===================================### CONTASRECEBER ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasReceberBAR#insertContasReceber(com.qat.samples.sysmgmt.base.model.ContasReceber)
 */
@Override
public InternalResponse insertContasReceber(ContasReceber contasreceber)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTASRECEBER, contasreceber, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasReceberBAR#updateContasReceber(com.qat.samples.sysmgmt.base.model.ContasReceber)
 */
@Override
public InternalResponse updateContasReceber(ContasReceber contasreceber)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTASRECEBER, contasreceber, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasReceberBAR#deleteContasReceber(com.qat.samples.sysmgmt.base.model.ContasReceber)
 */
@Override
public InternalResponse deleteContasReceberById(ContasReceber contasreceber)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTASRECEBER, contasreceber, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasReceberBAR#deleteAllContasRecebers()
 */
@Override
public InternalResponse deleteAllContasRecebers()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTASRECEBER_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IContasReceberBAR#fetchContasReceberById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public ContasReceber fetchContasReceberById(FetchByIdRequest request)
{
return (ContasReceber)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTASRECEBER, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContasReceberBAR#fetchAllContasRecebersCache()
 */
@Override
public InternalResultsResponse<ContasReceber> fetchAllContasRecebers(ContasReceber contasreceber)
{
	InternalResultsResponse<ContasReceber> response = new InternalResultsResponse<ContasReceber>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTASRECEBER_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IContasReceberBAR#fetchContasRecebersByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<ContasReceber> fetchContasRecebersByRequest(ContasReceberInquiryRequest request)
{
	InternalResultsResponse<ContasReceber> response = new InternalResultsResponse<ContasReceber>();
	fetchContasRecebersByRequest(getSqlSession(), request, STMT_FETCH_CONTASRECEBER_COUNT, STMT_FETCH_CONTASRECEBER_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContasRecebersByRequest ####======================================

public static void fetchContasRecebersByRequest(SqlSession sqlSession, ContasReceberInquiryRequest request, String countStatement,
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


//===================================### CONDPAG ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICondPagBAR#insertCondPag(com.qat.samples.sysmgmt.base.model.CondPag)
 */
@Override
public InternalResponse insertCondPag(CondPag condpag)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONDPAG, condpag, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICondPagBAR#updateCondPag(com.qat.samples.sysmgmt.base.model.CondPag)
 */
@Override
public InternalResponse updateCondPag(CondPag condpag)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONDPAG, condpag, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICondPagBAR#deleteCondPag(com.qat.samples.sysmgmt.base.model.CondPag)
 */
@Override
public InternalResponse deleteCondPagById(CondPag condpag)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONDPAG, condpag, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICondPagBAR#deleteAllCondPags()
 */
@Override
public InternalResponse deleteAllCondPags()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONDPAG_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.ICondPagBAR#fetchCondPagById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public CondPag fetchCondPagById(FetchByIdRequest request)
{
return (CondPag)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONDPAG, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICondPagBAR#fetchAllCondPagsCache()
 */
@Override
public InternalResultsResponse<CondPag> fetchAllCondPags(CondPag condpag)
{
	InternalResultsResponse<CondPag> response = new InternalResultsResponse<CondPag>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONDPAG_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.ICondPagBAR#fetchCondPagsByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<CondPag> fetchCondPagsByRequest(CondPagInquiryRequest request)
{
	InternalResultsResponse<CondPag> response = new InternalResultsResponse<CondPag>();
	fetchCondPagsByRequest(getSqlSession(), request, STMT_FETCH_CONDPAG_COUNT, STMT_FETCH_CONDPAG_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchCondPagsByRequest ####======================================

public static void fetchCondPagsByRequest(SqlSession sqlSession, CondPagInquiryRequest request, String countStatement,
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


//===================================### FORMAPG ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IFormaPgBAR#insertFormaPg(com.qat.samples.sysmgmt.base.model.FormaPg)
 */
@Override
public InternalResponse insertFormaPg(FormaPg formapg)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_FORMAPG, formapg, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IFormaPgBAR#updateFormaPg(com.qat.samples.sysmgmt.base.model.FormaPg)
 */
@Override
public InternalResponse updateFormaPg(FormaPg formapg)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_FORMAPG, formapg, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IFormaPgBAR#deleteFormaPg(com.qat.samples.sysmgmt.base.model.FormaPg)
 */
@Override
public InternalResponse deleteFormaPgById(FormaPg formapg)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_FORMAPG, formapg, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IFormaPgBAR#deleteAllFormaPgs()
 */
@Override
public InternalResponse deleteAllFormaPgs()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_FORMAPG_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IFormaPgBAR#fetchFormaPgById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public FormaPg fetchFormaPgById(FetchByIdRequest request)
{
return (FormaPg)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_FORMAPG, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IFormaPgBAR#fetchAllFormaPgsCache()
 */
@Override
public InternalResultsResponse<FormaPg> fetchAllFormaPgs(FormaPg formapg)
{
	InternalResultsResponse<FormaPg> response = new InternalResultsResponse<FormaPg>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_FORMAPG_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IFormaPgBAR#fetchFormaPgsByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<FormaPg> fetchFormaPgsByRequest(FormaPgInquiryRequest request)
{
	InternalResultsResponse<FormaPg> response = new InternalResultsResponse<FormaPg>();
	fetchFormaPgsByRequest(getSqlSession(), request, STMT_FETCH_FORMAPG_COUNT, STMT_FETCH_FORMAPG_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchFormaPgsByRequest ####======================================

public static void fetchFormaPgsByRequest(SqlSession sqlSession, FormaPgInquiryRequest request, String countStatement,
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


//===================================### BANCO ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBancoBAR#insertBanco(com.qat.samples.sysmgmt.base.model.Banco)
 */
@Override
public InternalResponse insertBanco(Banco banco)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_BANCO, banco, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBancoBAR#updateBanco(com.qat.samples.sysmgmt.base.model.Banco)
 */
@Override
public InternalResponse updateBanco(Banco banco)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_BANCO, banco, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBancoBAR#deleteBanco(com.qat.samples.sysmgmt.base.model.Banco)
 */
@Override
public InternalResponse deleteBancoById(Banco banco)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_BANCO, banco, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBancoBAR#deleteAllBancos()
 */
@Override
public InternalResponse deleteAllBancos()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_BANCO_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IBancoBAR#fetchBancoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Banco fetchBancoById(FetchByIdRequest request)
{
return (Banco)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_BANCO, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IBancoBAR#fetchAllBancosCache()
 */
@Override
public InternalResultsResponse<Banco> fetchAllBancos(Banco banco)
{
	InternalResultsResponse<Banco> response = new InternalResultsResponse<Banco>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_BANCO_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IBancoBAR#fetchBancosByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Banco> fetchBancosByRequest(BancoInquiryRequest request)
{
	InternalResultsResponse<Banco> response = new InternalResultsResponse<Banco>();
	fetchBancosByRequest(getSqlSession(), request, STMT_FETCH_BANCO_COUNT, STMT_FETCH_BANCO_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchBancosByRequest ####======================================

public static void fetchBancosByRequest(SqlSession sqlSession, BancoInquiryRequest request, String countStatement,
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


//===================================### CONTACORRENTE ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContaCorrenteBAR#insertContaCorrente(com.qat.samples.sysmgmt.base.model.ContaCorrente)
 */
@Override
public InternalResponse insertContaCorrente(ContaCorrente contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTACORRENTE, contacorrente, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContaCorrenteBAR#updateContaCorrente(com.qat.samples.sysmgmt.base.model.ContaCorrente)
 */
@Override
public InternalResponse updateContaCorrente(ContaCorrente contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTACORRENTE, contacorrente, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContaCorrenteBAR#deleteContaCorrente(com.qat.samples.sysmgmt.base.model.ContaCorrente)
 */
@Override
public InternalResponse deleteContaCorrenteById(ContaCorrente contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTACORRENTE, contacorrente, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContaCorrenteBAR#deleteAllContaCorrentes()
 */
@Override
public InternalResponse deleteAllContaCorrentes()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTACORRENTE_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.IContaCorrenteBAR#fetchContaCorrenteById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public ContaCorrente fetchContaCorrenteById(FetchByIdRequest request)
{
return (ContaCorrente)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTACORRENTE, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.IContaCorrenteBAR#fetchAllContaCorrentesCache()
 */
@Override
public InternalResultsResponse<ContaCorrente> fetchAllContaCorrentes(ContaCorrente contacorrente)
{
	InternalResultsResponse<ContaCorrente> response = new InternalResultsResponse<ContaCorrente>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTACORRENTE_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.IContaCorrenteBAR#fetchContaCorrentesByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<ContaCorrente> fetchContaCorrentesByRequest(ContaCorrenteInquiryRequest request)
{
	InternalResultsResponse<ContaCorrente> response = new InternalResultsResponse<ContaCorrente>();
	fetchContaCorrentesByRequest(getSqlSession(), request, STMT_FETCH_CONTACORRENTE_COUNT, STMT_FETCH_CONTACORRENTE_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContaCorrentesByRequest ####======================================

public static void fetchContaCorrentesByRequest(SqlSession sqlSession, ContaCorrenteInquiryRequest request, String countStatement,
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


//===================================### CONTA ####======================================
	/**
/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IContaBAR#insertConta(com.qat.samples.sysmgmt.base.model.Conta)
*/
@Override
public InternalResponse insertConta(Conta contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CONTA, contacorrente, response);
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IContaBAR#updateConta(com.qat.samples.sysmgmt.base.model.Conta)
*/
@Override
public InternalResponse updateConta(Conta contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CONTA, contacorrente, response);
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IContaBAR#deleteConta(com.qat.samples.sysmgmt.base.model.Conta)
*/
@Override
public InternalResponse deleteContaById(Conta contacorrente)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTA, contacorrente, response);
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IContaBAR#deleteAllContas()
*/
@Override
public InternalResponse deleteAllContas()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CONTA_ALL, response);
	return response;
}

/*
* (non-Javadoc)
* @see
* com.qat.samples.sysmgmt.bar.IContaBAR#fetchContaById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
*/
@Override
public Conta fetchContaById(FetchByIdRequest request)
{
return (Conta)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CONTA, request.getFetchId());

}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IContaBAR#fetchAllContasCache()
*/
@Override
public InternalResultsResponse<Conta> fetchAllContas(Conta contacorrente)
{
	InternalResultsResponse<Conta> response = new InternalResultsResponse<Conta>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CONTA_ALL));
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.bar.IContaBAR#fetchContasByRequest(com.qat.samples.sysmgmt.model.request.
* PagedInquiryRequest)
*/
@Override
public InternalResultsResponse<Conta> fetchContasByRequest(ContaInquiryRequest request)
{
	InternalResultsResponse<Conta> response = new InternalResultsResponse<Conta>();
	fetchContasByRequest(getSqlSession(), request, STMT_FETCH_CONTA_COUNT, STMT_FETCH_CONTA_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchContasByRequest ####======================================

public static void fetchContasByRequest(SqlSession sqlSession, ContaInquiryRequest request, String countStatement,
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



//===================================### CAIXA ####======================================
	/**
/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#insertCaixa(com.qat.samples.sysmgmt.base.model.Caixa)
 */
@Override
public InternalResponse insertCaixa(Caixa caixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_CAIXA, caixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#updateCaixa(com.qat.samples.sysmgmt.base.model.Caixa)
 */
@Override
public InternalResponse updateCaixa(Caixa caixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_CAIXA, caixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#deleteCaixa(com.qat.samples.sysmgmt.base.model.Caixa)
 */
@Override
public InternalResponse deleteCaixaById(Caixa caixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CAIXA, caixa, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#deleteAllCaixas()
 */
@Override
public InternalResponse deleteAllCaixas()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_CAIXA_ALL, response);
	return response;
}

/*
 * (non-Javadoc)
 * @see
 * com.qat.samples.sysmgmt.bar.ICaixaBAR#fetchCaixaById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
 */
@Override
public Caixa fetchCaixaById(FetchByIdRequest request)
{
return (Caixa)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_CAIXA, request.getFetchId());

}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#fetchAllCaixasCache()
 */
@Override
public InternalResultsResponse<Caixa> fetchAllCaixas(Caixa caixa)
{
	InternalResultsResponse<Caixa> response = new InternalResultsResponse<Caixa>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_CAIXA_ALL));
	return response;
}

/*
 * (non-Javadoc)
 * @see com.qat.samples.sysmgmt.bar.ICaixaBAR#fetchCaixasByRequest(com.qat.samples.sysmgmt.model.request.
 * PagedInquiryRequest)
 */
@Override
public InternalResultsResponse<Caixa> fetchCaixasByRequest(CaixaInquiryRequest request)
{
	InternalResultsResponse<Caixa> response = new InternalResultsResponse<Caixa>();
	fetchCaixasByRequest(getSqlSession(), request, STMT_FETCH_CAIXA_COUNT, STMT_FETCH_CAIXA_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchCaixasByRequest ####======================================

public static void fetchCaixasByRequest(SqlSession sqlSession, CaixaInquiryRequest request, String countStatement,
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


//===================================### AGENCIA ####======================================
	/**
/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.ICaixaBAR#insertCaixa(com.qat.samples.sysmgmt.base.model.Caixa)
*/
@Override
public InternalResponse insertAgencia(Agencia caixa)
{
	InternalResponse response = new InternalResponse();
	
	Integer historicoId = InsertHistBARD.maintainInsertHistorico(TabelaEnum.AGENCIA, getHistoricoBAR(), response);
	
	caixa.setProcessId(historicoId);
	
	MyBatisBARHelper.doInsert(getSqlSession(), STMT_INSERT_AGENCIA, caixa, response);
	
	insertPessoa(caixa, response, TabelaEnum.AGENCIA, historicoId);
	if (!ValidationUtil.isNullOrEmpty(caixa.getNumeroConta()))
	{
		ContaCorrenteBARD.maintainContaCorrenteAssociationsA(caixa.getNumeroConta(), response, caixa.getId(), TypeEnum.HIGH, AcaoTypeEnum.INSERT, TabelaEnum.AGENCIA, getFinanceiroBAR(), statusBAR, historicoBAR, caixa.getEmprId(), caixa.getUserId(), historicoId, historicoId);
	}
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IAgenciaBAR#updateAgencia(com.qat.samples.sysmgmt.base.model.Agencia)
*/
@Override
public InternalResponse updateAgencia(Agencia caixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doUpdate(getSqlSession(), STMT_UPDATE_AGENCIA, caixa, response);
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IAgenciaBAR#deleteAgencia(com.qat.samples.sysmgmt.base.model.Agencia)
*/
@Override
public InternalResponse deleteAgenciaById(Agencia caixa)
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_AGENCIA, caixa, response);
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IAgenciaBAR#deleteAllAgencias()
*/
@Override
public InternalResponse deleteAllAgencias()
{
	InternalResponse response = new InternalResponse();
	MyBatisBARHelper.doRemove(getSqlSession(), STMT_DELETE_AGENCIA_ALL, response);
	return response;
}

/*
* (non-Javadoc)
* @see
* com.qat.samples.sysmgmt.bar.IAgenciaBAR#fetchAgenciaById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest)
*/
@Override
public Agencia fetchAgenciaById(FetchByIdRequest request)
{
return (Agencia)MyBatisBARHelper.doQueryForObject(getSqlSession(), STMT_FETCH_AGENCIA, request.getFetchId());

}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.base.bar.IAgenciaBAR#fetchAllAgenciasCache()
*/
@Override
public InternalResultsResponse<Agencia> fetchAllAgencias(Agencia caixa)
{
	InternalResultsResponse<Agencia> response = new InternalResultsResponse<Agencia>();
	response.getResultsList().addAll(MyBatisBARHelper.doQueryForList(getSqlSession(), STMT_FETCH_AGENCIA_ALL));
	return response;
}

/*
* (non-Javadoc)
* @see com.qat.samples.sysmgmt.bar.IAgenciaBAR#fetchAgenciasByRequest(com.qat.samples.sysmgmt.model.request.
* PagedInquiryRequest)
*/
@Override
public InternalResultsResponse<Agencia> fetchAgenciasByRequest(AgenciaInquiryRequest request)
{
	InternalResultsResponse<Agencia> response = new InternalResultsResponse<Agencia>();
	fetchAgenciasByRequest(getSqlSession(), request, STMT_FETCH_AGENCIA_COUNT, STMT_FETCH_AGENCIA_ALL_REQUEST,
			response);
	return response;
}

//===================================### fetchAgenciasByRequest ####======================================

public static void fetchAgenciasByRequest(SqlSession sqlSession, AgenciaInquiryRequest request, String countStatement,
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

public boolean insertPessoa(Agencia pessoa, InternalResponse response ,TabelaEnum tabela,Integer historicoId){
	
	Integer count = 0;
	Boolean count1 = false;
	if (!ValidationUtil.isNullOrEmpty(pessoa.getEnderecos()))
	{
		count +=
				EnderecoBARD.maintainEnderecoAssociations(pessoa.getEnderecos(), response, pessoa.getId(), null,
						null,
						tabela, enderecoBAR, statusBAR, historicoBAR, pessoa.getId(),
						pessoa.getCreateUser(), historicoId, historicoId);
	}
	
	if (!ValidationUtil.isNullOrEmpty(pessoa.getEmails()))
	{
		count +=
				EmailBARD.maintainEmailAssociations(pessoa.getEmails(), response, pessoa.getId(), null, null,
						tabela, emailBAR, statusBAR, historicoBAR, pessoa.getId(),
						pessoa.getCreateUser(), historicoId, historicoId);
	}
	if (!ValidationUtil.isNullOrEmpty(pessoa.getTelefones()))
	{
		count +=
				TelefoneBARD.maintainTelefoneAssociations(pessoa.getTelefones(), response, pessoa.getId(), null,
						null,
						tabela, telefoneBAR, statusBAR, historicoBAR, pessoa.getId(),
						pessoa.getCreateUser(), historicoId, historicoId);
	}

	if (count > 0)
	{
		Status status = new Status();
		status.setStatus(CdStatusTypeEnum.ANALISANDO);
		List<Status> statusList = new ArrayList<Status>();
		statusList.add(status);
		count1 =
				StatusBARD.maintainStatusAssociations(statusList, response, pessoa.getId(), null, AcaoEnum.INSERT,
						pessoa.getCreateUser(), pessoa.getId(), tabela, statusBAR,
						historicoBAR, historicoId, historicoId);

	}
	
	return true;
}

}
