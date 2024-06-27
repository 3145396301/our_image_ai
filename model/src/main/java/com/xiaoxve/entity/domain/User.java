package com.xiaoxve.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 性别 0未知 1男 2女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 注册日期
     */
    private Date registerDate;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 手机号码
     */
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}