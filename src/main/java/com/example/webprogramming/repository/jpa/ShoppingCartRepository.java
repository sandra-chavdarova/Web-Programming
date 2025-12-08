package com.example.webprogramming.repository.jpa;

import com.example.webprogramming.model.ShoppingCart;
import com.example.webprogramming.model.User;
import com.example.webprogramming.model.enums.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus shoppingCartStatus);
}
