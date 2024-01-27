package com.eergeek.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apiserver")
public class BeanWithDefaultProfile {
    String address;
    int port;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "BeanWithDefaultProfile{" +
                "address='" + address + '\'' +
                ", port=" + port +
                '}';
    }
}
