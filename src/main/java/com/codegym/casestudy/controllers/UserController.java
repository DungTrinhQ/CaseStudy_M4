package com.codegym.casestudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/sign-up")
    public String getCreate() {
        return "signUp";
    }

}
