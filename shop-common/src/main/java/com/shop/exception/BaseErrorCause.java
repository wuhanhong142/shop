package com.shop.exception;

import com.shop.CommonEnum;

public enum BaseErrorCause implements CommonEnum<Integer, String> {

    SUCCESS(200, "SUCCESS", "请求处理成功"),
    ILLEGAL_PARAMETER(400, "ILLEGAL_PARAMETER", "请求参数错误"),
    TOKEN_ERROR(401, "TOKEN_ERROR", "请登录"),
    SYSTEM_EXCEPTION(500, "SYSTEM_EXCEPTION", "系统异常:%s"),
    CONFIRM_EXCEPTION(701, "CONFIRM_EXCEPTION", "确认提示"),
    BIZ_EXCEPTION(600, "BIZ_EXCEPTION", "业务异常:%s");

    BaseErrorCause(Integer code, String name, String messagePattern) {
        this.code = code;
        this.name = name;
        this.messagePattern = messagePattern;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getMessagePattern() {
        return messagePattern;
    }

    private final Integer code;

    private final String name;

    private final String messagePattern;


}
