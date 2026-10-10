package com.oleksandr.cv_api.dto;

import jakarta.validation.constraints.*;

public record ContactRequest(@NotBlank @Size(max = 100) String name, @NotBlank @Email String email, @NotBlank @Size(max = 500) String message) {
}
