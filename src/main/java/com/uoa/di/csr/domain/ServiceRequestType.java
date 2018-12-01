package com.uoa.di.csr.domain;

public enum ServiceRequestType {

    ABANDONED_VEHICLE_COMPLAINT("Abandoned Vehicle Complaint"),
    ALLEY_LIGHT_OUT("Alley Light Out"),
    STREET_LIGHTS_ALL_OUT("Street Lights - All/Out"),
    STREET_LIGHT_ONE_OUT("Street Light - 1/Out");

    private String value;

    ServiceRequestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ServiceRequestType reverseValue(String actualValue) {
        if (actualValue.equals(ABANDONED_VEHICLE_COMPLAINT.getValue())) {
            return ABANDONED_VEHICLE_COMPLAINT;
        } else if (actualValue.equals(ALLEY_LIGHT_OUT.getValue())) {
            return ALLEY_LIGHT_OUT;
        } else if (actualValue.equals(STREET_LIGHTS_ALL_OUT.getValue())) {
            return STREET_LIGHTS_ALL_OUT;
        } else if (actualValue.equals(STREET_LIGHT_ONE_OUT.getValue())) {
            return STREET_LIGHT_ONE_OUT;
        }
        //TODO ALL CASES SHOULD BE ADDED
        return null;
    }
}
