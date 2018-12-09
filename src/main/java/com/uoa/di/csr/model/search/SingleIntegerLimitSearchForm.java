package com.uoa.di.csr.model.search;

import javax.validation.constraints.NotNull;

public class SingleIntegerLimitSearchForm {

    @NotNull
    private Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
