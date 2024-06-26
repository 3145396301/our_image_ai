package com.xiaoxve.enumerate;

public enum ErrorEnum {
    // 数据操作错误定义
    NO_PERMISSION(403,"没有权限~"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器跑路了"),
    ;

    /** 错误码 */
    private Integer errorCode;

    /** 错误信息 */
    private String errorMsg;

    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
