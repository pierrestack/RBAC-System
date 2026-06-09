package com.rbacsystem.controller;

import com.rbacsystem.dto.role.RoleRequestDTO;
import com.rbacsystem.dto.role.RoleResponseDTO;
import com.rbacsystem.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponseDTO create(@RequestBody RoleRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public RoleResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<RoleResponseDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{roleId}/permissions/{permissionId}")
    public RoleResponseDTO addPermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return service.addPermission(roleId, permissionId);
    }

    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    public RoleResponseDTO removePermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return service.removePermission(roleId, permissionId);
    }
}
