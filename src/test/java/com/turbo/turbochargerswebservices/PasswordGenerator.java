package com.turbo.turbochargerswebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "ADMIN";
        System.out.println(encoder.encode(rawPassword));
    }
}
