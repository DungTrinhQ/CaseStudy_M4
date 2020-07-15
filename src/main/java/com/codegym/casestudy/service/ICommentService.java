package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Comment;
import java.util.List;

public interface ICommentService {
    Iterable<Comment> findAll();
    List<Comment> findAllByBlog();
    Comment findOne(Long id);
    Comment createComment(Comment comment);
    Comment delete(Long id);
    Comment save(Comment comment);
}
