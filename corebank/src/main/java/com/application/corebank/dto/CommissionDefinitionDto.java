package com.application.corebank.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class CommissionDefinitionDto {
    private Long id;
    private String code;
    private String description;
    private Double rate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
