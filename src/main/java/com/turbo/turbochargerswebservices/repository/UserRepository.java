package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractBaseRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
