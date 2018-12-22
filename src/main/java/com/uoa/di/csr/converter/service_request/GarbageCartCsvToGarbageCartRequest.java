package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.GarbageCartRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.parser.model.GarbageCartCsv;
import com.uoa.di.csr.repository.SpecialServiceAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GarbageCartCsvToGarbageCartRequest implements Function<GarbageCartCsv, GarbageCartRequest> {

    @Autowired
    private SpecialServiceAreaRepository specialServiceAreaRepository;

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public GarbageCartRequest apply(GarbageCartCsv garbageCartCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(garbageCartCsv);
        GarbageCartRequest garbageCartRequest = new GarbageCartRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, garbageCartRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        garbageCartRequest.setNumberOfBlackCartsDelivered(serviceRequestCsvToServiceRequest.safeParse(garbageCartCsv.getNumberOfBlackCartsDelivered(), Long::valueOf));

        serviceRequestCsvToServiceRequest.manageActivityIfExists(garbageCartCsv, garbageCartRequest);
        serviceRequestCsvToServiceRequest.manageSsaIfExists(garbageCartCsv, garbageCartRequest);
        return garbageCartRequest;
    }


}
