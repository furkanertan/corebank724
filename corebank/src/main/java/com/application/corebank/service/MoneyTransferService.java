package com.application.corebank.service;

import com.application.corebank.assembler.MoneyTransferAssembler;
import com.application.corebank.domain.MoneyTransfer;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.repository.MoneyTransferRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MoneyTransferService {

    private MoneyTransferRepository repository;
    private MoneyTransferAssembler assembler;
    private AccountService accountService;

    public void transferMoney(AccountDto senderAccountDto, AccountDto recipientAccountDto, String title, Double amount, Double commissionAmount, Double totalAmount) {
        //Create transfer money record
        MoneyTransfer moneyTransfer = assembler.fromDtoToEntity(senderAccountDto, recipientAccountDto, title, amount, commissionAmount, totalAmount);
        repository.save(moneyTransfer);
        log.info("Transfer money from {} to {} amount {}", senderAccountDto.getAccountNumber(), recipientAccountDto.getAccountNumber(), amount);

        //Update sender account balance
        accountService.updateAccountBalance(senderAccountDto.getAccountNumber(), totalAmount, true);
        log.info("Sender account balance updated");

        //Update receiver account balance
        accountService.updateAccountBalance(recipientAccountDto.getAccountNumber(), amount, false);
        log.info("Recipient account balance updated");
    }
}
