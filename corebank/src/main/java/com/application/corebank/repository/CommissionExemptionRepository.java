package com.application.corebank.repository;

import com.application.corebank.domain.CommissionExemption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionExemptionRepository extends JpaRepository<CommissionExemption, Long> {

    CommissionExemption findByAccountNoAndCommissionCodeAndStatus(String accountNo, String commissionCode, String status);
}
