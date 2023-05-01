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

    @Query(value = "SELECT count(*) FROM account a WHERE user_id = :userId and status = 'A'", nativeQuery = true)
    Integer countByUserId(Long userId);
}