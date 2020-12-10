package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.UserDto;
import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Long> implements UserService{

    private UserRepository userRepository;
    private final CustomMapper customMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CustomMapper customMapper) {
        super(userRepository);
        this.customMapper = customMapper;
    }

    @Override
    public List<UserDto> listAllActiveUsers() {
      return customMapper.mapUsers(userRepository.findByActiveTrue());
    }
}
