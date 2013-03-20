unit UFEpas;

interface
    function criarCodeClasseAPIControler(Txt:String):String;
    function criarCodeClasseHTML(Txt:String):String;
    function criarCodeClasseMainJS(Txt:String):String;
    function criarCodeClasseInitJS(Txt:String):String;
implementation

uses BrvFuncoesXE;

function criarCodeClasseHTML(Txt:String):String;
var F:TextFile;
begin
       AssignFile(F,'c:\I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'DAC.java');
       Rewrite(F); //abre o arquivo para escrita
       Closefile(F);
end;
function criarCodeClasseMainJS(Txt:String):String;
var F:TextFile;
begin
       AssignFile(F,'c:\I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'DAC.java');
       Rewrite(F); //abre o arquivo para escrita
       Closefile(F);
end;
function criarCodeClasseInitJS(Txt:String):String;
var F:TextFile;
begin
       AssignFile(F,'c:\I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'DAC.java');
        Rewrite(F); //abre o arquivo para escrita
       Closefile(F);
end;


function criarCodeClasseAPIControler(Txt:String):String;
var F:TextFile;
begin
      AssignFile(F,'c:\'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'APIControler.java');
      Rewrite(F); //abre o arquivo para escrita
      Writeln(F,'package com.sensus.mlc.wui.'+Txt+';');
      Writeln(F,'import javax.servlet.http.HttpServletRequest;');
      Writeln(F,'');
      Writeln(F,'import org.slf4j.Logger;');
      Writeln(F,'import org.slf4j.LoggerFactory;');
      Writeln(F,'import org.springframework.stereotype.Controller;');
      Writeln(F,'import org.springframework.web.bind.annotation.RequestBody;');
      Writeln(F,'import org.springframework.web.bind.annotation.RequestMapping;');
      Writeln(F,'import org.springframework.web.bind.annotation.RequestMethod;');
      Writeln(F,'import org.springframework.web.bind.annotation.ResponseBody;');
      Writeln(F,'');
      Writeln(F,'import com.sensus.common.model.response.Response;');
      Writeln(F,'import com.sensus.common.util.SensusInterfaceUtil;');
      Writeln(F,'import com.sensus.mlc.'+Txt+'.bcf.I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF;');
      Writeln(F,'import com.sensus.mlc.'+Txt+'.model.request.'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request;');
      Writeln(F,'import com.sensus.mlc.'+Txt+'.model.request.Inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request;');
      Writeln(F,'import com.sensus.mlc.'+Txt+'.model.response.'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response;');
      Writeln(F,'import com.sensus.mlc.'+Txt+'.model.response.Inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response;');
      Writeln(F,'import com.sensus.mlc.wui.BaseController;');
      Writeln(F,'import com.sensus.mlc.wui.light.LightAPIController;');
      Writeln(F,'');
      Writeln(F,'/** ');
      Writeln(F,'* @author QATEmployee ');
      Writeln(F,'* ');
      Writeln(F,'*/ ');
      Writeln(F,'@Controller');
      Writeln(F,'@RequestMapping("/api/'+Txt+'") ');
      Writeln(F,'public class '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'APIController extends BaseController  ');
      Writeln(F,'{ ');
      Writeln(F,'');
      Writeln(F,'/* ');
      Writeln(F,'* URLs Mapping   ');
      Writeln(F,'*/  ');
      Writeln(F,'/** The Constant MAP_FETCH. */ ');
      Writeln(F,'private static final String MAP_FETCH = "/fetch";');
      Writeln(F,'');
      Writeln(F,'private static final String MAP_FETCHALL = "/fetchall";');
      Writeln(F,'');
      Writeln(F,'/** The Constant MAP_DELETE. */ ');
      Writeln(F,'private static final String MAP_DELETE = "/delete";');
      Writeln(F,'');
      Writeln(F,'/** The Constant MAP_INSERT. */  ');
      Writeln(F,'private static final String MAP_INSERT = "/insert";');
      Writeln(F,'');
      Writeln(F,'/** The Constant MAP_INSERT. */  ');
      Writeln(F,'private static final String MAP_UPDATE = "/update";');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'private I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF '+Txt+'BCF;');
      Writeln(F,'');
      Writeln(F,'/** The Constant LOG. */');
      Writeln(F,'private static final Logger LOG = LoggerFactory.getLogger(LightAPIController.class);');
      Writeln(F,'');
      Writeln(F,'/** The Constant CONTROLLER_EXCEPTION_MSG. */  ');
      Writeln(F,'public static final String CONTROLLER_EXCEPTION_MSG = "'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'APIController";');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'public I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF() { ');
      Writeln(F,'return '+Txt+'BCF;');
      Writeln(F,'}  ');
      Writeln(F,'');
      Writeln(F,'public void set'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF(I'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF '+Txt+'BCF) {  ');
      Writeln(F,'this.'+Txt+'BCF = '+Txt+'BCF;');
      Writeln(F,'}');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'@RequestMapping(value = MAP_INSERT, method = RequestMethod.POST) ');
      Writeln(F,'@ResponseBody   ');
      Writeln(F,'public Response insert(@RequestBody '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request '+Txt+'Request, HttpServletRequest request) ');
      Writeln(F,'{ ');
      Writeln(F,'');
      Writeln(F,''+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response response = new '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response();');
      Writeln(F,'try  ');
      Writeln(F,'{ ');
      Writeln(F,'setUserContext('+Txt+'Request, request);');
      Writeln(F,'');
      Writeln(F,'response = get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF().insert'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'('+Txt+'Request);');
      Writeln(F,'');
      Writeln(F,'}  ');
      Writeln(F,'catch (Exception e)');
      Writeln(F,'{   ');
      Writeln(F,'SensusInterfaceUtil.handleException(LOG, response, e, DEFAULT_EXCEPTION_MSG,  ');
      Writeln(F,'			new String[] {CONTROLLER_EXCEPTION_MSG});');
      Writeln(F,'}  ');
      Writeln(F,'return response;');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'/**  ');
      Writeln(F,'* Update '+Txt+'.  ');
      Writeln(F,'*    ');
      Writeln(F,'* @param '+Txt+'Request the '+Txt+' request  ');
      Writeln(F,'* @return the '+Txt+' response  ');
      Writeln(F,'*/  ');
      Writeln(F,'');
      Writeln(F,'@RequestMapping(value = MAP_UPDATE, method = RequestMethod.POST)  ');
      Writeln(F,'@ResponseBody  ');
      Writeln(F,'public Response update'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'(@RequestBody '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request '+Txt+'Request, HttpServletRequest request) ');
      Writeln(F,'{ ');
      Writeln(F,'');
      Writeln(F,''+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response response = new '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response();');
      Writeln(F,'try  ');
      Writeln(F,'{ ');
      Writeln(F,'setUserContext('+Txt+'Request, request);');
      Writeln(F,'');
      Writeln(F,'response = get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF().update'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'('+Txt+'Request);');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'catch (Exception e) ');
      Writeln(F,'{  ');
      Writeln(F,'SensusInterfaceUtil.handleException(LOG, response, e, DEFAULT_EXCEPTION_MSG,  ');
      Writeln(F,'			new String[] {CONTROLLER_EXCEPTION_MSG});');
      Writeln(F,'}  ');
      Writeln(F,'return response;');
      Writeln(F,'');
      Writeln(F,'}  ');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'/**  ');
      Writeln(F,'* Delete filial. ');
      Writeln(F,'*      ');
      Writeln(F,'* @param filialRequest the filial request ');
      Writeln(F,'* @return the filial response    ');
      Writeln(F,'*/      ');
      Writeln(F,'');
      Writeln(F,'@RequestMapping(value = MAP_DELETE, method = RequestMethod.POST)  ');
      Writeln(F,'@ResponseBody  ');
      Writeln(F,'public Response delete'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'(@RequestBody '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request '+Txt+'Request, HttpServletRequest request) ');
      Writeln(F,'{  ');
      Writeln(F,'');
      Writeln(F,''+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response response = new '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response();');
      Writeln(F,'try ');
      Writeln(F,'{ ');
      Writeln(F,'setUserContext('+Txt+'Request, request);');
      Writeln(F,'');
      Writeln(F,'response = get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF().delete'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'('+Txt+'Request);');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'catch (Exception e) ');
      Writeln(F,'{ ');
      Writeln(F,'SensusInterfaceUtil.handleException(LOG, response, e, DEFAULT_EXCEPTION_MSG,');
      Writeln(F,'			new String[] {CONTROLLER_EXCEPTION_MSG});');
      Writeln(F,'}');
      Writeln(F,'return response;');
      Writeln(F,'');
      Writeln(F,'}  ');
      Writeln(F,'');
      Writeln(F,'/** ');
      Writeln(F,'* Fetch all filial.  ');
      Writeln(F,'*  ');
      Writeln(F,'* @param inquiryfilialRequest the inquiryfilial request  ');
      Writeln(F,'* @return the inquiry filial response  ');
      Writeln(F,'*/ ');
      Writeln(F,'');
      Writeln(F,'@RequestMapping(value = MAP_FETCHALL, method = RequestMethod.POST) ');
      Writeln(F,'@ResponseBody ');
      Writeln(F,'public Response fetch(@RequestBody Inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request, HttpServletRequest request) ');
      Writeln(F,'{  ');
      Writeln(F,'');
      Writeln(F,'Inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response response = new Inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response();');
      Writeln(F,'try');
      Writeln(F,'{ ');
      Writeln(F,'setUserContext(inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request, request);');
      Writeln(F,'');
      Writeln(F,'response = get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF().fetchAll'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'(inquiry'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request);');
      Writeln(F,'');
      Writeln(F,'}');
      Writeln(F,'catch (Exception e) ');
      Writeln(F,'{   ');
      Writeln(F,'SensusInterfaceUtil.handleException(LOG, response, e, DEFAULT_EXCEPTION_MSG,  ');
      Writeln(F,'			new String[] {CONTROLLER_EXCEPTION_MSG});');
      Writeln(F,'} ');
      Writeln(F,'return response;');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'');
      Writeln(F,'/**  ');
      Writeln(F,'* Fetch filial by id. ');
      Writeln(F,'* ');
      Writeln(F,'* @param filialRequest the filial request   ');
      Writeln(F,'* @return the filial response   ');
      Writeln(F,'*/    ');
      Writeln(F,'');
      Writeln(F,'@RequestMapping(value = MAP_FETCH, method = RequestMethod.POST) ');
      Writeln(F,'@ResponseBody ');
      Writeln(F,'public Response fetch(@RequestBody '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Request '+Txt+'Request, HttpServletRequest request)   ');
      Writeln(F,'{ ');
      Writeln(F,'');
      Writeln(F,''+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response response = new '+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'Response();');
      Writeln(F,'try   ');
      Writeln(F,'{  ');
      Writeln(F,'setUserContext('+Txt+'Request, request);');
      Writeln(F,'');
      Writeln(F,'response = get'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'BCF().fetch'+BrvFuncoesXE.PrimeiraMaiscula(Txt)+'ById('+Txt+'Request);');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'catch (Exception e)');
      Writeln(F,'{');
      Writeln(F,'SensusInterfaceUtil.handleException(LOG, response, e, DEFAULT_EXCEPTION_MSG,  ');
      Writeln(F,'			new String[] {CONTROLLER_EXCEPTION_MSG});');
      Writeln(F,'} ');
      Writeln(F,'return response;');
      Writeln(F,'');
      Writeln(F,'} ');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'');
      Writeln(F,'}  ');
      Closefile(F);
end;

end.