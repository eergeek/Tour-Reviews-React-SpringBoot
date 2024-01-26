package com.eergeek.lazyeagerbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {

    // Singleton - Eager Bean
    @Bean(name = "cool-bean")
    public MyBean beanOne() {
        return new MyBean("John");
    }

    // Singleton - Eager Bean
    @Bean(name = {"two", "third", "fourth"})
    public MyBean beanTwo() {
        return new MyBean("Two Newman");
    }

    // Singleton - Lazy Bean, wont be created at startup and until getBean() called
    @Bean(name = "lazy-bean")
    @Lazy
    public MyBean lazyBean() {
        return new MyBean("LazyMan");
    }

    /**
     * prototype scope bean, these are lazy by default
     * Every time getBean called new instance generated
     */
    @Bean(name = "proto-bean")
    @Scope("prototype")
    public MyBean protoBean() {
        return new MyBean("PrototypeMan");
    }

}
