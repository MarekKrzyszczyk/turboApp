package com.turbo.turbochargerswebservices.basicauth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {

    @GetMapping("/basicauth")
    public AuthenticationBean getAuthenticationResponse() {
       return new AuthenticationBean("You are authenticated");
    }

}
