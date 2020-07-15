package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("")
    public List<Comment> getAllComment(){return (List<Comment>) iCommentService.findAll();}
    @PostMapping("")
    public Comment createComment(@RequestBody Comment comment){
        return iCommentService.save(comment);
    }



}
