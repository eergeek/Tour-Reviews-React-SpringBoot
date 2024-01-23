package com.practice.demo.scopeofbeans;

import org.springframework.stereotype.Component;

@Component
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
