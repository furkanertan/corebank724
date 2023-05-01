package com.application.corebank.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class AccountDto {
    private Long id;
    private Long userId;
    private Integer accountNumber;
    private String accountName;
    private String accountType;
    private String currencyType;
    private Double balance;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
