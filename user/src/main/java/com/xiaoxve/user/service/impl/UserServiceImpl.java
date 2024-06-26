package com.xiaoxve.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxve.entity.domain.User;
import com.xiaoxve.exception.DefinitionException;
import com.xiaoxve.user.service.UserService;
import com.xiaoxve.user.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
* @author 86175
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-06-25 20:36:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {



    @Override
    public void register(User user) {
        if (user.getUsername()==null) {
            throw new DefinitionException(400,"用户名不能为空！");
        }

        if (user.getPassword()==null) {
            throw new DefinitionException(400,"密码不能为空！");
        }

        //

        // 保证密码安全
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encode);


    }
}




