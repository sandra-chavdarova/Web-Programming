package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.Category;
import com.example.webprogramming.model.Manufacturer;
import com.example.webprogramming.model.Product;
import com.example.webprogramming.model.enums.ProductLevel;
import com.example.webprogramming.model.exceptions.ProductNotFoundException;
import com.example.webprogramming.repository.ProductRepository;
import com.example.webprogramming.service.CategoryService;
import com.example.webprogramming.service.ManufacturerService;
import com.example.webprogramming.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ManufacturerService manufacturerService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product create(String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId) {
        Category category = categoryService.findById(categoryId);
        Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
        Product product = new Product(name, price, quantity, level, category, manufacturer);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, String name, Double price, Integer quantity, ProductLevel level, Long categoryId, Long manufacturerId) {
        Product product = findById(id);
        Category category = categoryService.findById(categoryId);
        Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setLevel(level);
        product.setCategory(category);
        product.setManufacturer(manufacturer);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> search(String text) {
        return productRepository.search(text);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
