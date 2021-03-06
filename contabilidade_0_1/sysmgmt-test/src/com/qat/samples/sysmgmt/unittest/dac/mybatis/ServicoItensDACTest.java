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
import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;
import com.qat.samples.sysmgmt.nf.dac.IServicoItensDAC;
import com.qat.samples.sysmgmt.nf.model.ServicoItens;
import com.qat.samples.sysmgmt.util.CdStatusTypeEnum;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class ServicoItensDACTest extends AbstractTransactionalJUnit4SpringContextTests
{

	private static final Logger LOG = LoggerFactory.getLogger(ServicoItensDACTest.class);
	private IServicoItensDAC servicoItensDAC; // injected by Spring through setter @resource

	// below

	public IServicoItensDAC getServicoItensDAC()
	{
		return servicoItensDAC;
	}

	@Resource
	public void setServicoItensDAC(IServicoItensDAC servicoItensDAC)
	{
		this.servicoItensDAC = servicoItensDAC;
	}

	@Test
	public void testupdateServicoItens() throws Exception
	{

		ServicoItens funcionario = new ServicoItens();
		funcionario = insertServicoItens(PersistanceActionEnum.INSERT);
		InternalResultsResponse<ServicoItens> response = new InternalResultsResponse<ServicoItens>();
		Integer a = getServicoItensDAC().insertServicoItens(funcionario, "", response);

		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		funcionario.setModelAction(PersistanceActionEnum.UPDATE);
		funcionario.setId(response.getFirstResult().getId());
		response = new InternalResultsResponse<ServicoItens>();

		a = getServicoItensDAC().updateServicoItens(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testinsertServicoItens() throws Exception
	{

		ServicoItens funcionario = new ServicoItens();
		funcionario = insertServicoItens(PersistanceActionEnum.INSERT);

		InternalResultsResponse<ServicoItens> response = new InternalResultsResponse<ServicoItens>();

		Integer a = getServicoItensDAC().insertServicoItens(funcionario, "INSERT", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);

		funcionario = new ServicoItens();
		funcionario = insertServicoItens(PersistanceActionEnum.INSERT);
		response = new InternalResultsResponse<ServicoItens>();

		a = getServicoItensDAC().insertServicoItens(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<ServicoItens> responseA =
				getServicoItensDAC().fetchServicoItensById(request);
		assertTrue(responseA.getResultsList().size() == 1);
		assertEquals(responseA.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testdeleteServicoItens() throws Exception
	{

		ServicoItens funcionario = new ServicoItens();
		funcionario = insertServicoItens(PersistanceActionEnum.INSERT);
		InternalResultsResponse<ServicoItens> response = new InternalResultsResponse<ServicoItens>();
		Integer a = getServicoItensDAC().insertServicoItens(funcionario, "", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		response = new InternalResultsResponse<ServicoItens>();
		funcionario.setModelAction(PersistanceActionEnum.DELETE);
		Integer b = getServicoItensDAC().deleteServicoItens(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<ServicoItens> responseA =
				getServicoItensDAC().fetchServicoItensById(request);
		assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);

	}

	@Test
	public void testfetchServicoItensById() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<ServicoItens> response = getServicoItensDAC().fetchServicoItensById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchServicoItensById2() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<ServicoItens> response = getServicoItensDAC().fetchServicoItensById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchServicoItensByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(4);
		InternalResultsResponse<ServicoItens> response = getServicoItensDAC().fetchServicoItensByRequest(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 4);
		assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	}

	public ServicoItens insertServicoItens(PersistanceActionEnum action)
	{
		ServicoItens exame = new ServicoItens();
		Date a = new Date();
		exame.setId(1);
		exame.setModelAction(action);
		// exame.setNome("Nome");
		// exame.setDataServicoItens((int)a.getTime());
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
