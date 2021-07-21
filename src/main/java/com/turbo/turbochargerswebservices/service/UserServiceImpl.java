package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.user.UserDto;
import com.turbo.turbochargerswebservices.model.dto.user.UserMapper;
import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, UserDto, Long> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
    }
}
