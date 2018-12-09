package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class TreeTrimsCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "Location of Trees")
    private String whereAreTreesLocated;

    public String getWhereAreTreesLocated() {
        return whereAreTreesLocated;
    }

    public void setWhereAreTreesLocated(String whereAreTreesLocated) {
        this.whereAreTreesLocated = whereAreTreesLocated;
    }
}
