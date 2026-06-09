package com.rbacsystem.service.permission;

import com.rbacsystem.dto.permission.PermissionRequestDTO;
import com.rbacsystem.dto.permission.PermissionResponseDTO;

import java.util.List;

public interface PermissionService {

    PermissionResponseDTO create(PermissionRequestDTO dto);

    List<PermissionResponseDTO> findAll();

    PermissionResponseDTO findById(Long id);

    void delete(Long id);

}
