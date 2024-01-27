package com.eergeek.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class MyProdBean implements MyBean {

    @Value("${apiserver.address}")
    String addressUri;

    @Value("${apiserver.port}")
    int port;

    @Override
    public String toString() {
        return "MyProdBean{" +
                "addressUri='" + addressUri + '\'' +
                ", port=" + port +
                '}';
    }
}
