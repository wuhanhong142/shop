package com.shop.exception;

import com.shop.CommonEnum;

/**
 * @author houkai
 */
public class FrontendBizException extends RuntimeException {


    public FrontendBizException(Integer code) {
        this.code = code;
    }

    public FrontendBizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public FrontendBizException(Integer special, Integer code, String message) {
        super(message);
        this.code = code;
        this.special = special;
    }

    public FrontendBizException(CommonEnum<Integer, String> commonEnum) {
        super(commonEnum.getName());
        this.code = commonEnum.getCode();
    }

    public FrontendBizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public FrontendBizException(Integer special, Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.special = special;
    }

    public FrontendBizException(CommonEnum<Integer, String> commonEnum, Throwable cause) {
        super(commonEnum.getName(), cause);
        this.code = commonEnum.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public Integer getSpecial() {
        return special;
    }

    private Integer code;

    private Integer special;

}
