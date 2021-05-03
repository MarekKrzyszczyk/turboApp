package com.turbo.turbochargerswebservices.controller;

import com.turbo.turbochargerswebservices.model.entity.User;
import org.junit.jupiter.api.BeforeAll;

public class IntegrationTestsBase {

    static User authenticatedUser = new User();
    static User notAuthenticatedUser = new User();

    @BeforeAll
    static void setUsers() {
        authenticatedUser.setUsername("turbo");
        authenticatedUser.setPassword("turbo");
        notAuthenticatedUser.setUsername("dummy");
        notAuthenticatedUser.setPassword("dummy");
    }
}
