package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    protected ICommentService iCommentService;

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
    public Comment createComment(@RequestBody Comment comment) {
        //comment.setUser(UserInLogin.userId);
        return iCommentService.createComment(comment);
    }
}
