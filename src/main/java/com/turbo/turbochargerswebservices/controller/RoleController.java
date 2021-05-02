package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.role.RoleDto;
import com.turbo.turbochargerswebservices.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> listAllRoles() {
        List<RoleDto> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto role) {
        RoleDto createdRole = roleService.save(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }
}


