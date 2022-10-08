package com.shop.page;


import com.shop.exception.BaseErrorCause;
import lombok.Data;

import java.util.Objects;

@Data
public class ApiData<T> {
    private Integer errCode;
    private String errMsg;
    private T data;
    private Integer code;

    public boolean checkSuccessErrCode() {
        if (!BaseErrorCause.SUCCESS.getCode().equals(this.errCode) || Objects.isNull(this.data)) {
            return false;
        }

        return true;
    }

    public boolean checkSuccessCode200() {
        if (!BaseErrorCause.SUCCESS.getCode().equals(this.code) || Objects.isNull(this.data)) {
            return false;
        }
        return true;
    }

    public boolean checkSuccessCode0() {
        if (this.code != 0 || Objects.isNull(this.data)) {
            return false;
        }
        return true;
    }

    public  static <T> ApiData<T> success(T data) {
        ApiData<T> apiData = new ApiData<T>();
        apiData.setCode(BaseErrorCause.SUCCESS.getCode());
        apiData.setErrCode(BaseErrorCause.SUCCESS.getCode());
        apiData.setErrMsg(BaseErrorCause.SUCCESS.getMessagePattern());
        apiData.setData(data);
        return apiData;
    }

    public  static <T> ApiData<T> fail(int errCode, String errMsg) {
        ApiData<T> apiData = new ApiData<T>();
        apiData.setCode(errCode);
        apiData.setErrCode(errCode);
        apiData.setErrMsg(errMsg);
        return apiData;
    }

    public  static <T> ApiData<T> fail(BaseErrorCause cause) {
        ApiData<T> apiData = new ApiData<T>();
        apiData.setErrCode(cause.getCode());
        apiData.setCode(cause.getCode());
        apiData.setErrMsg(cause.getMessagePattern());
        return apiData;
    }

    public  static <T> ApiData<T> fail(BaseErrorCause cause, String errMsg) {
        ApiData<T> apiData = new ApiData<T>();
        apiData.setErrCode(cause.getCode());
        apiData.setCode(cause.getCode());
        apiData.setErrMsg(String.format(cause.getMessagePattern(), errMsg));
        return apiData;
    }

    public  static <T> ApiData<T> fail(BaseErrorCause cause, Object ...errMsg) {
        ApiData<T> apiData = new ApiData<T>();
        apiData.setErrCode(cause.getCode());
        apiData.setCode(cause.getCode());
        apiData.setErrMsg(String.format(cause.getMessagePattern(), errMsg));
        return apiData;
    }
}
