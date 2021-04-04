package com.misumi.service.internal_trainserver.handler;

public enum ResponseEnum {
    /**
     * 请求成功
     */
    SUCCESS(10000, "ok"),
    /**
     * 前台请求参数错误
     */
    BAD_REQUEST_PARAMETER(10001, "请求参数不符合规定"),
    /**
     * 请求错误
     */
    BAD_REQUEST(10002, "请求错误"),
    /**
     * 请求的Content-Type错误
     */
    MEDIA_TYPE_NOT_SUPPORTED(10003, "请求的Content-Type错误"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(10004,"服务器错误"),

    /**
     * 用户验证错误
     */
    USER_BAD_REQUEST(10005,"用户验证错误"),
    /**
     * 错误的ID
     */
    BAD_ID(10006,"签名错误"),
    /**
     * 操作失败
     */
    RUN_ERROR(10007,"操作失败！");

    private Integer rtn;
    private String message;

    ResponseEnum(Integer rtn, String message) {
        this.rtn = rtn;
        this.message = message;
    }

    public Integer getRtn() {
        return rtn;
    }

    public String getMessage() {
        return message;
    }
}
