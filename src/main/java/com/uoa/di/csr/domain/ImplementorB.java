package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "implementor_b")
public class ImplementorB extends ServiceRequest {

    @Column(name = "columnA")
    private String columnA;

    @Column(name = "columnB")
    private String columnB;

    public String getColumnA() {
        return columnA;
    }

    public void setColumnA(String columnA) {
        this.columnA = columnA;
    }

    public String getColumnB() {
        return columnB;
    }

    public void setColumnB(String columnB) {
        this.columnB = columnB;
    }
}
