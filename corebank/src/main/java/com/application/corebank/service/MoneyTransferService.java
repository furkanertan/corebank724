package com.application.corebank.service;

import com.application.corebank.assembler.AccountAssembler;
import com.application.corebank.repository.MoneyTransferRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MoneyTransferService {

    private MoneyTransferRepository moneyTransferRepository;
    private AccountAssembler accountAssembler;
}
