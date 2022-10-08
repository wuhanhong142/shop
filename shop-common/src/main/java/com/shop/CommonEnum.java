package com.shop;

/**
 * 枚举通用接口
 *
 * @author houkai
 */
public interface CommonEnum<T, K> {

    /**
     * 获取枚举代码值
     *
     * @return T
     */
    T getCode();

    /**
     * 获取枚举说明
     *
     * @return T
     */
    K getName();
}
