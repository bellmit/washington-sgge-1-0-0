package com.qat.samples.sysmgmt.util.model.response;

import java.util.Collection;
import java.util.List;

import com.qat.framework.model.response.InquiryResponse;
import com.qat.samples.sysmgmt.entidade.model.Usuario;

public class UsuarioResponse extends InquiryResponse
{

	/** Attributes */
	private List<Usuario> usuarioList;

	/**
	 * The Constructor.
	 */
	public UsuarioResponse()
	{

	}

	/**
	 * @return the usuarioList
	 */
	public List<Usuario> getUsuarioList()
	{
		return usuarioList;
	}

	/**
	 * @param usuarioList the usuarioList to set
	 */
	public void setUsuarioList(List<Usuario> usuarioList)
	{
		this.usuarioList = usuarioList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.qat.framework.model.response.InquiryResponse#addResults(java.util.Collection)
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void addResults(Collection coll)
	{
		setUsuarioList((List<Usuario>)coll);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UsuarioResponse [getUsuarioList()=" + getUsuarioList() + ", getResultsSetInfo()="
				+ getResultsSetInfo() + ", getMessageIterator()=" + getMessageIterator() + ", getMessageList()="
				+ getMessageList() + ", getMessageInfoList()=" + getMessageInfoList() + ", isOperationSuccess()="
				+ isOperationSuccess() + "]";
	}

}