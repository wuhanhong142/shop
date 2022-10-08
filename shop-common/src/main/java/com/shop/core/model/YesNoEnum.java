package com.shop.core.model;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.shop.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YesNoEnum implements CommonEnum<String, String> {

    TRUE("Y", "TRUE"), FALSE("N", "FALSE");

    @JsonValue
    @EnumValue
    private final String code;
    private final String name;
}
