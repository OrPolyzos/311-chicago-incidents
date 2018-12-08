package com.uoa.di.csr.domain;

public enum ServiceRequestType {

    ABANDONED_VEHICLE_COMPLAINT("Abandoned Vehicle Complaint"),
    ALLEY_LIGHT_OUT("Alley Light Out"),
    STREET_LIGHTS_ALL_OUT("Street Lights - All/Out"),
    STREET_LIGHT_ONE_OUT("Street Light - 1/Out"),
    GARBAGE_CART("Garbage Cart Black Maintenance/Replacement"),
    RODENT_BAITING("Rodent Baiting/Rat Complaint");

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
        } else if (actualValue.equals(GARBAGE_CART.getValue())) {
            return GARBAGE_CART;
        } else if (actualValue.equals(RODENT_BAITING.getValue())) {
            return RODENT_BAITING;
        }
        //TODO ALL CASES SHOULD BE ADDED
        return null;
    }
}
