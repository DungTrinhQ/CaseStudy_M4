package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.repositories.ICommentRepository;
import com.codegym.casestudy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return (List<Comment>)commentRepository.findAll();
    }

    @Override
    public Comment findOne(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment delete(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        commentRepository.delete(comment);
        return comment;
    }
}
