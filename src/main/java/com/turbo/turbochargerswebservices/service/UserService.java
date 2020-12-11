package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.UserDto;
import com.turbo.turbochargerswebservices.model.entity.User;

import java.util.List;

public interface UserService extends AbstractBaseService<User, Long> {

    List<UserDto> listAllActiveUsers();

    void setDeletedAsTrue(Long id);
}
