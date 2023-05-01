package com.application.corebank.controller;

import com.application.corebank.dto.CommissionDefinitionDto;
import com.application.corebank.dto.CommissionExemptionDto;
import com.application.corebank.service.CommissionDefinitionService;
import com.application.corebank.service.CommissionExemptionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/commission")
@AllArgsConstructor
public class CommissionController {

    private CommissionExemptionService commissionExemptionService;
    private CommissionDefinitionService commissionDefinitionService;

    @GetMapping("/calculate")
    public Double calculateCommissionAmount(@RequestParam("fromAccount") String fromAccountNumber,
                                            @RequestParam("commissionCode") String commissionCode,
                                            @RequestParam("amount") Double amount) {

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
