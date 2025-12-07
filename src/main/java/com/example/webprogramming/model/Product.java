package com.example.webprogramming.model;

import com.example.webprogramming.model.enums.ProductLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private ProductLevel level;
    private Category category;
    private Manufacturer manufacturer;

    public Product(String name, Double price, Integer quantity, ProductLevel level, Category category, Manufacturer manufacturer) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.level = level;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}
