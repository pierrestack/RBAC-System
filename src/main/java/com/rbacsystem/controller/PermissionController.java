package com.rbacsystem.controller;

import com.rbacsystem.dto.permission.PermissionRequestDTO;
import com.rbacsystem.dto.permission.PermissionResponseDTO;
import com.rbacsystem.service.permission.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService service;

    @PostMapping
    public PermissionResponseDTO create(@RequestBody PermissionRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<PermissionResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PermissionResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
