package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findUserByUsername(String username);
}
