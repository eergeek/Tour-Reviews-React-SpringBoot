package com.eergeek.multipropertiesfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        /**
         * Uncomment below setProperty, try using through cmd line {@link cmdlinepropertiesfiles}
         * --spring.config.name=application-two (without .properties extenstion)
         **/
//        System.setProperty("spring.config.name", "application-one");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MyBean myBean = context.getBean(MyBean.class);

        System.out.println(myBean);
    }
}