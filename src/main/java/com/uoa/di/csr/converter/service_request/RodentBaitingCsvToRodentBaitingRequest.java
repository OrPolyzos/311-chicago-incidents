package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.domain.RodentBaitingRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.parser.model.RodentBaitingCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RodentBaitingCsvToRodentBaitingRequest implements Function<RodentBaitingCsv, RodentBaitingRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public RodentBaitingRequest apply(RodentBaitingCsv rodentBaitingCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(rodentBaitingCsv);
        RodentBaitingRequest rodentBaitingRequest = new RodentBaitingRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, rodentBaitingRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        rodentBaitingRequest.setNumberOfPremisesBaited(serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getNumberOfPremisesBaited()).isPresent() ? Integer.valueOf(rodentBaitingCsv.getNumberOfPremisesBaited()) : null);
        rodentBaitingRequest.setNumberOfPremisesWithGarbage(serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getNumberOfPremisesWithGarbage()).isPresent() ? Integer.valueOf(rodentBaitingCsv.getNumberOfPremisesWithGarbage()) : null);
        rodentBaitingRequest.setNumberOfPremisesWithRats(serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getNumberOfPremisesWithRats()).isPresent() ? Integer.valueOf(rodentBaitingCsv.getNumberOfPremisesWithRats()) : null);

        if (serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getSsa()).isPresent()) {
            SpecialServiceArea specialServiceArea = new SpecialServiceArea();
            specialServiceArea.setSsa(Integer.valueOf(rodentBaitingCsv.getSsa()));
            rodentBaitingRequest.setSpecialServiceArea(specialServiceArea);
        }

        Activity activity = new Activity();
        activity.setCurrentActivity(serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getCurrentActivity()).isPresent() ? rodentBaitingCsv.getCurrentActivity() : null);
        activity.setMostRecentAction(serviceRequestCsvToServiceRequest.mapToOptional(rodentBaitingCsv.getMostRecentAction()).isPresent() ? rodentBaitingCsv.getMostRecentAction() : null);
        rodentBaitingRequest.setActivity((serviceRequestCsvToServiceRequest.mapToOptional(activity.getCurrentActivity()).isPresent() || serviceRequestCsvToServiceRequest.mapToOptional(activity.getMostRecentAction()).isPresent()) ? activity : null);

        return rodentBaitingRequest;
    }

}
