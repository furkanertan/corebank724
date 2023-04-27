package com.application.corebank.assembler;

import com.application.corebank.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserAssembler {

    public User toCreateUser(String firstName, String lastName, String email, String phone, String address, String password, String token, int code) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setPassword(password);
        user.setToken(token);
        user.setCode(code);
        user.setVerified(0);
        user.setVerifiedAt(null);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(null);

        return user;
    }
}
