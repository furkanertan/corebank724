package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class CurrencyRatesDto {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private Double rate;
    private LocalDateTime updatedAt;
}
