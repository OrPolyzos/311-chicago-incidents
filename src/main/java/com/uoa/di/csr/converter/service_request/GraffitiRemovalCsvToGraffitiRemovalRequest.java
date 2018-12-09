package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.GraffitiRemovalRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.parser.model.GraffitiRemovalCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GraffitiRemovalCsvToGraffitiRemovalRequest implements Function<GraffitiRemovalCsv, GraffitiRemovalRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public GraffitiRemovalRequest apply(GraffitiRemovalCsv graffitiRemovalCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(graffitiRemovalCsv);
        GraffitiRemovalRequest graffitiRemovalRequest = new GraffitiRemovalRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, graffitiRemovalRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        graffitiRemovalRequest.setWhatTypeOfSurfaceTheGraffitiIsOn(serviceRequestCsvToServiceRequest.mapToOptional(graffitiRemovalCsv.getWhatTypeOfSurfaceTheGraffitiIsOn()).isPresent() ? graffitiRemovalCsv.getWhatTypeOfSurfaceTheGraffitiIsOn() : null);
        graffitiRemovalRequest.setWhereIsTheGraffitiLocated(serviceRequestCsvToServiceRequest.mapToOptional(graffitiRemovalCsv.getWhereIsTheGraffitiLocated()).isPresent() ? graffitiRemovalCsv.getWhereIsTheGraffitiLocated() : null);

        serviceRequestCsvToServiceRequest.manageSsaIfExists(graffitiRemovalCsv, graffitiRemovalRequest);
        return graffitiRemovalRequest;
    }

}
