package com.rbacsystem.service.role;

import com.rbacsystem.dto.role.RoleRequestDTO;
import com.rbacsystem.dto.role.RoleResponseDTO;
import com.rbacsystem.entity.Permission;
import com.rbacsystem.entity.Role;
import com.rbacsystem.mapper.RoleMapper;
import com.rbacsystem.repository.PermissionRepository;
import com.rbacsystem.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public RoleResponseDTO create(RoleRequestDTO dto) {
        Role role = Role.builder()
                .name(dto.name())
                .build();

        roleRepository.save(role);

        return RoleMapper.toRoleResponseDTO(role);
    }

    @Override
    public List<RoleResponseDTO> findAll() {
        return RoleMapper.toRoleResponseDTOList(roleRepository.findAll());
    }

    @Override
    public RoleResponseDTO findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        return RoleMapper.toRoleResponseDTO(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleResponseDTO addPermission(Long roleId, Long permissionId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.getPermissions().add(permission);
        roleRepository.save(role);
        return RoleMapper.toRoleResponseDTO(role);
    }

    @Override
    public RoleResponseDTO removePermission(Long roleId, Long permissionId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.getPermissions().remove(permission);
        roleRepository.save(role);
        return RoleMapper.toRoleResponseDTO(role);
    }
}