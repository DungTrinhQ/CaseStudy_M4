package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Blog;
import com.codegym.casestudy.service.IBlogService;
import com.codegym.casestudy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICommentService icommentService;
    @GetMapping("/blog/{id}")
    public ModelAndView getBlogDetail(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("blogDetail");
        mv.addObject("blogs",blogService.findOne(id));
//        mv.addObject("comments",commentService.findAll());
        // phải get them cả list cmt trong DB theo ID blog. r add vào object Mv
        //mv.addObject("comments");
        return mv;
    }


    @GetMapping("/blogCategory")
    public String getCategoryBlog() {
        return "category";
    }

    @GetMapping("/createBlog")
    public ModelAndView createBlog() {
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("blog",new Blog());
        return mv;
    }
    @PostMapping("/save-Blog")
    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
        blogService.createBlog(blog);
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("message","New Post created successfully");
        return mv;
    }
    @GetMapping("/searchBlog")
    public ModelAndView getSearch(@ModelAttribute("keyWord") String keyWord) {
        ModelAndView mv = new ModelAndView("home");
        List<Blog> blogs = (List) blogService.findAllByTitleLike(keyWord);
        mv.addObject("blogs",blogs);
        return mv;
    }
    @GetMapping("/blog/edit/{id}")
    public ModelAndView getEditBlog(@PathVariable Long id) {
        Blog blog = blogService.findOne(id);
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("blog",blog);
        return mv;
    }

}
