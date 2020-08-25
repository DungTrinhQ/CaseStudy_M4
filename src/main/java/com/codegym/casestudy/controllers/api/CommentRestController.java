package com.codegym.casestudy.controllers.api;

import com.codegym.casestudy.models.Blog;
import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.service.IBlogService;
import com.codegym.casestudy.service.ICommentService;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/comments")
public class CommentRestController {
    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public List<Comment> getAllComment(){return (List<Comment>) iCommentService.findAll();}

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE,"application/x-www-form-urlencoded"})
    public Comment createComment(@PathVariable Long id ,@RequestBody Comment comment,Principal principal){
        String userName = "";
        User user = null;
        if (principal != null) {
            userName = principal.getName();
            user = userService.findUserByUsername(userName);
        }
        comment.setUser(user);
        Blog blog = blogService.findOne(id);
        comment.setBlog(blog);
        return iCommentService.save(comment);
    }

    @GetMapping(value = "/{blogId}")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable  Long blogId){
        List<Comment> comments = iCommentService.findAllByBlogId(blogId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


}