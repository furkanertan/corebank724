package com.application.corebank.service;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.domain.Account;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.exception.AccountException;
import com.application.corebank.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.application.corebank.util.AccountStatus.ACTIVE;
import static com.application.corebank.util.AccountStatus.PASSIVE;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountAssembler accountAssembler;

    public AccountService(AccountRepository accountRepository, AccountAssembler accountAssembler) {
        this.accountRepository = accountRepository;
        this.accountAssembler = accountAssembler;
    }

    public List<AccountDto> getAllAccounts() throws AccountException {
        List<Account> accounts = accountRepository.findAll();

        if(isEmpty(accounts)){
            throw new AccountException("No accounts found");
        }

        return accountAssembler.fromEntityListToDtoList(accounts);
    }

    public List<AccountDto> getAllActiveAccountsByCustomerNo(Long userId) throws AccountException {
        List<Account> accounts = accountRepository.findAllByUserIdAndStatus(userId, ACTIVE.getCode());

        if(isEmpty(accounts)){
            throw new AccountException("No active accounts found for customer no: " + userId);
        }

        return accountAssembler.fromEntityListToDtoList(accounts);
    }

    public String createAccount(AccountDto accountDto) {
        Account account = accountAssembler.fromDtoToEntity(accountDto);
        account.setStatus(ACTIVE.getCode());
        accountRepository.save(account);

        return "Account created successfully!";
    }

    public String activateAccount(Integer accNumber) {
        Account account = accountRepository.findAccountByAccNumber(accNumber);
        if (isNull(account)) {
            return "Account does not exist";
        } else if (ACTIVE.getCode().equals(account.getStatus())) {
            return "Account is already active";
        } else {
            account.setStatus("A");
            accountRepository.save(account);

            return "Account activated";
        }
    }

    public String deactivateAccount(Integer accNumber) {
        Account account = accountRepository.findAccountByAccNumber(accNumber);
        if (isNull(account)) {
            return "Account does not exist!";
        } else if (PASSIVE.getCode().equals(account.getStatus())) {
            return "Account is already deactivated!";
        } else {
            account.setStatus("P");
            accountRepository.save(account);

            return "Account deactivated!";
        }
    }
}
