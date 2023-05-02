package com.application.corebank.assembler;

import com.application.corebank.domain.TransactionHistory;
import com.application.corebank.dto.TransactionHistoryDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionHistoryAssembler {

    public TransactionHistoryDto fromEntityToDto(TransactionHistory transactionHistory) {
        return TransactionHistoryDto.builder()
                .id(transactionHistory.getId())
                .accountNumber(transactionHistory.getAccountNumber())
                .transactionType(transactionHistory.getTransactionType())
                .message(transactionHistory.getMessage())
                .amount(transactionHistory.getAmount())
                .reasonCode(transactionHistory.getReasonCode())
                .transactionTime(transactionHistory.getTransactionTime())
                .build();
    }

    public TransactionHistory fromDtoToEntity(String accountNumber, String transactionType, String message, Double amount, String reasonCode) {
        TransactionHistory transactionHistory = new TransactionHistory();

        transactionHistory.setAccountNumber(accountNumber);
        transactionHistory.setTransactionType(transactionType);
        transactionHistory.setMessage(message);
        transactionHistory.setAmount(amount);
        transactionHistory.setReasonCode(reasonCode);
        transactionHistory.setTransactionTime(LocalDateTime.now());

        return transactionHistory;
    }

    public List<TransactionHistoryDto> fromEntityListToDtoList(List<TransactionHistory> transactionHistories) {
        return transactionHistories.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }
}
