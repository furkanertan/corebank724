package com.application.corebank.assembler;

import com.application.corebank.domain.CommissionDefinition;
import com.application.corebank.dto.CommissionDefinitionDto;
import org.springframework.stereotype.Component;

@Component
public class CommissionDefinitionAssembler {

    public CommissionDefinitionDto fromEntityToDto(CommissionDefinition commissionDefinition) {
        return CommissionDefinitionDto.builder().id(commissionDefinition.getId()).code(commissionDefinition.getCode()).description(commissionDefinition.getDescription()).rate(commissionDefinition.getRate()).status(commissionDefinition.getStatus()).createdAt(commissionDefinition.getCreatedAt()).updatedAt(commissionDefinition.getUpdatedAt()).build();
    }
}
