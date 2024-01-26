package com.eergeek.lazyeagerbeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);

        MyBean ref1 = context.getBean("cool-bean", MyBean.class);
        System.out.println(ref1);

        MyBean ref2 = context.getBean("two", MyBean.class);
        MyBean ref3 = context.getBean("third", MyBean.class);
        MyBean ref4 = context.getBean("fourth", MyBean.class);
        System.out.println(ref2);
        System.out.println(ref3);
        System.out.println(ref4);

        // Lazy Singleton Bean
        MyBean lazyBean = context.getBean("lazy-bean", MyBean.class);
        System.out.println(lazyBean);

        // Prototype Bean
        MyBean protoOne = context.getBean("proto-bean", MyBean.class);
        MyBean protoTwo = context.getBean("proto-bean", MyBean.class);
        MyBean protoThree = context.getBean("proto-bean", MyBean.class);
    }
}