package com.qat.samples.sysmgmt.validation;

import com.qat.framework.validation.IValidator;
import com.qat.framework.validation.ValidationContext;

/**
 * The Class BundleDValidator.
 */
public class CadastroValidator implements IValidator
{

	private static final String SYSMGMT_BASE_BUNDLEVALIDATOR_PROCDESC_REQUIRED =
			"sysmgmt.base.bundlevalidator.bundledesc.required";
	private static final String SYSMGMT_BASE_BUNDLEVALIDATOR_PROCCODE_REQUIRED =
			"sysmgmt.base.bundlevalidator.bundlecode.required";
	private static final String SYSMGMT_BASE_BUNDLEVALIDATOR_ID_REQUIRED =
			"sysmgmt.base.bundlevalidator.id.required";

	@Override
	public void validate(ValidationContext validationContext)
	{
		// Cadastro bundle = (Cadastro)validationContext.getObjectToBeValidated(Produto.class.getSimpleName());
		//
		// switch (validationContext.getValidationContextIndicator())
		// {
		// case DELETE:
		// validateProcId(validationContext.getMessages(), bundle);
		// break;
		// case UPDATE:
		// validateProcId(validationContext.getMessages(), bundle);
		// validateProcCode(validationContext.getMessages(), bundle);
		// validateProcDesc(validationContext.getMessages(), bundle);
		// break;
		// default:
		// validateProcCode(validationContext.getMessages(), bundle);
		// validateProcDesc(validationContext.getMessages(), bundle);
		// break;
		// }
	}

	// private void validateProcId(List<MessageInfo> list, Cadastro bundle)
	// {
	// ValidationUtil.isNullOrZero(bundle.getId(), SYSMGMT_BASE_BUNDLEVALIDATOR_ID_REQUIRED, list);
	// }
	//
	// private void validateProcCode(List<MessageInfo> list, Cadastro bundle)
	// {
	// ValidationUtil.isNullOrEmpty(bundle.getNome(), SYSMGMT_BASE_BUNDLEVALIDATOR_PROCCODE_REQUIRED, list);
	// }
	//
	// private void validateProcDesc(List<MessageInfo> list, Cadastro bundle)
	// {
	// ValidationUtil.isNullOrEmpty(bundle.getDescricao(), SYSMGMT_BASE_BUNDLEVALIDATOR_PROCDESC_REQUIRED,
	// list);
	// }
}