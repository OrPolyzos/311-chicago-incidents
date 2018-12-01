package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_request_id")
    private Long srId;

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @Column(name = "completion_date_time")
    private LocalDateTime completionDateTime;

    @Column(name = "sr_number")
    private String srNumber;

    @Column(name = "sr_type")
    private ServiceRequestType srType;

    @Column(name = "sr_status")
    private String srStatus;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "zip_code")
    private Long zipCode;

    //TODO NEED to specify decimal places
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

    //TODO Change this possibly to JSONB srType for Postgres
    @Column(name = "location")
    private String location;

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
}
