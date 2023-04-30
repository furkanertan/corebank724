package com.application.corebank.controller;

import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.service.AccountService;
import com.application.corebank.validation.AccountValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountValidation accountValidation;

    @GetMapping("/getAllAccounts")
    List<AccountDto> getAllAccounts() throws AccountException {
        log.info("Getting all accounts");

        return accountService.getAllAccounts();
    }

    @GetMapping("/getAllActiveAccountsByCustomerNo")
    List<AccountDto> getAllActiveAccountsByCustomerNo(@RequestParam Long userId) throws AccountException {
        log.info("Getting all active accounts by logged user: {}", userId);

        //accountValidation.isValidCustomerNo(userId);

        return accountService.getAllActiveAccountsByCustomerNo(userId);
    }

    @PostMapping("/createAccount")
    String createAccount(@RequestBody AccountDto accountDto) throws AccountException {
        log.info("Creating a new account");

        accountValidation.isValidAccountDto(accountDto);

        return accountService.createAccount(accountDto);
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
