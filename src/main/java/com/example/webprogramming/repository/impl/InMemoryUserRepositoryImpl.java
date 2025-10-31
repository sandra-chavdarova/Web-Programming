package com.example.webprogramming.repository.impl;

import com.example.webprogramming.bootstrap.DataHolder;
import com.example.webprogramming.model.User;
import com.example.webprogramming.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
    }

    @Override
    public User save(User user) {
        DataHolder.users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    @Override
    public void deleteByUsername(String username) {
        DataHolder.users.removeIf(u -> u.getUsername().equals(username));
    }
}
