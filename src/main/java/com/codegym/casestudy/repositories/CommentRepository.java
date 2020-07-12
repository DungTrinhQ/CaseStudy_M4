package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
}