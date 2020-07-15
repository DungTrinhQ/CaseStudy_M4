package com.codegym.casestudy.service;

import com.codegym.casestudy.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findOne(Long id);
    User createUser(User user);
    User delete(Long id);
    User findUserByUsername(String username);
}
