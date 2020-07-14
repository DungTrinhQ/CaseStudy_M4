package com.codegym.casestudy.service;

import com.codegym.casestudy.models.Comment;
import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findOne(Long id);
    Comment createComment(Comment comment);
    Comment delete(Long id);
}
