package com.uoa.di.csr.domain;

public enum ServiceRequestType {

    IMPLEMENTOR_A("asda"),
    STREET_LIGHTS_ALL_OUT("Street Lights - All/Out");

    private String value;

    ServiceRequestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ServiceRequestType reverseValue(String value) {
        if (value.equals(STREET_LIGHTS_ALL_OUT.getValue())) {
            return STREET_LIGHTS_ALL_OUT;
        } else {
            return IMPLEMENTOR_A;
        }
    }
}
