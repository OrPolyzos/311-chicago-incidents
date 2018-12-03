package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "service_requests")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_request_id")
    protected Long srId;

    @Column(name = "creation_date_time")
    protected LocalDateTime creationDateTime;

    @Column(name = "completion_date_time")
    protected LocalDateTime completionDateTime;

    @Column(name = "sr_number")
    protected String srNumber;

    @Column(name = "sr_type")
    protected ServiceRequestType srType;

    @Column(name = "sr_status")
    protected String srStatus;

    @Column(name = "street_address")
    protected String streetAddress;

    @Column(name = "zip_code")
    protected Long zipCode;

    @Column(name = "coordinate_x")
    protected Double coordinateX;

    @Column(name = "coordinate_y")
    protected Double coordinateY;

    @Column(name = "ward")
    protected Integer ward;

    @Column(name = "police_district")
    protected Integer policeDistrict;

    @Column(name = "community_area")
    protected Integer communityArea;

    @Column(name = "longitude")
    protected Double longitude;

    @Column(name = "latitude")
    protected Double latitude;

    //TODO Change this possibly to JSONB srType for Postgres
    @Column(name = "location")
    protected String location;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getCompletionDateTime() {
        return completionDateTime;
    }

    public void setCompletionDateTime(LocalDateTime completionDateTime) {
        this.completionDateTime = completionDateTime;
    }

    public String getSrNumber() {
        return srNumber;
    }

    public void setSrNumber(String srNumber) {
        this.srNumber = srNumber;
    }

    public ServiceRequestType getSrType() {
        return srType;
    }

    public void setSrType(ServiceRequestType srType) {
        this.srType = srType;
    }

    public String getSrStatus() {
        return srStatus;
    }

    public void setSrStatus(String srStatus) {
        this.srStatus = srStatus;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public Integer getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(Integer policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public Integer getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(Integer communityArea) {
        this.communityArea = communityArea;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
