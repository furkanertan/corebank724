package com.application.corebank.service;

import com.application.corebank.assembler.CurrencyAssembler;
import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyAssembler currencyAssembler;

    public CurrencyService(CurrencyRepository currencyRepository, CurrencyAssembler currencyAssembler) {
        this.currencyRepository = currencyRepository;
        this.currencyAssembler = currencyAssembler;
    }

    public List<Currency> getAllCurrencyTypes() {
        return currencyRepository.findAll();
    }

    public Currency createCurrency(CurrencyDto currencyDto) {
        Currency currency = currencyAssembler.fromDtoToEntity(currencyDto);

        return currencyRepository.save(currency);
    }
}
