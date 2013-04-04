Memo1
package com.sensus.mlc.CNAE.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.CNAE.bcl.ICnaeBCL; 
import com.sensus.mlc.CNAE.dac.ICnaeDAC;  
import com.sensus.mlc.CNAE.model.Cnae;    
import com.sensus.mlc.CNAE.model.request.CnaeRequest; 
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class CnaeBCLImpl implements ICnaeBCL 
package com.sensus.mlc.CNAE.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.CNAE.bcl.ICnaeBCL
import com.sensus.mlc.CNAE.dac.ICnaeDAC
import com.sensus.mlc.CNAE.model.Cnae
import com.sensus.mlc.CNAE.model.request.CnaeRequest
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class CnaeBCLImpl implements ICnaeBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(CnaeBCLImpl.class)
 
/** The CNAE dac. */ 
private ICnaeDAC CNAEDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Cnae> insertCnae(CnaeRequest CNAERequest)  
{  
InternalResultsResponse<Cnae> response = getCnaeDAC().insertCnae(CNAERequest)
 
if (!response.isInError())  
{    
Cnae CNAE = response.getFirstResult()
CNAERequest.setCnae(CNAE)
 
SearchParameter CNAEParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(CNAE.getCodemp()))
CNAERequest.getSearchLight().addSearchParameter(CNAEParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(CNAERequest, LCActionTypeEnum.INSERT_EMPRESA, null)
CNAERequest.getSearchLight().getSearchParameters().remove(CNAEParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Cnae> updateCnae(CnaeRequest CNAERequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Cnae> internalResultsResponse = getCnaeDAC().updateCnae(CNAERequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteCnae(CnaeRequest CNAERequest)  
{ 
 
InternalResultsResponse<Cnae> tagResponse =  
(InternalResultsResponse<Cnae>)getCnaeDAC().deleteCnae(CNAERequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getCnaeDAC().deleteCnae(CNAERequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Cnae CNAE = tagResponse.getFirstResult()
CNAERequest.setCnae(CNAE)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(CNAE.getCodemp()))
CNAERequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(CNAERequest, LCActionTypeEnum.DELETE_TAG, null)
CNAERequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Cnae> fetchAllCnae(InquiryCnaeRequest inquiryCNAERequest) 
{   
return getCnaeDAC().fetchAllCnae(inquiryCNAERequest)
}  
 
@Override  
public InternalResultsResponse<Cnae> fetchCnaeById(CnaeRequest CNAERequest) 
{   
return getCnaeDAC().fetchCnaeById(CNAERequest)
} 
 
public ICnaeDAC getCnaeDAC() 
{
return CNAEDAC
} 
 
public void setCnaeDAC(ICnaeDAC CNAEDAC) 
{ 
this.CNAEDAC = CNAEDAC
}  
 
@Override  
public InternalResultsResponse<Cnae> fetchAllCnaeTypes(InquiryCnaeRequest inquiryCNAERequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(CnaeRequest CNAERequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(CNAERequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(CnaeRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Cnae CNAE = tagRequest.getCnae()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(CNAE.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, CNAE.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Cnae")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Cnae> fetchAllCnaeFilial(CnaeRequest CNAERequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.bairro.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.bairro.bcl.IBairroBCL; 
import com.sensus.mlc.bairro.dac.IBairroDAC;  
import com.sensus.mlc.bairro.model.Bairro;    
import com.sensus.mlc.bairro.model.request.BairroRequest; 
import com.sensus.mlc.bairro.model.request.InquiryBairroRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class BairroBCLImpl implements IBairroBCL 
package com.sensus.mlc.bairro.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.bairro.bcl.IBairroBCL
import com.sensus.mlc.bairro.dac.IBairroDAC
import com.sensus.mlc.bairro.model.Bairro
import com.sensus.mlc.bairro.model.request.BairroRequest
import com.sensus.mlc.bairro.model.request.InquiryBairroRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class BairroBCLImpl implements IBairroBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(BairroBCLImpl.class)
 
/** The bairro dac. */ 
private IBairroDAC bairroDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Bairro> insertBairro(BairroRequest bairroRequest)  
{  
InternalResultsResponse<Bairro> response = getBairroDAC().insertBairro(bairroRequest)
 
if (!response.isInError())  
{    
Bairro bairro = response.getFirstResult()
bairroRequest.setBairro(bairro)
 
SearchParameter bairroParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(bairro.getCodemp()))
bairroRequest.getSearchLight().addSearchParameter(bairroParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(bairroRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
bairroRequest.getSearchLight().getSearchParameters().remove(bairroParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Bairro> updateBairro(BairroRequest bairroRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Bairro> internalResultsResponse = getBairroDAC().updateBairro(bairroRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteBairro(BairroRequest bairroRequest)  
{ 
 
InternalResultsResponse<Bairro> tagResponse =  
(InternalResultsResponse<Bairro>)getBairroDAC().deleteBairro(bairroRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getBairroDAC().deleteBairro(bairroRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Bairro bairro = tagResponse.getFirstResult()
bairroRequest.setBairro(bairro)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(bairro.getCodemp()))
bairroRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(bairroRequest, LCActionTypeEnum.DELETE_TAG, null)
bairroRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Bairro> fetchAllBairro(InquiryBairroRequest inquirybairroRequest) 
{   
return getBairroDAC().fetchAllBairro(inquirybairroRequest)
}  
 
@Override  
public InternalResultsResponse<Bairro> fetchBairroById(BairroRequest bairroRequest) 
{   
return getBairroDAC().fetchBairroById(bairroRequest)
} 
 
public IBairroDAC getBairroDAC() 
{
return bairroDAC
} 
 
public void setBairroDAC(IBairroDAC bairroDAC) 
{ 
this.bairroDAC = bairroDAC
}  
 
@Override  
public InternalResultsResponse<Bairro> fetchAllBairroTypes(InquiryBairroRequest inquirybairroRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(BairroRequest bairroRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(bairroRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(BairroRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Bairro bairro = tagRequest.getBairro()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(bairro.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, bairro.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Bairro")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Bairro> fetchAllBairroFilial(BairroRequest bairroRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.MUNICIPIO.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL; 
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC;  
import com.sensus.mlc.MUNICIPIO.model.Municipio;    
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest; 
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class MunicipioBCLImpl implements IMunicipioBCL 
package com.sensus.mlc.MUNICIPIO.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class MunicipioBCLImpl implements IMunicipioBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(MunicipioBCLImpl.class)
 
/** The MUNICIPIO dac. */ 
private IMunicipioDAC MUNICIPIODAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)  
{  
InternalResultsResponse<Municipio> response = getMunicipioDAC().insertMunicipio(MUNICIPIORequest)
 
if (!response.isInError())  
{    
Municipio MUNICIPIO = response.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter MUNICIPIOParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(MUNICIPIOParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(MUNICIPIORequest, LCActionTypeEnum.INSERT_EMPRESA, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(MUNICIPIOParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Municipio> internalResultsResponse = getMunicipioDAC().updateMunicipio(MUNICIPIORequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)  
{ 
 
InternalResultsResponse<Municipio> tagResponse =  
(InternalResultsResponse<Municipio>)getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Municipio MUNICIPIO = tagResponse.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(MUNICIPIORequest, LCActionTypeEnum.DELETE_TAG, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest) 
{   
return getMunicipioDAC().fetchAllMunicipio(inquiryMUNICIPIORequest)
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest) 
{   
return getMunicipioDAC().fetchMunicipioById(MUNICIPIORequest)
} 
 
public IMunicipioDAC getMunicipioDAC() 
{
return MUNICIPIODAC
} 
 
public void setMunicipioDAC(IMunicipioDAC MUNICIPIODAC) 
{ 
this.MUNICIPIODAC = MUNICIPIODAC
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioTypes(InquiryMunicipioRequest inquiryMUNICIPIORequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(MunicipioRequest MUNICIPIORequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(MUNICIPIORequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(MunicipioRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Municipio MUNICIPIO = tagRequest.getMunicipio()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(MUNICIPIO.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, MUNICIPIO.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Municipio")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioFilial(MunicipioRequest MUNICIPIORequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.MUNICIPIO.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL; 
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC;  
import com.sensus.mlc.MUNICIPIO.model.Municipio;    
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest; 
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class MunicipioBCLImpl implements IMunicipioBCL 
package com.sensus.mlc.MUNICIPIO.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class MunicipioBCLImpl implements IMunicipioBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(MunicipioBCLImpl.class)
 
/** The MUNICIPIO dac. */ 
private IMunicipioDAC MUNICIPIODAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)  
{  
InternalResultsResponse<Municipio> response = getMunicipioDAC().insertMunicipio(MUNICIPIORequest)
 
if (!response.isInError())  
{    
Municipio MUNICIPIO = response.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter MUNICIPIOParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(MUNICIPIOParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(MUNICIPIORequest, LCActionTypeEnum.INSERT_EMPRESA, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(MUNICIPIOParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Municipio> internalResultsResponse = getMunicipioDAC().updateMunicipio(MUNICIPIORequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)  
{ 
 
InternalResultsResponse<Municipio> tagResponse =  
(InternalResultsResponse<Municipio>)getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Municipio MUNICIPIO = tagResponse.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(MUNICIPIORequest, LCActionTypeEnum.DELETE_TAG, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest) 
{   
return getMunicipioDAC().fetchAllMunicipio(inquiryMUNICIPIORequest)
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest) 
{   
return getMunicipioDAC().fetchMunicipioById(MUNICIPIORequest)
} 
 
public IMunicipioDAC getMunicipioDAC() 
{
return MUNICIPIODAC
} 
 
public void setMunicipioDAC(IMunicipioDAC MUNICIPIODAC) 
{ 
this.MUNICIPIODAC = MUNICIPIODAC
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioTypes(InquiryMunicipioRequest inquiryMUNICIPIORequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(MunicipioRequest MUNICIPIORequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(MUNICIPIORequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(MunicipioRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Municipio MUNICIPIO = tagRequest.getMunicipio()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(MUNICIPIO.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, MUNICIPIO.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Municipio")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioFilial(MunicipioRequest MUNICIPIORequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.UF.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.UF.bcl.IUfBCL; 
import com.sensus.mlc.UF.dac.IUfDAC;  
import com.sensus.mlc.UF.model.Uf;    
import com.sensus.mlc.UF.model.request.UfRequest; 
import com.sensus.mlc.UF.model.request.InquiryUfRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class UfBCLImpl implements IUfBCL 
package com.sensus.mlc.UF.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.UF.bcl.IUfBCL
import com.sensus.mlc.UF.dac.IUfDAC
import com.sensus.mlc.UF.model.Uf
import com.sensus.mlc.UF.model.request.UfRequest
import com.sensus.mlc.UF.model.request.InquiryUfRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class UfBCLImpl implements IUfBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(UfBCLImpl.class)
 
/** The UF dac. */ 
private IUfDAC UFDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Uf> insertUf(UfRequest UFRequest)  
{  
InternalResultsResponse<Uf> response = getUfDAC().insertUf(UFRequest)
 
if (!response.isInError())  
{    
Uf UF = response.getFirstResult()
UFRequest.setUf(UF)
 
SearchParameter UFParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(UF.getCodemp()))
UFRequest.getSearchLight().addSearchParameter(UFParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(UFRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
UFRequest.getSearchLight().getSearchParameters().remove(UFParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Uf> updateUf(UfRequest UFRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Uf> internalResultsResponse = getUfDAC().updateUf(UFRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteUf(UfRequest UFRequest)  
{ 
 
InternalResultsResponse<Uf> tagResponse =  
(InternalResultsResponse<Uf>)getUfDAC().deleteUf(UFRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getUfDAC().deleteUf(UFRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Uf UF = tagResponse.getFirstResult()
UFRequest.setUf(UF)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(UF.getCodemp()))
UFRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(UFRequest, LCActionTypeEnum.DELETE_TAG, null)
UFRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Uf> fetchAllUf(InquiryUfRequest inquiryUFRequest) 
{   
return getUfDAC().fetchAllUf(inquiryUFRequest)
}  
 
@Override  
public InternalResultsResponse<Uf> fetchUfById(UfRequest UFRequest) 
{   
return getUfDAC().fetchUfById(UFRequest)
} 
 
public IUfDAC getUfDAC() 
{
return UFDAC
} 
 
public void setUfDAC(IUfDAC UFDAC) 
{ 
this.UFDAC = UFDAC
}  
 
@Override  
public InternalResultsResponse<Uf> fetchAllUfTypes(InquiryUfRequest inquiryUFRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(UfRequest UFRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(UFRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(UfRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Uf UF = tagRequest.getUf()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(UF.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, UF.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Uf")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Uf> fetchAllUfFilial(UfRequest UFRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.CNAE.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.CNAE.bcl.ICnaeBCL; 
import com.sensus.mlc.CNAE.dac.ICnaeDAC;  
import com.sensus.mlc.CNAE.model.Cnae;    
import com.sensus.mlc.CNAE.model.request.CnaeRequest; 
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class CnaeBCLImpl implements ICnaeBCL 
package com.sensus.mlc.CNAE.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.CNAE.bcl.ICnaeBCL
import com.sensus.mlc.CNAE.dac.ICnaeDAC
import com.sensus.mlc.CNAE.model.Cnae
import com.sensus.mlc.CNAE.model.request.CnaeRequest
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class CnaeBCLImpl implements ICnaeBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(CnaeBCLImpl.class)
 
/** The CNAE dac. */ 
private ICnaeDAC CNAEDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Cnae> insertCnae(CnaeRequest CNAERequest)  
{  
InternalResultsResponse<Cnae> response = getCnaeDAC().insertCnae(CNAERequest)
 
if (!response.isInError())  
{    
Cnae CNAE = response.getFirstResult()
CNAERequest.setCnae(CNAE)
 
SearchParameter CNAEParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(CNAE.getCodemp()))
CNAERequest.getSearchLight().addSearchParameter(CNAEParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(CNAERequest, LCActionTypeEnum.INSERT_EMPRESA, null)
CNAERequest.getSearchLight().getSearchParameters().remove(CNAEParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Cnae> updateCnae(CnaeRequest CNAERequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Cnae> internalResultsResponse = getCnaeDAC().updateCnae(CNAERequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteCnae(CnaeRequest CNAERequest)  
{ 
 
InternalResultsResponse<Cnae> tagResponse =  
(InternalResultsResponse<Cnae>)getCnaeDAC().deleteCnae(CNAERequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getCnaeDAC().deleteCnae(CNAERequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Cnae CNAE = tagResponse.getFirstResult()
CNAERequest.setCnae(CNAE)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(CNAE.getCodemp()))
CNAERequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(CNAERequest, LCActionTypeEnum.DELETE_TAG, null)
CNAERequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Cnae> fetchAllCnae(InquiryCnaeRequest inquiryCNAERequest) 
{   
return getCnaeDAC().fetchAllCnae(inquiryCNAERequest)
}  
 
@Override  
public InternalResultsResponse<Cnae> fetchCnaeById(CnaeRequest CNAERequest) 
{   
return getCnaeDAC().fetchCnaeById(CNAERequest)
} 
 
public ICnaeDAC getCnaeDAC() 
{
return CNAEDAC
} 
 
public void setCnaeDAC(ICnaeDAC CNAEDAC) 
{ 
this.CNAEDAC = CNAEDAC
}  
 
@Override  
public InternalResultsResponse<Cnae> fetchAllCnaeTypes(InquiryCnaeRequest inquiryCNAERequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(CnaeRequest CNAERequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(CNAERequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(CnaeRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Cnae CNAE = tagRequest.getCnae()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(CNAE.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, CNAE.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Cnae")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Cnae> fetchAllCnaeFilial(CnaeRequest CNAERequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.BAIRRO.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.BAIRRO.bcl.IBairroBCL; 
import com.sensus.mlc.BAIRRO.dac.IBairroDAC;  
import com.sensus.mlc.BAIRRO.model.Bairro;    
import com.sensus.mlc.BAIRRO.model.request.BairroRequest; 
import com.sensus.mlc.BAIRRO.model.request.InquiryBairroRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class BairroBCLImpl implements IBairroBCL 
package com.sensus.mlc.BAIRRO.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.BAIRRO.bcl.IBairroBCL
import com.sensus.mlc.BAIRRO.dac.IBairroDAC
import com.sensus.mlc.BAIRRO.model.Bairro
import com.sensus.mlc.BAIRRO.model.request.BairroRequest
import com.sensus.mlc.BAIRRO.model.request.InquiryBairroRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class BairroBCLImpl implements IBairroBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(BairroBCLImpl.class)
 
/** The BAIRRO dac. */ 
private IBairroDAC BAIRRODAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Bairro> insertBairro(BairroRequest BAIRRORequest)  
{  
InternalResultsResponse<Bairro> response = getBairroDAC().insertBairro(BAIRRORequest)
 
if (!response.isInError())  
{    
Bairro BAIRRO = response.getFirstResult()
BAIRRORequest.setBairro(BAIRRO)
 
SearchParameter BAIRROParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(BAIRRO.getCodemp()))
BAIRRORequest.getSearchLight().addSearchParameter(BAIRROParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(BAIRRORequest, LCActionTypeEnum.INSERT_EMPRESA, null)
BAIRRORequest.getSearchLight().getSearchParameters().remove(BAIRROParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Bairro> updateBairro(BairroRequest BAIRRORequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Bairro> internalResultsResponse = getBairroDAC().updateBairro(BAIRRORequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteBairro(BairroRequest BAIRRORequest)  
{ 
 
InternalResultsResponse<Bairro> tagResponse =  
(InternalResultsResponse<Bairro>)getBairroDAC().deleteBairro(BAIRRORequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getBairroDAC().deleteBairro(BAIRRORequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Bairro BAIRRO = tagResponse.getFirstResult()
BAIRRORequest.setBairro(BAIRRO)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(BAIRRO.getCodemp()))
BAIRRORequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(BAIRRORequest, LCActionTypeEnum.DELETE_TAG, null)
BAIRRORequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Bairro> fetchAllBairro(InquiryBairroRequest inquiryBAIRRORequest) 
{   
return getBairroDAC().fetchAllBairro(inquiryBAIRRORequest)
}  
 
@Override  
public InternalResultsResponse<Bairro> fetchBairroById(BairroRequest BAIRRORequest) 
{   
return getBairroDAC().fetchBairroById(BAIRRORequest)
} 
 
public IBairroDAC getBairroDAC() 
{
return BAIRRODAC
} 
 
public void setBairroDAC(IBairroDAC BAIRRODAC) 
{ 
this.BAIRRODAC = BAIRRODAC
}  
 
@Override  
public InternalResultsResponse<Bairro> fetchAllBairroTypes(InquiryBairroRequest inquiryBAIRRORequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(BairroRequest BAIRRORequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(BAIRRORequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(BairroRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Bairro BAIRRO = tagRequest.getBairro()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(BAIRRO.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, BAIRRO.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Bairro")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Bairro> fetchAllBairroFilial(BairroRequest BAIRRORequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.MUNICIPIO.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL; 
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC;  
import com.sensus.mlc.MUNICIPIO.model.Municipio;    
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest; 
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class MunicipioBCLImpl implements IMunicipioBCL 
package com.sensus.mlc.MUNICIPIO.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.MUNICIPIO.bcl.IMunicipioBCL
import com.sensus.mlc.MUNICIPIO.dac.IMunicipioDAC
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class MunicipioBCLImpl implements IMunicipioBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(MunicipioBCLImpl.class)
 
/** The MUNICIPIO dac. */ 
private IMunicipioDAC MUNICIPIODAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)  
{  
InternalResultsResponse<Municipio> response = getMunicipioDAC().insertMunicipio(MUNICIPIORequest)
 
if (!response.isInError())  
{    
Municipio MUNICIPIO = response.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter MUNICIPIOParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(MUNICIPIOParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(MUNICIPIORequest, LCActionTypeEnum.INSERT_EMPRESA, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(MUNICIPIOParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Municipio> internalResultsResponse = getMunicipioDAC().updateMunicipio(MUNICIPIORequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)  
{ 
 
InternalResultsResponse<Municipio> tagResponse =  
(InternalResultsResponse<Municipio>)getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getMunicipioDAC().deleteMunicipio(MUNICIPIORequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Municipio MUNICIPIO = tagResponse.getFirstResult()
MUNICIPIORequest.setMunicipio(MUNICIPIO)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(MUNICIPIO.getCodemp()))
MUNICIPIORequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(MUNICIPIORequest, LCActionTypeEnum.DELETE_TAG, null)
MUNICIPIORequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest) 
{   
return getMunicipioDAC().fetchAllMunicipio(inquiryMUNICIPIORequest)
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest) 
{   
return getMunicipioDAC().fetchMunicipioById(MUNICIPIORequest)
} 
 
public IMunicipioDAC getMunicipioDAC() 
{
return MUNICIPIODAC
} 
 
public void setMunicipioDAC(IMunicipioDAC MUNICIPIODAC) 
{ 
this.MUNICIPIODAC = MUNICIPIODAC
}  
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioTypes(InquiryMunicipioRequest inquiryMUNICIPIORequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(MunicipioRequest MUNICIPIORequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(MUNICIPIORequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(MunicipioRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Municipio MUNICIPIO = tagRequest.getMunicipio()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(MUNICIPIO.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, MUNICIPIO.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Municipio")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Municipio> fetchAllMunicipioFilial(MunicipioRequest MUNICIPIORequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.UF.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.UF.bcl.IUfBCL; 
import com.sensus.mlc.UF.dac.IUfDAC;  
import com.sensus.mlc.UF.model.Uf;    
import com.sensus.mlc.UF.model.request.UfRequest; 
import com.sensus.mlc.UF.model.request.InquiryUfRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class UfBCLImpl implements IUfBCL 
package com.sensus.mlc.UF.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.UF.bcl.IUfBCL
import com.sensus.mlc.UF.dac.IUfDAC
import com.sensus.mlc.UF.model.Uf
import com.sensus.mlc.UF.model.request.UfRequest
import com.sensus.mlc.UF.model.request.InquiryUfRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class UfBCLImpl implements IUfBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(UfBCLImpl.class)
 
/** The UF dac. */ 
private IUfDAC UFDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Uf> insertUf(UfRequest UFRequest)  
{  
InternalResultsResponse<Uf> response = getUfDAC().insertUf(UFRequest)
 
if (!response.isInError())  
{    
Uf UF = response.getFirstResult()
UFRequest.setUf(UF)
 
SearchParameter UFParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(UF.getCodemp()))
UFRequest.getSearchLight().addSearchParameter(UFParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(UFRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
UFRequest.getSearchLight().getSearchParameters().remove(UFParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Uf> updateUf(UfRequest UFRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Uf> internalResultsResponse = getUfDAC().updateUf(UFRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteUf(UfRequest UFRequest)  
{ 
 
InternalResultsResponse<Uf> tagResponse =  
(InternalResultsResponse<Uf>)getUfDAC().deleteUf(UFRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getUfDAC().deleteUf(UFRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Uf UF = tagResponse.getFirstResult()
UFRequest.setUf(UF)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(UF.getCodemp()))
UFRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(UFRequest, LCActionTypeEnum.DELETE_TAG, null)
UFRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Uf> fetchAllUf(InquiryUfRequest inquiryUFRequest) 
{   
return getUfDAC().fetchAllUf(inquiryUFRequest)
}  
 
@Override  
public InternalResultsResponse<Uf> fetchUfById(UfRequest UFRequest) 
{   
return getUfDAC().fetchUfById(UFRequest)
} 
 
public IUfDAC getUfDAC() 
{
return UFDAC
} 
 
public void setUfDAC(IUfDAC UFDAC) 
{ 
this.UFDAC = UFDAC
}  
 
@Override  
public InternalResultsResponse<Uf> fetchAllUfTypes(InquiryUfRequest inquiryUFRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(UfRequest UFRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(UFRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(UfRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Uf UF = tagRequest.getUf()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(UF.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, UF.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Uf")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Uf> fetchAllUfFilial(UfRequest UFRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.PAIS.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.PAIS.bcl.IPaisBCL; 
import com.sensus.mlc.PAIS.dac.IPaisDAC;  
import com.sensus.mlc.PAIS.model.Pais;    
import com.sensus.mlc.PAIS.model.request.PaisRequest; 
import com.sensus.mlc.PAIS.model.request.InquiryPaisRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class PaisBCLImpl implements IPaisBCL 
package com.sensus.mlc.PAIS.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.PAIS.bcl.IPaisBCL
import com.sensus.mlc.PAIS.dac.IPaisDAC
import com.sensus.mlc.PAIS.model.Pais
import com.sensus.mlc.PAIS.model.request.PaisRequest
import com.sensus.mlc.PAIS.model.request.InquiryPaisRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class PaisBCLImpl implements IPaisBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(PaisBCLImpl.class)
 
/** The PAIS dac. */ 
private IPaisDAC PAISDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Pais> insertPais(PaisRequest PAISRequest)  
{  
InternalResultsResponse<Pais> response = getPaisDAC().insertPais(PAISRequest)
 
if (!response.isInError())  
{    
Pais PAIS = response.getFirstResult()
PAISRequest.setPais(PAIS)
 
SearchParameter PAISParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(PAIS.getCodemp()))
PAISRequest.getSearchLight().addSearchParameter(PAISParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(PAISRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
PAISRequest.getSearchLight().getSearchParameters().remove(PAISParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Pais> updatePais(PaisRequest PAISRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Pais> internalResultsResponse = getPaisDAC().updatePais(PAISRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deletePais(PaisRequest PAISRequest)  
{ 
 
InternalResultsResponse<Pais> tagResponse =  
(InternalResultsResponse<Pais>)getPaisDAC().deletePais(PAISRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getPaisDAC().deletePais(PAISRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Pais PAIS = tagResponse.getFirstResult()
PAISRequest.setPais(PAIS)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(PAIS.getCodemp()))
PAISRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(PAISRequest, LCActionTypeEnum.DELETE_TAG, null)
PAISRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Pais> fetchAllPais(InquiryPaisRequest inquiryPAISRequest) 
{   
return getPaisDAC().fetchAllPais(inquiryPAISRequest)
}  
 
@Override  
public InternalResultsResponse<Pais> fetchPaisById(PaisRequest PAISRequest) 
{   
return getPaisDAC().fetchPaisById(PAISRequest)
} 
 
public IPaisDAC getPaisDAC() 
{
return PAISDAC
} 
 
public void setPaisDAC(IPaisDAC PAISDAC) 
{ 
this.PAISDAC = PAISDAC
}  
 
@Override  
public InternalResultsResponse<Pais> fetchAllPaisTypes(InquiryPaisRequest inquiryPAISRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(PaisRequest PAISRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(PAISRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(PaisRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Pais PAIS = tagRequest.getPais()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(PAIS.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, PAIS.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Pais")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Pais> fetchAllPaisFilial(PaisRequest PAISRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.Eventos.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.Eventos.bcl.IEventosBCL; 
import com.sensus.mlc.Eventos.dac.IEventosDAC;  
import com.sensus.mlc.Eventos.model.Eventos;    
import com.sensus.mlc.Eventos.model.request.EventosRequest; 
import com.sensus.mlc.Eventos.model.request.InquiryEventosRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class EventosBCLImpl implements IEventosBCL 
package com.sensus.mlc.Eventos.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.Eventos.bcl.IEventosBCL
import com.sensus.mlc.Eventos.dac.IEventosDAC
import com.sensus.mlc.Eventos.model.Eventos
import com.sensus.mlc.Eventos.model.request.EventosRequest
import com.sensus.mlc.Eventos.model.request.InquiryEventosRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class EventosBCLImpl implements IEventosBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(EventosBCLImpl.class)
 
/** The Eventos dac. */ 
private IEventosDAC EventosDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Eventos> insertEventos(EventosRequest EventosRequest)  
{  
InternalResultsResponse<Eventos> response = getEventosDAC().insertEventos(EventosRequest)
 
if (!response.isInError())  
{    
Eventos Eventos = response.getFirstResult()
EventosRequest.setEventos(Eventos)
 
SearchParameter EventosParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(Eventos.getCodemp()))
EventosRequest.getSearchLight().addSearchParameter(EventosParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(EventosRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
EventosRequest.getSearchLight().getSearchParameters().remove(EventosParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Eventos> updateEventos(EventosRequest EventosRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Eventos> internalResultsResponse = getEventosDAC().updateEventos(EventosRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteEventos(EventosRequest EventosRequest)  
{ 
 
InternalResultsResponse<Eventos> tagResponse =  
(InternalResultsResponse<Eventos>)getEventosDAC().deleteEventos(EventosRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getEventosDAC().deleteEventos(EventosRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Eventos Eventos = tagResponse.getFirstResult()
EventosRequest.setEventos(Eventos)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(Eventos.getCodemp()))
EventosRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(EventosRequest, LCActionTypeEnum.DELETE_TAG, null)
EventosRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Eventos> fetchAllEventos(InquiryEventosRequest inquiryEventosRequest) 
{   
return getEventosDAC().fetchAllEventos(inquiryEventosRequest)
}  
 
@Override  
public InternalResultsResponse<Eventos> fetchEventosById(EventosRequest EventosRequest) 
{   
return getEventosDAC().fetchEventosById(EventosRequest)
} 
 
public IEventosDAC getEventosDAC() 
{
return EventosDAC
} 
 
public void setEventosDAC(IEventosDAC EventosDAC) 
{ 
this.EventosDAC = EventosDAC
}  
 
@Override  
public InternalResultsResponse<Eventos> fetchAllEventosTypes(InquiryEventosRequest inquiryEventosRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(EventosRequest EventosRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(EventosRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(EventosRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Eventos Eventos = tagRequest.getEventos()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(Eventos.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, Eventos.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Eventos")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Eventos> fetchAllEventosFilial(EventosRequest EventosRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
package com.sensus.mlc.Titulares.bcl.impl; 
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure; 
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest; 
  
import java.util.ArrayList; 
import java.util.List; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
  
import com.sensus.common.model.response.InternalResponse; 
import com.sensus.common.model.response.InternalResultsResponse; 
import com.sensus.common.util.SensusAppContext; 
import com.sensus.common.validation.ValidationUtil; 
import com.sensus.mlc.base.util.LCDateUtil;   
import com.sensus.mlc.base.util.LCHelp;        
import com.sensus.mlc.Titulares.bcl.ITitularesBCL; 
import com.sensus.mlc.Titulares.dac.ITitularesDAC;  
import com.sensus.mlc.Titulares.model.Titulares;    
import com.sensus.mlc.Titulares.model.request.TitularesRequest; 
import com.sensus.mlc.Titulares.model.request.InquiryTitularesRequest;  
import com.sensus.mlc.process.bcl.IProcessBCL;    
import com.sensus.mlc.process.model.LCAction;  
import com.sensus.mlc.process.model.LCActionParameter;  
import com.sensus.mlc.process.model.LCActionTypeEnum;  
import com.sensus.mlc.process.model.Process;   
import com.sensus.mlc.process.model.ProcessItemStatusEnum; 
import com.sensus.mlc.process.model.ProcessStatusReasonEnum; 
import com.sensus.mlc.process.model.request.ProcessRequest; 
import com.sensus.mlc.schedule.bcl.IScheduleBCL;  
import com.sensus.mlc.smartpoint.model.Light; 
import com.sensus.mlc.smartpoint.model.PropertyEnum; 
import com.sensus.mlc.smartpoint.model.SearchParameter;
  
/** 
 * Action BCL implementation class. 
 * 
 * @author QAT. 
 */
public class TitularesBCLImpl implements ITitularesBCL 
package com.sensus.mlc.Titulares.bcl.impl
 
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest
 
import java.util.ArrayList
import java.util.List
 
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
 
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.common.util.SensusAppContext
import com.sensus.common.validation.ValidationUtil
import com.sensus.mlc.base.util.LCDateUtil
import com.sensus.mlc.base.util.LCHelp
import com.sensus.mlc.Titulares.bcl.ITitularesBCL
import com.sensus.mlc.Titulares.dac.ITitularesDAC
import com.sensus.mlc.Titulares.model.Titulares
import com.sensus.mlc.Titulares.model.request.TitularesRequest
import com.sensus.mlc.Titulares.model.request.InquiryTitularesRequest
import com.sensus.mlc.process.bcl.IProcessBCL
import com.sensus.mlc.process.model.LCAction
import com.sensus.mlc.process.model.LCActionParameter
import com.sensus.mlc.process.model.LCActionTypeEnum
import com.sensus.mlc.process.model.Process
import com.sensus.mlc.process.model.ProcessItemStatusEnum
import com.sensus.mlc.process.model.ProcessStatusReasonEnum
import com.sensus.mlc.process.model.request.ProcessRequest
import com.sensus.mlc.schedule.bcl.IScheduleBCL
import com.sensus.mlc.smartpoint.model.Light
import com.sensus.mlc.smartpoint.model.PropertyEnum
import com.sensus.mlc.smartpoint.model.SearchParameter
 
/**
* Action BCL implementation class. 
*
* @author Washington 
*/
public class TitularesBCLImpl implements ITitularesBCL 
{ 
 
/** The LOG. */  
private static transient Log LOG = LogFactory.getLog(TitularesBCLImpl.class)
 
/** The Titulares dac. */ 
private ITitularesDAC TitularesDAC // injected by Spring through setter 
 
/** The Constant PROCESS_BCL_BEAN. */ 
private static final String PROCESS_BCL_BEAN = "processBCLTarget"
 
/** The Constant SCHEDULE_BCL_BEAN. */ 
private static final String SCHEDULE_BCL_BEAN = "scheduleBCLTarget"
 
/** The Constant ACTION_PROVIDER_TYPE. */ 
private static final String ACTION_PROVIDER_TYPE = "EPM.TASK"
 
/** The Constant ADD_PROPERTY_TO_ACTION_FAILED. */ 
private static final String ADD_PROPERTY_TO_ACTION_FAILED =  
"sensus.epm.actionbclimpl.add.property.to.action.failed"
 
/** The Constant UPDATE_PROPERTY_TO_ACTION_FAILED. */  
private static final String UPDATE_PROPERTY_TO_ACTION_FAILED = 
"sensus.epm.actionbclimpl.update.property.to.action.failed"
 
/** The Constant DELETE_PROPERTY_FROM_ACTION_FAILED. */   
private static final String DELETE_PROPERTY_FROM_ACTION_FAILED = 
"sensus.epm.actionbclimpl.delete.property.from.action.failed"
 
/** The Constant PROPERTY_DAC_BEAN. */ 
private static final String PROPERTY_DAC_BEAN = "propertyDACTarget"
 
/** The Constant GET_ACTION_TO_CLONE_FAILED. */     
private static final String GET_ACTION_TO_CLONE_FAILED = "sensus.epm.actionbclimpl.get.action.to.clone.failed"
 
/** The Constant APPLY_ACTION_FAILED. */   
private static final String APPLY_ACTION_FAILED =  
"sensus.epm.actionbclimpl.apply.action.failed"
 
/** The Constant DATE_RAND_DIVISION. */  
private static final Integer DATE_RAND_DIVISION = 0xFFFFF
 
/**  
* Gets the process bcl. 
*   
* @return the process bcl 
*/
public IProcessBCL getProcessBCL() 
{  
return (IProcessBCL)SensusAppContext.getApplicationContext().getBean(PROCESS_BCL_BEAN)
} 
 
/**
* Gets the schedule bcl. 
* 
* @return the schedule bcl 
*/
public IScheduleBCL getScheduleBCL()
{  
return (IScheduleBCL)SensusAppContext.getApplicationContext().getBean(SCHEDULE_BCL_BEAN)
} 
 
@Override 
public InternalResultsResponse<Titulares> insertTitulares(TitularesRequest TitularesRequest)  
{  
InternalResultsResponse<Titulares> response = getTitularesDAC().insertTitulares(TitularesRequest)
 
if (!response.isInError())  
{    
Titulares Titulares = response.getFirstResult()
TitularesRequest.setTitulares(Titulares)
 
SearchParameter TitularesParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(Titulares.getCodemp()))
TitularesRequest.getSearchLight().addSearchParameter(TitularesParameter)
InternalResultsResponse<Process> processResponse =   
insertProcess(TitularesRequest, LCActionTypeEnum.INSERT_EMPRESA, null)
TitularesRequest.getSearchLight().getSearchParameters().remove(TitularesParameter)
 
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}  
return response
 
}  
 
@Override 
public InternalResultsResponse<Titulares> updateTitulares(TitularesRequest TitularesRequest)
{ 
InternalResponse groupResponse = new InternalResponse()
 
InternalResultsResponse<Titulares> internalResultsResponse = getTitularesDAC().updateTitulares(TitularesRequest)
 
if (!ValidationUtil.isNull(groupResponse))  
{  
internalResultsResponse.addMessages(groupResponse.getMessageInfoList())
} 
 
return internalResultsResponse
} 
 
@Override  
public InternalResponse deleteTitulares(TitularesRequest TitularesRequest)  
{ 
 
InternalResultsResponse<Titulares> tagResponse =  
(InternalResultsResponse<Titulares>)getTitularesDAC().deleteTitulares(TitularesRequest)
InternalResponse response = new InternalResponse()
 
if (tagResponse.isInError())  
{   
return response
}  
 
response = getTitularesDAC().deleteTitulares(TitularesRequest)
 
if (tagResponse.isInError()) 
{      
return response
}   
 
Titulares Titulares = tagResponse.getFirstResult()
TitularesRequest.setTitulares(Titulares)
 
SearchParameter tagParameter =  
new SearchParameter(PropertyEnum.EMPRESA_ID, String.valueOf(Titulares.getCodemp()))
TitularesRequest.getSearchLight().addSearchParameter(tagParameter)
 
InternalResultsResponse<Process> processResponse = 
insertProcess(TitularesRequest, LCActionTypeEnum.DELETE_TAG, null)
TitularesRequest.getSearchLight().getSearchParameters().remove(tagParameter)
 
if (processResponse.isInError())  
{       
response.setStatus(processResponse.getStatus())
response.addMessages(processResponse.getMessageInfoList())
}
 
return response
} 
 
@Override 
public InternalResultsResponse<Titulares> fetchAllTitulares(InquiryTitularesRequest inquiryTitularesRequest) 
{   
return getTitularesDAC().fetchAllTitulares(inquiryTitularesRequest)
}  
 
@Override  
public InternalResultsResponse<Titulares> fetchTitularesById(TitularesRequest TitularesRequest) 
{   
return getTitularesDAC().fetchTitularesById(TitularesRequest)
} 
 
public ITitularesDAC getTitularesDAC() 
{
return TitularesDAC
} 
 
public void setTitularesDAC(ITitularesDAC TitularesDAC) 
{ 
this.TitularesDAC = TitularesDAC
}  
 
@Override  
public InternalResultsResponse<Titulares> fetchAllTitularesTypes(InquiryTitularesRequest inquiryTitularesRequest)  
{ 
// TODO Auto-generated method stub  
return null
}         
 
private InternalResultsResponse<Process> insertProcess(TitularesRequest TitularesRequest,  
LCActionTypeEnum lcActionType, 
String processDescription)   
{ 
return insertProcess(TitularesRequest, lcActionType, processDescription, null)
} 
 
/**   
* Insert process. 
*   
* @param tagRequest the tag request 
* @param lcActionType the lc action type   
* @param processDescription the process description   
* @return the internal results response  
*/         
private InternalResultsResponse<Process> insertProcess(TitularesRequest tagRequest, LCActionTypeEnum lcActionType,  
String processDescription, List<Light> deactivatedLights) 
{
Titulares Titulares = tagRequest.getTitulares()
 
List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>()
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_ID, String.valueOf(Titulares.getCodemp())))
actionParameters.add(new LCActionParameter(PropertyEnum.TAG_NAME, Titulares.getCnpjemp()))
 
LCAction action = new LCAction(lcActionType)
action.setActionParameters(actionParameters)
action.setDescription("INSERT EMPRESA")
Process process = LCHelp.generateProcess(false, action, 0)
process.setIsProcessComplete(true)
process.setIsSubmitted(true)
process.setDescription("insert Titulares")
process.setRniCorrelationId("")
 
 
process.setEndTime(LCDateUtil.getNewDateUTC())
 
if (!ValidationUtil.isNullOrEmpty(processDescription))  
{ 
process.setDescription(processDescription)
} 
 
ProcessRequest processRequest = createProcessRequest(tagRequest, process)
processRequest.setProcessItemFailureList( 
createProcessItemWithFailure(  
	deactivatedLights,     
	ProcessItemStatusEnum.MLCFAILURE,  
	ProcessStatusReasonEnum.LIGHT_DEACTIVATED))
 
return getProcessBCL().insertProcess(processRequest)
} 
 
@Override  
public InternalResultsResponse<Titulares> fetchAllTitularesFilial(TitularesRequest TitularesRequest) 
{  
// TODO Auto-generated method stub  
return null
} 
}  
 
