package com.eswar.devops.project1.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank(message = "name is required") String name,
    @Email(message = "email must be valid") String email
) {}
