package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CommentRestController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("/api/comments")
    public List<Comment> getAllComment(){return (List<Comment>) iCommentService.findAll();}
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody Comment comment){
        return iCommentService.save(comment);
    }

    @GetMapping("/api/comments/{blogId}")
    public List<Comment> getAllComment(@PathVariable  Long blogId){return iCommentService.findAllByBlogId(blogId);}


}
