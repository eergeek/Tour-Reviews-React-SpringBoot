package com.eergeek.configpackagelocation.main;

import com.eergeek.configpackagelocation.components.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * @SpringBootApplication is equivalent to all below annotations
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
@SpringBootApplication(scanBasePackages = "com.eergeek.configpackagelocation.config")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println(context.getBean(MyBean.class));

        System.out.println(context.getBean("nameBean"));
        System.out.println(context.getBean("localDateTime"));

    }

    @Bean
    public String nameBean() {
        return "Hello Name Bean";
    }

    @Bean
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }
}
