package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.role.RoleDto;
import com.turbo.turbochargerswebservices.model.dto.role.RoleMapper;
import com.turbo.turbochargerswebservices.model.entity.Role;
import com.turbo.turbochargerswebservices.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractBaseServiceImpl<Role, RoleDto, Long> implements RoleService{

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        super(roleRepository, roleMapper);
    }
}
