package com.uoa.di.csr.parser.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvBindByPosition;

public class ServiceRequest {

    @CsvBindByPosition(position = 0)
    private String creationDateTime;

    @CsvBindByPosition(position = 1)
    private String status;

    @CsvBindByPosition(position = 2)
    private String completionDateTime;

    @CsvBindByPosition(position = 3)
    private String serviceRequestNumber;

    @CsvBindByPosition(position = 4)
    private String serviceRequestType;

    @CsvBindByPosition(position = 5)
    private String streetAddress;

    @CsvBindByPosition(position = 6)
    private String zipCode;

    @CsvBindByPosition(position = 7)
    private String coordinateX;

    @CsvBindByPosition(position = 8)
    private String coordinateY;

    @CsvBindByPosition(position = 9)
    private String ward;

    @CsvBindByPosition(position = 10)
    private String policeDistrict;

    @CsvBindByPosition(position = 11)
    private String communityArea;

    @CsvBindByPosition(position = 12)
    private String longitude;

    @CsvBindByPosition(position = 13)
    private String latitude;

    @CsvBindByPosition(position = 14)
    private String location;


}
