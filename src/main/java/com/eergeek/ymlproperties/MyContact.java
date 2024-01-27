package com.eergeek.ymlproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyContact {

    /**
     * It will read name, tel, score from one of the yml file given as spring.confi.name in Main method.
     * NOTE: Don't put space like this ${ contact.name } (bean creation error)
     */
    @Value("${contact.name}")
    private String username;

    @Value("${contact.tel}")
    private String telephone;

    @Value("${contact.score}")
    private int userscore;

    @Override
    public String toString() {
        return "MyContact{" +
                "username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userscore=" + userscore +
                '}';
    }
}
