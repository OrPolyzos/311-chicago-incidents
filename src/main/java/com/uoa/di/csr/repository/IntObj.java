package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequestType;

public class IntObj {

    private ServiceRequestType serviceRequestType;
    private Long count;

    public IntObj(ServiceRequestType serviceRequestType, Long count) {
        this.serviceRequestType = serviceRequestType;
        this.count = count;
    }

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public Long getCount() {
        return count;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
