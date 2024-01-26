package com.eergeek.lazyeagerbeans;

import org.springframework.context.annotation.Bean;

import java.util.Random;

public class MyBean {
    private String  name;
    private double score;

    public MyBean(String name) {
        this.name = name;
        this.score = Math.random() * 100;
        System.out.printf("Creating Bean with name: %s, score: %f \n", name, score);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
