package com.prosperitasglobal.sendsolv.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosperitasglobal.cbof.model.request.FetchByIdRequest;
import com.prosperitasglobal.sendsolv.model.Cidade;
import com.prosperitasglobal.sendsolv.model.Cnae;
import com.prosperitasglobal.sendsolv.model.CnaeEmpresa;
import com.prosperitasglobal.sendsolv.model.Deposito;
import com.prosperitasglobal.sendsolv.model.Documento;
import com.prosperitasglobal.sendsolv.model.Email;
import com.prosperitasglobal.sendsolv.model.Empresa;
import com.prosperitasglobal.sendsolv.model.Endereco;
import com.prosperitasglobal.sendsolv.model.EntidadeTypeEnum;
import com.prosperitasglobal.sendsolv.model.Estado;
import com.prosperitasglobal.sendsolv.model.Filial;
import com.prosperitasglobal.sendsolv.model.Plano;
import com.prosperitasglobal.sendsolv.model.Produto;
import com.prosperitasglobal.sendsolv.model.Regime;
import com.prosperitasglobal.sendsolv.model.Socio;
import com.prosperitasglobal.sendsolv.model.Telefone;
import com.prosperitasglobal.sendsolv.model.request.CnaeInquiryRequest;
import com.prosperitasglobal.sendsolv.model.request.DepositoInquiryRequest;
import com.prosperitasglobal.sendsolv.model.request.DepositoMaintenanceRequest;
import com.prosperitasglobal.sendsolv.model.request.EmpresaInquiryRequest;
import com.prosperitasglobal.sendsolv.model.request.EmpresaMaintenanceRequest;
import com.prosperitasglobal.sendsolv.model.request.FilialInquiryRequest;
import com.prosperitasglobal.sendsolv.model.request.FilialMaintenanceRequest;
import com.prosperitasglobal.sendsolv.model.request.RegimeInquiryRequest;
import com.prosperitasglobal.sendsolv.model.response.CnaeResponse;
import com.prosperitasglobal.sendsolv.model.response.DepositoResponse;
import com.prosperitasglobal.sendsolv.model.response.EmpresaResponse;
import com.prosperitasglobal.sendsolv.model.response.FilialResponse;
import com.prosperitasglobal.sendsolv.model.response.RegimeResponse;
import com.qat.framework.model.QATModel.PersistanceActionEnum;

@Controller
@RequestMapping("/api/empresa")
public class EmpresaAPIController extends EmpresaBaseController
{
	/** The URL mapping constants. */
	private static final String DELETE_EMPRESA = "/delete";

	/** The Constant EDIT_EMPRESA. */
	private static final String EDIT_EMPRESA = "/edit";

	/** The Constant FETCH_ALL. */
	private static final String FETCH_ALL = "/fetchall";

	/** The Constant INSERT_EMPRESA. */
	private static final String INSERT_EMPRESA = "/add";

	/** The Constant FETCH. */
	private static final String FETCH = "/fetch";

	private static final String FETCH_REGIME = "/fetch/regime";

	private static final String FETCH_CNAE = "/fetch/cnae";

	private static final String FETCH_ALL_FILIAL = "/fetchall/filial";

	private static final String FETCH_FILIAL = "/fetch/filial";

	private static final String EDIT_FILIAL = "/filial/edit";

	private static final String DELETE_FILIAL = "/filial/delete";

	private static final String INSERT_FILIAL = "/filial/add";

	private static final String FETCH_DEPOSITO = "/fetch/deposito";

	private static final String FETCH_ALL_DEPOSITO = "/fetchall/deposito";

	private static final String EDIT_DEPOSITO = "/deposito/edit";

	private static final String DELETE_DEPOSITO = "/deposito/delete";

	private static final String INSERT_DEPOSITO = "/deposito/add";

	/**
	 * Fetch all Empresas.
	 *
	 * @param pagedInquiryRequest the paged inquiry request
	 * @return the response
	 */
	@RequestMapping(value = FETCH_ALL, method = RequestMethod.POST)
	@ResponseBody
	public EmpresaResponse fetchAll(@RequestBody EmpresaInquiryRequest pagedInquiryRequest)
	{

		return fetchEmpresaByRequest(pagedInquiryRequest);

	}

	@RequestMapping(value = FETCH_CNAE, method = RequestMethod.POST)
	@ResponseBody
	public CnaeResponse fetchAll(@RequestBody CnaeInquiryRequest pagedInquiryRequest)
	{

		return fetchCnaeByRequest(pagedInquiryRequest);

	}

	@RequestMapping(value = FETCH_REGIME, method = RequestMethod.POST)
	@ResponseBody
	public RegimeResponse fetchAll(@RequestBody RegimeInquiryRequest pagedInquiryRequest)
	{

		return fetchRegimeByRequest(pagedInquiryRequest);

	}

	/**
	 * Fetch.
	 *
	 * @param fetchByIdRequest the fetch by id request
	 * @return the empresa response
	 */
	@RequestMapping(value = FETCH, method = RequestMethod.POST)
	@ResponseBody
	public EmpresaResponse fetch(@RequestBody FetchByIdRequest fetchByIdRequest)
	{

		return fetchEmpresaById(fetchByIdRequest);

	}

	/**
	 * Edit one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = EDIT_EMPRESA, method = RequestMethod.POST)
	@ResponseBody
	public EmpresaResponse editEmpresa(@RequestBody EmpresaMaintenanceRequest empresaRequest)
	{
		empresaRequest.setEmpresa(insertMockEmpresa(PersistanceActionEnum.INSERT));
		return edit(empresaRequest);

	}

	/**
	 * Delete one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = DELETE_EMPRESA, method = RequestMethod.POST)
	@ResponseBody
	public EmpresaResponse deleteEmpresa(@RequestBody EmpresaMaintenanceRequest empresaRequest)
	{
		empresaRequest.setEmpresa(insertMockEmpresa(PersistanceActionEnum.INSERT));
		return delete(empresaRequest);

	}

	/**
	 * Insert one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = INSERT_EMPRESA, method = RequestMethod.POST)
	@ResponseBody
	public EmpresaResponse insertEmpresa(@RequestBody EmpresaMaintenanceRequest empresaRequest)
	{
		empresaRequest.setEmpresa(insertMockEmpresa(PersistanceActionEnum.INSERT));
		return insert(empresaRequest);

	}

	// filial
	@RequestMapping(value = FETCH_ALL_FILIAL, method = RequestMethod.POST)
	@ResponseBody
	public FilialResponse fetchAll(@RequestBody FilialInquiryRequest pagedInquiryRequest)
	{

		return fetchFilialByRequest(pagedInquiryRequest);

	}

	/**
	 * Fetch.
	 *
	 * @param fetchByIdRequest the fetch by id request
	 * @return the empresa response
	 */
	@RequestMapping(value = FETCH_FILIAL, method = RequestMethod.POST)
	@ResponseBody
	public FilialResponse fetchFilial(@RequestBody FetchByIdRequest fetchByIdRequest)
	{

		return fetchFilialById(fetchByIdRequest);

	}

	/**
	 * Edit one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = EDIT_FILIAL, method = RequestMethod.POST)
	@ResponseBody
	public FilialResponse editFilial(@RequestBody FilialMaintenanceRequest empresaRequest)
	{
		empresaRequest.setFilial(insertMockFilial(PersistanceActionEnum.INSERT));
		return edit(empresaRequest);

	}

	/**
	 * Delete one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = DELETE_FILIAL, method = RequestMethod.POST)
	@ResponseBody
	public FilialResponse deleteFilial(@RequestBody FilialMaintenanceRequest empresaRequest)
	{
		empresaRequest.setFilial(insertMockFilial(PersistanceActionEnum.INSERT));
		return delete(empresaRequest);

	}

	/**
	 * Insert one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = INSERT_FILIAL, method = RequestMethod.POST)
	@ResponseBody
	public FilialResponse insertFilial(@RequestBody FilialMaintenanceRequest empresaRequest)
	{
		empresaRequest.setFilial(insertMockFilial(PersistanceActionEnum.INSERT));
		return insert(empresaRequest);

	}

	// deposito
	@RequestMapping(value = FETCH_DEPOSITO, method = RequestMethod.POST)
	@ResponseBody
	public DepositoResponse fetchAll(@RequestBody DepositoInquiryRequest pagedInquiryRequest)
	{

		return fetchDepositoByRequest(pagedInquiryRequest);

	}

	/**
	 * Fetch.
	 *
	 * @param fetchByIdRequest the fetch by id request
	 * @return the empresa response
	 */
	@RequestMapping(value = FETCH_ALL_DEPOSITO, method = RequestMethod.POST)
	@ResponseBody
	public DepositoResponse fetchDeposito(@RequestBody FetchByIdRequest fetchByIdRequest)
	{

		return fetchDepositoById(fetchByIdRequest);

	}

	/**
	 * Edit one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = EDIT_DEPOSITO, method = RequestMethod.POST)
	@ResponseBody
	public DepositoResponse editDeposito(@RequestBody DepositoMaintenanceRequest empresaRequest)
	{
		empresaRequest.setDeposito(insertMockDeposito(PersistanceActionEnum.INSERT));
		return edit(empresaRequest);

	}

	/**
	 * Delete one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = DELETE_DEPOSITO, method = RequestMethod.POST)
	@ResponseBody
	public DepositoResponse deleteDeposito(@RequestBody DepositoMaintenanceRequest empresaRequest)
	{
		empresaRequest.setDeposito(insertMockDeposito(PersistanceActionEnum.INSERT));
		return delete(empresaRequest);

	}

	/**
	 * Insert one empresa.
	 *
	 * @param empresaRequest the empresa request
	 * @return the response
	 */
	@RequestMapping(value = INSERT_DEPOSITO, method = RequestMethod.POST)
	@ResponseBody
	public DepositoResponse insertDeposito(@RequestBody DepositoMaintenanceRequest empresaRequest)
	{
		empresaRequest.setDeposito(insertMockDeposito(PersistanceActionEnum.INSERT));
		return insert(empresaRequest);

	}

	public List<Endereco> insertEndereco(PersistanceActionEnum modelAction)
	{
		List<Endereco> enderecoList = new ArrayList<Endereco>();
		Endereco endereco = new Endereco();

		endereco.setModelAction(modelAction);
		endereco.setId(1);
		endereco.setLogradouro("R: Maria Concei��o silva");
		endereco.setCidade(new Cidade(1));
		endereco.setEstado(new Estado(1));
		endereco.setBairro("Mangueiras");
		endereco.setNumero("686");
		endereco.setCep("38082-243");
		enderecoList.add(endereco);
		return enderecoList;
	}

	public List<Email> insertEmail(PersistanceActionEnum modelAction)
	{

		List<Email> emailList = new ArrayList<Email>();
		Email email = new Email();
		email.setId(1);
		email.setEmail("wlclimaco@gmail.com");
		email.setDescription("Casa");
		email.setModelAction(modelAction);
		emailList.add(email);

		return emailList;
	}

	public List<CnaeEmpresa> insertCnae(PersistanceActionEnum modelAction)
	{
		List<CnaeEmpresa> cnaeList = new ArrayList<CnaeEmpresa>();
		CnaeEmpresa cnae = new CnaeEmpresa();
		cnae.setModelAction(PersistanceActionEnum.INSERT);
		cnae.setIdCnae(new Cnae(1, PersistanceActionEnum.NONE));
		cnae.setId(1);
		cnaeList.add(cnae);

		cnae = new CnaeEmpresa();
		cnae.setModelAction(PersistanceActionEnum.INSERT);
		cnae.setIdCnae(new Cnae(1, PersistanceActionEnum.NONE));
		cnae.setId(1);
		cnaeList.add(cnae);

		cnae = new CnaeEmpresa();
		cnae.setModelAction(PersistanceActionEnum.INSERT);
		cnae.setIdCnae(new Cnae(1, PersistanceActionEnum.NONE));
		cnae.setId(1);
		cnaeList.add(cnae);

		return cnaeList;
	}

	public List<Telefone> insertTelefone(PersistanceActionEnum modelAction)
	{
		List<Telefone> telefoneList = new ArrayList<Telefone>();
		Telefone telefone = new Telefone();
		telefone.setModelAction(modelAction);
		telefone.setId(1);
		telefone.setDdd("34");
		telefone.setNumero("91782776");
		telefone.setDescricao("Casa");
		telefoneList.add(telefone);

		telefone = new Telefone();
		telefone.setModelAction(modelAction);
		telefone.setId(1);
		telefone.setDdd("34");
		telefone.setNumero("91782776");
		telefone.setDescricao("Trabalho");
		telefoneList.add(telefone);

		telefone = new Telefone();
		telefone.setModelAction(modelAction);
		telefone.setId(1);
		telefone.setDdd("34");
		telefone.setNumero("91782776");
		telefone.setDescricao("Celular");
		telefoneList.add(telefone);

		return telefoneList;
	}

	public List<Documento> insertDocumento(PersistanceActionEnum modelAction)
	{
		List<Documento> documentoList = new ArrayList<Documento>();
		Documento documento = new Documento();
		documento.setModelAction(modelAction);
		documento.setId(1);
		documento.setDescription("CNPJ");
		documento.setNumero("111111111000001");
		documentoList.add(documento);

		documento = new Documento();
		documento.setModelAction(modelAction);
		documento.setId(1);
		documento.setDescription("IM");
		documento.setNumero("111111111000001");
		documentoList.add(documento);

		documento = new Documento();
		documento.setModelAction(modelAction);
		documento.setId(1);
		documento.setDescription("IE");
		documento.setNumero("111111111000001");
		documentoList.add(documento);

		return documentoList;
	}

	public List<Socio> insertSocio(PersistanceActionEnum modelAction)
	{
		List<Socio> socioList = new ArrayList<Socio>();
		Socio socio = new Socio();
		socio.setModelAction(PersistanceActionEnum.INSERT);
		socio.setId(1);
		socio.setNome("Washington Luis");
		socio.setCota("1");
		socio.setPorcentagem("50");
		socioList.add(socio);

		socio = new Socio();
		socio.setModelAction(modelAction);
		socio.setId(1);
		socio.setNome("Washington Climaco");
		socio.setCota("1");
		socio.setPorcentagem("50");
		socioList.add(socio);

		return socioList;
	}

	public List<Plano> insertPlano(PersistanceActionEnum modelAction)
	{
		List<Plano> planoList = new ArrayList<Plano>();
		Plano plano = new Plano();
		Date a = new Date();
		plano.setModelAction(PersistanceActionEnum.INSERT);
		plano.setId(1);
		plano.setDataInicio(a.getTime() - 10000000);
		plano.setDataFinal(a.getTime());
		plano.setDesconto(new Double(5));
		plano.setProduto(new Produto(1));
		planoList.add(plano);

		plano = new Plano();
		a = new Date();
		plano.setModelAction(PersistanceActionEnum.INSERT);
		plano.setId(1);
		plano.setDataInicio(a.getTime() - 10000000);
		plano.setDataFinal(a.getTime());
		plano.setDesconto(new Double(5));
		plano.setProduto(new Produto(2));
		planoList.add(plano);

		return planoList;
	}

	public Filial insertMockFilial(PersistanceActionEnum modelAction)
	{
		Filial empresa = new Filial();

		empresa.setId(1);
		empresa.setModelAction(modelAction);
		empresa.setEmprId(1);
		empresa.setNome("Cosme e damiao Contabiliadade");
		empresa.setRegime(new Regime(1));
		empresa.setEntidadeEnum(EntidadeTypeEnum.FILIAL);
		empresa.setEnderecos(insertEndereco(modelAction));
		empresa.setDocumentos(insertDocumento(modelAction));
		empresa.setEmails(insertEmail(modelAction));
		empresa.setTelefones(insertTelefone(modelAction));
		empresa.setCnaes(insertCnae(modelAction));

		empresa.setUserId("WASHINGTON");
		return empresa;

	}

	public Deposito insertMockDeposito(PersistanceActionEnum modelAction)
	{
		Deposito empresa = new Deposito();

		empresa.setId(1);
		empresa.setModelAction(modelAction);
		empresa.setEmprId(4);
		empresa.setEntidadeId(7);
		empresa.setNome("Cosme e damiao Contabiliadade");
		empresa.setRegime(new Regime(1));
		empresa.setEntidadeEnum(EntidadeTypeEnum.DEPOSITO);
		empresa.setEnderecos(insertEndereco(modelAction));
		empresa.setDocumentos(insertDocumento(modelAction));
		empresa.setEmails(insertEmail(modelAction));
		empresa.setTelefones(insertTelefone(modelAction));
		empresa.setCnaes(insertCnae(modelAction));

		empresa.setUserId("WASHINGTON");
		return empresa;

	}

	public Empresa insertMockEmpresa(PersistanceActionEnum modelAction)
	{
		Empresa empresa = new Empresa();

		empresa.setId(1);
		empresa.setModelAction(modelAction);
		empresa.setEmprId(1);
		empresa.setNome("Cosme e damiao Contabiliadade");
		empresa.setRegime(new Regime(1));
		empresa.setEntidadeEnum(EntidadeTypeEnum.EMPRESA);
		// empresa.setConfiguracao(new Configuracao(1));
		empresa.setEnderecos(insertEndereco(modelAction));
		empresa.setDocumentos(insertDocumento(modelAction));
		empresa.setEmails(insertEmail(modelAction));
		empresa.setTelefones(insertTelefone(modelAction));
		empresa.setSocios(insertSocio(modelAction));
		empresa.setCnaes(insertCnae(modelAction));
		empresa.setPlanoList(insertPlano(modelAction));

		empresa.setUserId("WASHINGTON");
		return empresa;

	}
}
