package com.eergeek.restservices;

record Product(long id, String description, double price) {
    // Constructor without id field
    public Product(String description, double price) {
        this(0, description, price); // Assuming 0 as a default value for id
    }

    public Product withId(Long id) {
        return new Product(id, this.description, this.price);
    }
}

/***

public class Product {
    private int id;
    private String description;
    private double price;

        public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
 *
 */