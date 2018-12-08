package com.uoa.di.csr.model.search;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DaySearchForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate time;

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
