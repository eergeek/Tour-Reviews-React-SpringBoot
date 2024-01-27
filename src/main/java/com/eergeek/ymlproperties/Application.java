package com.eergeek.ymlproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // Read contact properties from app-one.yml
        // can use --spring.config.name=app-two as well
        System.setProperty("spring.config.name", "app-one");
        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyContact contact = context.getBean(MyContact.class);
        System.out.println(contact);

        MyContactConfigurationPrefix prefixContact = context.getBean(MyContactConfigurationPrefix.class);
        System.out.println(prefixContact);
    }
}
