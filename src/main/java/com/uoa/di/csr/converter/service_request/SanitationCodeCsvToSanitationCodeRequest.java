package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.SanitationCodeRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.parser.model.SanitationCodeCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SanitationCodeCsvToSanitationCodeRequest implements Function<SanitationCodeCsv, SanitationCodeRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public SanitationCodeRequest apply(SanitationCodeCsv sanitationCodeCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(sanitationCodeCsv);
        SanitationCodeRequest sanitationCodeRequest = new SanitationCodeRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, sanitationCodeRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        sanitationCodeRequest.setNatureOfThisCodeViolation(serviceRequestCsvToServiceRequest.safeParse(sanitationCodeCsv.getNatureOfThisCodeViolation(), Function.identity()));

        return sanitationCodeRequest;
    }

}
