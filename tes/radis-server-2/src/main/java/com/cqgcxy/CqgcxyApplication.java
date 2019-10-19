package com.cqgcxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CqgcxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqgcxyApplication.class, args);
    }

}
