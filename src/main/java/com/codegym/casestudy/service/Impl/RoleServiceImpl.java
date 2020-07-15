package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.Role;
import com.codegym.casestudy.repositories.IRoleRepository;
import com.codegym.casestudy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
