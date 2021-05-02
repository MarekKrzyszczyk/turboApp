package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.user.UserDto;
import com.turbo.turbochargerswebservices.model.dto.user.UserMapper;
import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, UserDto, Long> implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> listAllActiveUsers() {
        List<User> users = userRepository.findByDeletedFalse();
        return userMapper.mapToDtoList(users);
    }

    @Override
    public void setDeletedAsTrue(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isPresent()) {
            User deletedUser = optUser.get();
            deletedUser.setDeleted(true);
            userRepository.save(deletedUser);
        }
    }
}
