package com.application.corebank.repository;

import com.application.corebank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByAccNumber(Integer accNumber);
    List<Account> findAllByCustomerNoAndStatus(Integer customerNo, String status);
}