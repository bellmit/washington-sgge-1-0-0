package com.prosperitasglobal.sendsolv.dac;

import com.prosperitasglobal.cbof.model.request.FetchByIdRequest;
import com.prosperitasglobal.sendsolv.model.Email;
import com.prosperitasglobal.sendsolv.model.request.PagedInquiryRequest;
import com.qat.framework.model.response.InternalResponse;
import com.qat.framework.model.response.InternalResultsResponse;

/**
 * The Interface IEmailDAC.
 */
public interface IEmailDAC
{

	/**
	 * Update cnae.
	 *
	 * @param cnae the cnae
	 * @return the internal results response< cnae>
	 */
	public InternalResultsResponse<Email> updateEmail(Email cnae);

	/**
	 * Insert cnae.
	 *
	 * @param cnae the cnae
	 * @return the internal results response< cnae>
	 */
	public InternalResultsResponse<Email> insertEmail(Email cnae);

	/**
	 * Delete cnae.
	 *
	 * @param cnae the cnae
	 * @return the internal response
	 */
	public InternalResponse deleteEmail(Email cnae);

	/**
	 * Fetch cnae by id.
	 *
	 * @param request the request
	 * @return the internal results response
	 */
	public InternalResultsResponse<Email> fetchEmailById(FetchByIdRequest request);

	/**
	 * Fetch all cnaes.
	 *
	 * @return the internal results response< cnae>
	 */
	public InternalResultsResponse<Email> fetchAllEmails();

	/**
	 * Fetch cnae by request.
	 *
	 * @param request the request
	 * @return the internal results response< cnae>
	 */
	public InternalResultsResponse<Email> fetchEmailByRequest(PagedInquiryRequest request);

}
