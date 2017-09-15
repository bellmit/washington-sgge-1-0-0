/** create by system gera-java version 1.0.0 15/09/2017 12:17 : 54*/
package com.qat.samples.sysmgmt.bar.mybatis;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qat.framework.model.BaseModel.PersistenceActionEnum;
import com.qat.framework.model.response.InternalResponse.BusinessErrorCategory;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.samples.sysmgmt.advocacia.Advogados;
import com.qat.samples.sysmgmt.advocacia.Envolvidos;
import com.qat.samples.sysmgmt.advocacia.Processo;
import com.qat.samples.sysmgmt.advocacia.ProcessoStatus;
import com.qat.samples.sysmgmt.advocacia.request.ProcessoInquiryRequest;
import com.qat.samples.sysmgmt.bar.Advogado.IAdvocaciaBAR;
import com.qat.samples.sysmgmt.clinica.model.Especialidade;
import com.qat.samples.sysmgmt.util.model.Compromisso;
import com.qat.samples.sysmgmt.util.model.DiasHoras;
import com.qat.samples.sysmgmt.util.model.ParticipanteExterno;
import com.qat.samples.sysmgmt.util.model.TabelaEnum;
import com.qat.samples.sysmgmt.util.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.util.model.request.PagedInquiryRequest;

@ContextConfiguration(locations = {
		"classpath:conf/unittest-base-context.xml",
		"classpath:conf/bartest-context.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ActiveProfiles("postgres")
public class AdvocaciaBARTest extends AbstractTransactionalJUnit4SpringContextTests
{
private static final Logger LOG = LoggerFactory.getLogger(AdvocaciaBARTest.class);
private IAdvocaciaBAR advocaciaBAR; // injected by Spring through @Resource



public IAdvocaciaBAR getAdvocaciaBAR() {
return advocaciaBAR;
}
@Resource
public void setAdvocaciaBAR(IAdvocaciaBAR advocaciaBAR) {
this.advocaciaBAR = advocaciaBAR;
}


//===================================### PROCESSOSTATUS ####======================================


@Test
	public void testDeleteProcessoStatus()
	{
		ProcessoStatus processostatus = Objects.insertProcessoStatus(4, TabelaEnum.PROCESSOSTATUS, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		ProcessoStatus processostatusResponse = getAdvocaciaBAR().fetchProcessoStatusById(request);
		Assert.assertEquals(processostatusResponse, null);
		getAdvocaciaBAR().insertProcessoStatus(processostatus);
		processostatusResponse = getAdvocaciaBAR().fetchProcessoStatusById(request);
		Assert.assertEquals(processostatus.getId(), processostatusResponse.getId());
		getAdvocaciaBAR().deleteProcessoStatusById(processostatus);
		processostatusResponse = getAdvocaciaBAR().fetchProcessoStatusById(request);
		Assert.assertEquals(processostatusResponse, null);
	}



	@Test
	public void testFetchAllProcessoStatuss()
	{
	ProcessoStatus processostatus = new ProcessoStatus();
		List<ProcessoStatus> response = getAdvocaciaBAR().fetchAllProcessoStatuss(processostatus).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllProcessoStatuss()
	{
		getAdvocaciaBAR().deleteAllProcessoStatuss();
	ProcessoStatus processostatus = new ProcessoStatus();
		List<ProcessoStatus> response = getAdvocaciaBAR().fetchAllProcessoStatuss(new ProcessoStatus()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateProcessoStatus()
	{
		ProcessoStatus processostatus = Objects.insertProcessoStatus(1, TabelaEnum.PROCESSOSTATUS, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		ProcessoStatus processostatusResponse = getAdvocaciaBAR().fetchProcessoStatusById(request);
		Assert.assertEquals(processostatusResponse.getNote(), "NATIVE INSERT");
		getAdvocaciaBAR().updateProcessoStatus(processostatus);
		processostatusResponse = getAdvocaciaBAR().fetchProcessoStatusById(request);
		Assert.assertEquals(processostatusResponse.getNote(), "NATIVE INSERT UPDATE");
	}

	@Test
	public void testFetchProcessoStatussByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<ProcessoStatus> response = getAdvocaciaBAR().fetchProcessoStatussByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchProcessoStatussByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<ProcessoStatus> response2 = getAdvocaciaBAR().fetchProcessoStatussByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllProcessoStatuss();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<ProcessoStatus> response3 = getAdvocaciaBAR().fetchProcessoStatussByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### DIASHORAS ####======================================


@Test
	public void testDeleteDiasHoras()
	{
		DiasHoras diashoras = Objects.insertDiasHoras(4, TabelaEnum.DIASHORAS, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		DiasHoras diashorasResponse = getAdvocaciaBAR().fetchDiasHorasById(request);
		Assert.assertEquals(diashorasResponse, null);
		getAdvocaciaBAR().insertDiasHoras(diashoras);
		diashorasResponse = getAdvocaciaBAR().fetchDiasHorasById(request);
		Assert.assertEquals(diashoras.getId(), diashorasResponse.getId());
		getAdvocaciaBAR().deleteDiasHorasById(diashoras);
		diashorasResponse = getAdvocaciaBAR().fetchDiasHorasById(request);
		Assert.assertEquals(diashorasResponse, null);
	}

	@Test
	public void testFetchAllDiasHorass()
	{
	DiasHoras diashoras = new DiasHoras();
		List<DiasHoras> response = getAdvocaciaBAR().fetchAllDiasHorass(diashoras).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllDiasHorass()
	{
		getAdvocaciaBAR().deleteAllDiasHorass();
	DiasHoras diashoras = new DiasHoras();
		List<DiasHoras> response = getAdvocaciaBAR().fetchAllDiasHorass(new DiasHoras()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateDiasHoras()
	{
		DiasHoras diashoras = Objects.insertDiasHoras(1, TabelaEnum.DIASHORAS, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		DiasHoras diashorasResponse = getAdvocaciaBAR().fetchDiasHorasById(request);
		Assert.assertEquals(diashorasResponse.getDiario(), "NATIVE INSERT");
		getAdvocaciaBAR().updateDiasHoras(diashoras);
		diashorasResponse = getAdvocaciaBAR().fetchDiasHorasById(request);
		Assert.assertEquals(diashorasResponse.getDiario(), "NATIVE INSERT");
	}

	@Test
	public void testFetchDiasHorassByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<DiasHoras> response = getAdvocaciaBAR().fetchDiasHorassByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchDiasHorassByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<DiasHoras> response2 = getAdvocaciaBAR().fetchDiasHorassByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllDiasHorass();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<DiasHoras> response3 = getAdvocaciaBAR().fetchDiasHorassByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### ESPECIALIDADE ####======================================


@Test
	public void testDeleteEspecialidade()
	{
		Especialidade especialidade = Objects.insertEspecialidade(4, TabelaEnum.ESPECIALIDADE, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		Especialidade especialidadeResponse = getAdvocaciaBAR().fetchEspecialidadeById(request);
		Assert.assertEquals(especialidadeResponse, null);
		getAdvocaciaBAR().insertEspecialidade(especialidade);
		especialidadeResponse = getAdvocaciaBAR().fetchEspecialidadeById(request);
		Assert.assertEquals(especialidade.getId(), especialidadeResponse.getId());
		getAdvocaciaBAR().deleteEspecialidadeById(especialidade);
		especialidadeResponse = getAdvocaciaBAR().fetchEspecialidadeById(request);
		Assert.assertEquals(especialidadeResponse, null);
	}

	@Test
	public void testFetchAllEspecialidades()
	{
	Especialidade especialidade = new Especialidade();
		List<Especialidade> response = getAdvocaciaBAR().fetchAllEspecialidades(especialidade).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllEspecialidades()
	{
		getAdvocaciaBAR().deleteAllEspecialidades();
	Especialidade especialidade = new Especialidade();
		List<Especialidade> response = getAdvocaciaBAR().fetchAllEspecialidades(new Especialidade()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateEspecialidade()
	{
		Especialidade especialidade = Objects.insertEspecialidade(1, TabelaEnum.ESPECIALIDADE, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		Especialidade especialidadeResponse = getAdvocaciaBAR().fetchEspecialidadeById(request);
		Assert.assertEquals(especialidadeResponse.getNome(), "NATIVE INSERT");
		getAdvocaciaBAR().updateEspecialidade(especialidade);
		especialidadeResponse = getAdvocaciaBAR().fetchEspecialidadeById(request);
		Assert.assertEquals(especialidadeResponse.getNome(), "NATIVE INSERT UPDATE");
	}

	@Test
	public void testFetchEspecialidadesByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<Especialidade> response = getAdvocaciaBAR().fetchEspecialidadesByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchEspecialidadesByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<Especialidade> response2 = getAdvocaciaBAR().fetchEspecialidadesByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllEspecialidades();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<Especialidade> response3 = getAdvocaciaBAR().fetchEspecialidadesByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### COMPROMISSO ####======================================


@Test
	public void testDeleteCompromisso()
	{
		Compromisso compromisso = Objects.insertCompromisso(4, TabelaEnum.COMPROMISSO, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		Compromisso compromissoResponse = getAdvocaciaBAR().fetchCompromissoById(request);
		Assert.assertEquals(compromissoResponse, null);
		getAdvocaciaBAR().insertCompromisso(compromisso);
		compromissoResponse = getAdvocaciaBAR().fetchCompromissoById(request);
		Assert.assertEquals(compromisso.getId(), compromissoResponse.getId());
		getAdvocaciaBAR().deleteCompromissoById(compromisso);
		compromissoResponse = getAdvocaciaBAR().fetchCompromissoById(request);
		Assert.assertEquals(compromissoResponse, null);
	}

	@Test
	public void testFetchAllCompromissos()
	{
	Compromisso compromisso = new Compromisso();
		List<Compromisso> response = getAdvocaciaBAR().fetchAllCompromissos(compromisso).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllCompromissos()
	{
		getAdvocaciaBAR().deleteAllCompromissos();
	Compromisso compromisso = new Compromisso();
		List<Compromisso> response = getAdvocaciaBAR().fetchAllCompromissos(new Compromisso()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateCompromisso()
	{
		Compromisso compromisso = Objects.insertCompromisso(1, TabelaEnum.COMPROMISSO, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		Compromisso compromissoResponse = getAdvocaciaBAR().fetchCompromissoById(request);
		Assert.assertEquals(compromissoResponse.getTitulo(), "NATIVE INSERT");
		getAdvocaciaBAR().updateCompromisso(compromisso);
		compromissoResponse = getAdvocaciaBAR().fetchCompromissoById(request);
		Assert.assertEquals(compromissoResponse.getTitulo(), "NATIVE INSERT UPDATE");
	}

	@Test
	public void testFetchCompromissosByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<Compromisso> response = getAdvocaciaBAR().fetchCompromissosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchCompromissosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<Compromisso> response2 = getAdvocaciaBAR().fetchCompromissosByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllCompromissos();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<Compromisso> response3 = getAdvocaciaBAR().fetchCompromissosByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### ADVOGADOS ####======================================


@Test
	public void testDeleteAdvogados()
	{
		Advogados advogados = Objects.insertAdvogados(4, TabelaEnum.ADVOGADOS, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		Advogados advogadosResponse = getAdvocaciaBAR().fetchAdvogadosById(request);
		Assert.assertEquals(advogadosResponse, null);
		getAdvocaciaBAR().insertAdvogados(advogados);
		advogadosResponse = getAdvocaciaBAR().fetchAdvogadosById(request);
		Assert.assertEquals(advogados.getId(), advogadosResponse.getId());
		getAdvocaciaBAR().deleteAdvogadosById(advogados);
		advogadosResponse = getAdvocaciaBAR().fetchAdvogadosById(request);
		Assert.assertEquals(advogadosResponse, null);
	}

	@Test
	public void testFetchAllAdvogadoss()
	{
	Advogados advogados = new Advogados();
		List<Advogados> response = getAdvocaciaBAR().fetchAllAdvogadoss(advogados).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllAdvogadoss()
	{
		getAdvocaciaBAR().deleteAllAdvogadoss();
	Advogados advogados = new Advogados();
		List<Advogados> response = getAdvocaciaBAR().fetchAllAdvogadoss(new Advogados()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateAdvogados()
	{
		Advogados advogados = Objects.insertAdvogados(1, TabelaEnum.ADVOGADOS, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		Advogados advogadosResponse = getAdvocaciaBAR().fetchAdvogadosById(request);
		Assert.assertEquals(advogadosResponse.getAdvogadoPrincipal(), "1");
		getAdvocaciaBAR().updateAdvogados(advogados);
		advogadosResponse = getAdvocaciaBAR().fetchAdvogadosById(request);
		Assert.assertEquals(advogadosResponse.getAdvogadoPrincipal(), "0");
	}

	@Test
	public void testFetchAdvogadossByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<Advogados> response = getAdvocaciaBAR().fetchAdvogadossByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchAdvogadossByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<Advogados> response2 = getAdvocaciaBAR().fetchAdvogadossByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllAdvogadoss();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<Advogados> response3 = getAdvocaciaBAR().fetchAdvogadossByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### ENVOLVIDOS ####======================================


@Test
	public void testDeleteEnvolvidos()
	{
		Envolvidos envolvidos = Objects.insertEnvolvidos(4, TabelaEnum.ENVOLVIDOS, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		Envolvidos envolvidosResponse = getAdvocaciaBAR().fetchEnvolvidosById(request);
		Assert.assertEquals(envolvidosResponse, null);
		getAdvocaciaBAR().insertEnvolvidos(envolvidos);
		envolvidosResponse = getAdvocaciaBAR().fetchEnvolvidosById(request);
		Assert.assertEquals(envolvidos.getId(), envolvidosResponse.getId());
		getAdvocaciaBAR().deleteEnvolvidosById(envolvidos);
		envolvidosResponse = getAdvocaciaBAR().fetchEnvolvidosById(request);
		Assert.assertEquals(envolvidosResponse, null);
	}

	@Test
	public void testFetchAllEnvolvidoss()
	{
	Envolvidos envolvidos = new Envolvidos();
		List<Envolvidos> response = getAdvocaciaBAR().fetchAllEnvolvidoss(envolvidos).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllEnvolvidoss()
	{
		getAdvocaciaBAR().deleteAllEnvolvidoss();
	Envolvidos envolvidos = new Envolvidos();
		List<Envolvidos> response = getAdvocaciaBAR().fetchAllEnvolvidoss(new Envolvidos()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateEnvolvidos()
	{
		Envolvidos envolvidos = Objects.insertEnvolvidos(1, TabelaEnum.ENVOLVIDOS, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		Envolvidos envolvidosResponse = getAdvocaciaBAR().fetchEnvolvidosById(request);
		Assert.assertEquals(envolvidosResponse.getbCliente(), "0");
		getAdvocaciaBAR().updateEnvolvidos(envolvidos);
		envolvidosResponse = getAdvocaciaBAR().fetchEnvolvidosById(request);
		Assert.assertEquals(envolvidosResponse.getbCliente(), "1");
	}

	@Test
	public void testFetchEnvolvidossByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<Envolvidos> response = getAdvocaciaBAR().fetchEnvolvidossByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchEnvolvidossByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<Envolvidos> response2 = getAdvocaciaBAR().fetchEnvolvidossByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllEnvolvidoss();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<Envolvidos> response3 = getAdvocaciaBAR().fetchEnvolvidossByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### PARTICIPANTEEXTERNO ####======================================


@Test
	public void testDeleteParticipanteExterno()
	{
		ParticipanteExterno participanteexterno = Objects.insertParticipanteExterno(4, TabelaEnum.PARTICIPANTEEXTERNO, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		ParticipanteExterno participanteexternoResponse = getAdvocaciaBAR().fetchParticipanteExternoById(request);
		Assert.assertEquals(participanteexternoResponse, null);
		getAdvocaciaBAR().insertParticipanteExterno(participanteexterno);
		participanteexternoResponse = getAdvocaciaBAR().fetchParticipanteExternoById(request);
		Assert.assertEquals(participanteexterno.getId(), participanteexternoResponse.getId());
		getAdvocaciaBAR().deleteParticipanteExternoById(participanteexterno);
		participanteexternoResponse = getAdvocaciaBAR().fetchParticipanteExternoById(request);
		Assert.assertEquals(participanteexternoResponse, null);
	}

	@Test
	public void testFetchAllParticipanteExternos()
	{
	ParticipanteExterno participanteexterno = new ParticipanteExterno();
		List<ParticipanteExterno> response = getAdvocaciaBAR().fetchAllParticipanteExternos(participanteexterno).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllParticipanteExternos()
	{
		getAdvocaciaBAR().deleteAllParticipanteExternos();
	ParticipanteExterno participanteexterno = new ParticipanteExterno();
		List<ParticipanteExterno> response = getAdvocaciaBAR().fetchAllParticipanteExternos(new ParticipanteExterno()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateParticipanteExterno()
	{
		ParticipanteExterno participanteexterno = Objects.insertParticipanteExterno(1, TabelaEnum.PARTICIPANTEEXTERNO, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		ParticipanteExterno participanteexternoResponse = getAdvocaciaBAR().fetchParticipanteExternoById(request);
		Assert.assertEquals(participanteexternoResponse.getNome(), "NATIVE INSERT");
		getAdvocaciaBAR().updateParticipanteExterno(participanteexterno);
		participanteexternoResponse = getAdvocaciaBAR().fetchParticipanteExternoById(request);
		Assert.assertEquals(participanteexternoResponse.getNome(), "NATIVE INSERT UPDATE");
	}

	@Test
	public void testFetchParticipanteExternosByRequest() throws Exception
	{
		// check for valid and precount
		PagedInquiryRequest request = new PagedInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<ParticipanteExterno> response = getAdvocaciaBAR().fetchParticipanteExternosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchParticipanteExternosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		PagedInquiryRequest request2 = new PagedInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<ParticipanteExterno> response2 = getAdvocaciaBAR().fetchParticipanteExternosByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllParticipanteExternos();
		PagedInquiryRequest request3 = new PagedInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<ParticipanteExterno> response3 = getAdvocaciaBAR().fetchParticipanteExternosByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

//===================================### PROCESSO ####======================================


@Test
	public void testDeleteProcesso()
	{
		Processo processo = Objects.insertProcesso(4, TabelaEnum.PROCESSO, PersistenceActionEnum.INSERT);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(4);
		Processo processoResponse = getAdvocaciaBAR().fetchProcessoById(request);
		Assert.assertEquals(processoResponse, null);
		getAdvocaciaBAR().insertProcesso(processo);
		processoResponse = getAdvocaciaBAR().fetchProcessoById(request);
		Assert.assertEquals(processo.getId(), processoResponse.getId());
		getAdvocaciaBAR().deleteProcessoById(processo);
		processoResponse = getAdvocaciaBAR().fetchProcessoById(request);
		Assert.assertEquals(processoResponse, null);
	}

	@Test
	public void testFetchAllProcessos()
	{
	Processo processo = new Processo();
		List<Processo> response = getAdvocaciaBAR().fetchAllProcessos(processo).getResultsList();
		Assert.assertNotNull(response);
	}

	@Test
	public void testDeleteAllProcessos()
	{
		getAdvocaciaBAR().deleteAllProcessos();
	Processo processo = new Processo();
		List<Processo> response = getAdvocaciaBAR().fetchAllProcessos(new Processo()).getResultsList();
		Assert.assertEquals(response.size(), 0);
	}

	@Test
	public void testUpdateProcesso()
	{
		Processo processo = Objects.insertProcesso(1, TabelaEnum.PROCESSO, PersistenceActionEnum.UPDATE);
		FetchByIdRequest request = new FetchByIdRequest();
		request.setFetchId(1);
		Processo processoResponse = getAdvocaciaBAR().fetchProcessoById(request);
		Assert.assertEquals(processoResponse.getProcesso(), "NATIVE INSERT");
		getAdvocaciaBAR().updateProcesso(processo);
		processoResponse = getAdvocaciaBAR().fetchProcessoById(request);
		Assert.assertEquals(processoResponse.getProcesso(), "NATIVE INSERT UPDATE");
	}

	@Test
	public void testFetchProcessosByRequest() throws Exception
	{
		// check for valid and precount
		ProcessoInquiryRequest request = new ProcessoInquiryRequest();
		request.setPreQueryCount(true);
		request.setStartPage(0);
		request.setPageSize(3);
		InternalResultsResponse<Processo> response = getAdvocaciaBAR().fetchProcessosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);
		// check for valid and precount and start 2nd page
		request.setPreQueryCount(true);
		request.setStartPage(1);
		request.setPageSize(3);
		response = getAdvocaciaBAR().fetchProcessosByRequest(request);
		//Assert.assertTrue(response.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response.getResultsSetInfo().getPageSize() == 3);
		Assert.assertTrue(response.getResultsSetInfo().getTotalRowsAvailable() > 0);

		// check for valid and no precount
		ProcessoInquiryRequest request2 = new ProcessoInquiryRequest();
		request2.setPreQueryCount(false);
		InternalResultsResponse<Processo> response2 = getAdvocaciaBAR().fetchProcessosByRequest(request2);
		Assert.assertFalse(response2.getResultsSetInfo().isMoreRowsAvailable());
		Assert.assertTrue(response2.getResultsSetInfo().getPageSize() == 20);
		// this is because we did not choose to precount
		Assert.assertTrue(response2.getResultsSetInfo().getTotalRowsAvailable() == 0);

		// check for zero rows
		getAdvocaciaBAR().deleteAllProcessos();
		ProcessoInquiryRequest request3 = new ProcessoInquiryRequest();
		request3.setPreQueryCount(true);
		InternalResultsResponse<Processo> response3 = getAdvocaciaBAR().fetchProcessosByRequest(request3);
		Assert.assertTrue(response3.getBusinessError() == BusinessErrorCategory.NoRowsFound);

	}

	@Before
	public void setup()
	{
		executeSqlScript("conf/insertProcessoStatus.sql", false);
		executeSqlScript("conf/insertDiasHoras.sql", false);
		executeSqlScript("conf/insertEspecialidade.sql", false);
		executeSqlScript("conf/insertCompromisso.sql", false);
		executeSqlScript("conf/insertAdvogados.sql", false);
		executeSqlScript("conf/insertEnvolvidos.sql", false);
		executeSqlScript("conf/insertParticipanteExterno.sql", false);
		executeSqlScript("conf/insertProcesso.sql", false);
	}

}
