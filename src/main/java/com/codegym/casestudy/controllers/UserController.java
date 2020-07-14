package com.codegym.casestudy.controllers;

import com.codegym.casestudy.Pojos.UserRegistration;
import com.codegym.casestudy.models.Role;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class UserController {

}
