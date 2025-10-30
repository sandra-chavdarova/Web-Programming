package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.Category;
import com.example.webprogramming.repository.CategoryRepository;
import com.example.webprogramming.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category create(String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category category = new Category(name, description);
        return this.categoryRepository.save(category);
    }

    @Override
    public Category update(String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category category = new Category(name, description);
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(String name) {
        this.categoryRepository.delete(name);
    }

    @Override
    public List<Category> searchCategories(String text) {
        return this.categoryRepository.search(text);
    }
}
