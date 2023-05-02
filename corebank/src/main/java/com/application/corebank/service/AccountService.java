package com.application.corebank.service;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.domain.Account;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.application.corebank.util.AccountStatus.ACTIVE;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@Slf4j
@AllArgsConstructor
public class AccountService {

    private AccountRepository repository;
    private AccountAssembler assembler;

    public List<AccountDto> getAllAccounts() throws AccountException {
        List<Account> accounts = repository.findAll();

        if (isEmpty(accounts)) {
            throw new AccountException("No accounts found");
        }

        return assembler.fromEntityListToDtoList(accounts);
    }

    public List<AccountDto> getAllActiveAccountsByCustomerNo(Long userId) {
        List<Account> accounts = repository.findAllByUserIdAndStatus(userId, ACTIVE.getCode());

        if (isEmpty(accounts)) {
            System.out.println("No active accounts found for customer no: " + userId);
        }

        return assembler.fromEntityListToDtoList(accounts);
    }

    public AccountDto getAccountByAccountNumber(Integer accountNumber) {
        Account account = repository.findAccountByAccNumber(accountNumber);

        if (isNull(account)) {
            System.out.println("Account does not exist!");
        }

        return assembler.fromEntityToDto(account);
    }

    public void createAccount(AccountDto accountDto) {
        Account account = assembler.toCreateAccount(accountDto);
        repository.save(account);
        log.info("Account created successfully!");
    }

    public void updateAccountBalance(Integer accountNumber, Double balance, Boolean isSender) {
        Account account = repository.findAccountByAccNumber(accountNumber);

        if (isSender) {
            balance = account.getBalance() - balance;
        } else {
            balance = account.getBalance() + balance;
        }

        Account updatedAccount = assembler.toUpdateAccountBalance(account, balance);
        repository.save(updatedAccount);

        log.info("Account updated successfully!");
    }

    public String deleteAccount(Integer accNumber) {
        Account account = repository.findAccountByAccNumber(accNumber);
        if (isNull(account)) {
            return "Account does not exist!";
        } else {
            repository.delete(account);

            return "Account deleted!";
        }
    }

    public Integer getNumberOfUserAccounts(Long userId) {
        Integer accountNumber = repository.countByUserId(userId);

        return accountNumber != null ? accountNumber : 0;
    }
}
