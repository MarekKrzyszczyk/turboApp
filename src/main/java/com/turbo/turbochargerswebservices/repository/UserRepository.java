package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.User;

import java.util.List;

public interface UserRepository extends AbstractBaseRepository<User, Long> {

    List<User> findByActiveTrue();
}
