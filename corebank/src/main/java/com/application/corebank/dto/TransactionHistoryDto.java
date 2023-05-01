package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class TransactionHistoryDto {
    private Long id;
    private String accountNumber;
    private String transactionType;
    private String message;
    private Double amount;
    private String reasonCode;
    private LocalDateTime transactionTime;
}
