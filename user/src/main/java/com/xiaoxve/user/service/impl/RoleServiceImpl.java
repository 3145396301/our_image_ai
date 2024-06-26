package com.xiaoxve.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxve.entity.domain.Role;
import com.xiaoxve.user.service.RoleService;
import com.xiaoxve.user.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 86175
* @description 针对表【role】的数据库操作Service实现
* @createDate 2024-06-25 20:36:12
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

}




