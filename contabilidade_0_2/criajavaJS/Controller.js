Controller = function (teste,bar){

	var text = '/** create by system gera-java version 1.0.0 '+dataAtualFormatada()+'*/\n';

text = text + "\n";
text = text + "package com.qat.samples.sysmgmt.controller;\n";
text = text + "\n";
text = text + "\n";
text = text + "import javax.annotation.Resource;\n";
text = text + "\n";
text = text + "import org.slf4j.Logger;\n";
text = text + "import org.slf4j.LoggerFactory;\n";
text = text + "import org.springframework.stereotype.Controller;\n";
text = text + "import org.springframework.web.bind.annotation.RequestBody;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMapping;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMethod;\n";
text = text + "import org.springframework.web.bind.annotation.RequestParam;\n";
text = text + "import org.springframework.web.bind.annotation.ResponseBody;\n";
text = text + "\n";
text = text + "import com.qat.framework.model.response.InternalResultsResponse;\n";
text = text + "import com.qat.framework.util.ResponseHandler;\n";
text = text + "import com.qat.samples.sysmgmt.bac.I"+titleize(bar)+"BAC;\n";
text = text + "import com.qat.samples.sysmgmt.model."+titleize(bar)+";\n";
text = text + "import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.request."+titleize(bar)+"MaintenanceRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.request.RefreshRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.response."+titleize(bar)+"Response;\n";
text = text + "\n";
text = text + "/**\n";
text = text + " * The Class "+titleize(bar)+"APIController.\n";
text = text + " */\n";
text = text + "@Controller\n";
text = text + '@RequestMapping("/'+bar.toLowerCase()+'/api")\n';
text = text + "public class "+titleize(bar)+"APIController extends BaseController\n";
text = text + "{\n";
text = text + "	/** The Constant DEFAULT_EXCEPTION_MSG. */\n";
text = text + '	private static final String DEFAULT_EXCEPTION_MSG = "sysmgmt.base.'+bar.toLowerCase()+'controllerrest.defaultexception";\n';
text = text + "\n";
text = text + "	/** The Constant LOG. */\n";
text = text + "	private static final Logger LOG = LoggerFactory.getLogger("+titleize(bar)+"APIController.class);\n";
text = text + "\n";
text = text + "	/** The "+bar.toLowerCase()+" bac. */\n";
text = text + "	private I"+titleize(bar)+"BAC "+bar.toLowerCase()+"BAC; // injected by @Resource\n";
text = text + "\n";
text = text + "	/**\n";
text = text + "	 * Gets the "+bar.toLowerCase()+" bac.\n";
text = text + "	 *\n";
text = text + "	 * @return the "+bar.toLowerCase()+" bac\n";
text = text + "	 */\n";
text = text + "	public I"+titleize(bar)+"BAC get"+titleize(bar)+"BAC()\n";
text = text + "	{\n";
text = text + "		return "+bar.toLowerCase()+"BAC;\n";
text = text + "	}\n";
text = text + "\n";
text = text + "	/**\n";
text = text + "	 * Sets the "+bar.toLowerCase()+" bac.\n";
text = text + "	 *\n";
text = text + "	 * @param "+bar.toLowerCase()+"BAC the new "+bar.toLowerCase()+" bac\n";
text = text + "	 */\n";
text = text + "	@Resource\n";
text = text + "	public void set"+titleize(bar)+"BAC(I"+titleize(bar)+"BAC "+bar.toLowerCase()+"BAC)\n";
text = text + "	{\n";
text = text + "		this."+bar.toLowerCase()+"BAC = "+bar.toLowerCase()+"BAC;\n";
text = text + "	}\n";
text = text + "\n";
text = text + "\n";

for(i=0;i < teste.length;i++){

var nome = teste[i].classe.toLowerCase();
nomeM = titleize(teste[i].classe)
text = text + "\n";
text = text + '//===================================### '+nomeM.toUpperCase()+' ####======================================\n';
text = text + '/**\n';
text = text + '	 * Refresh '+nomeM.toLowerCase()+'s.\n';
text = text + '	 *\n';
text = text + '	 * @param refreshInt the refresh int\n';
text = text + '	 * @param retList the ret list\n';
text = text + '	 * @param retPaged the ret paged\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/refresh", method = RequestMethod.GET)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response refresh'+nomeM+'s(@RequestParam("refreshInt") Integer refreshInt,\n';
text = text + '			@RequestParam("retList") Boolean retList,\n';
text = text + '			@RequestParam("retPaged") Boolean retPaged)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + "\n";
text = text + '		try\n';
text = text + '		{\n';
text = text + '			RefreshRequest request = new RefreshRequest(refreshInt, retList, retPaged);\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().refresh'+nomeM+'s(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + "\n";
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Fetch '+nomeM.toLowerCase()+' paged.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/fetchPage", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response fetch'+nomeM+'Paged(@RequestBody '+nomeM+'InquiryRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().fetch'+nomeM+'sByRequest(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Insert '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/insert", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response insert'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().insert'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Update '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/update", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response update'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().update'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Delete '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/delete", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response delete'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + "\n";
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().delete'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + "\n";
text = text + '	}\n';
text = text + "\n";
}
text = text + "}\n";
return text;
}


ControllerSpringBoot = function (teste,bar){

	var text = '/** create by system gera-java version 1.0.0 '+dataAtualFormatada()+'*/\n';
	text = text + "\n";
text = text + "package com.nouhoun.springboot.jwt.integration.controller;\n";
text = text + "\n";
text = text + "import java.io.IOException;\n";
text = text + "import java.util.List;\n";
text = text + "\n";
text = text + "import javax.servlet.http.HttpServletRequest;\n";
text = text + "\n";
text = text + "import org.slf4j.Logger;\n";
text = text + "import org.slf4j.LoggerFactory;\n";
text = text + "import org.springframework.beans.factory.annotation.Autowired;\n";
text = text + "import org.springframework.http.HttpStatus;\n";
text = text + "import org.springframework.http.ResponseEntity;\n";
text = text + "import org.springframework.stereotype.Controller;\n";
text = text + "import org.springframework.web.bind.annotation.CrossOrigin;\n";
text = text + "import org.springframework.web.bind.annotation.RequestBody;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMapping;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMethod;\n";
text = text + "\n";
text = text + "import com.fasterxml.jackson.core.JsonParseException;\n";
text = text + "import com.fasterxml.jackson.databind.JsonMappingException;\n";
text = text + "import com.fasterxml.jackson.databind.ObjectMapper;\n";
text = text + "import com.nouhoun.springboot.jwt.integration.domain.Chat;\n";
text = text + "import com.nouhoun.springboot.jwt.integration.domain.ChatItens;\n";
text = text + "import com.nouhoun.springboot.jwt.integration.domain.security.User;\n";
text = text + "import com.nouhoun.springboot.jwt.integration.service.ChatService;\n";

text = text + "\n";
text = text + "package com.qat.samples.sysmgmt.controller;\n";
text = text + "\n";
text = text + "\n";
text = text + "import javax.annotation.Resource;\n";
text = text + "\n";
text = text + "import org.slf4j.Logger;\n";
text = text + "import org.slf4j.LoggerFactory;\n";
text = text + "import org.springframework.stereotype.Controller;\n";
text = text + "import org.springframework.web.bind.annotation.RequestBody;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMapping;\n";
text = text + "import org.springframework.web.bind.annotation.RequestMethod;\n";
text = text + "import org.springframework.web.bind.annotation.RequestParam;\n";
text = text + "import org.springframework.web.bind.annotation.ResponseBody;\n";
text = text + "\n";
text = text + "import com.qat.framework.model.response.InternalResultsResponse;\n";
text = text + "import com.qat.framework.util.ResponseHandler;\n";
text = text + "import com.qat.samples.sysmgmt.bac.I"+titleize(bar)+"BAC;\n";
text = text + "import com.qat.samples.sysmgmt.model."+titleize(bar)+";\n";
text = text + "import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.request."+titleize(bar)+"MaintenanceRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.request.RefreshRequest;\n";
text = text + "import com.qat.samples.sysmgmt.model.response."+titleize(bar)+"Response;\n";
text = text + "\n";
text = text + "/**\n";
text = text + " * The Class "+titleize(bar)+"Controller.\n";
text = text + " */\n";
text = text + "@Controller\n";
text = text + '@RequestMapping("/'+bar.toLowerCase()+'/api")\n';
text = text + "public class "+titleize(bar)+"Controller \n";
text = text + "{\n";
text = text + "	/** The Constant DEFAULT_EXCEPTION_MSG. */\n";
text = text + '	private static final String DEFAULT_EXCEPTION_MSG = "sysmgmt.base.'+bar.toLowerCase()+'controllerrest.defaultexception";\n';
text = text + "\n";
text = text + "	/** The Constant LOG. */\n";
text = text + "	private static final Logger LOG = LoggerFactory.getLogger("+titleize(bar)+"Controller.class);\n";
text = text + "\n";
text = text + "	/** The "+bar.toLowerCase()+" Service. */\n";
text = text + "@Autowired\n";
text = text + "	private "+titleize(bar)+"Service "+bar.toLowerCase()+"Service;\n";
text = text + "\n";

for(i=0;i < teste.length;i++){

var nome = teste[i].classe.toLowerCase();
nomeM = titleize(teste[i].classe)
text = text + "\n";
text = text + '//===================================### '+nomeM.toUpperCase()+' ####======================================\n';
text = text + '/**\n';
text = text + '	 * Refresh '+nomeM.toLowerCase()+'s.\n';
text = text + '	 *\n';
text = text + '	 * @param refreshInt the refresh int\n';
text = text + '	 * @param retList the ret list\n';
text = text + '	 * @param retPaged the ret paged\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@CrossOrigin(origins = "*")\n';
text = text + '	@RequestMapping(value = "/refresh", method = RequestMethod.GET)\n';
text = text + '	@ResponseBody\n';
text = text + '	public ResponseEntity<List<'+nomeM+'>>  refresh'+nomeM+'s(@RequestParam("refreshInt") Integer refreshInt,\n';
text = text + '			@RequestParam("retList") Boolean retList,\n';
text = text + '			@RequestParam("retPaged") Boolean retPaged)\n';
text = text + '	{\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			List<'+nomeM+'> '+nomeM.toLowerCase()+'s = '+bar.toLowerCase()+'Service.refresh'+nomeM+'s(retList, retPaged);\n';					
text = text + '			return APIResponse.toOkResponse('+nomeM.toLowerCase()+'s);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + "\n";
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Fetch '+nomeM.toLowerCase()+' paged.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/fetchPage", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public ResponseEntity<List<'+nomeM+'>> fetch'+nomeM+'Paged(@RequestBody String requestString)\n';
text = text + '	{\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			ObjectMapper mapper = new ObjectMapper();\n';
text = text + '			Request request = mapper.readValue(requestString, Request.class);\n';
text = text + "\n";
text = text + '			return new ResponseEntity<List<'+nomeM+'>>('+bar.toLowerCase()+'Service.find'+nomeM+'All(request), HttpStatus.OK);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Insert '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/insert", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response insert'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().insert'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Update '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/update", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response update'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().update'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + '	}\n';
text = text + "\n";
text = text + '	/**\n';
text = text + '	 * Delete '+nomeM.toLowerCase()+'.\n';
text = text + '	 *\n';
text = text + '	 * @param request the request\n';
text = text + '	 * @return the '+nomeM.toLowerCase()+' response\n';
text = text + '	 */\n';
text = text + '	@RequestMapping(value = "/delete", method = RequestMethod.POST)\n';
text = text + '	@ResponseBody\n';
text = text + '	public '+nomeM+'Response delete'+nomeM+'(@RequestBody '+nomeM+'MaintenanceRequest request)\n';
text = text + '	{\n';
text = text + '		'+nomeM+'Response '+nomeM.toLowerCase()+'Response = new '+nomeM+'Response();\n';
text = text + "\n";
text = text + '		try\n';
text = text + '		{\n';
text = text + '			InternalResultsResponse<'+nomeM+'> internalResponse = get'+titleize(bar)+'BAC().delete'+nomeM+'(request);\n';
text = text + '			ResponseHandler.handleOperationStatusAndMessages('+nomeM.toLowerCase()+'Response, internalResponse, true);\n';
text = text + '		}\n';
text = text + '		catch (Exception ex)\n';
text = text + '		{\n';
text = text + '			ResponseHandler.handleException(LOG, '+nomeM.toLowerCase()+'Response, ex, DEFAULT_EXCEPTION_MSG,\n';
text = text + '					new Object[] {ex.toString()});\n';
text = text + '		}\n';
text = text + '		return '+nomeM.toLowerCase()+'Response;\n';
text = text + "\n";
text = text + '	}\n';
text = text + "\n";
}
text = text + "}\n";
return text;
}

