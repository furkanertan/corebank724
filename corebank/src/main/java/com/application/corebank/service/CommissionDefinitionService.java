package com.application.corebank.service;

import com.application.corebank.assembler.CommissionDefinitionAssembler;
import com.application.corebank.domain.CommissionDefinition;
import com.application.corebank.dto.CommissionDefinitionDto;
import com.application.corebank.repository.CommissionDefinitionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CommissionDefinitionService {

    private CommissionDefinitionRepository repository;
    private CommissionDefinitionAssembler assembler;

    public CommissionDefinitionDto getCommissionDefinitionByCode(String code) {
        CommissionDefinition commissionDefinition = repository.findAllByCodeAndStatus(code, "A");
        if (commissionDefinition != null) {
            return assembler.fromEntityToDto(commissionDefinition);
        }
        return null;
    }
}
