package com.qat.samples.sysmgmt.util.dac.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.LoggerFactory;

import com.qat.framework.model.QATModel;
import com.qat.framework.model.response.InternalResultsResponse;
import com.qat.framework.util.QATMyBatisDacHelper;
import com.qat.framework.validation.ValidationUtil;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.util.Cidade;
import com.qat.samples.sysmgmt.util.dac.ICidadeDAC;
import com.qat.samples.sysmgmt.util.model.request.CidadeInquiryRequest;

/**
 * The Class CommonBusinessObjectsDACImpl.
 */
public class CidadeDACImpl extends SqlSessionDaoSupport implements ICidadeDAC
{
	/** The Constant CONTACT_NAMESPACE. */
	private static final String CONTACT_NAMESPACE = "CidadeMap.";

	/** The Constant CONTACT_STMT_UPDATE. */
	private static final String CONTACT_STMT_UPDATE = CONTACT_NAMESPACE + "updateCidade";

	/** The Constant CONTACT_STMT_DELETE_PERSON_CONTACT. */
	private static final String CONTACT_STMT_DELETE_PERSON_CONTACT = CONTACT_NAMESPACE + "deleteCidadeById";

	/** The Constant CONTACT_STMT_INSERT. */
	private static final String CONTACT_STMT_INSERT = CONTACT_NAMESPACE + "insertCidade";

	/** The Constant LOG. */
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CidadeDACImpl.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.cbof.dac.ICommonBusinessObjectsDAC#insertCidade(com.prosperitasglobal.cbof.model.Cidade,
	 * java.lang.String, com.qat.framework.model.response.InternalResultsResponse)
	 */
	@Override
	public Integer insertCidade(Cidade cidade, String statementName, InternalResultsResponse<?> response)
	{
		Integer insertCount = 0;
		// First insert the root cidade data
		insertCount = QATMyBatisDacHelper.doInsert(getSqlSession(), CONTACT_STMT_INSERT, cidade, response);

		return insertCount;
	}

	/*
	 * (non-Javadoc)
	 * @see com.prosperitasglobal.cbof.dac.ICidadeDAC#deleteBusinessCidade(com.prosperitasglobal.cbof.model.Cidade,
	 * com.qat.framework.model.response.InternalResultsResponse)
	 */
	@Override
	public Integer deleteBusinessCidade(Cidade cidade, InternalResultsResponse<?> response)
	{
		return QATMyBatisDacHelper.doRemove(getSqlSession(), CONTACT_STMT_DELETE_PERSON_CONTACT, cidade, response);
	}

	/*
	 * (non-Javadoc)
	 * @see com.prosperitasglobal.cbof.dac.ICidadeDAC#deletePersonCidade(com.prosperitasglobal.cbof.model.Cidade,
	 * com.qat.framework.model.response.InternalResultsResponse)
	 */
	@Override
	public Integer deleteCidade(Cidade cidade, InternalResultsResponse<?> response)
	{
		return QATMyBatisDacHelper.doRemove(getSqlSession(), CONTACT_STMT_DELETE_PERSON_CONTACT, cidade, response);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.prosperitasglobal.cbof.dac.ICommonBusinessObjectsDAC#updateCidade(com.prosperitasglobal.cbof.model.Cidade,
	 * com.qat.framework.model.response.InternalResultsResponse)
	 */
	@Override
	public Integer updateCidade(Cidade cidade, InternalResultsResponse<?> response)
	{
		Integer updateCount = 0;

		// First update the root if necessary.
		if (!ValidationUtil.isNull(cidade.getModelAction())
				&& (cidade.getModelAction() == QATModel.PersistanceActionEnum.UPDATE))
		{
			updateCount = QATMyBatisDacHelper.doUpdate(getSqlSession(), CONTACT_STMT_UPDATE, cidade, response);
		}

		return updateCount;
	}

	/*
	 * (non-Javadoc)
	 * @see com.prosperitasglobal.cbof.dac.ICidadeDAC#maintainCidadeAssociations(java.util.List, java.lang.Integer,
	 * java.lang.String, com.qat.framework.model.response.InternalResultsResponse)
	 */
	@Override
	public Integer maintainCidadeAssociations(List<Cidade> cidadeList, Integer parentId, String associateStatement,
			InternalResultsResponse<?> response)
	{
		Integer count = 0;
		// First Maintain Cidades
		if (ValidationUtil.isNullOrEmpty(cidadeList))
		{
			return count;
		}
		// For Each Cidade...
		for (Cidade cidade : cidadeList)
		{
			// Make sure we set the parent key
			cidade.setParentId(parentId);

			if (ValidationUtil.isNull(cidade.getModelAction()))
			{
				continue;
			}
			switch (cidade.getModelAction())
			{
				case INSERT:
					count += insertCidade(cidade, associateStatement, response);
					break;
				case UPDATE:
					count += updateCidade(cidade, response);
					break;
				case DELETE:
					count += deleteCidade(cidade, response);
					break;
				default:
					if (LOG.isDebugEnabled())
					{
						LOG.debug("ModelAction for Organization missing!");
					}
					break;
			}
		}
		return count;
	}

	@Override
	public InternalResultsResponse<Cidade> fetchCidadeById(FetchByIdRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalResultsResponse<Cidade> fetchCidadeByRequest(CidadeInquiryRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
