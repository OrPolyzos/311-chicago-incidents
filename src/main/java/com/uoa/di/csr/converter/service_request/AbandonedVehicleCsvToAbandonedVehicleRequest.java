package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.AbandonedVehicleRequest;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.parser.model.AbandonedVehicleCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AbandonedVehicleCsvToAbandonedVehicleRequest implements Function<AbandonedVehicleCsv, AbandonedVehicleRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public AbandonedVehicleRequest apply(AbandonedVehicleCsv abandonedVehicleCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(abandonedVehicleCsv);
        AbandonedVehicleRequest abandonedVehicleRequest = new AbandonedVehicleRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, abandonedVehicleRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        abandonedVehicleRequest.setLicensePlate(serviceRequestCsvToServiceRequest.safeParse(abandonedVehicleCsv.getLicensePlate(), Function.identity()));
        abandonedVehicleRequest.setVehicleMakeModel(serviceRequestCsvToServiceRequest.safeParse(abandonedVehicleCsv.getVehicleMakeModel(), Function.identity()));
        abandonedVehicleRequest.setHowManyDaysReportedAsParked(serviceRequestCsvToServiceRequest.safeParse(abandonedVehicleCsv.getHowManyDaysReportedAsParked(), Long::valueOf));
        abandonedVehicleRequest.setVehicleColor(serviceRequestCsvToServiceRequest.safeParse(abandonedVehicleCsv.getVehicleColor(), Function.identity()));

        serviceRequestCsvToServiceRequest.manageActivityIfExists(abandonedVehicleCsv, abandonedVehicleRequest);
        serviceRequestCsvToServiceRequest.manageSsaIfExists(abandonedVehicleCsv, abandonedVehicleRequest);
        return abandonedVehicleRequest;
    }


}
