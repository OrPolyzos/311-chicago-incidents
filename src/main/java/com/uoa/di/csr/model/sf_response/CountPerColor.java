package com.uoa.di.csr.model.sf_response;

import java.math.BigInteger;

public class CountPerColor {

    private String color;
    private BigInteger count;

    public CountPerColor(Object color, Object count) {
        this.color = (String) color;
        this.count = (BigInteger) count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
