package com.rbacsystem.service.permission;

import com.rbacsystem.dto.permission.PermissionRequestDTO;
import com.rbacsystem.dto.permission.PermissionResponseDTO;
import com.rbacsystem.entity.Permission;
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

        Permission permission = new Permission();
        permission.setName(dto.name());

        repository.save(permission);

        return new PermissionResponseDTO(
                permission.getId(),
                permission.getName()
        );

    }

    @Override
    public List<PermissionResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(permission -> new PermissionResponseDTO(
                        permission.getId(),
                        permission.getName()
                ))
                .toList();
    }

    @Override
    public PermissionResponseDTO findById(Long id) {
        Permission permission = repository.findById(id)
                .orElseThrow();

        return new PermissionResponseDTO(
                permission.getId(),
                permission.getName()
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
