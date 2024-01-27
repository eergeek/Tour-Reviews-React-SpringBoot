package com.eergeek.ymlproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "contact")  // "contact" property from yml file
public class MyContactConfigurationPrefix {

    /**
     * These variable to be initialized correctly by spring while bean creation
     * should have exact names as in yml file under "contact" property
     */
    String name;
    String tel;
    int score;

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MyContactConfigurationPrefix{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", score=" + score +
                '}';
    }
}
