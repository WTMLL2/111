package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User findByUsername(String username);
    User findById(Long id);
    List<User> findAll();
    User update(User user);
    void delete(Long id);
}
