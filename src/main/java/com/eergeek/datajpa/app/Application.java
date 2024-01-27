package com.eergeek.datajpa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.eergeek.datajpa.entity")
@ComponentScan("com.eergeek.datajpa")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        System.out.println();
    }
}