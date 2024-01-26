package com.eergeek.simpleconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {

    // this will be Singleton Bean if removed prototype scope
    // prototype scope would create new bean every time context.getBean(MyBean.class) would be called
    // would not initialize automatically at startup like singleton bean
    @Bean
    @Scope("prototype")
    public MyBean myCustomBean() {
        return new MyBean();
    }
}