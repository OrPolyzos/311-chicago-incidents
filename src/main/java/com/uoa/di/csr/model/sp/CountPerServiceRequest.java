package com.uoa.di.csr.model.sp;

import com.uoa.di.csr.domain.ServiceRequestType;

public class CountPerServiceRequest {

    private ServiceRequestType serviceRequestType;
    private Integer count;

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
