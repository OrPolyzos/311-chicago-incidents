package com.uoa.di.csr.model.search;

import javax.validation.constraints.NotNull;

public class ServiceRequestTypeSearchForm extends FromTimeToTimeSearchForm {

    @NotNull
    private String serviceRequestType;


    public String getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(String serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }
}
