package com.xiaoxve.user.controller;


import com.xiaoxve.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author y1ng
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;


//    @PostMapping("/register")
//    private



}
