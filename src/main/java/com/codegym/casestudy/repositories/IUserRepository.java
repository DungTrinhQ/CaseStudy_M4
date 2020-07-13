package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
}
