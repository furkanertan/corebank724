package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class MoneyTransferDto {
    private Long id;
    private Long fromCustomerNo;
    private Integer fromAccountNo;
    private String fromAccountCurrencyType;
    private Long toCustomerNo;
    private Integer toAccountNo;
    private String toAccountCurrencyType;
    private Double amount;
    private Double commissionAmount;
    private Double totalAmount;
    private String title;
    private LocalDateTime transferDate;
}
