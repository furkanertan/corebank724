package com.application.corebank.service;

import com.application.corebank.assembler.UserAssembler;
import com.application.corebank.domain.User;
import com.application.corebank.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private UserAssembler assembler;

    public void saveUser(String firstName, String lastName, String email, String phone, String address, String password, String token, int code) {
        log.info("Saving user to database");

        User user = assembler.toCreateUser(firstName, lastName, email, phone, address, password, token, code);
        log.info("password: " + user.getPassword());
        repository.save(user);

        log.info("User saved to database!");
    }

    public void updatePassword(Long userId, String password) {
        log.info("Updating user password...");

        repository.updatePassword(userId, password);

        log.info("User password updated!");
    }

    public void verifyUser(String token, int code) {
        log.info("Verifying user...");

        repository.verifyUser(token, code);

        log.info("User verified!");
    }

    public User findByToken(String token) {
        log.info("Finding user by token...");

        return repository.findByToken(token);
    }

    public User findByEmail(String email) {
        log.info("Finding user by email...");

        return repository.findByEmail(email);
    }

    public User findById(Long id) {
        log.info("Finding user by id...");

        return repository.findById(id).orElse(null);
    }
}
