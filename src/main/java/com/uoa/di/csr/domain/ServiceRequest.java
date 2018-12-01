package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_request_id")
    private Long id;

    @Column(name = "creation_date_time")
    private LocalDate creationDateTime;

    @Column(name = "completion_date_time")
    private LocalDate completionDateTime;

    @Column(name = "sr_number")
    private String number;

    @Column(name = "sr_type")
    private ServiceRequestType type;

    @Column(name = "sr_status")
    private String status;

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

    //TODO Change this possibly to JSONB type for Postgres
    @Column(name = "location")
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDate creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDate getCompletionDateTime() {
        return completionDateTime;
    }

    public void setCompletionDateTime(LocalDate completionDateTime) {
        this.completionDateTime = completionDateTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ServiceRequestType getType() {
        return type;
    }

    public void setType(ServiceRequestType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
