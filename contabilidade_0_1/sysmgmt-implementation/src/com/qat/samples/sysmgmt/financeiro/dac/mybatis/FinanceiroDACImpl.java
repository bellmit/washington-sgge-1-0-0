package com.qat.samples.sysmgmt.financeiro.dac.mybatis;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.LoggerFactory;

import com.qat.framework.model.QATModel;
import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.util.QATMyBatisDacHelper;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.dacd.mybatis.PagedResultsDACD;
import com.qat.samples.sysmgmt.financeiro.dac.IFinanceiroDAC;
import com.qat.samples.sysmgmt.financeiro.model.Financeiro;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;

/**
 * The Class FinanceiroDACImpl.
 */
public class FinanceiroDACImpl extends SqlSessionDaoSupport implements IFinanceiroDAC
{

	/** The Constant EMPRESA_NAMESPACE. */
	private static final String EMPRESA_NAMESPACE = "FinanceiroMap.";

	/** The Constant CBOF_NAMESPACE. */
	private static final String CBOF_NAMESPACE = "CBOFMap.";

	/** The Constant EMPRESA_STMT_FETCH_COUNT. */
	private static final String EMPRESA_STMT_FETCH_COUNT = EMPRESA_NAMESPACE + "fetchFinanceiroRowCount";

	/** The Constant EMPRESA_STMT_FETCH_ALL_BY_REQUEST. */
	private static final String EMPRESA_STMT_FETCH_ALL_BY_REQUEST = EMPRESA_NAMESPACE
			+ "fetchAllFinanceirosByRequest";

	/** The Constant EMPRESA_STMT_FETCH_BY_ID. */
	private static final String EMPRESA_STMT_FETCH_BY_ID = EMPRESA_NAMESPACE + "fetchFinanceiroById";

	/** The Constant EMPRESA_STMT_INSERT. */
	private static final String EMPRESA_STMT_INSERT = EMPRESA_NAMESPACE + "insertFinanceiro";

	/** The Constant EMPRESA_STMT_ASSOC_ORG_TO_CONTACT. */
	private static final String EMPRESA_STMT_ASSOC_ORG_TO_CONTACT = EMPRESA_NAMESPACE
			+ "associateFinanceiroWithContact";

	/** The Constant EMPRESA_STMT_UPDATE. */
	private static final String EMPRESA_STMT_UPDATE = EMPRESA_NAMESPACE + "updateFinanceiro";

	/** The Constant EMPRESA_STMT_DELETE. */
	private static final String EMPRESA_STMT_DELETE = EMPRESA_NAMESPACE + "deleteFinanceiroById";

	/** The Constant EMPRESA_DOCUMENT_STMT_UPDATE. */
	private static final String EMPRESA_DOCUMENT_STMT_UPDATE = EMPRESA_NAMESPACE
			+ "updateFinanceiroDocument";

	/** The Constant EMPRESA_STMT_ASSOC_ORG_TO_DOCUMENT. */
	private static final String EMPRESA_STMT_ASSOC_ORG_TO_DOCUMENT = EMPRESA_NAMESPACE
			+ "associateFinanceiroWithDocument";

	/** The Constant EMPRESA_STMT_DELETE_DOCUMENT. */
	private static final String EMPRESA_STMT_DELETE_DOCUMENT = EMPRESA_NAMESPACE
			+ "deleteFinanceiroDocument";

	/** The Constant STMT_VERSION. */
	private static final String EMPRESA_STMT_VERSION = EMPRESA_NAMESPACE + "fetchVersionNumber";

	/** The Constant EMPRESA_STMT_UPDATE_EMPRESA_STATUS. */
	private static final String EMPRESA_STMT_UPDATE_EMPRESA_STATUS = CBOF_NAMESPACE
			+ "updateBusinessStatus";

	/** The Constant LOG. */
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(FinanceiroDACImpl.class);

	/** The valid sort fields for an cnae inquiry. Will be injected by Spring. */
	private Map<String, String> cnaeInquiryValidSortFields;

	/**
	 * Get the valid sort fields for the cnae inquiry. Attribute injected by Spring.
	 * 
	 * @return The valid sort fields for the cnae inquiry.
	 */
	public Map<String, String> getFinanceiroInquiryValidSortFields()
	{
		return cnaeInquiryValidSortFields;
	}

	/**
	 * Set the valid sort fields for the cnae inquiry. Attribute injected by Spring.
	 * 
	 * @param cnaeInquiryValidSortFields The valid sort fields for the cnae inquiry to set.
	 */
	public void setFinanceiroInquiryValidSortFields(Map<String, String> cnaeInquiryValidSortFields)
	{
		this.cnaeInquiryValidSortFields = cnaeInquiryValidSortFields;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.sendsolv.dac.IFinanceiroDAC#insertFinanceiro(com.prosperitasglobal.sendsolv.model
	 * .Financeiro)
	 */
	@Override
	public InternalResultsResponse<Financeiro> insertFinanceiro(Financeiro cnae)
	{
		Integer insertCount = 0;
		InternalResultsResponse<Financeiro> response = new InternalResultsResponse<Financeiro>();

		// First insert the root
		// Is successful the unique-id will be populated back into the object.
		insertCount = QATMyBatisDacHelper.doInsert(getSqlSession(), EMPRESA_STMT_INSERT, cnae, response);

		if (response.isInError())
		{
			return response;
		}
		// Next traverse the object graph and "maintain" the associations
		insertCount += maintainFinanceiroAssociations(cnae, response);

		// Finally, if something was inserted then add the Financeiro to the result.
		if (insertCount > 0)
		{
			response.addResult(cnae);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.sendsolv.dac.IFinanceiroDAC#updateFinanceiro(com.prosperitasglobal.sendsolv.model
	 * .Financeiro)
	 */
	@Override
	public InternalResultsResponse<Financeiro> updateFinanceiro(Financeiro cnae)
	{
		Integer updateCount = 0;
		InternalResultsResponse<Financeiro> response = new InternalResultsResponse<Financeiro>();

		// First update the root if necessary.
		if (!ValidationUtil.isNull(cnae.getModelAction())
				&& (cnae.getModelAction() == QATModel.PersistanceActionEnum.UPDATE))
		{
			updateCount =
					QATMyBatisDacHelper.doUpdate(getSqlSession(), EMPRESA_STMT_UPDATE, cnae,
							response);
		}

		if (response.isInError())
		{
			return response;
		}
		// Next traverse the object graph and "maintain" the associations
		updateCount += maintainFinanceiroAssociations(cnae, response);

		// Finally, if something was updated then add the Person to the result.
		if (updateCount > 0)
		{
			response.addResult(cnae);
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.sendsolv.dac.IFinanceiroDAC#deleteFinanceiro(com.prosperitasglobal.sendsolv.model
	 * .Financeiro)
	 */
	@Override
	public InternalResponse deleteFinanceiro(Financeiro cnae)
	{
		InternalResponse response = new InternalResponse();
		QATMyBatisDacHelper.doRemove(getSqlSession(), EMPRESA_STMT_DELETE, cnae, response);

		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see com.prosperitasglobal.sendsolv.dac.IFinanceiroDAC#fetchFinanceiroById(FetchByIdRequest)
	 */
	@Override
	public InternalResultsResponse<Financeiro> fetchFinanceiroById(FetchByIdRequest request)
	{
		InternalResultsResponse<Financeiro> response = new InternalResultsResponse<Financeiro>();
		QATMyBatisDacHelper.doQueryForList(getSqlSession(), EMPRESA_STMT_FETCH_BY_ID, request, response);
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.sendsolv.dac.IFinanceiroDAC#fetchFinanceiroByRequest(com.prosperitasglobal.sendsolv
	 * .model.request.PagedInquiryRequest)
	 */
	@Override
	public InternalResultsResponse<Financeiro> fetchFinanceiroByRequest(PagedInquiryRequest request)
	{
		InternalResultsResponse<Financeiro> response = new InternalResultsResponse<Financeiro>();

		/*
		 * Helper method to translation from the user friendly" sort field names to the
		 * actual database column names.
		 */
		// QATMyBatisDacHelper.translateSortFields(request, getFinanceiroInquiryValidSortFields());

		PagedResultsDACD.fetchObjectsByRequest(getSqlSession(), request, EMPRESA_STMT_FETCH_COUNT,
				EMPRESA_STMT_FETCH_ALL_BY_REQUEST, response);
		return response;
	}

	/**
	 * Maintain cnae associations.
	 * 
	 * @param cnae the cnae
	 * @param response the response
	 * @return the integer
	 */
	private Integer maintainFinanceiroAssociations(Financeiro cnae,
			InternalResultsResponse<Financeiro> response)
	{
		Integer count = 0;
		// First Maintain Contacts
		// if (ValidationUtil.isNullOrEmpty(cnae.getContactList()))
		// {
		// return count;
		// }
		// // For Each Contact...
		// for (Contact contact : cnae.getContactList())
		// {
		// // Make sure we set the parent key
		// contact.setParentKey(cnae.getId());
		//
		// if (ValidationUtil.isNull(contact.getModelAction()))
		// {
		// continue;
		// }
		// switch (contact.getModelAction())
		// {
		// case INSERT:
		// count = getContactDAC().insertContact(contact,
		// EMPRESA_STMT_ASSOC_ORG_TO_CONTACT, response);
		// break;
		// case UPDATE:
		// count = getContactDAC().updateContact(contact, response);
		// break;
		// case DELETE:
		// count = getContactDAC().deleteBusinessContact(contact, response);
		// break;
		// default:
		// if (LOG.isDebugEnabled())
		// {
		// LOG.debug("ModelAction for Financeiro missing!");
		// }
		// break;
		// }
		// }
		return count;
	}

	@Override
	public InternalResultsResponse<Financeiro> fetchAllFinanceiros()
	{
		// TODO Auto-generated method stub
		return null;
	}
}