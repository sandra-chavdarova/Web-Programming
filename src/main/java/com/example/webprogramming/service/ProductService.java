package com.example.webprogramming.service;

import com.example.webprogramming.model.Product;
import com.example.webprogramming.model.enums.ProductLevel;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    Product create(String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId);

    Product update(Long id, String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId);

    List<Product> findAll();

    List<Product> search(String text);

    void delete(Long id);
}
