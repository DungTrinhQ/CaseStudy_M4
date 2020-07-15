package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.User;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/sign-up")
    public ModelAndView getCreateUser() {
        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("user",new User());
        return mv;
    }

    @PostMapping("/save-User")
    public ModelAndView save(@ModelAttribute("user") User user) {
        userService.createUser(user);
        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("message","Đăng ký thành công");
        return mv;
    }
}
