package com.rbacsystem.dto.role;

import jakarta.validation.constraints.NotBlank;

public record RoleRequestDTO(
        @NotBlank(message = "Role name must not be blank")
        String name
) {
}
