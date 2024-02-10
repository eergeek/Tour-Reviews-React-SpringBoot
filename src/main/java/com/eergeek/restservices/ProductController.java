package com.eergeek.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

        logger.info("Static Block Loaded {}", catalog);
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

    @GetMapping(value = "/productsV2/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = catalog.get(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }

        return ResponseEntity.notFound().build();
    }


    /***
     *
     * @param price
     * @return products having price greater than minpirce
     * URL: http://localhost:8080/simple/productsV2?minprice=10000
     */
    @GetMapping(value = "/productsV2")
    public ResponseEntity<List<Product>> getProductsWithMinPrice(
            @RequestParam(value = "minprice", required = false, defaultValue = "0")
            double price) {

        List<Product> products = catalog.values().stream()
                .filter(product -> product.price() > price)
                .toList();

        return ResponseEntity.ok(products);
    }
}
