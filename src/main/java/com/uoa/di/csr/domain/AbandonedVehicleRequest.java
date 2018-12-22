package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abandoned_vehicle_requests",
        indexes = {
                @Index(name = "licence_plate_index", columnList = "licence_plate")
        })
@DiscriminatorValue(value = "AbandonedVehicleRequest")
public class AbandonedVehicleRequest extends ServiceRequest implements SsaRequest, ActivityRequest {

    @Column(name = "licence_plate", length = 2048)
    private String licensePlate;

    @Column(name = "vehicle_make_model")
    private String vehicleMakeModel;

    @Column(name = "vehicle_color")
    private String vehicleColor;

    @Column(name = "days_reported_as_parked")
    private Long howManyDaysReportedAsParked;

    @OneToOne
    private Activity activity;

    @OneToOne
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

    public Long getHowManyDaysReportedAsParked() {
        return howManyDaysReportedAsParked;
    }

    public void setHowManyDaysReportedAsParked(Long howManyDaysReportedAsParked) {
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
