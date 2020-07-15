package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> findAllByBlog_Id(Long blogId);
}
