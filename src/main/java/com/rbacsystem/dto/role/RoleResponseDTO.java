package com.rbacsystem.dto.role;

import com.rbacsystem.dto.permission.PermissionResponseDTO;

import java.util.Set;

public record RoleResponseDTO(
        Long id,
        String name,
        Set<PermissionResponseDTO> permissions
) {
}
