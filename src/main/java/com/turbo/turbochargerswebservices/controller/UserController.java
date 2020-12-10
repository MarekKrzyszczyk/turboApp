package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.UserDto;
import com.turbo.turbochargerswebservices.model.entity.Status;
import com.turbo.turbochargerswebservices.model.entity.User;
import com.turbo.turbochargerswebservices.service.StatusService;
import com.turbo.turbochargerswebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final CustomMapper customMapper;

    @Autowired
    public UserController(UserService userService, CustomMapper customMapper) {
        this.userService = userService;
        this.customMapper = customMapper;
    }

    @GetMapping("/users")
    public List<UserDto> listAllUsers() {
      return userService.listAllActiveUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}


