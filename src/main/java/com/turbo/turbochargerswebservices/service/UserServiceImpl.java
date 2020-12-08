package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Long> implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

}
