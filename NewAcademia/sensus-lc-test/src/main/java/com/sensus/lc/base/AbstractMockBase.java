package com.sensus.lc.base;

import static com.sensus.lc.base.TestBaseUtil.createNotificationHistory;
import static com.sensus.lc.base.TestBaseUtil.createUserContext;

import java.util.ArrayList;
import java.util.List;

import com.sensus.common.model.response.InternalResponse;
import com.sensus.common.model.response.InternalResponse.Status;
import com.sensus.common.model.response.InternalResultsResponse;
import com.sensus.common.model.response.Response;
import com.sensus.lc.light.model.Light;
import com.sensus.lc.light.model.NotificationHistory;
import com.sensus.lc.process.model.Process;
import com.sensus.lc.process.model.ProcessItem;
import com.sensus.lc.tag.model.Tag;
import com.sensus.lc.tenant.model.Tenant;

/**
 * The Class AbstractMockBase.
 */
public class AbstractMockBase
{
	protected static final String ERROR_CODE = "error";
	protected static final String J_UNIT = "JUnit";
	protected static final Integer TEN = 10;
	private LCAreaEnum areaEnum = LCAreaEnum.DEFAULT;
	private SituationsEnum situationsEnum = SituationsEnum.SUCCESS;
	private Class<?> evaluableClass;
	private List<String> evaluableMethods = new ArrayList<String>();
	private String testControl;

	/**
	 * Gets the evaluable class.
	 * 
	 * @return the evaluable class
	 */
	public Class<?> getEvaluableClass()
	{
		return evaluableClass;
	}

	/**
	 * Sets the evaluable class.
	 * 
	 * @param evaluableClass the new evaluable class
	 */
	public void setEvaluableClass(Class<?> evaluableClass)
	{
		this.evaluableClass = evaluableClass;
	}

	/**
	 * Gets the methods.
	 * 
	 * @return the methods
	 */
	public List<String> getEvaluableMethods()
	{
		return evaluableMethods;
	}

	/**
	 * Sets the evaluable methods.
	 * 
	 * @param evaluableMethods the new evaluable methods
	 */
	public void setEvaluableMethods(List<String> evaluableMethods)
	{
		this.evaluableMethods = evaluableMethods;
	}

	/**
	 * Adds the evaluable method.
	 * 
	 * @param method the method
	 */
	public void addEvaluableMethod(String method)
	{
		getEvaluableMethods().add(method);
	}

	/**
	 * Gets the test control.
	 * 
	 * @return the test control
	 */
	public String getTestControl()
	{
		return testControl;
	}

	/**
	 * Sets the test control.
	 * 
	 * @param testControl the new test control
	 */
	public void setTestControl(String testControl)
	{
		this.testControl = testControl;
	}

	/**
	 * Checks if is valid situation.
	 * 
	 * @param className the class name
	 * @param methodName the method name
	 * @return true, if is valid situation
	 * @throws ClassNotFoundException the class not found exception
	 */
	private boolean isValidSituation(String className, String methodName) throws ClassNotFoundException
	{
		return getEvaluableClass().isAssignableFrom(Class.forName(className)) &&
				getEvaluableMethods().contains(methodName);

	}

	/**
	 * Gets the situations enum.
	 * 
	 * @return the situations enum
	 */
	public SituationsEnum getSituationsEnum()
	{
		try
		{
			if (getEvaluableMethods().isEmpty() || (getEvaluableClass() == null))
			{
				return situationsEnum;
			}

			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			for (int i = 0; i < (stackTrace.length - 1); i++)
			{
				if (isValidSituation(stackTrace[i].getClassName(), stackTrace[i].getMethodName())
						|| isValidSituation(stackTrace[i + 1].getClassName(), stackTrace[i + 1].getMethodName()))
				{
					return situationsEnum;
				}
			}
		}
		catch (Exception e)
		{
			return SituationsEnum.EXCEPTION;
		}

		// Situation default
		return SituationsEnum.SUCCESS;
	}

	/**
	 * Sets the situations enum.
	 * 
	 * @param situationsEnum the new situations enum
	 */
	public void setSituationsEnum(SituationsEnum situationsEnum)
	{
		this.situationsEnum = situationsEnum;
	}

	/**
	 * Gets the area enum.
	 * 
	 * @return the area enum
	 */
	public LCAreaEnum getAreaEnum()
	{
		return areaEnum;
	}

	/**
	 * Sets the area enum.
	 * 
	 * @param areaEnum the new area enum
	 */
	public void setAreaEnum(LCAreaEnum areaEnum)
	{
		this.areaEnum = areaEnum;
	}

	/**
	 * Result response tag.
	 * 
	 * @return the internal results response
	 */
	protected InternalResultsResponse<Tag> getResultResponseTag()
	{
		InternalResultsResponse<Tag> response = new InternalResultsResponse<>();
		response.getResultsList().add(new Tag(1, "Tag 1"));
		response.getResultsList().add(new Tag(2, "Tag 2"));
		return response;
	}

	/**
	 * Gets the result response light.
	 * 
	 * @return the result response light
	 */
	protected InternalResultsResponse<Light> getResultResponseLight()
	{
		InternalResultsResponse<Light> response = new InternalResultsResponse<>();
		response.getResultsList().add(new Light(1));
		response.getResultsList().add(new Light(2));
		return response;
	}

	/**
	 * Gets the result response tag.
	 * 
	 * @return the result response tag
	 */
	protected InternalResultsResponse<Process> getResultResponseProcess()
	{
		InternalResultsResponse<Process> response = new InternalResultsResponse<>();
		ProcessItem item = new ProcessItem();
		item.setLight(new Light(1));
		Process process = new Process();
		process.setId(1);
		process.setProcessItems(new ArrayList<ProcessItem>());
		process.getProcessItems().add(item);
		process.setIsProcessComplete(true);
		response.getResultsList().add(process);

		process = new Process();
		process.setId(2);
		process.setProcessItems(new ArrayList<ProcessItem>());
		process.getProcessItems().add(item);
		process.setIsProcessComplete(true);
		response.getResultsList().add(process);

		return response;
	}

	/**
	 * Gets the result response notification.
	 * 
	 * @return the result response notification
	 */
	protected InternalResultsResponse<NotificationHistory> getResultResponseNotification()
	{
		InternalResultsResponse<NotificationHistory> response = new InternalResultsResponse<>();
		response.addResult(createNotificationHistory(createUserContext(), TestBaseUtil.createLight()));
		return response;
	}

	/**
	 * Gets the result response tenant.
	 * 
	 * @return the result response tenant
	 */
	protected InternalResultsResponse<Tenant> getResultResponseTenant()
	{
		InternalResultsResponse<Tenant> response = new InternalResultsResponse<>();
		response.getResultsList().add(new Tenant(1));

		return response;
	}

	/**
	 * Gets the response defaul.
	 * 
	 * @return the response defaul
	 */
	protected Response getResponseDefaul()
	{
		return new Response();
	}

	/**
	 * Gets the response error.
	 * 
	 * @return the response error
	 */
	protected Response getResponseWithError()
	{
		Response response = new Response();
		response.setOperationSuccess(false);
		response.addFieldErrorMessage(ERROR_CODE);
		return response;
	}

	/**
	 * Gets the internal response defaul.
	 * 
	 * @return the internal response defaul
	 */
	protected InternalResponse getInternalResponseDefault()
	{
		return new InternalResponse();
	}

	/**
	 * Gets the response results error.
	 * 
	 * @return the response results error
	 */
	@SuppressWarnings("rawtypes")
	protected InternalResultsResponse getResponseResultsError()
	{
		InternalResultsResponse response = new InternalResultsResponse<>();
		response.setStatus(Status.ExceptionError);
		response.addFieldErrorMessage(ERROR_CODE);
		return response;
	}

	/**
	 * Gets the response error.
	 * 
	 * @return the response error
	 */
	protected InternalResponse getResponseError()
	{
		InternalResponse response = new InternalResponse();
		response.setStatus(Status.ExceptionError);
		response.addFieldErrorMessage(ERROR_CODE);
		return response;
	}
}
