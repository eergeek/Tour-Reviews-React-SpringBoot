package com.practice.demo.autowiring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component("information")
public class Info {
    public List<String> getCities() {
        return Arrays.asList(
                "Jkor",
                "Tomer",
                "Bombay",
                "Badoda",
                "Bisk",
                "Bahar-en",
                "Zen",
                "Delhi",
                "Dhaka",
                "Osaka",
                "Osbourn",
                "Jersey");
    }

    public Map<String, String> getCurrencies() {
        return Map.of(
                "UK", "Pound",
                "IN", "Rupee",
                "US", "Dollar",
                "CH", "Yen",
                "RU", "Ruble"
        );
    }
}