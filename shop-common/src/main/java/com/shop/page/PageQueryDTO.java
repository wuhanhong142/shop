package com.shop.page;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PageQueryDTO<T> implements Serializable {

    @NotNull(message = "页码")
    private Integer pageNo = 1;

    @NotNull(message = "分页大小")
    private Integer pageSize = 10;

    private long total;

    private int start;

    @Valid
    @NotNull(message = "查询参数不能为null,可为空对象")
    private T param;

    @NotNull(message = "不需要分页查询")
    private boolean notNeedPageQuery = false;

    private SortedParamDTO sortParam = new SortedParamDTO();

    public int getStart() {
        start = (pageNo - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        return start;
    }

}
