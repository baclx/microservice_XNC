package com.example.identity_card_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IdentityCardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityCardServiceApplication.class, args);
    }

}
