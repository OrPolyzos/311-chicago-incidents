package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.parser.model.ServiceRequestCsv;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ServiceRequestCsvToServiceRequest implements Function<ServiceRequestCsv, ServiceRequest> {

    private static final String EMPTY_STRING = "";

    @Override
    public ServiceRequest apply(ServiceRequestCsv serviceRequestCsv) {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setNumber(serviceRequestCsv.getServiceRequestNumber());
        serviceRequest.setType(ServiceRequestType.reverseValue(serviceRequestCsv.getServiceRequestType()));
        serviceRequest.setCreationDateTime(LocalDateTime.parse(serviceRequestCsv.getCreationDateTime()));
        serviceRequest.setStatus(serviceRequestCsv.getStatus());
        serviceRequest.setStreetAddress(serviceRequestCsv.getStreetAddress());
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        serviceRequest.setCompletionDateTime(mapToOptional(serviceRequestCsv.getCompletionDateTime()).isPresent() ? LocalDateTime.parse(serviceRequestCsv.getCompletionDateTime()) : null);
        serviceRequest.setZipCode(mapToOptional(serviceRequestCsv.getZipCode()).isPresent() ? Long.valueOf(serviceRequestCsv.getZipCode()) : null);
        serviceRequest.setCoordinateX(mapToOptional(serviceRequestCsv.getCoordinateX()).isPresent() ? new BigDecimal(serviceRequestCsv.getCoordinateX()) : null);
        serviceRequest.setCoordinateY(mapToOptional(serviceRequestCsv.getCoordinateY()).isPresent() ? new BigDecimal(serviceRequestCsv.getCoordinateY()) : null);
        serviceRequest.setWard(mapToOptional(serviceRequestCsv.getWard()).isPresent() ? Integer.valueOf(serviceRequestCsv.getWard()) : null);
        serviceRequest.setPoliceDistrict(mapToOptional(serviceRequestCsv.getPoliceDistrict()).isPresent() ? Integer.valueOf(serviceRequestCsv.getPoliceDistrict()) : null);
        serviceRequest.setCommunityArea(mapToOptional(serviceRequestCsv.getCommunityArea()).isPresent() ? Integer.valueOf(serviceRequestCsv.getCommunityArea()) : null);
        serviceRequest.setLongitude(mapToOptional(serviceRequestCsv.getLongitude()).isPresent() ? Double.valueOf(serviceRequestCsv.getLongitude()) : null);
        serviceRequest.setLatitude(mapToOptional(serviceRequestCsv.getLatitude()).isPresent() ? Double.valueOf(serviceRequestCsv.getLatitude()) : null);
        serviceRequest.setLocation(mapToOptional(serviceRequestCsv.getLocation()).isPresent() ? serviceRequestCsv.getLocation() : null);
        return serviceRequest;
    }

    private Optional<String> mapToOptional(String value) {
        return value.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(value);
    }
}
