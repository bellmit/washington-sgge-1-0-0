package com.prosperitasglobal.sendsolv.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosperitasglobal.cbof.model.request.FetchByIdRequest;
import com.prosperitasglobal.sendsolv.model.request.ClienteInquiryRequest;
import com.prosperitasglobal.sendsolv.model.request.ClienteMaintenanceRequest;
import com.prosperitasglobal.sendsolv.model.response.ClienteResponse;

/**
 * The ClienteAPIController Class.
 *
 * @author Flavio Tosta, Washington Costa
 *
 */
@Controller
@RequestMapping("/api/cliente")
public class ClienteAPIController extends ClienteBaseController
{

	/** The URL mapping constants. */
	private static final String DELETE_CLIENTE = "/delete";

	/** The Constant EDIT_CLIENTE. */
	private static final String EDIT_CLIENTE = "/edit";

	/** The Constant FETCH_ALL. */
	private static final String FETCH_ALL = "/fetchall";

	/** The Constant INSERT_CLIENTE. */
	private static final String INSERT_CLIENTE = "/add";

	/** The Constant FETCH. */
	private static final String FETCH = "/fetch";

	/** The Constant APPLY. */

	/**
	 * Fetch all Clientes.
	 *
	 * @param pagedInquiryRequest the paged inquiry request
	 * @return the response
	 */
	@RequestMapping(value = FETCH_ALL, method = RequestMethod.POST)
	@ResponseBody
	public ClienteResponse fetchAll(@RequestBody ClienteInquiryRequest pagedInquiryRequest)
	{

		return fetchClienteByRequest(pagedInquiryRequest);

	}

	/**
	 * Fetch.
	 *
	 * @param fetchByIdRequest the fetch by id request
	 * @return the cliente response
	 */
	@RequestMapping(value = FETCH, method = RequestMethod.POST)
	@ResponseBody
	public ClienteResponse fetch(@RequestBody FetchByIdRequest fetchByIdRequest)
	{

		return fetchClienteById(fetchByIdRequest);

	}

	/**
	 * Edit one cliente.
	 *
	 * @param clienteRequest the cliente request
	 * @return the response
	 */
	@RequestMapping(value = EDIT_CLIENTE, method = RequestMethod.POST)
	@ResponseBody
	public ClienteResponse editCliente(@RequestBody ClienteMaintenanceRequest clienteRequest)
	{

		return edit(clienteRequest);

	}

	/**
	 * Delete one cliente.
	 *
	 * @param clienteRequest the cliente request
	 * @return the response
	 */
	@RequestMapping(value = DELETE_CLIENTE, method = RequestMethod.POST)
	@ResponseBody
	public ClienteResponse deleteCliente(@RequestBody ClienteMaintenanceRequest clienteRequest)
	{

		return delete(clienteRequest);

	}

	/**
	 * Insert one cliente.
	 *
	 * @param clienteRequest the cliente request
	 * @return the response
	 */
	@RequestMapping(value = INSERT_CLIENTE, method = RequestMethod.POST)
	@ResponseBody
	public ClienteResponse insertCliente(@RequestBody ClienteMaintenanceRequest clienteRequest)
	{

		return insert(clienteRequest);

	}

}
