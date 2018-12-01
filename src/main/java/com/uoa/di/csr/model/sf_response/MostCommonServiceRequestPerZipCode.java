package com.uoa.di.csr.model.sf_response;

import com.uoa.di.csr.domain.ServiceRequestType;

import java.math.BigInteger;

public class MostCommonServiceRequestPerZipCode {

    private BigInteger zipCode;
    private ServiceRequestType serviceRequestType;
    private BigInteger count;

    public MostCommonServiceRequestPerZipCode(Object zipCode, Object serviceRequestType, Object count) {
        this.zipCode = (BigInteger) zipCode;
        this.serviceRequestType = ServiceRequestType.reverseValue((String) serviceRequestType);
        this.count = (BigInteger) count;
    }

    public BigInteger getZipCode() {
        return zipCode;
    }

    public void setZipCode(BigInteger zipCode) {
        this.zipCode = zipCode;
    }

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
