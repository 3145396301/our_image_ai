package com.xiaoxve.user.exception;

import com.xiaoxve.enumerate.ErrorEnum;
import com.xiaoxve.exception.DefinitionException;
import com.xiaoxve.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义异常
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result bizExceptionHandler(DefinitionException e) {
        e.printStackTrace();
        return Result.defineError(e);
    }


    // 处理其他异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler( Exception e) {
        e.printStackTrace();
        return Result.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
