package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.User;
import com.codegym.casestudy.repositories.IUserRepository;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return user;
    }
}
