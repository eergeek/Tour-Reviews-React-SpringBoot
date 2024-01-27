package com.eergeek.cmdlineproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // --name="Somename" passed via cmd line overrides the application.properties "name"
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MyBean myBean = context.getBean(MyBean.class);

        System.out.println(myBean);
    }
}
