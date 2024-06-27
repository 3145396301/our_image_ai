package com.xiaoxve.user.service;

import com.xiaoxve.entity.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxve.entity.dto.UserDto;

/**
* @author 86175
* @description 针对表【user】的数据库操作Service
* @createDate 2024-06-25 20:36:12
*/
public interface UserService extends IService<User> {

    void register(UserDto user);

    Boolean checkUsername(String username);

    Boolean login(User user);
}
