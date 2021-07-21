package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.security.TurboUserDetails;
import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        } else {
            return new TurboUserDetails(optionalUser.get());
        }
    }
}
