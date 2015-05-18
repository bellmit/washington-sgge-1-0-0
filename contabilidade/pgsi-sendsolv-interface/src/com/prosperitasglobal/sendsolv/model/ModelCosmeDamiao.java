package com.prosperitasglobal.sendsolv.model;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class ModelCosmeDamiao extends QATModel
{
	/** The SendSolv id for the account. */
	private Integer parentKey;

	private TypeEnum type;

	private AcaoEnum acaoType;

	private TabelaEnum tabelaEnum;

	/**
	 * @return the parentKey
	 */
	public Integer getParentKey()
	{
		return parentKey;
	}

	/**
	 * @param parentKey the parentKey to set
	 */
	public void setParentKey(Integer parentKey)
	{
		this.parentKey = parentKey;
	}

	public TypeEnum getType()
	{
		return type;
	}

	public void setType(TypeEnum type)
	{
		this.type = type;
	}

	public AcaoEnum getAcaoType()
	{
		return acaoType;
	}

	public void setAcaoType(AcaoEnum acaoType)
	{
		this.acaoType = acaoType;
	}

	public TabelaEnum getTabelaEnum()
	{
		return tabelaEnum;
	}

	public void setTabelaEnum(TabelaEnum tabelaEnum)
	{
		this.tabelaEnum = tabelaEnum;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ModelCosmeDamiao [getParentKey()=" + getParentKey() + ", getModelAction()=" + getModelAction()
				+ ", getCreateUser()=" + getCreateUser() + ", getCreateDateUTC()=" + getCreateDateUTC()
				+ ", getModifyUser()=" + getModifyUser() + ", getModifyDateUTC()=" + getModifyDateUTC()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
