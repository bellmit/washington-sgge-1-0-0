/** create by system gera-java version 1.0.0 15/09/2017 11:19 : 10*/
package com.qat.samples.sysmgmt.bar.Advogado;
import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.samples.sysmgmt.advocacia.Advogados;
import com.qat.samples.sysmgmt.advocacia.Envolvidos;
import com.qat.samples.sysmgmt.advocacia.Processo;
import com.qat.samples.sysmgmt.advocacia.ProcessoCliente;
import com.qat.samples.sysmgmt.advocacia.ProcessoStatus;
import com.qat.samples.sysmgmt.advocacia.ProcessoUsuarios;
import com.qat.samples.sysmgmt.advocacia.request.ProcessoInquiryRequest;
import com.qat.samples.sysmgmt.arquivo.model.Arquivo;
import com.qat.samples.sysmgmt.clinica.model.Especialidade;
import com.qat.samples.sysmgmt.util.model.ClienteCompromisso;
import com.qat.samples.sysmgmt.util.model.Compromisso;
import com.qat.samples.sysmgmt.util.model.DiasHoras;
import com.qat.samples.sysmgmt.util.model.DoisValores;
import com.qat.samples.sysmgmt.util.model.ParticipanteExterno;
import com.qat.samples.sysmgmt.util.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.util.model.request.PagedInquiryRequest;

/**
 * The Interface AdvocaciaBAR.. (Data Access Component - DAC)
 */
public interface IAdvocaciaBAR
{

	/**
	 * Fetch processostatus by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public ProcessoStatus fetchProcessoStatusById(FetchByIdRequest request);

	/**
* Insert processostatus.
*
* @param processostatus the processostatus
*
* @return the internal response
*/
	public InternalResponse insertProcessoStatus(ProcessoStatus processostatus);

	/**
* Update processostatus.
*
* @param processostatus the processostatus
*
* @return the internal response
*/
	public InternalResponse updateProcessoStatus(ProcessoStatus processostatus);

	/**
* Delete processostatus.
*
* @param processostatus the processostatus
*
* @return the internal response
*/
	public InternalResponse deleteProcessoStatusById(ProcessoStatus processostatus);

	/**
* Delete all processostatuss.
*
* @return the internal response
*/
	public InternalResponse deleteAllProcessoStatuss();

	/**
* Fetch all processostatuss.
*
* @return the list< processostatus>
*/
	public InternalResultsResponse<ProcessoStatus> fetchAllProcessoStatuss(ProcessoStatus  processostatus);

	/**
* Fetch processostatuss by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<ProcessoStatus> fetchProcessoStatussByRequest(PagedInquiryRequest request);

	/**
	 * Fetch diashoras by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public DiasHoras fetchDiasHorasById(FetchByIdRequest request);

	/**
* Insert diashoras.
*
* @param diashoras the diashoras
*
* @return the internal response
*/
	public InternalResponse insertDiasHoras(DiasHoras diashoras);

	/**
* Update diashoras.
*
* @param diashoras the diashoras
*
* @return the internal response
*/
	public InternalResponse updateDiasHoras(DiasHoras diashoras);

	/**
* Delete diashoras.
*
* @param diashoras the diashoras
*
* @return the internal response
*/
	public InternalResponse deleteDiasHorasById(DiasHoras diashoras);

	/**
* Delete all diashorass.
*
* @return the internal response
*/
	public InternalResponse deleteAllDiasHorass();

	/**
* Fetch all diashorass.
*
* @return the list< diashoras>
*/
	public InternalResultsResponse<DiasHoras> fetchAllDiasHorass(DiasHoras  diashoras);

	/**
* Fetch diashorass by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<DiasHoras> fetchDiasHorassByRequest(PagedInquiryRequest request);

	/**
	 * Fetch especialidade by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Especialidade fetchEspecialidadeById(FetchByIdRequest request);

	/**
* Insert especialidade.
*
* @param especialidade the especialidade
*
* @return the internal response
*/
	public InternalResponse insertEspecialidade(Especialidade especialidade);

	/**
* Update especialidade.
*
* @param especialidade the especialidade
*
* @return the internal response
*/
	public InternalResponse updateEspecialidade(Especialidade especialidade);

	/**
* Delete especialidade.
*
* @param especialidade the especialidade
*
* @return the internal response
*/
	public InternalResponse deleteEspecialidadeById(Especialidade especialidade);

	/**
* Delete all especialidades.
*
* @return the internal response
*/
	public InternalResponse deleteAllEspecialidades();

	/**
* Fetch all especialidades.
*
* @return the list< especialidade>
*/
	public InternalResultsResponse<Especialidade> fetchAllEspecialidades(Especialidade  especialidade);

	/**
* Fetch especialidades by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<DoisValores> fetchEspecialidadesByRequest(PagedInquiryRequest request);

	/**
	 * Fetch compromisso by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Compromisso fetchCompromissoById(FetchByIdRequest request);

	/**
* Insert compromisso.
*
* @param compromisso the compromisso
*
* @return the internal response
*/
	public InternalResponse insertCompromisso(Compromisso compromisso);

	/**
* Update compromisso.
*
* @param compromisso the compromisso
*
* @return the internal response
*/
	public InternalResponse updateCompromisso(Compromisso compromisso);

	/**
* Delete compromisso.
*
* @param compromisso the compromisso
*
* @return the internal response
*/
	public InternalResponse deleteCompromissoById(Compromisso compromisso);

	/**
* Delete all compromissos.
*
* @return the internal response
*/
	public InternalResponse deleteAllCompromissos();

	/**
* Fetch all compromissos.
*
* @return the list< compromisso>
*/
	public InternalResultsResponse<Compromisso> fetchAllCompromissos(Compromisso  compromisso);

	/**
* Fetch compromissos by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<Compromisso> fetchCompromissosByRequest(PagedInquiryRequest request);

	/**
	 * Fetch advogados by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Advogados fetchAdvogadosById(FetchByIdRequest request);

	/**
* Insert advogados.
*
* @param advogados the advogados
*
* @return the internal response
*/
	public InternalResponse insertAdvogados(Advogados advogados);

	/**
* Update advogados.
*
* @param advogados the advogados
*
* @return the internal response
*/
	public InternalResponse updateAdvogados(Advogados advogados);

	/**
* Delete advogados.
*
* @param advogados the advogados
*
* @return the internal response
*/
	public InternalResponse deleteAdvogadosById(Advogados advogados);

	/**
* Delete all advogadoss.
*
* @return the internal response
*/
	public InternalResponse deleteAllAdvogadoss();

	/**
* Fetch all advogadoss.
*
* @return the list< advogados>
*/
	public InternalResultsResponse<Advogados> fetchAllAdvogadoss(Advogados  advogados);

	/**
* Fetch advogadoss by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<Advogados> fetchAdvogadossByRequest(PagedInquiryRequest request);

	/**
	 * Fetch envolvidos by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Envolvidos fetchEnvolvidosById(FetchByIdRequest request);

	/**
* Insert envolvidos.
*
* @param envolvidos the envolvidos
*
* @return the internal response
*/
	public InternalResponse insertEnvolvidos(Envolvidos envolvidos);

	/**
* Update envolvidos.
*
* @param envolvidos the envolvidos
*
* @return the internal response
*/
	public InternalResponse updateEnvolvidos(Envolvidos envolvidos);

	/**
* Delete envolvidos.
*
* @param envolvidos the envolvidos
*
* @return the internal response
*/
	public InternalResponse deleteEnvolvidosById(Envolvidos envolvidos);

	/**
* Delete all envolvidoss.
*
* @return the internal response
*/
	public InternalResponse deleteAllEnvolvidoss();

	/**
* Fetch all envolvidoss.
*
* @return the list< envolvidos>
*/
	public InternalResultsResponse<Envolvidos> fetchAllEnvolvidoss(Envolvidos  envolvidos);

	/**
* Fetch envolvidoss by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<Envolvidos> fetchEnvolvidossByRequest(PagedInquiryRequest request);

	/**
	 * Fetch participante by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public ParticipanteExterno fetchParticipanteExternoById(FetchByIdRequest request);

	/**
* Insert participante.
*
* @param participante the participante
*
* @return the internal response
*/
	public InternalResponse insertParticipanteExterno(ParticipanteExterno participante);

	/**
* Update participante.
*
* @param participante the participante
*
* @return the internal response
*/
	public InternalResponse updateParticipanteExterno(ParticipanteExterno participante);

	/**
* Delete participante.
*
* @param participante the participante
*
* @return the internal response
*/
	public InternalResponse deleteParticipanteExternoById(ParticipanteExterno participante);

	/**
* Delete all participantes.
*
* @return the internal response
*/
	public InternalResponse deleteAllParticipanteExternos();

	/**
* Fetch all participantes.
*
* @return the list< participante>
*/
	public InternalResultsResponse<ParticipanteExterno> fetchAllParticipanteExternos(ParticipanteExterno  participante);

	/**
* Fetch participantes by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<ParticipanteExterno> fetchParticipanteExternosByRequest(PagedInquiryRequest request);

	/**
	 * Fetch processo by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Processo fetchProcessoById(FetchByIdRequest request);

	/**
* Insert processo.
*
* @param processo the processo
*
* @return the internal response
*/
	public InternalResponse insertProcesso(Processo processo);

	/**
* Update processo.
*
* @param processo the processo
*
* @return the internal response
*/
	public InternalResponse updateProcesso(Processo processo);

	/**
* Delete processo.
*
* @param processo the processo
*
* @return the internal response
*/
	public InternalResponse deleteProcessoById(Processo processo);

	/**
* Delete all processos.
*
* @return the internal response
*/
	public InternalResponse deleteAllProcessos();

	/**
* Fetch all processos.
*
* @return the list< processo>
*/
	public InternalResultsResponse<Processo> fetchAllProcessos(Processo  processo);

	/**
* Fetch processos by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<Processo> fetchProcessosByRequest(ProcessoInquiryRequest request);

	/**
	 * Fetch clientecompromisso by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public ClienteCompromisso fetchClienteCompromissoById(FetchByIdRequest request);

	/**
* Insert clientecompromisso.
*
* @param clientecompromisso the clientecompromisso
*
* @return the internal response
*/
	public InternalResponse insertClienteCompromisso(ClienteCompromisso clientecompromisso);

	/**
* Update clientecompromisso.
*
* @param clientecompromisso the clientecompromisso
*
* @return the internal response
*/
	public InternalResponse updateClienteCompromisso(ClienteCompromisso clientecompromisso);

	/**
* Delete clientecompromisso.
*
* @param clientecompromisso the clientecompromisso
*
* @return the internal response
*/
	public InternalResponse deleteClienteCompromissoById(ClienteCompromisso clientecompromisso);

	/**
* Delete all clientecompromissos.
*
* @return the internal response
*/
	public InternalResponse deleteAllClienteCompromissos();

	/**
* Fetch all clientecompromissos.
*
* @return the list< clientecompromisso>
*/
	public InternalResultsResponse<ClienteCompromisso> fetchAllClienteCompromissos(ClienteCompromisso  clientecompromisso);

	/**
* Fetch clientecompromissos by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<ClienteCompromisso> fetchClienteCompromissosByRequest(PagedInquiryRequest request);

	/**
	 * Fetch arquivo by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public Arquivo fetchArquivoById(FetchByIdRequest request);

	/**
* Insert arquivo.
*
* @param arquivo the arquivo
*
* @return the internal response
*/
	public InternalResponse insertArquivo(Arquivo arquivo);

	/**
* Update arquivo.
*
* @param arquivo the arquivo
*
* @return the internal response
*/
	public InternalResponse updateArquivo(Arquivo arquivo);

	/**
* Delete arquivo.
*
* @param arquivo the arquivo
*
* @return the internal response
*/
	public InternalResponse deleteArquivoById(Arquivo arquivo);

	/**
* Delete all arquivos.
*
* @return the internal response
*/
	public InternalResponse deleteAllArquivos();

	/**
* Fetch all arquivos.
*
* @return the list< arquivo>
*/
	public InternalResultsResponse<Arquivo> fetchAllArquivos(Arquivo  arquivo);

	/**
* Fetch arquivos by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<Arquivo> fetchArquivosByRequest(PagedInquiryRequest request);
	/**
	 * Fetch processousuarios by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public ProcessoUsuarios fetchProcessoUsuariosById(FetchByIdRequest request);

	/**
* Insert processousuarios.
*
* @param processousuarios the processousuarios
*
* @return the internal response
*/
	public InternalResponse insertProcessoUsuarios(ProcessoUsuarios processousuarios);

	/**
* Update processousuarios.
*
* @param processousuarios the processousuarios
*
* @return the internal response
*/
	public InternalResponse updateProcessoUsuarios(ProcessoUsuarios processousuarios);

	/**
* Delete processousuarios.
*
* @param processousuarios the processousuarios
*
* @return the internal response
*/
	public InternalResponse deleteProcessoUsuariosById(ProcessoUsuarios processousuarios);

	/**
* Delete all processousuarioss.
*
* @return the internal response
*/
	public InternalResponse deleteAllProcessoUsuarioss();

	/**
* Fetch all processousuarioss.
*
* @return the list< processousuarios>
*/
	public InternalResultsResponse<ProcessoUsuarios> fetchAllProcessoUsuarioss(ProcessoUsuarios  processousuarios);

	/**
* Fetch processousuarioss by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<ProcessoUsuarios> fetchProcessoUsuariossByRequest(PagedInquiryRequest request);

	/**
	 * Fetch processocliente by id.
	 *
	 * @param request the request
* @return the internal results response
*/
	public ProcessoCliente fetchProcessoClienteById(FetchByIdRequest request);

	/**
* Insert processocliente.
*
* @param processocliente the processocliente
*
* @return the internal response
*/
	public InternalResponse insertProcessoCliente(ProcessoCliente processocliente);

	/**
* Update processocliente.
*
* @param processocliente the processocliente
*
* @return the internal response
*/
	public InternalResponse updateProcessoCliente(ProcessoCliente processocliente);

	/**
* Delete processocliente.
*
* @param processocliente the processocliente
*
* @return the internal response
*/
	public InternalResponse deleteProcessoClienteById(ProcessoCliente processocliente);

	/**
* Delete all processoclientes.
*
* @return the internal response
*/
	public InternalResponse deleteAllProcessoClientes();

	/**
* Fetch all processoclientes.
*
* @return the list< processocliente>
*/
	public InternalResultsResponse<ProcessoCliente> fetchAllProcessoClientes(ProcessoCliente  processocliente);

	/**
* Fetch processoclientes by request.
*
* @param request the request
* @return the internal results response
*/
	public InternalResultsResponse<ProcessoCliente> fetchProcessoClientesByRequest(PagedInquiryRequest request);
}
