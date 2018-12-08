package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;


public class RodentBaitingCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "Number of Premises Baited")
    private String numberOfPremisesBaited;

    @CsvBindByName(column = "Number of Premises with Garbage")
    private String numberOfPremisesWithGarbage;

    @CsvBindByName(column = "Number of Premises with Rats")
    private String numberOfPremisesWithRats;

    @CsvBindByName(column = "SSA")
    private String ssa;

    @CsvBindByName(column = "Current Activity")
    private String currentActivity;

    @CsvBindByName(column = "Most Recent Action")
    private String mostRecentAction;

    public String getNumberOfPremisesBaited() {
        return numberOfPremisesBaited;
    }

    public void setNumberOfPremisesBaited(String numberOfPremisesBaited) {
        this.numberOfPremisesBaited = numberOfPremisesBaited;
    }

    public String getNumberOfPremisesWithGarbage() {
        return numberOfPremisesWithGarbage;
    }

    public void setNumberOfPremisesWithGarbage(String numberOfPremisesWithGarbage) {
        this.numberOfPremisesWithGarbage = numberOfPremisesWithGarbage;
    }

    public String getNumberOfPremisesWithRats() {
        return numberOfPremisesWithRats;
    }

    public void setNumberOfPremisesWithRats(String numberOfPremisesWithRats) {
        this.numberOfPremisesWithRats = numberOfPremisesWithRats;
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
