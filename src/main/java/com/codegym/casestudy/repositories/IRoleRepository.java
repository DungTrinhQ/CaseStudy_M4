package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Long> {
}
