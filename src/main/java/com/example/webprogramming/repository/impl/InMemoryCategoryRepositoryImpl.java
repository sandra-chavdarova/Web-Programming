package com.example.webprogramming.repository.impl;

import com.example.webprogramming.bootstrap.DataHolder;
import com.example.webprogramming.model.Category;
import com.example.webprogramming.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepositoryImpl implements CategoryRepository {
    @Override
    public Optional<Category> findById(Long id) {
        return DataHolder.categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Category save(Category category) {
        delete(category.getId());
        DataHolder.categories.add(category);
        return category;
    }

    @Override
    public List<Category> findAll() {
        return DataHolder.categories;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return DataHolder.categories.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    @Override
    public List<Category> search(String text) {
        return DataHolder.categories.stream().filter(c -> c.getName().contains(text) || c.getDescription().contains(text)).toList();
    }

    @Override
    public void delete(String name) {
        DataHolder.categories.removeIf(c -> c.getName().equals(name));
    }

    @Override
    public void delete(Long id) {
        DataHolder.categories.removeIf(c -> c.getId().equals(id));
    }

}
