package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class SanitationCodeCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "What is the Nature of this Code Violation?")
    private String natureOfThisCodeViolation;

    public String getNatureOfThisCodeViolation() {
        return natureOfThisCodeViolation;
    }

    public void setNatureOfThisCodeViolation(String natureOfThisCodeViolation) {
        this.natureOfThisCodeViolation = natureOfThisCodeViolation;
    }
}
