package com.example.webprogramming.repository.impl;

import com.example.webprogramming.bootstrap.DataHolder;
import com.example.webprogramming.model.ShoppingCart;
import com.example.webprogramming.model.enums.ShoppingCartStatus;
import com.example.webprogramming.repository.ShoppingCartRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepositoryImpl implements ShoppingCartRepository {

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return DataHolder.shoppingCarts.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status) {
        return DataHolder.shoppingCarts.stream().filter(s -> s.getUser().getUsername().equals(username) && s.getStatus().equals(status)).findFirst();
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        DataHolder.shoppingCarts.removeIf(s -> s.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }
}
