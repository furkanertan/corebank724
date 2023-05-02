package com.application.corebank.assembler;

import com.application.corebank.domain.CurrencyRates;
import com.application.corebank.dto.CurrencyRatesDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyRatesAssembler {

    public CurrencyRatesDto toDto(CurrencyRates currencyRates) {
        return CurrencyRatesDto.builder()
                .id(currencyRates.getId())
                .fromCurrency(currencyRates.getFromCurrency())
                .toCurrency(currencyRates.getToCurrency())
                .rate(currencyRates.getRate())
                .updatedAt(currencyRates.getUpdatedAt())
                .build();
    }

    public CurrencyRates toEntity(CurrencyRatesDto currencyRatesDto) {
        CurrencyRates currencyRates = new CurrencyRates();

        currencyRates.setFromCurrency(currencyRatesDto.getFromCurrency());
        currencyRates.setToCurrency(currencyRatesDto.getToCurrency());
        currencyRates.setRate(currencyRatesDto.getRate());
        currencyRates.setUpdatedAt(currencyRatesDto.getUpdatedAt());

        return currencyRates;
    }

    public CurrencyRates toEntity(String fromCurrency, String toCurrency, Double rate) {
        CurrencyRates currencyRates = new CurrencyRates();

        currencyRates.setFromCurrency(fromCurrency);
        currencyRates.setToCurrency(toCurrency);
        currencyRates.setRate(rate);
        currencyRates.setUpdatedAt(LocalDateTime.now());

        return currencyRates;
    }

    public List<CurrencyRatesDto> fromEntityListToDtoList(List<CurrencyRates> currencyRates) {
        return currencyRates.stream().map(this::toDto).collect(Collectors.toList());
    }
}
