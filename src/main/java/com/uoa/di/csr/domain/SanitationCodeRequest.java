package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "sanitation_code_requests")
@DiscriminatorValue(value = "SanitationCodeRequest")
public class SanitationCodeRequest extends ServiceRequest {

    @Column(name = "nature_of_violation")
    private String natureOfThisCodeViolation;

    public String getNatureOfThisCodeViolation() {
        return natureOfThisCodeViolation;
    }

    public void setNatureOfThisCodeViolation(String natureOfThisCodeViolation) {
        this.natureOfThisCodeViolation = natureOfThisCodeViolation;
    }
}
