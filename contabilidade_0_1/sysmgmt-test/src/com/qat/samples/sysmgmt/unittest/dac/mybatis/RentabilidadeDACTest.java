package com.qat.samples.sysmgmt.unittest.dac.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResponse.Status;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.samples.sysmgmt.banco.Banco;
import com.qat.samples.sysmgmt.banco.BancoPessoa;
import com.qat.samples.sysmgmt.cfop.Cfop;
import com.qat.samples.sysmgmt.cfop.CfopPessoa;
import com.qat.samples.sysmgmt.cfop.CfopTypeEnum;
import com.qat.samples.sysmgmt.cnae.Cnae;
import com.qat.samples.sysmgmt.cnae.CnaeEmpresa;
import com.qat.samples.sysmgmt.cnae.model.request.CnaeInquiryRequest;
import com.qat.samples.sysmgmt.contabilidade.Plano;
import com.qat.samples.sysmgmt.entidade.Deposito;
import com.qat.samples.sysmgmt.entidade.Empresa;
import com.qat.samples.sysmgmt.entidade.EntidadeTypeEnum;
import com.qat.samples.sysmgmt.entidade.Filial;
import com.qat.samples.sysmgmt.entidade.Usuario;
import com.qat.samples.sysmgmt.entidade.dac.IEmpresaDAC;
import com.qat.samples.sysmgmt.entidade.model.request.DepositoInquiryRequest;
import com.qat.samples.sysmgmt.entidade.model.request.EmpresaInquiryRequest;
import com.qat.samples.sysmgmt.entidade.model.request.FilialInquiryRequest;
import com.qat.samples.sysmgmt.estado.Estado;
import com.qat.samples.sysmgmt.fiscal.Rentabilidade;
import com.qat.samples.sysmgmt.fiscal.Regime;
import com.qat.samples.sysmgmt.fiscal.model.request.RentabilidadeInquiryRequest;
import com.qat.samples.sysmgmt.fiscal.model.request.RegimeInquiryRequest;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.produto.model.request.PlanoInquiryRequest;
import com.qat.samples.sysmgmt.util.Cidade;
import com.qat.samples.sysmgmt.util.Configuracao;
import com.qat.samples.sysmgmt.util.Documento;
import com.qat.samples.sysmgmt.util.DocumentoTypeEnum;
import com.qat.samples.sysmgmt.util.Email;
import com.qat.samples.sysmgmt.util.EmailTypeEnum;
import com.qat.samples.sysmgmt.util.Rentabilidade;
import com.qat.samples.sysmgmt.util.RentabilidadeTypeEnum;
import com.qat.samples.sysmgmt.util.Note;
import com.qat.samples.sysmgmt.util.Telefone;
import com.qat.samples.sysmgmt.util.TelefoneTypeEnum;
import com.qat.samples.sysmgmt.util.model.request.CidadeInquiryRequest;

@ContextConfiguration(locations = {
		"classpath:com/qat/samples/sysmgmt/unittest/conf/unittest-datasource-txn-context.xml",
		"classpath:com/qat/samples/sysmgmt/unittest/conf/aoplogger-context.xml",
		"classpath:conf/web/conf/qat-sysmgmt-base-dac-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class RentabilidadeDACTest extends AbstractTransactionalJUnit4SpringContextTests
{


	private static final Logger LOG = LoggerFactory.getLogger(RentabilidadeDACTest.class);
	private IRentabilidadeDAC rentabilidadeDAC; // injected by Spring through setter @resource

	// below

	public IRentabilidadeDAC getRentabilidadeDAC()
	{
		return rentabilidadeDAC;
	}

	@Resource
	public void setRentabilidadeDAC(IRentabilidadeDAC rentabilidadeDAC)
	{
		this.rentabilidadeDAC = rentabilidadeDAC;
	}

	@Test
	public void testupdateRentabilidade() throws Exception
	{

		Rentabilidade funcionario = new Rentabilidade();
		funcionario = insertRentabilidade(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Rentabilidade> response = new InternalResultsResponse<Rentabilidade>();
		Integer a = getEntidadeDAC().insertRentabilidade(funcionario,"", response);
		
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = funcionarioResponse.getFirstResult();
		funcionario.setModelAction(PersistanceActionEnum.UPDATE);
		funcionario.setId(funcionarioResponse.getFirstResult().getId());
		response = new InternalResultsResponse<Rentabilidade>();
		
		a = getEntidadeDAC().updateRentabilidade(funcionario, response);
		assertEquals(funcionarioResponse.getStatus(), Status.OperationSuccess);

	}

	@Test
	public void testinsertRentabilidade() throws Exception
	{

		Rentabilidade funcionario = new Rentabilidade();
		funcionario = insertRentabilidade(PersistanceActionEnum.INSERT);

		InternalResultsResponse<Rentabilidade> response = new InternalResultsResponse<Rentabilidade>();

		Integer a = getRentabilidadeDAC().insertRentabilidade(funcionario, "INSERT", response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		
		
		Rentabilidade funcionario = new Rentabilidade();
		funcionario = insertRentabilidade(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Rentabilidade> response = new InternalResultsResponse<Rentabilidade>();

		Integer a = getEntidadeDAC().insertRentabilidade(funcionario, response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	//	FetchByIdRequest request = new FetchByIdRequest();
	//	request.setFetchId(response.getFirstResult().getId());
		InternalResultsResponse<Rentabilidade> responseA = getEntidadeDAC().fetchRentabilidadeById(response.getFirstResult().getId());
		assertTrue(responseA.getResultsList().size() == 1);
		assertEquals(responseA.getStatus(), Status.OperationSuccess);


	}

	@Test
	public void testdeleteRentabilidade() throws Exception
	{

		Rentabilidade funcionario = new Rentabilidade();
		funcionario = insertRentabilidade(PersistanceActionEnum.INSERT);
		InternalResultsResponse<Rentabilidade> response = new InternalResultsResponse<Rentabilidade>();
		Integer a = getEntidadeDAC().insertRentabilidade(funcionario,response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		funcionario = response.getFirstResult();
		response = new InternalResultsResponse<Rentabilidade>();
		funcionario.setModelAction(PersistanceActionEnum.DELETE);
		Integer b = getEntidadeDAC().deleteRentabilidade(funcionario,response);
		assertEquals(response.getStatus(), Status.OperationSuccess);
		//FetchByIdRequest request = new FetchByIdRequest();
	//	request.setFetchId(funcionarioResponse.getFirstResult().getId());
		InternalResultsResponse<Classicacao> responseA = getEntidadeDAC().fetchRentabilidadeById(funcionarioResponse.getFirstResult().getId());
		assertTrue(responseA.getResultsList().get(0).getStatusList().get(0).getStatus() == CdStatusTypeEnum.DELETADO);

	}

	@Test
	public void testfetchRentabilidadeById() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Rentabilidade> response = getRentabilidadeDAC().fetchRentabilidadeById(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchRentabilidadeById2() throws Exception
	{
		// check for valid and precount
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(3);
		InternalResultsResponse<Rentabilidade> response = getRentabilidadeDAC().fetchRentabilidadeById(1);
		assertTrue(response.getResultsSetInfo().getPageSize() == 1);
		assertEquals(response.getStatus(), Status.OperationSuccess);
	}

	@Test
	public void testfetchRentabilidadeByRequest() throws Exception
	{
		// check for valid and precount
		RentabilidadeInquiryRequest request = new RentabilidadeInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(4);
		InternalResultsResponse<Rentabilidade> response = getRentabilidadeDAC().fetchRentabilidadeByRequest(request);
		assertTrue(response.getResultsSetInfo().getPageSize() == 4);
		assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
	}

	public Rentabilidade insertRentabilidade(PersistanceActionEnum action)
	{
		Rentabilidade exame = new Rentabilidade();
		Date a = new Date();
		exame.setId(1);
		exame.setModelAction(action);
		// exame.setNome("Nome");
		// exame.setDataRentabilidade((int)a.getTime());
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
