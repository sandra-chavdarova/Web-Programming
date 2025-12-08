package com.example.webprogramming.repository.mock.impl;

import com.example.webprogramming.bootstrap.DataHolder;
import com.example.webprogramming.model.Product;
import com.example.webprogramming.repository.mock.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {

    @Override
    public Optional<Product> findById(Long id) {
        return DataHolder.products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Product save(Product product) {
        DataHolder.products.removeIf(p -> p.getId().equals(product.getId()));
        DataHolder.products.add(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return DataHolder.products;
    }

    @Override
    public List<Product> search(String text) {
        return DataHolder.products.stream().filter(p -> p.getName().toLowerCase().contains(text.toLowerCase())
                || p.getLevel().toString().toLowerCase().contains(text.toLowerCase())
                || p.getCategory().getName().toLowerCase().contains(text.toLowerCase())
                || p.getManufacturer().getName().toLowerCase().contains(text.toLowerCase())
        ).toList();
    }

    @Override
    public void delete(Long id) {
        DataHolder.products.removeIf(p -> p.getId().equals(id));
    }
}
