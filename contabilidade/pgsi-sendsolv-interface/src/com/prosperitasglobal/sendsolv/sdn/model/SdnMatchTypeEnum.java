package com.prosperitasglobal.sendsolv.sdn.model;

import com.qat.framework.model.II18nEnum;
import com.qat.framework.model.IIntegerEnum;

public enum SdnMatchTypeEnum implements IIntegerEnum, II18nEnum
{
	INDIVIDUAL(1, "F"),

	ENTITY(2, "L");

	/** The code. */
	private Integer code;

	/** The label key. */
	private String labelKey;

	/**
	 * The Constructor.
	 *
	 * @param value The value of the payer type enumeration.
	 * @param labelKeyParam The label key parameter.
	 */
	private SdnMatchTypeEnum(Integer value, String labelKeyParam)
	{
		code = value;
		labelKey = labelKeyParam;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public Integer getValue()
	{
		return code;
	}

	/**
	 * Enumeration for value.
	 *
	 * @param value The value of the country usage enumeration.
	 * @return The country usage enumeration.
	 */
	public static SdnMatchTypeEnum enumForValue(Integer value)
	{
		for (SdnMatchTypeEnum e : values())
		{
			if (e.getValue().equals(value))
			{
				return e;
			}
		}

		return null;
	}

	/**
	 * Gets the valid values for the country usage's.
	 *
	 * @return The valid values.
	 */
	public static String getValidValues()
	{
		String comma = "";
		StringBuilder enumValue = new StringBuilder();

		for (SdnMatchTypeEnum i : SdnMatchTypeEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.model.II18nEnum#getLabelKey()
	 */
	@Override
	public String getLabelKey()
	{
		return labelKey;
	}
}