package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.dto.user.UserDto;
import com.turbo.turbochargerswebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
//        userService.setDeletedAsTrue(id);
//        return ResponseEntity.ok().build();
//    }
}