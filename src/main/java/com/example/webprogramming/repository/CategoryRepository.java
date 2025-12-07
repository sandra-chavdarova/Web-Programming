package com.example.webprogramming.repository;

import com.example.webprogramming.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);

    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findByName(String name);

    List<Category> search(String text);

    void delete(String name);

    void delete(Long id);
}
