package com.eergeek.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/simple")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private Map<Long, Product> catalog = new HashMap<>();

    /**
     * This is a static block to initialize the catalog map
     * NOTE: THIS BLOCK IS OUTSIDE ANY METHOD, YET WORKS
     */ {
        catalog = Map.of(
                1L, new Product(1, "Jockey Shoes", 3000),
                2L, new Product(2, "Black phone", 30000),
                3L, new Product(3, "Headphone", 400),
                4L, new Product(4, "Old Cars", 100),
                5L, new Product(5, "Air plane", 10)
        );
    }

    @GetMapping(value = "/hi")
    @ResponseBody
    public String welcome() {
         return "Hey Welcome";
    }

    @GetMapping(value = "/productsV1")
    @ResponseBody
    public Collection<Product> getProductsV1() {
        logger.info("Handling /simple/productsV1 request");
        return catalog.values();
    }

    @GetMapping(value = "/productsV2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Product>> getProductsV2() {
        logger.info("Handling /simple/productsV2 request");

        return ResponseEntity.ok(catalog.values());
    }

}
