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