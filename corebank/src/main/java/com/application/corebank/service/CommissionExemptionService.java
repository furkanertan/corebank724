package com.application.corebank.service;

import com.application.corebank.assembler.CommissionExemptionAssembler;
import com.application.corebank.domain.CommissionExemption;
import com.application.corebank.dto.CommissionExemptionDto;
import com.application.corebank.repository.CommissionExemptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CommissionExemptionService {

    private CommissionExemptionAssembler assembler;
    private CommissionExemptionRepository repository;

    public CommissionExemptionDto getAllCommissionExemptionsByAccount(String accountNumber, String commissionCode) {
        CommissionExemption commissionExemption = repository.findByAccountNoAndCommissionCodeAndStatus(accountNumber, commissionCode, "A");

        if (commissionExemption != null) {
            return assembler.fromEntityToDto(commissionExemption);
        }

        return null;
    }
}