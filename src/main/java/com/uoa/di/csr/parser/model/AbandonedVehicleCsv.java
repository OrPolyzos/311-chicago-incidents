package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class AbandonedVehicleCsv extends ServiceRequestCsv {

    @CsvBindByName(column = "License Plate")
    private String licensePlate;

    @CsvBindByName(column = "Vehicle Make/Model")
    private String vehicleMakeModel;

    @CsvBindByName(column = "Vehicle color")
    private String vehicleColor;

    @CsvBindByName(column = "How Many Days Has the Vehicle Been Reported as Parked?")
    private String howManyDaysReportedAsParked;

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
}
