package com.uoa.di.csr.model.sf_response;

import com.uoa.di.csr.domain.ServiceRequestType;

import java.math.BigInteger;

public class CountPerServiceRequest {

    private ServiceRequestType serviceRequestType;
    private BigInteger count;

    public CountPerServiceRequest(Object serviceRequestType, Object count) {
        this.serviceRequestType = ServiceRequestType.reverseValue((String) serviceRequestType);
        this.count = (BigInteger) count;
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
