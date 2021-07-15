package org.acme.products;

public class Product {

    private String id;
    
    private String name;

    private String description;

    private double price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }

    public static class Builder {

        private final Product product;

        public Builder(String id) {
            product = new Product();
            product.id = id;
        }

        public Builder name(String name) {
            product.name = name;
            return this;
        }

        public Builder description(String description) {
            product.description = description;
            return this;
        }

        public Builder price(double price) {
            product.price = price;
            return this;
        }

        public Product build() {
            return product;
        }

    }
    
}
