package com.emotte.cloud.controller;

import com.emotte.cloud.app.user.emerp.model.User;
import com.emotte.cloud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @RequestMapping("/insert")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/insert2")
    public int addUser2(User user) {
        return userService.addUser2(user);
    }

    @RequestMapping("/insert3")
    public int addUser3(User user) {
        return userService.addUser3(user);
    }





}
