package com.practice.demo.scopeofbeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("==================== Before Application Start ===================");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("==================== After Application Start ===================");

        demoSingleton(context);
    }

    private static void demoSingleton(ApplicationContext context) {
        MySingletonComponent component1 = context.getBean(MySingletonComponent.class);
        MySingletonComponent component2 = context.getBean(MySingletonComponent.class);
        MySingletonComponent component3 = context.getBean(MySingletonComponent.class);

        System.out.println(component1);
        System.out.println(component2);
        System.out.println(component3);
    }
}
