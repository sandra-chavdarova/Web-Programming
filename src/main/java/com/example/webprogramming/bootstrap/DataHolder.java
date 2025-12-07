package com.example.webprogramming.bootstrap;

import com.example.webprogramming.model.*;
import com.example.webprogramming.model.enums.ProductLevel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Category> categories = null;
    public static List<Manufacturer> manufacturers = null;
    public static List<Product> products = null;
    public static List<User> users = null;
    public static List<ShoppingCart> shoppingCarts = null;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category("Movies", "Movies Category"));
        categories.add(new Category("Books", "Books Category"));
        categories.add(new Category("Clothes", "Clothes Category"));

        manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Mango", "Spain"));
        manufacturers.add(new Manufacturer("Nike", "USA"));
        manufacturers.add(new Manufacturer("Amazon", "USA"));

        products = new ArrayList<>();
        products.add(new Product("Sneakers 1", 4300.00, 5, ProductLevel.NORMAL, categories.get(2), manufacturers.get(1)));
        products.add(new Product("Sneakers 2", 6300.00, 5, ProductLevel.SILVER, categories.get(2), manufacturers.get(1)));

        shoppingCarts = new ArrayList<>();

        users = new ArrayList<>();
        users.add(new User("sandra", "ch", "Sandra", "Chavdarova"));
        users.add(new User("kristina", "ch", "Kristina", "Chavdarova"));
    }
}

