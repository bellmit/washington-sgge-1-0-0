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
import com.qat.samples.sysmgmt.clinica.PlanoSaude;
import com.qat.samples.sysmgmt.clinica.model.request.PlanoSaudeInquiryRequest;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.pessoa.dac.IPlanoSaudeDAC;
import com.qat.samples.sysmgmt.util.CdStatusTypeEnum;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class PlanoSaudeDACTest extends AbstractTransactionalJUnit4SpringContextTests
{

	private static final Logger LOG = LoggerFactory.getLogger(PlanoSaudeDACTest.class);
	private IPlanoSaudeDAC planoSaudeDAC; // injected by Spring through setter @resource

	// below

	public IPlanoSaudeDAC getPlanoSaudeDAC()
	{
		return planoSaudeDAC;
	}

	@Resource
	public void setPlanoSaudeDAC(IPlanoSaudeDAC planoSaudeDAC)
	{
		this.planoSaudeDAC = planoSaudeDAC;
	}

	@Test
	public void testupdatePlanoSaude() throws Exception
	{

		PlanoSaude funcionario = new PlanoSaude();
		funcionario = insertPlanoSaude(PersistanceActionEnum.INSERT);
		InternalResultsResponse<PlanoSaude> response = new InternalResultsResponse<PlanoSaude>();
		Integer a = getPlanoSaudeDAC().insertPlanoSaude(funcionario, "", response);

		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		funcionario.setModelAction(PersistanceActionEnum.UPDATE);
		funcionario.setId(response.getFirstResult().getId());
		response = new InternalResultsResponse<PlanoSaude>();

		a = getPlanoSaudeDAC().updatePlanoSaude(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testinsertPlanoSaude() throws Exception
	{

		PlanoSaude funcionario = new PlanoSaude();
		funcionario = insertPlanoSaude(PersistanceActionEnum.INSERT);

		InternalResultsResponse<PlanoSaude> response = new InternalResultsResponse<PlanoSaude>();

		Integer a = getPlanoSaudeDAC().insertPlanoSaude(funcionario, "INSERT", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

		funcionario = new PlanoSaude();
		funcionario = insertPlanoSaude(PersistanceActionEnum.INSERT);
		response = new InternalResultsResponse<PlanoSaude>();

		a = getPlanoSaudeDAC().insertPlanoSaude(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<PlanoSaude> responseA =
				getPlanoSaudeDAC().fetchPlanoSaudeById(request);
		assertTrue(responseA.getResultsList().size() == 1);
		assertEquals(responseA.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testdeletePlanoSaude() throws Exception
	{

		PlanoSaude funcionario = new PlanoSaude();
		funcionario = insertPlanoSaude(PersistanceActionEnum.INSERT);
		InternalResultsResponse<PlanoSaude> response = new InternalResultsResponse<PlanoSaude>();
		Integer a = getPlanoSaudeDAC().insertPlanoSaude(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		response = new InternalResultsResponse<PlanoSaude>();
		funcionario.setModelAction(PersistanceActionEnum.DELETE);
		Integer b = getPlanoSaudeDAC().deletePlanoSaude(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<PlanoSaude> responseA =
				getPlanoSaudeDAC().fetchPlanoSaudeById(request);
		assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);

	}

	@Test
	public void testfetchPlanoSaudeById() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<PlanoSaude> response = getPlanoSaudeDAC().fetchPlanoSaudeById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchPlanoSaudeById2() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<PlanoSaude> response = getPlanoSaudeDAC().fetchPlanoSaudeById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchPlanoSaudeByRequest() throws Exception
	{
		// check for valid and precount
		PlanoSaudeInquiryRequest request = new PlanoSaudeInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(4);
		InternalResultsResponse<PlanoSaude> response = getPlanoSaudeDAC().fetchPlanoSaudeByRequest(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 4);
		assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	}

	public PlanoSaude insertPlanoSaude(PersistanceActionEnum action)
	{
		PlanoSaude exame = new PlanoSaude();
		Date a = new Date();
		exame.setId(1);
		exame.setModelAction(action);
		// exame.setNome("Nome");
		// exame.setDataPlanoSaude((int)a.getTime());
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