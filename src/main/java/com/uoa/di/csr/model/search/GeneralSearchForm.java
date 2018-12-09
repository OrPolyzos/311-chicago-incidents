package com.uoa.di.csr.model.search;

import javax.validation.constraints.Pattern;

public class GeneralSearchForm {

    @Pattern(regexp = "^[0-9]*$")
    private String serviceRequestId;

    private String streetAddress;

    @Pattern(regexp = "^[0-9]*$")
    private String zipCode;

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
