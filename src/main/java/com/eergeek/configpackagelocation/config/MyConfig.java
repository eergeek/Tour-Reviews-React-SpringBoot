package com.eergeek.configpackagelocation.config;

import com.eergeek.configpackagelocation.components.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setUsername("ConfigLocation");
        myBean.setScore(100_000);

        return myBean;
    }
}
