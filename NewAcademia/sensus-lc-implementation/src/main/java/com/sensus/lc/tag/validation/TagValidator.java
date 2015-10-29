package com.sensus.lc.tag.validation;

import static com.sensus.common.validation.ValidationUtil.isNull;
import static com.sensus.common.validation.ValidationUtil.isNullOrEmpty;

import java.util.List;

import com.sensus.common.model.MessageInfo;
import com.sensus.common.validation.IValidator;
import com.sensus.common.validation.ValidationContext;
import com.sensus.lc.base.model.MLCPersistanceActionEnum;
import com.sensus.lc.base.util.LCHelp;
import com.sensus.lc.tag.model.Tag;

/**
 * The Class TagValidator.
 */
public class TagValidator implements IValidator
{

	/** The Constant ONE_HUNDRED. */
	private static final int ONE_HUNDRED = 100;

	/** The description length. */
	private int descriptionLength = ONE_HUNDRED;

	/** The Constant TAG_NAME. */
	private static final String TAG_NAME = Tag.class.getSimpleName();

	/** The Constant SENSUS_MLC_VALIDATOR_NAME_REQUIRED. */
	private static final String SENSUS_MLC_VALIDATOR_NAME_REQUIRED = "sensus.mlc.validator.name.required";

	/** The Constant SENSUS_MLC_VALIDATOR_ID_REQUIRED. */
	private static final String SENSUS_MLC_VALIDATOR_ID_REQUIRED = "sensus.mlc.validator.id.required";

	/** The Constant SENSUS_MLC_VALIDATOR_REQUIRED. */
	private static final String SENSUS_MLC_VALIDATOR_REQUIRED = "sensus.mlc.validator.required";

	/** The Constant SENSUS_MLC_TAGVALIDATOR_AUTO_GROUP_REQUIRED. */
	private static final String SENSUS_MLC_TAGVALIDATOR_AUTO_GROUP_REQUIRED =
			"sensus.mlc.tagvalidator.autogroup.required";

	/** The Constant SENSUS_MLC_VALIDATOR_LENGTH_INVALID. */
	private static final String SENSUS_MLC_VALIDATOR_LENGTH_INVALID = "sensus.mlc.validator.name.length.invalid";

	/**
	 * Gets the description length.
	 * 
	 * @return the description length
	 */
	public int getDescriptionLength()
	{
		return descriptionLength;
	}

	/**
	 * Sets the description length.
	 * 
	 * @param descriptionLength the new description length
	 */
	public void setDescriptionLength(int descriptionLength)
	{
		this.descriptionLength = descriptionLength;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.validation.IValidator#validate(com.sensus.common.validation.ValidationContext)
	 */
	@Override
	public void validate(ValidationContext validationContext)
	{
		MLCPersistanceActionEnum action =
				(MLCPersistanceActionEnum)validationContext.getValidationArguments().get(
						MLCPersistanceActionEnum.getSlcActionName());

		List<MessageInfo> list = validationContext.getMessages();

		// Validate Procedure
		if (isNull(action) || !isNullOrEmpty(list))
		{
			return;
		}

		Tag tag = (Tag)validationContext.getObjectsToBeValidated().get(TAG_NAME);
		if (isNull(tag))
		{
			list.add(MessageInfo.createFieldValidationError(SENSUS_MLC_VALIDATOR_REQUIRED, TAG_NAME));
			return;
		}

		switch (action)
		{
			case INSERT:
				validateTagName(list, tag);
				return;

			case DELETE:
				validateTagId(list, tag);
				return;

			case UPDATE:
				validateTagId(list, tag);
				validateAutoGroup(list, tag);
				return;

			case FETCH_BY_NAME:
				validateTagName(list, tag);
				return;

			case DEL_LIGHT_FROM_TAG:
				validateTagId(list, tag);
				return;

			case ADD_LIGHT_TO_TAG:
				validateTagId(list, tag);
				return;

			default:
				break;
		}
	}

	/**
	 * Validate tag id.
	 * 
	 * @param list the list
	 * @param tag the tag
	 */
	private void validateTagId(List<MessageInfo> list, Tag tag)
	{
		LCHelp.isNullOrZeroLC(tag.getId(), SENSUS_MLC_VALIDATOR_ID_REQUIRED, list, TAG_NAME);
	}

	/**
	 * Validate tag name.
	 * 
	 * @param list the list
	 * @param tag the tag
	 */
	private void validateTagName(List<MessageInfo> list, Tag tag)
	{
		LCHelp.isNullOrEmptyLC(tag.getName(), SENSUS_MLC_VALIDATOR_NAME_REQUIRED, list, TAG_NAME);
		LCHelp.isValidLength(tag.getName(), descriptionLength, SENSUS_MLC_VALIDATOR_LENGTH_INVALID, list);
	}

	/**
	 * Validate auto group.
	 * 
	 * @param list the list
	 * @param tag the tag
	 */
	private void validateAutoGroup(List<MessageInfo> list, Tag tag)
	{
		isNull(tag.isAutoGroup(), SENSUS_MLC_TAGVALIDATOR_AUTO_GROUP_REQUIRED, list);
	}
}