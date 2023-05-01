package com.application.corebank.repository;

import com.application.corebank.domain.CommissionDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionDefinitionRepository extends JpaRepository<CommissionDefinition, Long> {

    CommissionDefinition findAllByCodeAndStatus(String code, String status);
}
