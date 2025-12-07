package com.example.webprogramming.service;

import com.example.webprogramming.model.Product;
import com.example.webprogramming.model.ShoppingCart;

import java.util.*;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
