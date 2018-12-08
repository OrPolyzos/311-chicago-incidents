package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.domain.GarbageCartRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.parser.model.GarbageCartCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GarbageCartCsvToGarbageCartRequest implements Function<GarbageCartCsv, GarbageCartRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public GarbageCartRequest apply(GarbageCartCsv garbageCartCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(garbageCartCsv);
        GarbageCartRequest garbageCartRequest = new GarbageCartRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, garbageCartRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        garbageCartRequest.setNumberOfBlackCartsDelivered(serviceRequestCsvToServiceRequest.mapToOptional(garbageCartCsv.getNumberOfBlackCartsDelivered()).isPresent() ? Integer.valueOf(garbageCartCsv.getNumberOfBlackCartsDelivered()) : null);
        if (serviceRequestCsvToServiceRequest.mapToOptional(garbageCartCsv.getSsa()).isPresent()) {
            SpecialServiceArea specialServiceArea = new SpecialServiceArea();
            specialServiceArea.setSsa(Integer.valueOf(garbageCartCsv.getSsa()));
            garbageCartRequest.setSpecialServiceArea(specialServiceArea);
        }

        Activity activity = new Activity();
        activity.setCurrentActivity(serviceRequestCsvToServiceRequest.mapToOptional(garbageCartCsv.getCurrentActivity()).isPresent() ? garbageCartCsv.getCurrentActivity() : null);
        activity.setMostRecentAction(serviceRequestCsvToServiceRequest.mapToOptional(garbageCartCsv.getMostRecentAction()).isPresent() ? garbageCartCsv.getMostRecentAction() : null);
        garbageCartRequest.setActivity((serviceRequestCsvToServiceRequest.mapToOptional(activity.getCurrentActivity()).isPresent() || serviceRequestCsvToServiceRequest.mapToOptional(activity.getMostRecentAction()).isPresent()) ? activity : null);

        return garbageCartRequest;
    }

}
