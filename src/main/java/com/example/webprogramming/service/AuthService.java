package com.example.webprogramming.service;

import com.example.webprogramming.model.User;

public interface AuthService {
    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname);
}
