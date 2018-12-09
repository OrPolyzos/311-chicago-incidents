package com.uoa.di.csr.model.sf_response;

import java.math.BigInteger;

public class CountPerSsa {

    private BigInteger ssa;
    private BigInteger count;

    public CountPerSsa(Object ssa, Object count) {
        this.ssa = (BigInteger) ssa;
        this.count = (BigInteger) count;
    }

    public BigInteger getSsa() {
        return ssa;
    }

    public void setSsa(BigInteger ssa) {
        this.ssa = ssa;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
