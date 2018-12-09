package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class PotHoleCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "Number of Potholes filled on block")
    private String numberOfPotholesFilledOnBlock;

    @CsvBindByName(column = "SSA")
    private String ssa;

    @CsvBindByName(column = "Current Activity")
    private String currentActivity;

    @CsvBindByName(column = "Most Recent Action")
    private String mostRecentAction;

    public String getNumberOfPotholesFilledOnBlock() {
        return numberOfPotholesFilledOnBlock;
    }

    public void setNumberOfPotholesFilledOnBlock(String numberOfPotholesFilledOnBlock) {
        this.numberOfPotholesFilledOnBlock = numberOfPotholesFilledOnBlock;
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
