package com.uoa.di.csr.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "abandoned_vehicle_requests")
@DiscriminatorValue(value = "AbandonedVehicleRequest")
public class AbandonedVehicleRequest extends ServiceRequest {

    @Column(name = "licence_plate")
    private String licensePlate;

    @Column(name = "vehicle_make_model")
    private String vehicleMakeModel;

    @Column(name = "vehicle_color")
    private String vehicleColor;

    @Column(name = "days_reported_as_parked")
    private Integer howManyDaysReportedAsParked;

    @OneToOne(cascade = CascadeType.ALL)
    private Activity activity;

    @OneToOne(cascade = CascadeType.ALL)
    private SpecialServiceArea specialServiceArea;

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

    public Integer getHowManyDaysReportedAsParked() {
        return howManyDaysReportedAsParked;
    }

    public void setHowManyDaysReportedAsParked(Integer howManyDaysReportedAsParked) {
        this.howManyDaysReportedAsParked = howManyDaysReportedAsParked;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public SpecialServiceArea getSpecialServiceArea() {
        return specialServiceArea;
    }

    public void setSpecialServiceArea(SpecialServiceArea specialServiceArea) {
        this.specialServiceArea = specialServiceArea;
    }
}
