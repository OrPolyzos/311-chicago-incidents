package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class ServiceRequestCsv {

    @CsvBindByName(column = "Creation Date")
    protected String creationDateTime;

    @CsvBindByName(column = "Completion Date")
    protected String completionDateTime;

    @CsvBindByName(column = "Status")
    protected String status;

    @CsvBindByName(column = "Service Request Number")
    protected String serviceRequestNumber;

    @CsvBindByName(column = "Type of Service Request")
    protected String serviceRequestType;

    @CsvBindByName(column = "Street Address")
    protected String streetAddress;

    @CsvBindByName(column = "ZIP Code")
    protected String zipCode;

    @CsvBindByName(column = "X Coordinate")
    protected String coordinateX;

    @CsvBindByName(column = "Y Coordinate")
    protected String coordinateY;

    @CsvBindByName(column = "Ward")
    protected String ward;

    @CsvBindByName(column = "Police District")
    protected String policeDistrict;

    @CsvBindByName(column = "Community Area")
    protected String communityArea;

    @CsvBindByName(column = "Latitude")
    protected String longitude;

    @CsvBindByName(column = "Longitude")
    protected String latitude;

    @CsvBindByName(column = "Location")
    protected String location;

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCompletionDateTime() {
        return completionDateTime;
    }

    public void setCompletionDateTime(String completionDateTime) {
        this.completionDateTime = completionDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(String policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public String getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(String communityArea) {
        this.communityArea = communityArea;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
