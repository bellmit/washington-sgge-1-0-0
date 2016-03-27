package com.qat.samples.sysmgmt.unittest.dac.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qat.framework.model.QATModel.PersistanceActionEnum;
import com.qat.framework.model.response.InternalResponse.Status;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.samples.sysmgmt.fiscal.Tributacao;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.produto.model.request.TributacaoInquiryRequest;
import com.qat.samples.sysmgmt.util.CdStatusTypeEnum;
import com.qat.samples.sysmgmt.util.dac.ITributacaoDAC;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class TributacaoDACTest extends AbstractTransactionalJUnit4SpringContextTests
{

	private static final Logger LOG = LoggerFactory.getLogger(TributacaoDACTest.class);
	private ITributacaoDAC tributacaoDAC; // injected by Spring through setter @resource

	// below

	public ITributacaoDAC getTributacaoDAC()
	{
		return tributacaoDAC;
	}

	@Resource
	public void setTributacaoDAC(ITributacaoDAC tributacaoDAC)
	{
		this.tributacaoDAC = tributacaoDAC;
	}

	@Test
	public void testupdateTributacao() throws Exception
	{

		Tributacao funcionario = new Tributacao();
		funcionario = insertTributacao(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Tributacao> response = new InternalResultsResponse<Tributacao>();
		Integer a = getTributacaoDAC().insertTributacao(funcionario, "", response);

		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		funcionario.setModelAction(PersistanceActionEnum.UPDATE);
		funcionario.setId(response.getFirstResult().getId());
		response = new InternalResultsResponse<Tributacao>();

		a = getTributacaoDAC().updateTributacao(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testinsertTributacao() throws Exception
	{

		Tributacao funcionario = new Tributacao();
		funcionario = insertTributacao(PersistanceActionEnum.INSERT);

		InternalResultsResponse<Tributacao> response = new InternalResultsResponse<Tributacao>();

		Integer a = getTributacaoDAC().insertTributacao(funcionario, "INSERT", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

		funcionario = new Tributacao();
		funcionario = insertTributacao(PersistanceActionEnum.INSERT);
		response = new InternalResultsResponse<Tributacao>();

		a = getTributacaoDAC().insertTributacao(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<Tributacao> responseA =
				getTributacaoDAC().fetchTributacaoById(request);
		assertTrue(responseA.getResultsList().size() == 1);
		assertEquals(responseA.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testdeleteTributacao() throws Exception
	{

		Tributacao funcionario = new Tributacao();
		funcionario = insertTributacao(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Tributacao> response = new InternalResultsResponse<Tributacao>();
		Integer a = getTributacaoDAC().insertTributacao(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		response = new InternalResultsResponse<Tributacao>();
		funcionario.setModelAction(PersistanceActionEnum.DELETE);
		Integer b = getTributacaoDAC().deleteTributacao(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<Tributacao> responseA =
				getTributacaoDAC().fetchTributacaoById(request);
		assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);

	}

	@Test
	public void testfetchTributacaoById() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Tributacao> response = getTributacaoDAC().fetchTributacaoById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchTributacaoById2() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Tributacao> response = getTributacaoDAC().fetchTributacaoById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchTributacaoByRequest() throws Exception
	{
		// check for valid and precount
		TributacaoInquiryRequest request = new TributacaoInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(4);
		InternalResultsResponse<Tributacao> response = getTributacaoDAC().fetchTributacaoByRequest(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 4);
		assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	}

	public Tributacao insertTributacao(PersistanceActionEnum action)
	{
		Tributacao exame = new Tributacao();
		Date a = new Date();
		exame.setId(1);
		exame.setModelAction(action);
		// exame.setNome("Nome");
		// exame.setDataTributacao((int)a.getTime());
		// exame.setMedicoResponsavel("Resposnsavel");
		// exame.setLaboratorio("Laboratorio");

		return exame;
	}

	@Before
	public void setup()
	{
		executeSqlScript("com/qat/samples/sysmgmt/unittest/conf/insertBanco.sql", false);
	}
}