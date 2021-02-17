package com.mindera.school.rentacar.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateUserDto {

    @NotNull(message="First name cannot be null")
    @Size(min = 2, message = "Fist name must not be less than two characters")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    @Size(min = 2, message = "Last name must not be less than two characters")
    private String lastName;

    @NotNull(message="License ID should be provided")
    @Size(min = 8, max = 16, message = "License ID should be valid")
    private String licenseId;

    @NotNull(message="Password cannot be null")
    @Size(min = 6, max = 16, message = "Password must have at least 6 and not more then 16 characters")
    private String email;

    @NotNull(message="Email cannot be null")
    @Email(message = "Email should be valid")
    private String password;
}
