package com.uoa.di.csr.model.sf_response;

import com.uoa.di.csr.domain.ServiceRequestType;

public class AvgCompletionTimePerServiceRequestType {

    private ServiceRequestType serviceRequestType;
    private Double avgCompletionTime;

    public AvgCompletionTimePerServiceRequestType(Object serviceRequestType, Object avgCompletionTime) {
        this.serviceRequestType = ServiceRequestType.reverseValue((String) serviceRequestType);
        this.avgCompletionTime = (Double) avgCompletionTime;
    }

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public Double getAvgCompletionTime() {
        return avgCompletionTime;
    }

    public void setAvgCompletionTime(Double avgCompletionTime) {
        this.avgCompletionTime = avgCompletionTime;
    }
}
