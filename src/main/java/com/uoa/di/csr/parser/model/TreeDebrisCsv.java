package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class TreeDebrisCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "If Yes, where is the debris located?")
    private String whereIsDebrisLocated;

    @CsvBindByName(column = "SSA")
    private String ssa;

    @CsvBindByName(column = "Current Activity")
    private String currentActivity;

    @CsvBindByName(column = "Most Recent Action")
    private String mostRecentAction;


    public String getWhereIsDebrisLocated() {
        return whereIsDebrisLocated;
    }

    public void setWhereIsDebrisLocated(String whereIsDebrisLocated) {
        this.whereIsDebrisLocated = whereIsDebrisLocated;
    }

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getMostRecentAction() {
        return mostRecentAction;
    }

    public void setMostRecentAction(String mostRecentAction) {
        this.mostRecentAction = mostRecentAction;
    }
}
