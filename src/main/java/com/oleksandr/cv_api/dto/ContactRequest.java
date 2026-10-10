package com.oleksandr.cv_api.dto;

import jakarta.validation.constraints.*;

public record ContactRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be at most 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Message is required")
        @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
        String message
){}
