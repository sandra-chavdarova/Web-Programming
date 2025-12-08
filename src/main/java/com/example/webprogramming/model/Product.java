package com.example.webprogramming.model;

import com.example.webprogramming.model.enums.ProductLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private ProductLevel level;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Manufacturer manufacturer;

    private boolean active = true;

    public Product(
            String name, Double price, Integer quantity, ProductLevel productLevel,
            Category category, Manufacturer manufacturer
    ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.level = productLevel;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}

