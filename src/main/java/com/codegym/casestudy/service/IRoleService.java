package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    Role findById(Long id);

    void save(Role role);

    void remove(Long id);
}
