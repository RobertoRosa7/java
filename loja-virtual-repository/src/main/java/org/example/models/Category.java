package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final List<Product> products = new ArrayList<>();
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("A cagegoria:  %d, %s", this.id, this.name);
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
