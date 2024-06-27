package com.xiaoxve.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxve.entity.domain.User;
import com.xiaoxve.entity.dto.UserDto;
import com.xiaoxve.exception.DefinitionException;
import com.xiaoxve.user.service.UserService;
import com.xiaoxve.user.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author 86175
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-06-25 20:36:12
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public void register(UserDto user) {

        //参数校验
        checkParams(user);

        // 验证码校验
        if (!user.getSmsCode().equals((String) redisTemplate.opsForValue().get("phone:" + user.getPhone()))) {
            throw new DefinitionException(400, "验证码错误！");
        }

        // 保证密码安全
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encode);

        user.setRegisterDate(new Date());
        user.setRoleName("user");

        // 保存用户到数据库
        this.save(user);
    }


    @Override
    public Boolean checkUsername(String username) {
        User one = this.getOne(new QueryWrapper<User>().eq("username", username));
        return one == null;
    }

    @Override
    public Boolean login(User user) {

        // 参数校验
        checkParams(user);

        // 查询用户
        User one = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));

        if (one == null) {
            throw new DefinitionException(400, "用户名不存在！");
        }

        // 密码校验
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(user.getPassword(),one.getPassword())) {
            throw new DefinitionException(400,"密码错误，请稍后重试");
        }

        StpUtil.login(one.getId());
        return true;
    }


    /**
     * 参数校验
     */
    private static void checkParams(User user) {

        Pattern usernamePattern = Pattern.compile("^.{6,}$");
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z]).{8,}$");

        if (user.getUsername() == null) {
            throw new DefinitionException(400, "用户名不能为空！");
        }

        if (!usernamePattern.matcher(user.getUsername()).matches()) {
            throw new DefinitionException(400, "用户名长度不能小于6！");
        }

        if (user.getPassword() == null) {
            throw new DefinitionException(400, "密码不能为空！");
        }

        if (!passwordPattern.matcher(user.getPassword()).matches()) {
            throw new DefinitionException(400, "密码必须包含一个字母，且长度不能小于8！");
        }
    }
}




