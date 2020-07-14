package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.Category;
import com.codegym.casestudy.repositories.ICategoryRepository;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createUser(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.delete(category);
        return category;
    }
}
