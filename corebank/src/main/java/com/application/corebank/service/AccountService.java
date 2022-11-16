package com.application.corebank.service;

import com.application.corebank.domain.Account;
import com.application.corebank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
