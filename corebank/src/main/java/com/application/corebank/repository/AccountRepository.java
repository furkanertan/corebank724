package com.application.corebank.repository;

import com.application.corebank.domain.Account;
import com.application.corebank.domain.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT sum(a.balance) as totalBalance, a.acc_currency_type as currencyType  FROM account a WHERE user_id = :userId group by a.acc_currency_type", nativeQuery = true)
    List<AccountBalance> getTotalBalanceAndCurrencyTypeByUserId(Long userId);

    Account findAccountByAccNumber(Integer accNumber);

    List<Account> findAllByUserIdAndStatus(Long userId, String status);

    @Query(value = "SELECT count(*) FROM account a WHERE user_id = :userId and status = 'A'", nativeQuery = true)
    Integer countByUserId(Long userId);
}