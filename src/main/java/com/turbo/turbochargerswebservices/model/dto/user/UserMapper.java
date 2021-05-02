package com.turbo.turbochargerswebservices.model.dto.user;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.dto.role.RoleMapper;
import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupMapper;
import com.turbo.turbochargerswebservices.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class, RoleMapper.class, WorkgroupMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface UserMapper extends CustomMapper<User, UserDto> {

}
