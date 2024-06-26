package com.xiaoxve.result;

import com.xiaoxve.enumerate.ErrorEnum;
import com.xiaoxve.exception.DefinitionException;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Result<T>  {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private T data;
    public Result() {

    }
    //自定义返回结果的构造方法
    public Result(Boolean success,Integer code, String msg,T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    // success
    public static Result success(Object data) {
        Result result = new Result<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static Result
    success() {
        Result result = new Result<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(null);
        return result;
    }

    //自定义异常返回的结果
    public static Result defineError(DefinitionException de){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }
    //其他异常处理方法返回的结果
    public static Result otherError(ErrorEnum errorEnum){
        Result result = new Result();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
}
