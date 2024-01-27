package com.eergeek.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /**
         * If there are two configuration files with same name like below .properties will take precedence
         * profile.yml profiles.properties
         */
        System.setProperty("spring.config.name", "profiles");
        ApplicationContext context = SpringApplication.run(Application.class, args);  // args is IMP if passing via cmdline

        // Dev profile or Prod profile depending on this
        // --spring.profiles.active=development
        // or read value from profiles.properties
        MyBean devBean = context.getBean(MyBean.class);
        System.out.println(devBean);

        BeanWithDefaultProfile defaultProfile = context.getBean(BeanWithDefaultProfile.class);
        System.out.println(defaultProfile);
    }
}
