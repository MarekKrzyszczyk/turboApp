package com.turbo.turbochargerswebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TurbochargersWebServices {

    public static void main(String[] args) {
        SpringApplication.run(TurbochargersWebServices.class, args);
    }

}
