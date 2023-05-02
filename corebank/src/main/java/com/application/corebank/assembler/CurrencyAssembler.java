package com.application.corebank.assembler;

import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyAssembler {

    public Currency fromDtoToEntity(CurrencyDto currencyDto) {
        Currency currency = new Currency();

        currency.setType(currencyDto.getType());
        currency.setDescription(currencyDto.getDescription());

        return currency;
    }

    public CurrencyDto fromEntityToDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setType(currency.getType());
        currencyDto.setDescription(currency.getDescription());

        return currencyDto;
    }

    public List<CurrencyDto> fromEntityListToDtoList(List<Currency> currencyList) {
        return currencyList.stream().map(this::fromEntityToDto).collect(Collectors.toList());
    }
}
