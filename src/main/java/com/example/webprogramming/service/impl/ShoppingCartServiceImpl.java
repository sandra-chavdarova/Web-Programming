package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.Product;
import com.example.webprogramming.model.ShoppingCart;
import com.example.webprogramming.model.User;
import com.example.webprogramming.model.enums.ShoppingCartStatus;
import com.example.webprogramming.model.exceptions.ProductAlreadyInShoppingCartException;
import com.example.webprogramming.model.exceptions.ShoppingCartNotFoundException;
import com.example.webprogramming.model.exceptions.UserNotFoundException;
import com.example.webprogramming.repository.jpa.ShoppingCartRepository;
import com.example.webprogramming.repository.jpa.UserRepository;
import com.example.webprogramming.service.ProductService;
import com.example.webprogramming.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = userRepository.findByUsernameIgnoreCase(username).orElseThrow(() -> new UserNotFoundException(username));
        return this.shoppingCartRepository.findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId);
        if (shoppingCart.getProducts().stream().anyMatch(i -> i.getId().equals(productId)))
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
