package com.application.corebank.assembler;

import com.application.corebank.domain.MoneyTransfer;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.dto.MoneyTransferDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MoneyTransferAssembler {

    public MoneyTransferDto fromEntityToDto(MoneyTransferDto moneyTransferDto) {
        return MoneyTransferDto.builder()
                .id(moneyTransferDto.getId())
                .fromAccountNo(moneyTransferDto.getFromAccountNo())
                .toAccountNo(moneyTransferDto.getToAccountNo())
                .amount(moneyTransferDto.getAmount())
                .commissionAmount(moneyTransferDto.getCommissionAmount())
                .totalAmount(moneyTransferDto.getTotalAmount())
                .title(moneyTransferDto.getTitle())
                .transferDate(moneyTransferDto.getTransferDate())
                .build();
    }

    public MoneyTransfer toCreateMoneyTransfer(String fromAccountNo, String toAccountNo, Double amount, Double commissionAmount, Double totalAmount, String title) {
        MoneyTransfer moneyTransfer = new MoneyTransfer();

        return moneyTransfer;
    }

    public MoneyTransfer fromDtoToEntity(AccountDto senderAccountDto, AccountDto recipientAccountDto, String title, Double amount, Double commissionAmount, Double totalAmount) {
        MoneyTransfer moneyTransfer = new MoneyTransfer();

        moneyTransfer.setFromCustomerNo(senderAccountDto.getUserId());
        moneyTransfer.setFromAccountNo(senderAccountDto.getAccountNumber());
        moneyTransfer.setFromAccountCurrencyType(senderAccountDto.getCurrencyType());
        moneyTransfer.setToCustomerNo(recipientAccountDto.getUserId());
        moneyTransfer.setToAccountNo(recipientAccountDto.getAccountNumber());
        moneyTransfer.setToAccountCurrencyType(recipientAccountDto.getCurrencyType());
        moneyTransfer.setTitle(title);
        moneyTransfer.setAmount(amount);
        moneyTransfer.setCommissionAmount(commissionAmount);
        moneyTransfer.setTotalAmount(totalAmount);
        moneyTransfer.setTransferDate(LocalDateTime.now());

        return moneyTransfer;
    }
}
