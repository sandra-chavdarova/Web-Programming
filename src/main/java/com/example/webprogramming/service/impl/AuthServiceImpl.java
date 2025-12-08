package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.User;
import com.example.webprogramming.model.exceptions.InvalidArgumentsException;
import com.example.webprogramming.model.exceptions.InvalidUserCredentialsException;
import com.example.webprogramming.model.exceptions.PasswordsDoNotMatchException;
import com.example.webprogramming.repository.jpa.UserRepository;
import com.example.webprogramming.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username == null || username.isEmpty()
                || password == null || password.isEmpty()
                || repeatPassword == null || repeatPassword.isEmpty()
                || name == null || name.isEmpty()
                || surname == null || surname.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        return this.userRepository.save(new User(username, password, name, surname));
    }
}
