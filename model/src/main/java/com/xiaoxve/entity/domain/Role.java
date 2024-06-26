package com.xiaoxve.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName role
 */
@TableName(value ="role")
@Data
public class Role implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}