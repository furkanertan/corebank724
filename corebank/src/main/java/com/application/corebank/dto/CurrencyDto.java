package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CurrencyDto {
    private String type;
    private String description;
}
