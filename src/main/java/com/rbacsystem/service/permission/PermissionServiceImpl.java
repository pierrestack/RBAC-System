package com.rbacsystem.service.permission;

import com.rbacsystem.dto.permission.PermissionRequestDTO;
import com.rbacsystem.dto.permission.PermissionResponseDTO;
import com.rbacsystem.entity.Permission;
import com.rbacsystem.mapper.PermissionMapper;
import com.rbacsystem.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    @Override
    public PermissionResponseDTO create(PermissionRequestDTO dto) {

        Permission permission = Permission.builder()
                .name(dto.name())
                .build();

        repository.save(permission);

        return PermissionMapper.toPermissionResponseDTO(permission);

    }

    @Override
    public List<PermissionResponseDTO> findAll() {
        return PermissionMapper.toPermissionResponseDTOList(repository.findAll());
    }

    @Override
    public PermissionResponseDTO findById(Long id) {
        Permission permission = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id: " + id));

        return PermissionMapper.toPermissionResponseDTO(permission);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
