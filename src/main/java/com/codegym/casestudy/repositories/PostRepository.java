package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Post;
import com.codegym.casestudy.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    List<Post> findAllByUser(User user);
}
