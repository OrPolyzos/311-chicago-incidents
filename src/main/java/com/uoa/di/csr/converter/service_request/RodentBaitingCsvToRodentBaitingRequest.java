package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.RodentBaitingRequest;
import com.uoa.di.csr.domain.ServiceRequest;
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
        rodentBaitingRequest.setNumberOfPremisesBaited(serviceRequestCsvToServiceRequest.safeParse(rodentBaitingCsv.getNumberOfPremisesBaited(), Long::valueOf));
        rodentBaitingRequest.setNumberOfPremisesWithGarbage(serviceRequestCsvToServiceRequest.safeParse(rodentBaitingCsv.getNumberOfPremisesWithGarbage(), Long::valueOf));
        rodentBaitingRequest.setNumberOfPremisesWithRats(serviceRequestCsvToServiceRequest.safeParse(rodentBaitingCsv.getNumberOfPremisesWithRats(), Long::valueOf));

        serviceRequestCsvToServiceRequest.manageActivityIfExists(rodentBaitingCsv, rodentBaitingRequest);
        serviceRequestCsvToServiceRequest.manageSsaIfExists(rodentBaitingCsv, rodentBaitingRequest);

        return rodentBaitingRequest;
    }

}
