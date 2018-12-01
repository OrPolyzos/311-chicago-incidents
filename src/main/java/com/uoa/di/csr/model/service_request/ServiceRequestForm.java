package com.uoa.di.csr.model.service_request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

import static com.uoa.di.csr.model.validation.RegexPatterns.*;

public class ServiceRequestForm {

    @Null
    private Long id;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    private String serviceRequestNumber;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    //TODO ADD SPECIFIC REGEX PATTERN FOR THE TYPE
    private String serviceRequestType;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    //TODO ADD SPECIFIC REGEX PATTERN FOR THE ZIP CODE
    private String zipCode;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    //TODO ADD SPECIFIC REGEX PATTERN FOR THE X COORDINATE
    private String coordinateX;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    //TODO ADD SPECIFIC REGEX PATTERN FOR THE Y COORDINATE
    private String coordinateY;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Pattern(regexp = INTEGER_PATTERN, message = POSITIVE_INTEGER_MESSAGE)
    private String ward;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Pattern(regexp = INTEGER_PATTERN, message = POSITIVE_INTEGER_MESSAGE)
    private Integer policeDistrict;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Pattern(regexp = INTEGER_PATTERN, message = POSITIVE_INTEGER_MESSAGE)
    private Integer communityArea;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    private Double longitude;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    private Double latitude;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    private String location;

    @Null
    private LocalDateTime creationDateTime;
}
