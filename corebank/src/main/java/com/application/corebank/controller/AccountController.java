package com.application.corebank.controller;

import com.application.corebank.domain.Account;
import com.application.corebank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getAllAccounts")
    List<Account> getAllAccounts() {
        log.info("Getting all accounts");

        return accountService.getAllAccounts();
    }
}
