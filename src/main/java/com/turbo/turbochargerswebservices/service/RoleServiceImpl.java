package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Role;
import com.turbo.turbochargerswebservices.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractBaseServiceImpl<Role, Long> implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
    }

}
