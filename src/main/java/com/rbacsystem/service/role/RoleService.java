package com.rbacsystem.service.role;

import com.rbacsystem.dto.role.RoleRequestDTO;
import com.rbacsystem.dto.role.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponseDTO create(RoleRequestDTO dto);

    List<RoleResponseDTO> findAll();

    RoleResponseDTO findById(Long id);

    void delete(Long id);

    RoleResponseDTO addPermission(Long roleId, Long permissionId);

    RoleResponseDTO removePermission(Long roleId, Long permissionId);
}

