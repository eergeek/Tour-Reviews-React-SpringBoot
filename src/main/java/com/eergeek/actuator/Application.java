package com.eergeek.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "actuator");
        SpringApplication.run(Application.class);
    }
}
