package com.application.corebank.repository;

import com.application.corebank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "UPDATE User u SET u.code = null, u.verified = 1, u.verified_at = CURRENT_TIMESTAMP, u.updated_at = CURRENT_TIMESTAMP WHERE u.token = :token AND u.code = :code", nativeQuery = true)
    @Transactional
    void verifyUser(String token, int code);

    User findByToken(String token);

    User findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE User u SET u.password = :password WHERE u.id = :userId ", nativeQuery = true)
    @Transactional
    void updatePassword(Long userId, String password);
}
