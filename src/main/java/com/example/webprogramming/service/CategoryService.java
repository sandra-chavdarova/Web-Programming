package com.example.webprogramming.service;

import com.example.webprogramming.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();

    Category create(String name, String description);

    Category update(String name, String description);

    void delete(String name);

    List<Category> searchCategories(String text);
}
