package com.practice.demo30.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MyComponent myComponent = context.getBean("bestBean", MyComponent.class);

        System.out.println(myComponent);
    }
}
