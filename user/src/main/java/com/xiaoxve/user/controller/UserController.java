package com.xiaoxve.user.controller;


import com.xiaoxve.entity.domain.User;
import com.xiaoxve.result.Result;
import com.xiaoxve.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author y1ng
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;



    @Operation(summary = "用户注册")
    @PostMapping("/register")
    private Result register(@RequestBody User user) {
        userService.register(user);
        return Result.success();
    }



}
