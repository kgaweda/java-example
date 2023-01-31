package com.example.javaexmaple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaexmaple.model.User;
import com.example.javaexmaple.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<User> returnAllUser(){
        return userService.getUsers();
    }
}
