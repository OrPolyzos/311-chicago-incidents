package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class AbandonedVehicleCsv extends ServiceRequestCsv implements SsaCsv, ActivityCsv {

    @CsvBindByName(column = "License Plate")
    private String licensePlate;

    @CsvBindByName(column = "Vehicle Make/Model")
    private String vehicleMakeModel;

    @CsvBindByName(column = "Vehicle color")
    private String vehicleColor;

    @CsvBindByName(column = "How Many Days Has the Vehicle Been Reported as Parked?")
    private String howManyDaysReportedAsParked;

    @CsvBindByName(column = "Current Activity")
    private String currentActivity;

    @CsvBindByName(column = "Most Recent Action")
    private String mostRecentAction;

    @CsvBindByName(column = "SSA")
    private String ssa;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleMakeModel() {
        return vehicleMakeModel;
    }

    public void setVehicleMakeModel(String vehicleMakeModel) {
        this.vehicleMakeModel = vehicleMakeModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getHowManyDaysReportedAsParked() {
        return howManyDaysReportedAsParked;
    }

    public void setHowManyDaysReportedAsParked(String howManyDaysReportedAsParked) {
        this.howManyDaysReportedAsParked = howManyDaysReportedAsParked;
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

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }
}
