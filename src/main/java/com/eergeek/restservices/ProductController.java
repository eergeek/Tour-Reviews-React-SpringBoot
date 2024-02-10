package com.eergeek.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/simple")
@CrossOrigin
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository catalog;

    @GetMapping(value = "/hi")
    @ResponseBody
    public String welcome() {
        return "Hey Welcome";
    }

    @GetMapping(value = "/productsV1")
    @ResponseBody
    public Collection<Product> getProductsV1() {
        logger.info("Handling /simple/productsV1 request");
        return catalog.getAll();
    }

    @GetMapping(value = "/productsV2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Product>> getProductsV2() {
        logger.info("Handling /simple/productsV2 request");

        return ResponseEntity.ok(catalog.getAll());
    }

    @GetMapping(value = "/productsV2/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = catalog.getById(id);
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

        List<Product> products = catalog.getAll().stream()
                .filter(product -> product.price() > price)
                .toList();

        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "/productsV2/addnew")
    public ResponseEntity<Boolean> addProduct(@RequestBody Product product) {
        boolean insertedProduct = catalog.insert(product);
        return insertedProduct
                ? ResponseEntity.created(URI.create("addnew/")).body(insertedProduct)
                : ResponseEntity.internalServerError().build();
    }

    @DeleteMapping(value = "/productsV2")
    public ResponseEntity<Boolean> deleteProduct(
            @RequestParam(value = "deleteId", required = true, defaultValue = "")
            long id) {
        boolean deleted = catalog.delete(id);
        return deleted ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }

    @PutMapping(value = "productsV2/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody Product updatedProduct) {
        boolean updated = catalog.update(updatedProduct);
        return updated ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
