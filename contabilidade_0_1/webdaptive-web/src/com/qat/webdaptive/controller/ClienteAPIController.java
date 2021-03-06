package com.qat.webdaptive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class ClienteAPIController.
 */
@Controller
@RequestMapping("/cliente/api")
public class ClienteAPIController extends ClienteBaseController
{

	// /**
	// * Refresh bas.
	// *
	// * @param request the request
	// * @return the procedure response
	// */
	// @RequestMapping(value = "/refreshBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ClienteResponse refreshBAS(@RequestBody RefreshRequest request)
	// {
	// return refreshClientes(request);
	// }
	//
	// /**
	// * Insert bas.
	// *
	// * @param request the request
	// * @return the procedure response
	// */
	// @RequestMapping(value = "/insertBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ClienteResponse insertBAS(@RequestBody ClienteMaintenanceRequest request)
	// {
	// return maintainClientes(request, PersistanceActionEnum.INSERT);
	// }
	//
	// /**
	// * Update bas.
	// *
	// * @param request the request
	// * @return the procedure response
	// */
	// @RequestMapping(value = "/updateBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ClienteResponse updateBAS(@RequestBody ClienteMaintenanceRequest request)
	// {
	// return maintainClientes(request, PersistanceActionEnum.UPDATE);
	// }
	//
	// /**
	// * Delete bas.
	// *
	// * @param request the request
	// * @return the procedure response
	// */
	// @RequestMapping(value = "/deleteBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ClienteResponse deleteBAS(@RequestBody ClienteMaintenanceRequest request)
	// {
	// return maintainClientes(request, PersistanceActionEnum.DELETE);
	// }
	//
	// /**
	// * Fetch by request bas.
	// *
	// * @param request the request
	// * @return the procedure response
	// */
	// @RequestMapping(value = "/fetchByRequestBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ClienteResponse fetchByRequestBAS(@RequestBody PagedInquiryRequest request)
	// {
	// return clienteFetchByRequest(request);
	// }
}
