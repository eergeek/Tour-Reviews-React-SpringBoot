package com.eergeek.app;

import com.eergeek.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.eergeek")
@EntityScan("com.eergeek.entity")
@EnableJpaRepositories("com.eergeek.repos")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        EmployeeService service = context.getBean(EmployeeService.class);
        service.useStandardCRUDRepoMethods();
        service.useCustomCRUDRepoMethods();
    }
}
