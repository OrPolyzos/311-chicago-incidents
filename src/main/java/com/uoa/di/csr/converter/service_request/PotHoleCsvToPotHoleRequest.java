package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.domain.PotHoleRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.parser.model.PotHoleCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PotHoleCsvToPotHoleRequest implements Function<PotHoleCsv, PotHoleRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public PotHoleRequest apply(PotHoleCsv potHoleCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(potHoleCsv);
        PotHoleRequest potHoleRequest = new PotHoleRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, potHoleRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        potHoleRequest.setNumberOfPotholesFilledOnBlock(serviceRequestCsvToServiceRequest.mapToOptional(potHoleCsv.getNumberOfPotholesFilledOnBlock()).isPresent() ? Integer.valueOf(potHoleCsv.getNumberOfPotholesFilledOnBlock()) : null);
        if (serviceRequestCsvToServiceRequest.mapToOptional(potHoleCsv.getSsa()).isPresent()) {
            SpecialServiceArea specialServiceArea = new SpecialServiceArea();
            specialServiceArea.setSsa(Integer.valueOf(potHoleCsv.getSsa()));
            potHoleRequest.setSpecialServiceArea(specialServiceArea);
        }

        Activity activity = new Activity();
        activity.setCurrentActivity(serviceRequestCsvToServiceRequest.mapToOptional(potHoleCsv.getCurrentActivity()).isPresent() ? potHoleCsv.getCurrentActivity() : null);
        activity.setMostRecentAction(serviceRequestCsvToServiceRequest.mapToOptional(potHoleCsv.getMostRecentAction()).isPresent() ? potHoleCsv.getMostRecentAction() : null);
        potHoleRequest.setActivity((serviceRequestCsvToServiceRequest.mapToOptional(activity.getCurrentActivity()).isPresent() || serviceRequestCsvToServiceRequest.mapToOptional(activity.getMostRecentAction()).isPresent()) ? activity : null);

        return potHoleRequest;
    }

}
