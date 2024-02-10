package com.eergeek.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Repository
public class ProductRepository {

    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);
    private HashMap<Long, Product> productHashMap = new HashMap<>();
    private static long nextId = 1;

    /**
     * This is a static block to initialize the catalog map
     * NOTE: THIS BLOCK IS OUTSIDE ANY METHOD, YET WORKS
     */ {
        insert(new Product("Tenth Product", 10.10));
        insert(new Product("Eleventh Product", 11.11));
        insert(new Product("Twelth Product", 12.12));

        log.info("Static Block Loaded {}", productHashMap);
    }

    public Collection<Product> getAll() {
        return productHashMap.values();
    }

    public Product getById(long id) {
        return productHashMap.get(id);
    }

    public boolean insert(Product product) {
        long id = nextId++;
        Product withIdProduct = product.withId(id);
        Product existing = productHashMap.put(id, withIdProduct);

        if (Objects.isNull(existing)) {
            log.info("++ inserted product: {}", withIdProduct);
            return true;
        }

        log.warn("replaced existing product {}", existing);
        return false;
    }

    public boolean update(Product product) {
        Product existing;
        if (productHashMap.containsKey(product.id())) {
            existing = productHashMap.put(product.id(), product);

            log.info("++ updated product: {}", existing);
            return true;
        }

        log.warn("product update failed, product: {}", product);
        return false;
    }

    public boolean delete(long id) {
        Product product = productHashMap.get(id);

        if (productHashMap.containsKey(id)) {
            productHashMap.remove(id);

            log.info("-- deleted product: {}", product);
            return true;
        }

        log.warn("product deletion failed, product: {}", product);
        return false;
    }
}
