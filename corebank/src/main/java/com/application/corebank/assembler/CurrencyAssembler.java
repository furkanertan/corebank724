package com.application.corebank.assembler;

import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyAssembler {

    public Currency fromDtoToEntity(CurrencyDto currencyDto) {
        Currency currency = new Currency();

        currency.setType(currencyDto.getType());
        currency.setDescription(currencyDto.getDescription());

        return currency;
    }
}
