package com.sensus.mlc.contabil.bcl.impl;

import static com.sensus.mlc.base.util.LCActionUtil.createMessageInfoNone;
import static com.sensus.mlc.base.util.LCActionUtil.createMessageWarningOther;
import static com.sensus.mlc.base.util.LCHelp.createInquiryLightRequest;
import static com.sensus.mlc.base.util.LCHelp.createProcessItemWithFailure;
import static com.sensus.mlc.base.util.LCHelp.createProcessRequest;
import static com.sensus.mlc.base.util.LCPropertiesExtractorUtil.extractLightId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sensus.common.model.Message;
import com.sensus.common.model.Message.MessageLevel;
import com.sensus.common.model.Message.MessageSeverity;
import com.sensus.common.model.MessageInfo;
import com.sensus.common.model.response.InternalResponse;
import com.sensus.common.model.response.InternalResponse.Status;
import com.sensus.common.model.response.InternalResultsResponse;
import com.sensus.common.util.SensusAppContext;
import com.sensus.common.validation.ValidationUtil;
import com.sensus.mlc.base.model.MLCSortExpression;
import com.sensus.mlc.base.util.LCDateUtil;
import com.sensus.mlc.base.util.LCHelp;
import com.sensus.mlc.process.bcl.IProcessBCL;
import com.sensus.mlc.process.model.LCAction;
import com.sensus.mlc.process.model.LCActionParameter;
import com.sensus.mlc.process.model.LCActionTypeEnum;
import com.sensus.mlc.process.model.Process;
import com.sensus.mlc.process.model.ProcessItemStatusEnum;
import com.sensus.mlc.process.model.ProcessStatusReasonEnum;
import com.sensus.mlc.process.model.request.ProcessRequest;
import com.sensus.mlc.smartpoint.bcl.ISmartPointAccessorBCL;
import com.sensus.mlc.smartpoint.model.Light;
import com.sensus.mlc.smartpoint.model.LightOrderByEnum;
import com.sensus.mlc.smartpoint.model.LightStatusEnum;
import com.sensus.mlc.smartpoint.model.PropertyEnum;
import com.sensus.mlc.smartpoint.model.SearchLight;
import com.sensus.mlc.smartpoint.model.SearchParameter;
import com.sensus.mlc.smartpoint.model.request.InquiryLightRequest;
import com.sensus.mlc.smartpoint.model.request.LightRequest;
import com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL;
import com.sensus.mlc.lfclfiscal.dac.ILfclfiscalDAC;
import com.sensus.mlc.lfclfiscal.model.Lfclfiscal;
import com.sensus.mlc.lfclfiscal.model.request.InquiryLfclfiscalRequest;
import com.sensus.mlc.lfclfiscal.model.request.LfclfiscalRequest;

/** 
 * The Class LfclfiscalBCLImpl. 
 */ 
public class LfclfiscalBCLImpl implements ILfclfiscalBCL
{

	/**  The Constant SEPARATOR. */ 
	private static final String SEPARATOR = " - ";

	/**  The lfclfiscal dac. */ 
	private ILfclfiscalDAC lfclfiscalDAC;



	/**  The process bcl. */ 
	private IProcessBCL processBCL;

	/**  The lc help. */ 
	private LCHelp lcHelp;


	/** 
	 * Gets the lc help.
	 * 
	 * @return the lc help 
	 */ 
	public LCHelp getLcHelp() 
	{ 
		return lcHelp;
	} 

	/** 
	 * Sets the lc help.
	 *
	 * @param lcHelp the new lc help  
	 */ 
	public void setLcHelp(LCHelp lcHelp) 
	{ 
		this.lcHelp = lcHelp;
	} 

	/** 
	 * Spring Sets the lfclfiscal dac. 
	 *  
	 * @param iLfclfiscalDAC the new lfclfiscal dac 
	 */ 
	public void setLfclfiscalDAC(ILfclfiscalDAC iLfclfiscalDAC)
	{ 
		lfclfiscalDAC = iLfclfiscalDAC;
	} 

	/** 
	 * Gets the lfclfiscal dac. 
	 * 
	 * @return the lfclfiscal dac 
	 */ 
	public ILfclfiscalDAC getLfclfiscalDAC()
	{
		return lfclfiscalDAC;
	}

	/** 
	 * Gets the process bcl.
	 * 
	 * @return the process bcl 
	 */ 
	public IProcessBCL getProcessBCL() 
	{
		return processBCL;
	}

	/** 
	 * Sets the process bcl.
	 *  
	 * @param processBCL the new process bcl  
	 */ 
	public void setProcessBCL(IProcessBCL processBCL)
	{ 
		this.processBCL = processBCL;
	} 
	/*  
	 * (non-Javadoc)
	 * @see com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL#fetchAllLfclfiscals(InquiryLfclfiscalRequest) 
	 */ 
	@Override 
	public InternalResultsResponse<Lfclfiscal> fetchAllLfclfiscal(InquiryLfclfiscalRequest inquiryLfclfiscalRequest)
	{
		return getLfclfiscalDAC().fetchAllLfclfiscal(inquiryLfclfiscalRequest);
	}

	/*  
	 * (non-Javadoc)  
	 * @see com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL#fetchLfclfiscalById(com.sensus.mlc.lfclfiscal.model.request.LfclfiscalRequest)  
	 */ 
	@Override
	public InternalResultsResponse<Lfclfiscal> fetchLfclfiscalById(LfclfiscalRequest lfclfiscalRequest)
	{ 
		return getLfclfiscalDAC().fetchLfclfiscalById(lfclfiscalRequest);
	}
	/*  
	 * (non-Javadoc) 
	 * @see com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL#insertLfclfiscal(com.sensus.mlc.lfclfiscal.model.request.LfclfiscalRequest) 
	 */ 
	@Override 
	public InternalResultsResponse<Lfclfiscal> insertLfclfiscal(LfclfiscalRequest lfclfiscalRequest) 
	{  

		InternalResultsResponse<Lfclfiscal> response = getLfclfiscalDAC().insertLfclfiscal(lfclfiscalRequest);

		if (!response.isInError())
		{  
			Lfclfiscal lfclfiscal = response.getFirstResult();
			lfclfiscalRequest.setLfclfiscal(lfclfiscal);

			SearchParameter lfclfiscalParameter = new SearchParameter(PropertyEnum.LFCLFISCAL_ID, String.valueOf(lfclfiscal.getId()));
			lfclfiscalRequest.getSearchLight().addSearchParameter(lfclfiscalParameter);
			InternalResultsResponse<Process> processResponse = 
					this.insertProcess(lfclfiscalRequest, LCActionTypeEnum.INSERT_LFCLFISCAL, null);
			lfclfiscalRequest.getSearchLight().getSearchParameters().remove(lfclfiscalParameter);

			response.setStatus(processResponse.getStatus());
			response.addMessages(processResponse.getMessageInfoList());
		} 
		return response;

	}  

	/* 
	 * (non-Javadoc) 
	 * @see com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL#deleteLfclfiscal(com.sensus.mlc.lfclfiscal.model.request.LfclfiscalRequest)
	 */ 
	@Override 
	public InternalResponse deleteLfclfiscal(LfclfiscalRequest lfclfiscalRequest)
	{
		InternalResultsResponse<Lfclfiscal> lfclfiscalResponse = getLfclfiscalDAC().fetchLfclfiscalById(lfclfiscalRequest);
		InternalResponse response = new InternalResponse();

		if (lfclfiscalResponse.isInError()) 
		{
			response.setStatus(lfclfiscalResponse.getStatus());
			response.addMessages(lfclfiscalResponse.getMessageInfoList());
			return response;
		} 

		response = getLfclfiscalDAC().deleteLfclfiscal(lfclfiscalRequest);

		if (response.isInError()) 
		{
			return response;
		}

		Lfclfiscal lfclfiscal = lfclfiscalResponse.getFirstResult();
		lfclfiscalRequest.setLfclfiscal(lfclfiscal);

		SearchParameter lfclfiscalParameter = new SearchParameter(PropertyEnum.LFCLFISCAL_ID, String.valueOf(lfclfiscal.getId()));
		lfclfiscalRequest.getSearchLight().addSearchParameter(lfclfiscalParameter);

		InternalResultsResponse<Process> processResponse =  
				this.insertProcess(lfclfiscalRequest, LCActionTypeEnum.DELETE_TAG, null);
		lfclfiscalRequest.getSearchLight().getSearchParameters().remove(lfclfiscalParameter);

		if (processResponse.isInError())  
		{
			response.setStatus(processResponse.getStatus());
			response.addMessages(processResponse.getMessageInfoList());
		} 

		return response;
	}  
   
	/*  
	 * (non-Javadoc) 
	 * @see com.sensus.mlc.lfclfiscal.bcl.ILfclfiscalBCL#updateLfclfiscal(com.sensus.mlc.lfclfiscal.model.request.LfclfiscalRequest)
	 */ 
	@Override 
	public InternalResultsResponse<Lfclfiscal> updateLfclfiscal(LfclfiscalRequest lfclfiscalRequest)
	{ 
		InternalResultsResponse<Lfclfiscal> response = getLfclfiscalDAC().updateLfclfiscal(lfclfiscalRequest);

		if (!response.isInError()) 
		{ 
			InternalResponse processResponse = insertProcess(lfclfiscalRequest, LCActionTypeEnum.UPDATE_GROUP, null);

			response.addMessages(processResponse.getMessageInfoList());
		}
		return response;

	} 

	/** 
	 * Insert process.
	 * 
	 * @param lfclfiscalRequest the lfclfiscal request 
	 * @param lcActionType the lc action type 
	 * @param processDescription the process description 
	 * @return the internal results response  
	 */ 
	private InternalResultsResponse<Process> insertProcess(LfclfiscalRequest lfclfiscalRequest, LCActionTypeEnum lcActionType,
			String processDescription) 
			{  
		return insertProcess(lfclfiscalRequest, lcActionType, processDescription, null);
			}

	/** 
	 * Insert process. 
	 *  
	 * @param lfclfiscalRequest the lfclfiscal request 
	 * @param lcActionType the lc action type 
	 * @param processDescription the process description 
	 * @param deactivatedLights the deactivated lights   
	 * @return the internal results response 
	 */ 
	private InternalResultsResponse<Process> insertProcess(LfclfiscalRequest lfclfiscalRequest, LCActionTypeEnum lcActionType,
			String processDescription, List<Light> deactivatedLights)  
	{
		if(ValidationUtil.isNull(lfclfiscalRequest.getLfclfiscal()))
		{ 
			InternalResultsResponse<Process> response = new InternalResultsResponse<Process>();
			response.setStatus(Status.ExceptionError);
			return response;
		} 

		Lfclfiscal lfclfiscal = lfclfiscalRequest.getLfclfiscal();

		List<LCActionParameter> actionParameters = new ArrayList<LCActionParameter>();
		actionParameters.add(new LCActionParameter(PropertyEnum.EMPRESA_ID, String.valueOf(lfclfiscal.getCodemp())));
   actionParameters.add(new LCActionParameter(PropertyEnum.EMPRESA_ID, lfclfiscal.getCodemp().toString()));
   InquiryLightRequest lightRequest = createInquiryLightRequest(lfclfiscalRequest);
   Integer lightAmount = 1;

		LCAction action = new LCAction(lcActionType);
		action.setActionParameters(actionParameters);
		Process process = LCHelp.generateProcess(false, action, lightAmount);
		process.setIsProcessComplete(true);
		process.setEndTime(LCDateUtil.getNewDateUTC());

		if (!ValidationUtil.isNullOrEmpty(processDescription)) 
		{
			process.setDescription(processDescription);
		} 

		ProcessRequest processRequest = createProcessRequest(lfclfiscalRequest, process);
		processRequest.setProcessItemFailureList(  
				createProcessItemWithFailure(  
						deactivatedLights,   
						ProcessItemStatusEnum.MLCFAILURE,
						ProcessStatusReasonEnum.LIGHT_DEACTIVATED));

		return getProcessBCL().insertProcess(processRequest);
	} 
} 


 
 
