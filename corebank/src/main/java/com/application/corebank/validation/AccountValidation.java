package com.application.corebank.validation;

import com.application.corebank.exception.AccountException;
import org.springframework.stereotype.Component;

@Component
public class AccountValidation {

    private static final String ACCOUNT_NUMBER_PATTERN = "[0-9]{9}";
    private static final String CUSTOMER_NUMBER_PATTERN = "[0-9]{9}";

    public void isValidAccount(String accountNumber) throws AccountException {
        if(!accountNumber.matches(ACCOUNT_NUMBER_PATTERN)) {
            throw new AccountException("Invalid account number given!");
        }
    }

    public void isValidCustomerNo(String customerNumber) throws AccountException {
        if(!customerNumber.matches(CUSTOMER_NUMBER_PATTERN)) {
            throw new AccountException("Invalid customer number given!");
        }
    }
}
