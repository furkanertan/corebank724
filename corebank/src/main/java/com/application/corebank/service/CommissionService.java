package com.application.corebank.service;

import com.application.corebank.dto.CommissionDefinitionDto;
import com.application.corebank.dto.CommissionExemptionDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CommissionService {

    private CommissionExemptionService commissionExemptionService;
    private CommissionDefinitionService commissionDefinitionService;

    public Double calculateCommissionAmount(String fromAccountNumber, String commissionCode, Double amount) {
        //Get commission definition by code for the transaction
        CommissionDefinitionDto commissionDefinition = commissionDefinitionService.getCommissionDefinitionByCode(commissionCode);

        //Get commission exemptions for the account and this commissionCode
        CommissionExemptionDto commissionExemption = commissionExemptionService.getAllCommissionExemptionsByAccount(fromAccountNumber, commissionCode);

        double commissionAmount;
        //If user has exemption for this commission code, do not charge commission
        if (commissionExemption == null) {
            commissionAmount = amount * commissionDefinition.getRate();
            log.info("Commission amount {} will be charged for this transaction", commissionAmount);
        } else {
            log.info("User has exemption for this commission code, no commission will be charged for this transaction");
            commissionAmount = 0;
        }
        return commissionAmount;
    }
}
