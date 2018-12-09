package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.domain.ActivityRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.domain.SsaRequest;
import com.uoa.di.csr.parser.model.ActivityCsv;
import com.uoa.di.csr.parser.model.ServiceRequestCsv;
import com.uoa.di.csr.parser.model.SsaCsv;
import com.uoa.di.csr.service.ActivityService;
import com.uoa.di.csr.service.SpecialAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ServiceRequestCsvToServiceRequest implements Function<ServiceRequestCsv, ServiceRequest> {

    private static final String EMPTY_STRING = "";

    @Autowired
    private SpecialAreaService specialAreaService;

    @Autowired
    private ActivityService activityService;

    @Override
    public ServiceRequest apply(ServiceRequestCsv serviceRequestCsv) {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setSrNumber(serviceRequestCsv.getServiceRequestNumber());
        serviceRequest.setSrType(ServiceRequestType.reverseValue(serviceRequestCsv.getServiceRequestType()));
        serviceRequest.setCreationDateTime(LocalDateTime.parse(serviceRequestCsv.getCreationDateTime()));
        serviceRequest.setSrStatus(serviceRequestCsv.getStatus());
        serviceRequest.setStreetAddress(serviceRequestCsv.getStreetAddress());
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        serviceRequest.setCompletionDateTime(mapToOptional(serviceRequestCsv.getCompletionDateTime()).isPresent() ? LocalDateTime.parse(serviceRequestCsv.getCompletionDateTime()) : null);
        serviceRequest.setZipCode(mapToOptional(serviceRequestCsv.getZipCode()).isPresent() ? Long.valueOf(serviceRequestCsv.getZipCode()) : null);
        serviceRequest.setCoordinateX(mapToOptional(serviceRequestCsv.getCoordinateX()).isPresent() ? Double.valueOf(serviceRequestCsv.getCoordinateX()) : null);
        serviceRequest.setCoordinateY(mapToOptional(serviceRequestCsv.getCoordinateY()).isPresent() ? Double.valueOf(serviceRequestCsv.getCoordinateY()) : null);
        serviceRequest.setWard(mapToOptional(serviceRequestCsv.getWard()).isPresent() ? Integer.valueOf(serviceRequestCsv.getWard()) : null);
        serviceRequest.setPoliceDistrict(mapToOptional(serviceRequestCsv.getPoliceDistrict()).isPresent() ? Integer.valueOf(serviceRequestCsv.getPoliceDistrict()) : null);
        serviceRequest.setCommunityArea(mapToOptional(serviceRequestCsv.getCommunityArea()).isPresent() ? Integer.valueOf(serviceRequestCsv.getCommunityArea()) : null);
        serviceRequest.setLongitude(mapToOptional(serviceRequestCsv.getLongitude()).isPresent() ? Double.valueOf(serviceRequestCsv.getLongitude()) : null);
        serviceRequest.setLatitude(mapToOptional(serviceRequestCsv.getLatitude()).isPresent() ? Double.valueOf(serviceRequestCsv.getLatitude()) : null);
        serviceRequest.setLocation(mapToOptional(serviceRequestCsv.getLocation()).isPresent() ? serviceRequestCsv.getLocation() : null);
        return serviceRequest;
    }

    protected void passParentValues(ServiceRequest serviceRequest, ServiceRequest serviceRequestToPassTheValues) {
        serviceRequestToPassTheValues.setSrNumber(serviceRequest.getSrNumber());
        serviceRequestToPassTheValues.setSrType(serviceRequest.getSrType());
        serviceRequestToPassTheValues.setCreationDateTime(serviceRequest.getCreationDateTime());
        serviceRequestToPassTheValues.setSrStatus(serviceRequest.getSrStatus());
        serviceRequestToPassTheValues.setStreetAddress(serviceRequest.getStreetAddress());
        serviceRequestToPassTheValues.setCompletionDateTime(serviceRequest.getCompletionDateTime());
        serviceRequestToPassTheValues.setZipCode(serviceRequest.getZipCode());
        serviceRequestToPassTheValues.setCoordinateX(serviceRequest.getCoordinateX());
        serviceRequestToPassTheValues.setCoordinateY(serviceRequest.getCoordinateY());
        serviceRequestToPassTheValues.setWard(serviceRequest.getWard());
        serviceRequestToPassTheValues.setPoliceDistrict(serviceRequest.getPoliceDistrict());
        serviceRequestToPassTheValues.setCommunityArea(serviceRequest.getCommunityArea());
        serviceRequestToPassTheValues.setLongitude(serviceRequest.getLongitude());
        serviceRequestToPassTheValues.setLatitude(serviceRequest.getLatitude());
        serviceRequestToPassTheValues.setLocation(serviceRequest.getLocation());
    }

    protected Optional<String> mapToOptional(String value) {
        return value == null || value.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(value);
    }

    protected void manageSsaIfExists(SsaCsv ssaCsv, SsaRequest ssaRequest) {
        SpecialServiceArea specialServiceArea = new SpecialServiceArea();
        specialServiceArea.setSsa(mapToOptional(ssaCsv.getSsa()).isPresent() ? Integer.valueOf(ssaCsv.getSsa()) : null);

        SpecialServiceArea specialServiceAreaToUse = specialAreaService.save(specialServiceArea);
        ssaRequest.setSpecialServiceArea(specialServiceAreaToUse);
    }

    protected void manageActivityIfExists(ActivityCsv activityCsv, ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setCurrentActivity(mapToOptional(activityCsv.getCurrentActivity()).isPresent() ? activityCsv.getCurrentActivity() : null);
        activity.setMostRecentAction(mapToOptional(activityCsv.getMostRecentAction()).isPresent() ? activityCsv.getMostRecentAction() : null);

        Activity activityToUse = activityService.save(activity);
        activityRequest.setActivity(activityToUse);
    }
}
