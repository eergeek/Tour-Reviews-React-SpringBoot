package com.practice.demo.components;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("bestBean")
public class MyComponent {
    private LocalDateTime localDateTime = LocalDateTime.now();

    public MyComponent() {
        System.out.printf("MyComponent bean created at %s\n", localDateTime);
    }

    @Override
    public String toString() {
        return "MyComponent{" +
                "localDateTime=" + localDateTime +
                '}';
    }
}
