package com.qat.samples.sysmgmt.unittest.dac.mybatis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qat.samples.sysmgmt.util.dac.IStatusDAC;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class StatusDACTest extends AbstractTransactionalJUnit4SpringContextTests
{

	private static final Logger LOG = LoggerFactory.getLogger(StatusDACTest.class);
	private IStatusDAC statusDAC; // injected by Spring through setter @resource

	// below

	public IStatusDAC getStatusDAC()
	{
		return statusDAC;
	}

	@Resource
	public void setStatusDAC(IStatusDAC statusDAC)
	{
		this.statusDAC = statusDAC;
	}

	// @Test
	// public void testupdateStatus() throws Exception
	// {
	//
	// Status funcionario = new Status();
	// funcionario = insertStatus(PersistanceActionEnum.INSERT);
	// InternalResultsResponse<Status> response = new InternalResultsResponse<Status>();
	// Integer a = getStatusDAC().insertStatus(funcionario, "", response);
	//
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// funcionario = response.getFirstResult();
	// funcionario.setModelAction(PersistanceActionEnum.UPDATE);
	// funcionario.setId(response.getFirstResult().getId());
	// response = new InternalResultsResponse<Status>();
	//
	// a = getStatusDAC().updateStatus(funcionario, response);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	//
	// }
	//
	// @Test
	// public void testinsertStatus() throws Exception
	// {
	//
	// Status funcionario = new Status();
	// funcionario = insertStatus(PersistanceActionEnum.INSERT);
	//
	// InternalResultsResponse<Status> response = new InternalResultsResponse<Status>();
	//
	// Integer a = getStatusDAC().insertStatus(funcionario, "INSERT", response);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	//
	// Status funcionario = new Status();
	// funcionario = insertStatus(PersistanceActionEnum.INSERT);
	// InternalResultsResponse<Status> response = new InternalResultsResponse<Status>();
	//
	// Integer a = getStatusDAC().insertStatus(funcionario, response);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// // FetchByIdRequest request = new FetchByIdRequest();
	// // request.setFetchId(response.getFirstResult().getId());
	// InternalResultsResponse<Status> responseA = getStatusDAC().fetchStatusById(response.getFirstResult().getId());
	// assertTrue(responseA.getResultsList().size() == 1);
	// assertEquals(responseA.getStatus(), Status.OperationSuccess);
	//
	// }
	//
	// @Test
	// public void testdeleteStatus() throws Exception
	// {
	//
	// Status funcionario = new Status();
	// funcionario = insertStatus(PersistanceActionEnum.INSERT);
	// InternalResultsResponse<Status> response = new InternalResultsResponse<Status>();
	// Integer a = getStatusDAC().insertStatus(funcionario, response);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// funcionario = response.getFirstResult();
	// response = new InternalResultsResponse<Status>();
	// funcionario.setModelAction(PersistanceActionEnum.DELETE);
	// Integer b = getStatusDAC().deleteStatus(funcionario, response);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// // FetchByIdRequest request = new FetchByIdRequest();
	// // request.setFetchId(response.getFirstResult().getId());
	// InternalResultsResponse<Classicacao> responseA =
	// getStatusDAC().fetchStatusById(response.getFirstResult().getId());
	// assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);
	//
	// }
	//
	// @Test
	// public void testfetchStatusById() throws Exception
	// {
	// // check for valid and precount
	// FetchByIdRequest request = new FetchByIdRequest();
	// request.setFetchId(3);
	// InternalResultsResponse<Status> response = getStatusDAC().fetchStatusById(request);
	// assertTrue(response.getResultsSetInfo().getPageSize() == 1);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// }
	//
	// @Test
	// public void testfetchStatusById2() throws Exception
	// {
	// // check for valid and precount
	// FetchByIdRequest request = new FetchByIdRequest();
	// request.setFetchId(3);
	// InternalResultsResponse<Status> response = getStatusDAC().fetchStatusById(1);
	// assertTrue(response.getResultsSetInfo().getPageSize() == 1);
	// assertEquals(response.getStatus(), Status.OperationSuccess);
	// }
	//
	// @Test
	// public void testfetchStatusByRequest() throws Exception
	// {
	// // check for valid and precount
	// StatusInquiryRequest request = new StatusInquiryRequest();
	// request.setPreQueryCount(true);
	// request.setStartPage(0);
	// request.setPageSize(4);
	// InternalResultsResponse<Status> response = getStatusDAC().fetchStatusByRequest(request);
	// assertTrue(response.getResultsSetInfo().getPageSize() == 4);
	// assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	// }
	//
	// public Status insertStatus(PersistanceActionEnum action)
	// {
	// Status exame = new Status();
	// Date a = new Date();
	// exame.setId(1);
	// exame.setModelAction(action);
	// // exame.setNome("Nome");
	// // exame.setDataStatus((int)a.getTime());
	// // exame.setMedicoResponsavel("Resposnsavel");
	// // exame.setLaboratorio("Laboratorio");
	//
	// return exame;
	// }
	//
	// @Before
	// public void setup()
	// {
	// executeSqlScript("com/qat/samples/sysmgmt/unittest/conf/insertBanco.sql", false);
	// }
}