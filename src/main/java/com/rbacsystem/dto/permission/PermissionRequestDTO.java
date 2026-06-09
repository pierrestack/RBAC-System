package com.rbacsystem.dto.permission;

import jakarta.validation.constraints.NotBlank;

public record PermissionRequestDTO(
        @NotBlank(message = "Permission name must not be blank")
        String name
) {
}
