package com.prosperitasglobal.sendsolv.settings.model;

import com.qat.framework.model.IIntegerEnum;

/**
 * The Enum LanguagesEnum.
 */
public enum LanguagesEnum implements IIntegerEnum
{

	/** The ENGLISH. */
	ENGLISH(1),

	/** The PORTUGUESE. */
	PORTUGUESE(2),

	/** The SPANISH. */
	SPANISH(3),

	/** The GERMAN. */
	GERMAN(4);

	/** The LanguagesEnum. */
	private Integer value;

	/**
	 * Instantiates a new Languages Enum .
	 *
	 * @param languagesEnumValue the languages enum value
	 */
	private LanguagesEnum(Integer languagesEnumValue)
	{
		value = languagesEnumValue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.model.IIntegerEnum#getValue()
	 */
	@Override
	public Integer getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the Languages enum
	 */
	public static LanguagesEnum enumForValue(Integer value)
	{
		for (LanguagesEnum e : values())
		{
			if (e.getValue().equals(value))
			{
				return e;
			}
		}

		return null;
	}

	/**
	 * Gets the valid values.
	 *
	 * @return the valid values
	 */
	public static String getValidValues()
	{
		LanguagesEnum[] enums = LanguagesEnum.class.getEnumConstants();

		String comma = "";
		StringBuilder enumValue = new StringBuilder();
		for (LanguagesEnum i : enums)
		{
			enumValue.append(comma + i.getValue());
			comma = ", ";
		}
		return enumValue.toString();
	}

}