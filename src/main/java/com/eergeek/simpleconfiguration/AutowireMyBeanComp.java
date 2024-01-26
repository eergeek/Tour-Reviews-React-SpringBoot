package com.eergeek.simpleconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowireMyBeanComp {

    @Autowired
    MyBean myBean;

    // if autowired this method at startup MyBean would be initialized with below values
    @Autowired
    public void getMyBeanData() {
        myBean.setUsername("DONNER Man");
        myBean.setScore(1000);
    }

    @Override
    public String toString() {
        return "AutowireMyBeanComp{" +
                "myBean=" + myBean +
                '}';
    }
}
