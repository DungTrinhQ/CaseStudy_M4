package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Post;
import com.codegym.casestudy.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private PostService postService;



    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }




}
