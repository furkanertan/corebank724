package com.application.corebank.repository;

import com.application.corebank.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    @Query(value = "SELECT * FROM transaction_history WHERE account_number IN ?1 ORDER BY transaction_time DESC LIMIT 5", nativeQuery = true)
    List<TransactionHistory> findTop5ByAccountNumberOrderByTransactionTimeDesc(List<String> accountNumber);

    @Query(value = "SELECT * FROM transaction_history WHERE account_number IN ?1 ORDER BY transaction_time DESC", nativeQuery = true)
    List<TransactionHistory> findAllOrderByTransactionTimeDesc(List<String> accountNumber);
}
