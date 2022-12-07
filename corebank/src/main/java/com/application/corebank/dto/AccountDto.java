package com.application.corebank.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountDto {
    private Integer customerNo;
    private Integer accountNumber;
    private String currencyType;
    private Double balance;
    private String type;
    private String status;
}
