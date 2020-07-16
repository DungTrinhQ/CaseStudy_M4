package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.service.ICommentService;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    protected ICommentService iCommentService;

    @Autowired
    private IUserService userService;

    @GetMapping("/comments")
    public ModelAndView getCommnetsByBlogId() {
        ModelAndView mv = new ModelAndView("Comment");
        List<Comment> comments = (List<Comment>) iCommentService.findAll();
        mv.addObject("comments", comments);
        return mv;
    }

    @RequestMapping(value = "/createNewComment", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Comment createComment(@RequestBody Comment comment, Principal principal) {
        String userName = "";
        User user = null;
        if (principal != null) {
            userName = principal.getName();
            user = userService.findUserByUsername(userName);
        }
        comment.setUser(user);
        //comment.setUser(UserInLogin.userId);
        return iCommentService.createComment(comment);
    }
}
