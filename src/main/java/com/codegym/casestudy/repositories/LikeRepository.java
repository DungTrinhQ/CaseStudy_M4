package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Like;
import com.codegym.casestudy.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {
    Like findLikeByUser(User user);
}
