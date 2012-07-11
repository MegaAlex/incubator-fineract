package org.mifosng.platform.organisation.service;

import java.util.ArrayList;
import java.util.List;

import org.mifosng.platform.DataValidatorBuilder;
import org.mifosng.platform.api.commands.BranchMoneyTransferCommand;
import org.mifosng.platform.api.data.ApiParameterError;
import org.mifosng.platform.exceptions.PlatformApiDataValidationException;

public class BranchMoneyTransferCommandValidator {

	private final BranchMoneyTransferCommand command;

	public BranchMoneyTransferCommandValidator(final BranchMoneyTransferCommand command) {
		this.command = command;
	}
	
	public void validate() {
		
		List<ApiParameterError> dataValidationErrors = new ArrayList<ApiParameterError>();
		
		DataValidatorBuilder baseDataValidator = new DataValidatorBuilder(dataValidationErrors).resource("office.money.transfer");
		
		baseDataValidator.reset().parameter("fromOfficeId").value(command.getFromOfficeId()).notNull();
		baseDataValidator.reset().parameter("toOfficeId").value(command.getToOfficeId()).notNull();
		baseDataValidator.reset().parameter("transactionDate").value(command.getTransactionLocalDate()).notNull();
		baseDataValidator.reset().parameter("currencyCode").value(command.getCurrencyCode()).notBlank();
		baseDataValidator.reset().parameter("transactionAmount").value(command.getTransactionAmountValue()).notNull();
		
		if (!dataValidationErrors.isEmpty()) {
			throw new PlatformApiDataValidationException("validation.msg.validation.errors.exist", "Validation errors exist.", dataValidationErrors);
		}
	}
}