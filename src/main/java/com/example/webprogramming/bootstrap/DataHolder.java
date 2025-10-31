package com.example.webprogramming.bootstrap;

import com.example.webprogramming.model.Category;
import com.example.webprogramming.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Category> categories = null;
    public static List<User> users = null;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category("Movies", "Movies Category"));
        categories.add(new Category("Books", "Books Category"));

        users = new ArrayList<>();
        users.add(new User("sandra", "ch", "Sandra", "Chavdarova"));
    }
}
