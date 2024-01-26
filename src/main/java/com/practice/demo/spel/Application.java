package com.practice.demo.spel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("====== Value Injection via Properties file and SpEL Direct ======");
        ValueInjectionYmlDirect valueInjection = context.getBean(ValueInjectionYmlDirect.class);
        valueInjection.getInjectedValues();

        // Spring Expression Language Injected Values
        context.getBean(SpELBean.class).printInjectedValues();
    }
}
