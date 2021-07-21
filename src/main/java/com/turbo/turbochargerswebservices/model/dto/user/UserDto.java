package com.turbo.turbochargerswebservices.model.dto.user;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import com.turbo.turbochargerswebservices.model.dto.role.RoleDto;
import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupDto;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto extends AbstractBaseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Set<RoleDto> roles;

    private Set<WorkgroupDto> workgroups;
}
