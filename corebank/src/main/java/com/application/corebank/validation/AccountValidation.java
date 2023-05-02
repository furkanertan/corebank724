package com.application.corebank.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
@Slf4j
public class AccountValidation {

    public boolean isValidAccount(String accountNumber) {
        //Invalid account number given
        log.info("accountNumber: {}", accountNumber);
        return !isEmpty(accountNumber);
    }

    public boolean isValidAccountName(String accountName) {
        //Invalid account name given
        log.info("accountName: {}", accountName);
        return !isEmpty(accountName);
    }

    public boolean isValidAccountType(String accountType) {
        //Invalid account type given
        log.info("accountType: {}", accountType);
        return !isEmpty(accountType);
    }

    public boolean isValidAccountCurrencyType(String accountCurrencyType) {
        //Invalid currency type given
        log.info("accountCurrencyType: {}", accountCurrencyType);
        return !isEmpty(accountCurrencyType);
    }

    public boolean isValidUser(Long userId) {
        //Invalid user given
        log.info("userId: {}", userId);
        return userId != null;
    }
}
