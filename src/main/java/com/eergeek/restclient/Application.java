package com.eergeek.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@PropertySource("classpath:client.yml")
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "client");
        ApplicationContext context = SpringApplication.run(Application.class, args);

        ProductRestClient client = context.getBean(ProductRestClient.class);
        client.demoOne();
        client.demoInsert();
        client.demoUpdate();
        client.demoDelete();
        client.demoGetAll();
    }
}
