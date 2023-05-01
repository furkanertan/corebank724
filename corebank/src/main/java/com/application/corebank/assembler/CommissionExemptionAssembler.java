package com.application.corebank.assembler;

import com.application.corebank.domain.CommissionExemption;
import com.application.corebank.dto.CommissionExemptionDto;
import org.springframework.stereotype.Component;

@Component
public class CommissionExemptionAssembler {

    public CommissionExemptionDto fromEntityToDto(CommissionExemption commissionExemption) {
        return CommissionExemptionDto.builder()
                .id(commissionExemption.getId())
                .accountNo(commissionExemption.getAccountNo())
                .accountCurrencyType(commissionExemption.getAccountCurrencyType())
                .userId(commissionExemption.getUserId())
                .commissionCode(commissionExemption.getCommissionCode())
                .status(commissionExemption.getStatus())
                .createdAt(commissionExemption.getCreatedAt())
                .updatedAt(commissionExemption.getUpdatedAt())
                .build();
    }
}
