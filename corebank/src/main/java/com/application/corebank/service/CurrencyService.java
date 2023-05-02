package com.application.corebank.service;

import com.application.corebank.assembler.CurrencyAssembler;
import com.application.corebank.domain.Currency;
import com.application.corebank.dto.CurrencyDto;
import com.application.corebank.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyService {

    private CurrencyRepository repository;
    private CurrencyAssembler assembler;


    public Set<String> getAllCurrencyTypes() {
        return repository.getAllCurrencyTypes();
    }

    public List<CurrencyDto> getAllCurrencies() {
        List<Currency> currencyList = repository.findAll();

        return assembler.fromEntityListToDtoList(currencyList);
    }

    public Currency createCurrency(CurrencyDto currencyDto) {
        Currency currency = assembler.fromDtoToEntity(currencyDto);

        return repository.save(currency);
    }
}
