package com.shop.core.model;

import lombok.Data;

import java.util.Map;

@Data
public class ViewPageDTO {
    private String op;
    private String viewName;
    private Map<String, Object> data;
}
