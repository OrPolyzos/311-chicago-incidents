package com.uoa.di.csr.model.sf_response;

import java.math.BigInteger;

public class CountPerLicencePlate {

    private String licencePlate;
    private BigInteger count;

    public CountPerLicencePlate(Object licencePlate, Object count) {
        this.licencePlate = (String) licencePlate;
        this.count = (BigInteger) count;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
