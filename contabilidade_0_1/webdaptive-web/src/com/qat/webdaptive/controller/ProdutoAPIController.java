package com.qat.webdaptive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class ProdutoAPIController.
 */
@Controller
@RequestMapping("/produto/api")
public class ProdutoAPIController extends ProdutoBaseController
{

	// /**
	// * Refresh bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/refreshBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse refreshBAS(@RequestBody RefreshRequest request)
	// {
	// return refreshProdutos(request);
	// }
	//
	// /**
	// * Insert bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/insertBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse insertBAS(@RequestBody ProdutoMaintenanceRequest request)
	// {
	// return maintainProdutos(request, PersistanceActionEnum.INSERT);
	// }
	//
	// /**
	// * Update bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/updateBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse updateBAS(@RequestBody ProdutoMaintenanceRequest request)
	// {
	// return maintainProdutos(request, PersistanceActionEnum.UPDATE);
	// }
	//
	// /**
	// * Delete bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/deleteBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse deleteBAS(@RequestBody ProdutoMaintenanceRequest request)
	// {
	// return maintainProdutos(request, PersistanceActionEnum.DELETE);
	// }
	//
	// /**
	// * Fetch by request bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/fetchByRequestBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse fetchByRequestBAS(@RequestBody PagedInquiryRequest request)
	// {
	// return produtoFetchByRequest(request);
	// }
	//
	// /**
	// * Refresh bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/cadastro/refreshBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse refreshCadastroBAS(@RequestBody RefreshRequest request)
	// {
	// return refreshProdutos(request);
	// }
	//
	// /**
	// * Insert bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/cadastro/insertBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public CadastroResponse insertCadastroBAS(@RequestBody CadastroMaintenanceRequest request)
	// {
	// return maintainCadastros(request, PersistanceActionEnum.INSERT);
	// }
	//
	// /**
	// * Update bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/cadastro/updateBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public CadastroResponse updateCadastroBAS(@RequestBody CadastroMaintenanceRequest request)
	// {
	// return maintainCadastros(request, PersistanceActionEnum.UPDATE);
	// }
	//
	// /**
	// * Delete bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/cadastro/deleteBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public CadastroResponse deleteCadastroBAS(@RequestBody CadastroMaintenanceRequest request)
	// {
	// return maintainCadastros(request, PersistanceActionEnum.DELETE);
	// }
	//
	// /**
	// * Fetch by request bas.
	// *
	// * @param request the request
	// * @return the produto response
	// */
	// @RequestMapping(value = "/cadastro/fetchByRequestBAS", method = RequestMethod.POST)
	// @ResponseBody
	// public ProdutoResponse fetchByRequestCadastroBAS(@RequestBody PagedInquiryRequest request)
	// {
	// return produtoFetchByRequest(request);
	// }
	//
	// @RequestMapping(value = "/produtoCSV", method = RequestMethod.POST)
	// @ResponseBody
	// private static void writeAllExample() throws IOException
	// {
	// System.out.println("\n**** writeAllExample ****");
	//
	// String csv = "C:\\work\\output2.csv";
	// // CSVWriter writer = new CSVWriter(new FileWriter(csv));
	//
	// List<String[]> data = new ArrayList<String[]>();
	// data.add(new String[] {"India", "New Delhi"});
	// data.add(new String[] {"United States", "Washington D.C"});
	// data.add(new String[] {"Germany", "Berlin"});
	//
	// // writer.writeAll(data);
	// System.out.println("CSV written successfully.");
	// // writer.close();
	// }

}
