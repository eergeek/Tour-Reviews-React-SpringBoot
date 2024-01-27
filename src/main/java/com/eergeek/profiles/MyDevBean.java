package com.eergeek.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class MyDevBean implements MyBean {

    @Value("${apiserver.address}")
    String address;

    @Value("${apiserver.port}")
    int port;

    @Override
    public String toString() {
        return "MyDevBean{" +
                "address='" + address + '\'' +
                ", port=" + port +
                '}';
    }
}
