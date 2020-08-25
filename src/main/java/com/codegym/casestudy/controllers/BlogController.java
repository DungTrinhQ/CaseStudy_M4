package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Blog;
import com.codegym.casestudy.models.Category;
import com.codegym.casestudy.models.Comment;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.service.IBlogService;
import com.codegym.casestudy.service.ICategoryService;
import com.codegym.casestudy.service.ICommentService;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICommentService commentService;
    @GetMapping("{id}")
    public ModelAndView getBlogDetail(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("blogDetail");
        mv.addObject("blogs",blogService.findOne(id));
        return mv;
    }

    @GetMapping("category")
    public String getCategoryBlog() {
        return "category";
    }

    @GetMapping("create")
    public ModelAndView createBlog() {
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("blog", new Blog());
        return mv;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute("blog") Blog blog, Principal principal) {
        String userName = "";
        User user = null;
        if (principal != null) {
            userName = principal.getName();
            user = userService.findUserByUsername(userName);
        }
        blog.setUser(user);
        blogService.createBlog(blog);
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("message","New Post created successfully");
        return mv;
    }

    @GetMapping("search")
    public ModelAndView getSearch(@ModelAttribute("keyWord") String keyWord) {
        ModelAndView mv = new ModelAndView("home");
        Iterable<Blog> blogs = (Iterable) blogService.findAllByTitleLike(keyWord);
        mv.addObject("blogs", blogs);
        return mv;
    }

    @GetMapping("edit/{id}")
    public ModelAndView getEditBlog(@PathVariable Long id) {
        Blog blog = blogService.findOne(id);
        ModelAndView mv = new ModelAndView("form-Post");
        mv.addObject("blog", blog);
        return mv;
    }

    @GetMapping("category/{category_id}")
    public ModelAndView getSearchBlogByCategory(@PathVariable("category_id") Long category_id) {
        ModelAndView mv = new ModelAndView("home");
        Iterable<Blog> blogs = (Iterable) blogService.findAllByCategoryContainingOrderByPostTimeDesc(category_id);
        mv.addObject("blogs", blogs);
        return mv;
    }
    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }
}
