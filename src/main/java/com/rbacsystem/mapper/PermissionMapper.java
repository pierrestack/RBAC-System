package com.rbacsystem.mapper;

import com.rbacsystem.dto.permission.PermissionRequestDTO;
import com.rbacsystem.dto.permission.PermissionResponseDTO;
import com.rbacsystem.entity.Permission;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PermissionMapper {

    public static Permission toPermissionEntity(PermissionRequestDTO dto) {
        if (dto == null) return null;

        return Permission.builder()
                .name(dto.name())
                .build();
    }

    public static PermissionResponseDTO toPermissionResponseDTO(Permission permission) {
        if (permission == null) return null;

        return new PermissionResponseDTO(
                permission.getId(),
                permission.getName()
        );
    }

    public static List<PermissionResponseDTO> toPermissionResponseDTOList(List<Permission> permissions) {
        return permissions.stream()
                .map(PermissionMapper::toPermissionResponseDTO)
                .toList();
    }

    public static Set<PermissionResponseDTO> toPermissionResponseDTOSet(Set<Permission> permissions) {
        return permissions.stream()
                .map(PermissionMapper::toPermissionResponseDTO)
                .collect(Collectors.toSet());
    }
}
