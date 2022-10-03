package com.example.immigration_info_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImmigrationInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmigrationInfoServiceApplication.class, args);
    }

}
