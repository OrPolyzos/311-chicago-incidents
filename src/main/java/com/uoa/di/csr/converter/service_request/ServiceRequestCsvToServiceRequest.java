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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ServiceRequestCsvToServiceRequest implements Function<ServiceRequestCsv, ServiceRequest> {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceRequestCsvToServiceRequest.class);
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
        serviceRequest.setCreationDateTime(safeParse(serviceRequestCsv.getCreationDateTime(), LocalDateTime::parse));
        serviceRequest.setSrStatus(serviceRequestCsv.getStatus());
        serviceRequest.setStreetAddress(serviceRequestCsv.getStreetAddress());
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        serviceRequest.setCompletionDateTime(safeParse(serviceRequestCsv.getCompletionDateTime(), LocalDateTime::parse));
        serviceRequest.setZipCode(safeParse(serviceRequestCsv.getZipCode(), Long::valueOf));
        serviceRequest.setCoordinateX(safeParse(serviceRequestCsv.getCoordinateX(), Double::valueOf));
        serviceRequest.setCoordinateY(safeParse(serviceRequestCsv.getCoordinateY(), Double::valueOf));
        serviceRequest.setWard(safeParse(serviceRequestCsv.getWard(), Integer::valueOf));
        serviceRequest.setPoliceDistrict(safeParse(serviceRequestCsv.getPoliceDistrict(), Integer::valueOf));
        serviceRequest.setCommunityArea(safeParse(serviceRequestCsv.getCommunityArea(), Integer::valueOf));
        serviceRequest.setLongitude(safeParse(serviceRequestCsv.getLongitude(), Double::valueOf));
        serviceRequest.setLatitude(safeParse(serviceRequestCsv.getLatitude(), Double::valueOf));
        serviceRequest.setLocation(safeParse(serviceRequestCsv.getLocation(), Function.identity()));
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

    protected void manageSsaIfExists(SsaCsv ssaCsv, SsaRequest ssaRequest) {
        SpecialServiceArea specialServiceArea = new SpecialServiceArea();
        specialServiceArea.setSsa(safeParse(ssaCsv.getSsa(), Integer::valueOf));

        SpecialServiceArea specialServiceAreaToUse = specialAreaService.save(specialServiceArea);
        ssaRequest.setSpecialServiceArea(specialServiceAreaToUse);
    }

    protected void manageActivityIfExists(ActivityCsv activityCsv, ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setCurrentActivity(safeParse(activityCsv.getCurrentActivity(), Function.identity()));
        activity.setMostRecentAction(safeParse(activity.getMostRecentAction(), Function.identity()));

        Activity activityToUse = activityService.save(activity);
        activityRequest.setActivity(activityToUse);
    }

    protected <T> T safeParse(String valueToParse, Function<String, T> mapper) {
        try {
            return mapToOptional(valueToParse).isPresent() ? mapper.apply(valueToParse) : null;
        } catch (Exception ex) {
            LOG.error("Failed to convert: '{}'", valueToParse);
            return null;
        }
    }

    private Optional<String> mapToOptional(String value) {
        return value == null || value.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(value);
    }
}
