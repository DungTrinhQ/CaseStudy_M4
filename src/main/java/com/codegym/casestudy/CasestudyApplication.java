package com.codegym.casestudy;

import com.codegym.casestudy.config.CustomUserDetails;
import com.codegym.casestudy.models.Role;
import com.codegym.casestudy.models.User;
import com.codegym.casestudy.repositories.UserRepository;
import com.codegym.casestudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class CasestudyApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }


    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService) throws Exception {
        if (repository.count()==0)
            userService.save(new User("admin", "adminPassword", Arrays.asList(new Role("USER"), new Role("ACTUATOR") , new Role("ADMIN"))));
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }


    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }

}
