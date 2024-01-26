package com.practice.demo32.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SpELBean {

    // Scalar Values
    @Value("#{ 5 * 100 }")
    private double workWeekCheckAmount;

    // new Object invocation
    @Value("#{ new java.util.Date() }")
    private Date todaysDate;

    // T for static method
    @Value("#{ T(java.lang.Math).random() * 100 }")
    private int randomLuckyNumber;

    // Accessing Method from other bean
    @Value("#{ information.getCities[3] }")
    private String thirdCity;

    @Value("#{ information.getCities().size() }")
    private int sizeOfCities;

    @Value("#{ information.getCurrencies['UK'] }")
    private String currenyOfUK;

    @Value("#{ information.getCities.?[startsWith('B')] }")
    private List<String> citiesStartingWithB;

    // first city starting with B
    @Value("#{ information.getCities.^[startsWith('B')]}")
    private String firstBCity;

    // last city starting with B
    @Value("#{ information.getCities.$[startsWith('B')]}")
    private String lastBCity;

    // MAKE ALL VALUES IN CITIES LIST UPPERCASE USING SpEL
    @Value("#{ information.getCities.![toUpperCase()] }")
    private List<String> upperCaseCities;

    /**
     * This method not autowired, it will not be called by spring automatically at startup
     * It's been called explicitly when SpEL Bean is created at startup
     * then by Accessing that bean in {@link Application}
     */
    void printInjectedValues() {
        System.out.println("\n********** Spring Expression Language Injected Values *******");
        System.out.printf("""
                        Third City: %s, Total cities: %d
                        Currency of Uk: %s
                        Cities Starting with B: %s
                        First City with B: %s
                        Last City with B: %s
                        ALL CITIES UPPERCASE: %s""",
                thirdCity, sizeOfCities, currenyOfUK,
                citiesStartingWithB, firstBCity, lastBCity, upperCaseCities);
    }

    // This method is called by Spring Automatically at Startup no need to call explicitly
    @Autowired
    void autowireMethodParamAtRuntime(@Value("#{ systemProperties['user.name'] }") String uname) {
        System.out.println("-------------- This is Set by Spring at Startup not by any User ------");
        System.out.println("Username: " + uname);
    }


}
