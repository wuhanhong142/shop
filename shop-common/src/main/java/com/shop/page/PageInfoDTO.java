package com.shop.page;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageInfoDTO<T> {

    protected long current;
    protected long size;
    protected long total;
    protected List<T> records;
}
