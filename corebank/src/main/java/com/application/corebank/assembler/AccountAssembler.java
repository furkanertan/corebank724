package com.application.corebank.assembler;

import com.application.corebank.domain.Account;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.util.AccountStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountAssembler {

    public Account toCreateAccount(AccountDto accountDto) {
        Account account = new Account();

        account.setUserId(accountDto.getUserId());
        account.setAccNumber(accountDto.getAccountNumber());
        account.setAccCurrencyType(accountDto.getCurrencyType());
        account.setAccName(accountDto.getAccountName());
        account.setAccType(accountDto.getAccountType());
        account.setBalance(accountDto.getBalance());
        account.setStatus(accountDto.getStatus());
        account.setCreatedAt(accountDto.getCreatedAt());

        return account;
    }

    public Account toUpdateAccountBalance(Account account, Double balance) {
        account.setBalance(balance);
        account.setUpdatedAt(LocalDateTime.now());

        return account;
    }

    public AccountDto fromEntityToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setUserId(account.getUserId());
        accountDto.setAccountNumber(account.getAccNumber());
        accountDto.setCurrencyType(account.getAccCurrencyType());
        accountDto.setAccountName(account.getAccName());
        accountDto.setAccountType(account.getAccType());
        accountDto.setBalance(account.getBalance());
        accountDto.setStatus(account.getStatus());
        accountDto.setUpdatedAt(account.getUpdatedAt());
        accountDto.setCreatedAt(account.getCreatedAt());

        return accountDto;
    }

    public AccountDto toAccountDto(String accountName, String accountType, String accountCurrencyType, Integer accountNumber, Long userId) {
        AccountDto accountDto = new AccountDto();

        accountDto.setUserId(userId);
        accountDto.setAccountNumber(accountNumber);
        accountDto.setCurrencyType(accountCurrencyType);
        accountDto.setAccountName(accountName);
        accountDto.setAccountType(accountType);
        accountDto.setBalance(0.0);
        accountDto.setStatus(AccountStatus.ACTIVE.getCode());
        accountDto.setCreatedAt(LocalDateTime.now());

        return accountDto;
    }

    public List<AccountDto> fromEntityListToDtoList(List<Account> accounts) {
        return accounts.stream().map(this::fromEntityToDto).collect(Collectors.toList());
    }
}
