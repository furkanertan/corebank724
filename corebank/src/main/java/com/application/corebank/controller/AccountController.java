package com.application.corebank.controller;

import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.service.AccountService;
import com.application.corebank.validation.AccountValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountValidation accountValidation;

    public AccountController(AccountService accountService, AccountValidation accountValidation) {
        this.accountService = accountService;
        this.accountValidation = accountValidation;
    }

    @GetMapping("/getAllAccounts")
    List<AccountDto> getAllAccounts() throws AccountException {
        log.info("Getting all accounts");

        return accountService.getAllAccounts();
    }

    @GetMapping("/getAllActiveAccountsByCustomerNo")
    List<AccountDto> getAllActiveAccountsByCustomerNo(@RequestParam String customerNo) throws AccountException {
        log.info("Getting all active accounts by customer no: {}", customerNo);

        accountValidation.isValidCustomerNo(customerNo);

        return accountService.getAllActiveAccountsByCustomerNo(Integer.valueOf(customerNo));
    }

    @PostMapping("/createAccount")
    String createAccount(@RequestBody AccountDto accountDto) {
        log.info("Creating a new account");

        return "Account created";

        // accountValidation.isValidAccount(accountNumber);

        //return accountService.createAccount(accountDto);
    }

    @PutMapping("/activateAccount")
    String activateAccount(@RequestParam String accountNumber) throws AccountException {
        log.info("Activating account");

        accountValidation.isValidAccount(accountNumber);

        return accountService.activateAccount(Integer.valueOf(accountNumber));
    }

    @PutMapping("/deactivateAccount")
    String deactivateAccount(@RequestParam String accountNumber) throws AccountException {
        log.info("Deactivating account");

        accountValidation.isValidAccount(accountNumber);

        return accountService.deactivateAccount(Integer.valueOf(accountNumber));
    }
}
