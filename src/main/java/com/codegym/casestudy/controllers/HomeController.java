package com.codegym.casestudy.controllers;

import com.codegym.casestudy.service.IBlogService;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("blogs",blogService.findAllByDateDesc());
        mv.addObject("categories", categoryService.findAll());
        return mv;
    }


}
