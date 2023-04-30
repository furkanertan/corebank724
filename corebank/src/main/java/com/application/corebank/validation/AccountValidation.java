package com.application.corebank.validation;

import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class AccountValidation {

    private static final String ACCOUNT_NUMBER_PATTERN = "[0-9]{9}";

    public void isValidAccount(String accountNumber) throws AccountException {
        if (isEmpty(accountNumber) || !accountNumber.matches(ACCOUNT_NUMBER_PATTERN)) {
            throw new AccountException("Invalid account number given!");
        }
    }

    public void isValidAccountDto(AccountDto accountDto) throws AccountException {
        isValidAccount(String.valueOf(accountDto.getAccountNumber()));
    }
}
