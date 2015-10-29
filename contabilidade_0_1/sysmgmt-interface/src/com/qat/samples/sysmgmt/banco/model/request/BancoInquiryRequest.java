package com.qat.samples.sysmgmt.banco.model.request;

import com.qat.samples.sysmgmt.banco.model.criteria.BancoCriteria;
import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;

/**
 * The Class ProdutoInquiryRequest.
 */
public class BancoInquiryRequest extends PagedInquiryRequest
{

	/** The criteria. */
	private BancoCriteria criteria;

	/**
	 * Gets the criteria.
	 * 
	 * @return the criteria
	 */
	public BancoCriteria getCriteria()
	{
		if (criteria == null)
		{
			criteria = new BancoCriteria();
		}
		return criteria;
	}

	/**
	 * Sets the criteria.
	 * 
	 * @param criteria the criteria
	 */
	public void setCriteria(BancoCriteria criteria)
	{
		this.criteria = criteria;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BancoInquiryRequest [getCriteria()=" + getCriteria() + ", toString()=" + super.toString() + "]";
	}

}
