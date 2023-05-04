package com.application.corebank.controller;

import com.application.corebank.service.CommissionService;
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

    private CommissionService commissionService;

    @GetMapping("/calculate")
    public Double calculateCommissionAmount(@RequestParam("fromAccount") String fromAccountNumber,
                                            @RequestParam("commissionCode") String commissionCode,
                                            @RequestParam("amount") Double amount) {

        log.info("Calculating commission amount for account {} and commission code {} and amount {}", fromAccountNumber, commissionCode, amount);
        return commissionService.calculateCommissionAmount(fromAccountNumber, commissionCode, amount);
    }
}
