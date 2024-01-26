package com.eergeek.simpleconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // get my Bean with Default setters
        System.out.println(context.getBean("myCustomBean"));

        // get my Bean
        MyBean myBeanWithName = context.getBean("myCustomBean", MyBean.class);
        myBeanWithName.setScore(3000);
        System.out.println(myBeanWithName);

        System.out.println(context.getBean("autowireMyBeanComp", AutowireMyBeanComp.class));
    }
}
