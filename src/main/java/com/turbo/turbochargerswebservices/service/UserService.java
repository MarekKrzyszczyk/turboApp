package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.user.UserDto;

import java.util.List;

public interface UserService extends AbstractBaseService<UserDto, Long> {

    List<UserDto> listAllActiveUsers();

    void setDeletedAsTrue(Long id);
}
