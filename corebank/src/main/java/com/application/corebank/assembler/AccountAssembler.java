package com.application.corebank.assembler;

import com.application.corebank.domain.Account;
import com.application.corebank.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountAssembler {

    public Account fromDtoToEntity(AccountDto accountDto) {
        Account account = new Account();

        account.setCustomerNo(accountDto.getCustomerNo());
        account.setAccNumber(accountDto.getAccountNumber());
        account.setAccCurrencyType(accountDto.getCurrencyType());
        account.setAccType(accountDto.getType());
        account.setStatus(accountDto.getStatus());

        return account;
    }

    public AccountDto fromEntityToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setCustomerNo(account.getCustomerNo());
        accountDto.setAccountNumber(account.getAccNumber());
        accountDto.setCurrencyType(account.getAccCurrencyType());
        accountDto.setType(account.getAccType());
        accountDto.setStatus(account.getStatus());

        return accountDto;
    }

    public List<AccountDto> fromEntityListToDtoList(List<Account> accounts) {
        return accounts.stream().map(this::fromEntityToDto).collect(Collectors.toList());
    }
}
