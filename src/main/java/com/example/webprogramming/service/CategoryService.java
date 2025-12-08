package com.example.webprogramming.service;

import com.example.webprogramming.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();

    Category findById(Long id);

    Category create(String name, String description);

    Category update(Long id, String name, String description);

    void delete(Long id);

    List<Category> searchCategories(String text);
}
