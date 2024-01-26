package com.eergeek.interdependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);

        TransactionManager txm1 = context.getBean("transactionManager1", TransactionManager.class);
        txm1.beginTransaction();
        txm1.endTransaction();

        TransactionManager txm2 = context.getBean("transactionManager2", TransactionManager.class);
        txm2.beginTransaction();
        txm2.endTransaction();

        TransactionManager txm3 = context.getBean("transactionManager3", TransactionManager.class);
        txm3.beginTransaction();
        txm3.endTransaction();
    }
}
