package com.mkrzyszczyk.rest.webservices.restfulwebservices.controller;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.User;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}
