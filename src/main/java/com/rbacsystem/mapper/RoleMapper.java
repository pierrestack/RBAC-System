package com.rbacsystem.mapper;

import com.rbacsystem.dto.role.RoleRequestDTO;
import com.rbacsystem.dto.role.RoleResponseDTO;
import com.rbacsystem.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleMapper {

    public static Role toRoleEntity(RoleRequestDTO dto) {

        if (dto == null) return null;

        return Role.builder()
                .name(dto.name())
                .build();
    }

    public static RoleResponseDTO toRoleResponseDTO(Role role) {
        if(role == null) return null;

        return new RoleResponseDTO(
                role.getId(),
                role.getName(),
                PermissionMapper.toPermissionResponseDTOSet(role.getPermissions())
        );
    }

    public static List<RoleResponseDTO> toRoleResponseDTOList(List<Role> roles) {
        if(roles == null) return null;

        return roles.stream()
                .map(RoleMapper::toRoleResponseDTO)
                .toList();
    }

    public static Set<RoleResponseDTO> toRoleResponseDTOSet(Set<Role> roles) {
        if(roles == null) return null;

        return roles.stream()
                .map(RoleMapper::toRoleResponseDTO)
                .collect(Collectors.toSet());
    }
}
