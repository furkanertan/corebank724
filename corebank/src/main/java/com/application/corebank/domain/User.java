package com.application.corebank.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "First name cannot be empty!")
    @Size(min = 3, max = 30, message = "First name should be between 2 and 30 characters!")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty!")
    @Size(min = 3, max = 30, message = "Last name should be between 2 and 30 characters!")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty!")
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email should be valid!")
    private String email;

    @NotEmpty(message = "Phone cannot be empty!")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone should be valid!")
    private String phone;

    @NotEmpty(message = "Address cannot be empty!")
    @Size(min = 3, max = 100, message = "Address should be between 3 and 100 characters!")
    private String address;

    @NotEmpty(message = "Password cannot be empty!")
    @NotNull
    private String password;
    @Transient
    private String confirmPassword;
    private String token;
    private Integer code;
    private Integer verified;
    private LocalDate verifiedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
