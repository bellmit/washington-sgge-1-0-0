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
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.nf.dac.IOrcamentoDAC;
import com.qat.samples.sysmgmt.nf.model.Orcamento;
import com.qat.samples.sysmgmt.nf.model.request.OrcamentoInquiryRequest;
import com.qat.samples.sysmgmt.util.CdStatusTypeEnum;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class OrcamentoDACTest extends AbstractTransactionalJUnit4SpringContextTests
{

	private static final Logger LOG = LoggerFactory.getLogger(OrcamentoDACTest.class);
	private IOrcamentoDAC orcamentoDAC; // injected by Spring through setter @resource

	// below

	public IOrcamentoDAC getOrcamentoDAC()
	{
		return orcamentoDAC;
	}

	@Resource
	public void setOrcamentoDAC(IOrcamentoDAC orcamentoDAC)
	{
		this.orcamentoDAC = orcamentoDAC;
	}

	@Test
	public void testupdateOrcamento() throws Exception
	{

		Orcamento funcionario = new Orcamento();
		funcionario = insertOrcamento(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Orcamento> response = new InternalResultsResponse<Orcamento>();
		Integer a = getOrcamentoDAC().insertOrcamento(funcionario, "", response);

		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		funcionario.setModelAction(PersistanceActionEnum.UPDATE);
		funcionario.setId(response.getFirstResult().getId());
		response = new InternalResultsResponse<Orcamento>();

		a = getOrcamentoDAC().updateOrcamento(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testinsertOrcamento() throws Exception
	{

		Orcamento funcionario = new Orcamento();
		funcionario = insertOrcamento(PersistanceActionEnum.INSERT);

		InternalResultsResponse<Orcamento> response = new InternalResultsResponse<Orcamento>();

		Integer a = getOrcamentoDAC().insertOrcamento(funcionario, "INSERT", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

		funcionario = new Orcamento();
		funcionario = insertOrcamento(PersistanceActionEnum.INSERT);
		response = new InternalResultsResponse<Orcamento>();

		a = getOrcamentoDAC().insertOrcamento(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<Orcamento> responseA =
				getOrcamentoDAC().fetchOrcamentoById(request);
		assertTrue(responseA.getResultsList().size() == 1);
		assertEquals(responseA.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testdeleteOrcamento() throws Exception
	{

		Orcamento funcionario = new Orcamento();
		funcionario = insertOrcamento(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Orcamento> response = new InternalResultsResponse<Orcamento>();
		Integer a = getOrcamentoDAC().insertOrcamento(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		response = new InternalResultsResponse<Orcamento>();
		funcionario.setModelAction(PersistanceActionEnum.DELETE);
		Integer b = getOrcamentoDAC().deleteOrcamento(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<Orcamento> responseA =
				getOrcamentoDAC().fetchOrcamentoById(request);
		assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);

	}

	@Test
	public void testfetchOrcamentoById() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Orcamento> response = getOrcamentoDAC().fetchOrcamentoById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchOrcamentoById2() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Orcamento> response = getOrcamentoDAC().fetchOrcamentoById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchOrcamentoByRequest() throws Exception
	{
		// check for valid and precount
		OrcamentoInquiryRequest request = new OrcamentoInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(4);
		InternalResultsResponse<Orcamento> response = getOrcamentoDAC().fetchOrcamentoByRequest(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 4);
		assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	}

	public Orcamento insertOrcamento(PersistanceActionEnum action)
	{
		Orcamento exame = new Orcamento();
		Date a = new Date();
		exame.setId(1);
		exame.setModelAction(action);
		// exame.setNome("Nome");
		// exame.setDataOrcamento((int)a.getTime());
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
