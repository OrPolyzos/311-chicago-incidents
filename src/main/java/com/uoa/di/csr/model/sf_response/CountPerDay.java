package com.uoa.di.csr.model.sf_response;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CountPerDay {

    private LocalDateTime day;
    private BigInteger count;

    public CountPerDay(Object day, Object count) {
        this.day = ((Timestamp) day).toLocalDateTime();
        this.count = (BigInteger) count;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
