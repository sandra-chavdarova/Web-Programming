package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.Category;
import com.example.webprogramming.model.exceptions.CategoryNotFoundException;
import com.example.webprogramming.repository.jpa.CategoryRepository;
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
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
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
    public Category update(Long id, String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category category = new Category(name, description);
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> searchCategories(String text) {
        return this.categoryRepository.findAllByNameContainingIgnoreCaseOrDescriptionLikeIgnoreCase(text, text);
    }
}
