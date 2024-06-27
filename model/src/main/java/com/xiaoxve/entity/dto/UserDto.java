package com.xiaoxve.entity.dto;

import com.xiaoxve.entity.domain.User;
import lombok.Data;


@Data
public class UserDto extends User {

    private String smsCode;

    private boolean isRememberMe;

}
