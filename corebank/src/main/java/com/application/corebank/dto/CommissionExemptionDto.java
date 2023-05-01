package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class CommissionExemptionDto {
    private Long id;
    private String accountNo;
    private String accountCurrencyType;
    private Long userId;
    private String commissionCode;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
