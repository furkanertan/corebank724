package com.application.corebank.service;

import com.application.corebank.assembler.TransactionHistoryAssembler;
import com.application.corebank.domain.TransactionHistory;
import com.application.corebank.dto.TransactionHistoryDto;
import com.application.corebank.repository.TransactionHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionHistoryService {

    private TransactionHistoryAssembler assembler;
    private TransactionHistoryRepository repository;

    public void createTransactionHistory(String accountNumber, String transactionType, String message, Double amount, String reasonCode) {
        if ("OUTGOING".equals(reasonCode)) {
            amount = amount * -1;
        }

        TransactionHistory transactionHistory = assembler.fromDtoToEntity(accountNumber, transactionType, message, amount, reasonCode);
        repository.save(transactionHistory);
        log.info("Transaction history created");
    }

    public List<TransactionHistoryDto> getLast5Transactions(List<String> accountNumber) {
        List<TransactionHistory> transactionHistories = repository.findTop5ByAccountNumberOrderByTransactionTimeDesc(accountNumber);

        if (transactionHistories.isEmpty()) {
            System.out.println("No transaction history found");
            return new ArrayList<>();
        }

        return assembler.fromEntityListToDtoList(transactionHistories);
    }
}
