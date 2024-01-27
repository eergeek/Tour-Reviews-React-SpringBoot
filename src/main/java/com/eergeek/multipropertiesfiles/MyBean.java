package com.eergeek.multipropertiesfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${name}")
    String name;

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
