package com.example.webprogramming.repository;

import com.example.webprogramming.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    List<Product> search(String text);

    void delete(Long id);
}
