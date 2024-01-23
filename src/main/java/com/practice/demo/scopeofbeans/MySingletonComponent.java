package com.practice.demo.scopeofbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
/*
 * Lazy Component Bean won't be created when SpringApplication.run(Application.class, args);
 * It will be created when explicitly called context.getBean("mySingletonComponent");
 */
@Lazy
public class MySingletonComponent {
    private static int nextId;
    private int id = nextId++;

    public MySingletonComponent() {
        System.out.printf("MySingletonComponent Bean Constructed #%d\n", id);
    }

    @Override
    public String toString() {
        return "MySingletonComponent Bean{" +
                "id=" + id +
                '}';
    }
}
