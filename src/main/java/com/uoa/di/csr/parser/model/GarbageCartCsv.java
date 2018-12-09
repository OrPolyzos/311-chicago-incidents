package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class GarbageCartCsv extends ServiceRequestCsv implements SsaCsv, ActivityCsv {

    @CsvBindByName(column = "Number of Black Carts Delivered")
    private String numberOfBlackCartsDelivered;

    @CsvBindByName(column = "SSA")
    private String ssa;

    @CsvBindByName(column = "Current Activity")
    private String currentActivity;

    @CsvBindByName(column = "Most Recent Action")
    private String mostRecentAction;

    public String getNumberOfBlackCartsDelivered() {
        return numberOfBlackCartsDelivered;
    }

    public void setNumberOfBlackCartsDelivered(String numberOfBlackCartsDelivered) {
        this.numberOfBlackCartsDelivered = numberOfBlackCartsDelivered;
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
