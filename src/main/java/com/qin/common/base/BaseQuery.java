package com.qin.common.base;

import lombok.Data;

public class BaseQuery {
    //默认值
    private Integer page=1;
    private Integer limit=10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public BaseQuery(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public BaseQuery() {
    }
}
