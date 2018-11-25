package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
//@Table(name = "service-requests")
public class ServiceRequest {

    @Id
    @Column(name = "service_request_id")
    private Long id;

    @Column(name = "service_request_number", unique = true)
    private String serviceRequestNumber;

    @Column(name = "service_request_type")
    private String serviceRequestType;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "coordinate_x")
    private BigDecimal coordinateX;

    @Column(name = "coordinate_y")
    private BigDecimal coordinateY;

    @Column(name = "ward")
    private Integer ward;

    @Column(name = "police_district")
    private Integer policeDistrict;

    @Column(name = "community_area")
    private Integer communityArea;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    //TODO Change this possibly to JSONB type for Postgres
    @Column(name = "location")
    private String location;

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceRequestNumber() {
        return serviceRequestNumber;
    }

    public void setServiceRequestNumber(String serviceRequestNumber) {
        this.serviceRequestNumber = serviceRequestNumber;
    }

    public String getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(String serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(BigDecimal coordinateX) {
        this.coordinateX = coordinateX;
    }

    public BigDecimal getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(BigDecimal coordinateY) {
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

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
}
