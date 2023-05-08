package com.application.corebank.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountBalanceDto {

    public Double savingsBalance;
    public Double checksBalance;
    public Double depositsBalance;
}
