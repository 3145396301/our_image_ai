package com.xiaoxve.user.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.xiaoxve.entity.domain.User;
import com.xiaoxve.entity.dto.UserDto;
import com.xiaoxve.exception.DefinitionException;
import com.xiaoxve.result.Result;
import com.xiaoxve.user.service.SMSService;
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

    @Resource
    private SMSService smsService;

    @Operation(summary = "发送验证码")
    @GetMapping("/sendSMS/{phoneNumber}")
    private Result sendSMS(@PathVariable("phoneNumber") String phoneNumber) {
        // 生成四位数随机数code
        String code = String.valueOf((Math.random()*9+1)*1000);
        smsService.sendSMS(phoneNumber,code);
        return Result.success();
    }


    @Operation(summary = "用户注册")
    @PostMapping("/register")
    private Result register(@RequestBody UserDto user) {
        userService.register(user);
        return Result.success();
    }

    @Operation(summary = "用户名查重")
    @GetMapping("/checkUsername/{username}")
    private Result checkUsername(@PathVariable("username") String username) {
        Boolean b = userService.checkUsername(username);
        return Result.success(b);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    private Result login(@RequestBody User user) {
        Boolean b = userService.login(user);
        return Result.success(b);
    }

    @Operation(summary = "退出登录")
    @GetMapping("/logout")
    private Result logout() {
        if (!StpUtil.isLogin()) {
            throw new DefinitionException(400,"用户未登录！");
        }
        StpUtil.logout();
        return Result.success();
    }



}
