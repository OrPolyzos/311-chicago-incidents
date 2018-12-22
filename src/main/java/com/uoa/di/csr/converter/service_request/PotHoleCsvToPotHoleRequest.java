package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.PotHoleRequest;
import com.uoa.di.csr.domain.ServiceRequest;
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
        potHoleRequest.setNumberOfPotholesFilledOnBlock(serviceRequestCsvToServiceRequest.safeParse(potHoleCsv.getNumberOfPotholesFilledOnBlock(), Long::valueOf));

        serviceRequestCsvToServiceRequest.manageActivityIfExists(potHoleCsv, potHoleRequest);
        serviceRequestCsvToServiceRequest.manageSsaIfExists(potHoleCsv, potHoleRequest);
        return potHoleRequest;
    }

}
