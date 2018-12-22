package com.uoa.di.csr.model.search;

import javax.validation.constraints.NotNull;

public class SingleNumberLimitSearchForm {

    @NotNull
    private Long limit;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
