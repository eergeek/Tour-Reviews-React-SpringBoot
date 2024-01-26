package com.practice.demo30.scopeofbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/**
 * Other Scopes for bean access are
 * request - available throughout the web (http) request
 * session - throughout the browser session
 * application - throughout running life of application
 * prototype - everytime getBean called new instance will be returned for that bean
 */
@Scope("prototype")
public class MyPrototypeComponent {
    private static int nextId;
    private int id = nextId++;

    public MyPrototypeComponent() {
        System.out.printf("MyPrototypeComponent Bean #%d\n", id);
    }

    @Override
    public String toString() {
        return "MyPrototypeComponent Bean {" +
                "id=" + id +
                '}';
    }
}
