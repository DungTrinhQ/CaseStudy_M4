package com.codegym.casestudy.services;

import com.codegym.casestudy.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    User findUserByUsername(String username);
    User findUserByUserId(Long id);
}
