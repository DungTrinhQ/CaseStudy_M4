package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<Comment,Long> {
}
