package com.application.corebank.assembler;

import com.application.corebank.domain.User;
import com.application.corebank.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setVerified(user.getVerified());
        userDto.setVerifiedAt(user.getVerifiedAt());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());

        return userDto;
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }
}
