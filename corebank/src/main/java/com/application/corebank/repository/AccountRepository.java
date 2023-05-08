package com.application.corebank.repository;

import com.application.corebank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByAccNumber(Integer accNumber);

    List<Account> findAllByUserIdAndStatus(Long userId, String status);

    List<Account> findAllByUserIdAndAccCurrencyTypeAndStatus(Long userId, String accCurrencyType, String status);

    @Query(value = "SELECT SUM(balance) FROM Account WHERE accType = :accType AND userId = :userId AND status = :status")
    Double getTotalBalanceByAccountTypeAndUserId(String accType, Long userId, String status);
}