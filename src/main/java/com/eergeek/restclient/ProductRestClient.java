package com.eergeek.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Port;
import java.util.List;

@Component
//@ConfigurationProperties(prefix = "server")
public class ProductRestClient {

    RestTemplate restTemplate = new RestTemplate();

//    @Value("{baseuri}")
    private String baseUri = "http://localhost:8080/simple/";

    public void demoOne() {
        ResponseEntity<Product> response = restTemplate.getForEntity(baseUri + "productsV2/3", Product.class);
        System.out.printf("""
                GET REQUEST: 
                status-code: {%s},
                body: {%s}
                """, response.getStatusCode(), response.getBody());
    }

    public void demoInsert() {
        ResponseEntity<Boolean> response = restTemplate.postForEntity(baseUri + "productsV2/addnew",
                new Product("post by client", 12.00), Boolean.class);

        System.out.printf("""
                POST REQUEST: INSERT
                status-code: %s,
                body: %s
                """, response.getStatusCode(), response.getBody());
    }

    public void demoUpdate() {
        Product product = restTemplate.getForObject(baseUri + "productsV2/2", Product.class);
        product.setPrice(20000);

        restTemplate.put(baseUri +"productsV2/update", product);
        System.out.println("UPDATED PRODCUT");
    }

    public void demoDelete() {
        restTemplate.delete(baseUri + "productsV2?deleteId=2");
        System.out.println("DELETED id=2");
    }

    public void demoGetAll() {
        ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<List<Product>>(){};

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                baseUri + "productsV2",
                HttpMethod.GET,
                null,
                responseType
        );

        System.out.println("GET ALL REQUEST");
        response.getBody().forEach(System.out::println);
    }
}
