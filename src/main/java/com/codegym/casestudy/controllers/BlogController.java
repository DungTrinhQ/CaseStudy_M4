package com.codegym.casestudy.controllers;

import com.codegym.casestudy.Pojos.CommentPojo;
import com.codegym.casestudy.config.CustomUserDetails;
import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.models.Post;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.services.CommentService;
import com.codegym.casestudy.services.PostService;
import com.codegym.casestudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private PostService postService;



}
