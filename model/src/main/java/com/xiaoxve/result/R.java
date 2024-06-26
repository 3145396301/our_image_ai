package com.xiaoxve.result;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;


@Data
@Accessors(chain = true)
public class R<T>  {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_OK);
        r.setMsg("success");
        r.setData(data);
        return r;
    }
    public static <T> R<T> success(T data, String msg) {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_OK);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static <T> R<T> error(T data) {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        r.setMsg("error");
        r.setData(data);
        return r;
    }
    public static <T> R<T> error(T data, String msg) {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
