package com.codegym.casestudy.controllers;

import com.codegym.casestudy.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("blogs",blogService.findAll());
        return mv;
    }


}
