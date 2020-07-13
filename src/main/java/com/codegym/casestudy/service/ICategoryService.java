package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Category;
import com.codegym.casestudy.models.User;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findOne(Long id);
    Category createUser(Category category);
    Category delete(Long id);
}