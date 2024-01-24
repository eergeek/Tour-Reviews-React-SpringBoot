package com.practice.demo.autowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        BankServiceImpl bankService = context.getBean(BankServiceImpl.class);

        bankService.mapInjectionAutowire(); // Collection / Map Auto wiring

        System.out.println("====== DEPOSIT =========");
        bankService.deposit(0, 10_000);

        System.out.println("====== WITHDRAW =========");
        bankService.withdraw(0, 20_000_000);

        System.out.println("====== TRANSFER ==========");
        bankService.transfer(0, 1, 5_000);
    }
}
