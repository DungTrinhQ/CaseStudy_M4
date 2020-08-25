package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Role;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/sign-up")
    public ModelAndView getCreateUser() {
        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("user",new User());
        return mv;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("user") User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        Role role = new Role();
        role.setId(1L);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        user.setRoles(roleList);
        userService.createUser(user);

        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("message","Đăng ký thành công");
        return mv;
    }
}
