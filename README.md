### For below `produces` to work it requires `fasterxml` dependency included in `pom.xml`

```java
    @GetMapping(value = "/productsV1", produces = MediaType.APPLICATION_XML_VALUE)
    public Collection<Product> getProductsV1() {
        return catalog.values();
    }
```

### Where this works without any additional dependency in spring-web out of the Box
#### But `@ResponseBody` is required as return type is not `ResposneEntity' instead a `Collection'
#### Even mediatype as well not specified still it will return `JSON` reponse
```java
    @GetMapping(value = "/productsV1")
    @ResponseBody
    public Collection<Product> getProductsV1() {
        return catalog.values();
        }
```


## Path Variable
#### Below snippet would work with url like the one below, notice `/productsV2/1`
**http://localhost:8080/simple/productsV2/1**
```java
@GetMapping(value = "/productsV2/{id}")
public ResponseEntity<Product> getProduct(@PathVariable long id) {}
```

## Optional Request Parameters in URL body
#### Where as below snippet has *Optional* Request parameter *minprice*
#### URL: http://localhost:8080/simple/productsV2?minprice=10000
```java
    @GetMapping(value = "/productsV2")
    public ResponseEntity<List<Product>> getProductsWithMinPrice(
            @RequestParam(value = "minprice", required = false, defaultValue = "0")
            double price) { }
```