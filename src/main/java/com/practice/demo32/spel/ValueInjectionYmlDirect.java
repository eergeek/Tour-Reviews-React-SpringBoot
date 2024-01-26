package com.practice.demo32.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueInjectionYmlDirect {

    @Value("${name}")  // read from the application.properties
    private String username;

    @Value("#{7 * 10}")  // calculate the value directly
    private int directInjection;

    public void getInjectedValues() {
        System.out.printf("YML Injection: %s\n" +
                "Direct Calculated Injection: %d", username, directInjection);
    }
}
