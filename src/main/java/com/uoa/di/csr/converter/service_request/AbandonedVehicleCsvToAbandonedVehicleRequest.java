package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.AbandonedVehicleRequest;
import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.parser.model.AbandonedVehicleCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class AbandonedVehicleCsvToAbandonedVehicleRequest implements Function<AbandonedVehicleCsv, AbandonedVehicleRequest> {

    private static final String EMPTY_STRING = "";

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public AbandonedVehicleRequest apply(AbandonedVehicleCsv abandonedVehicleCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(abandonedVehicleCsv);
        AbandonedVehicleRequest abandonedVehicleRequest = new AbandonedVehicleRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, abandonedVehicleRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        abandonedVehicleRequest.setLicensePlate(mapToOptional(abandonedVehicleCsv.getLicensePlate()).isPresent() ? abandonedVehicleCsv.getLicensePlate() : null);
        abandonedVehicleRequest.setVehicleMakeModel(mapToOptional(abandonedVehicleCsv.getVehicleMakeModel()).isPresent() ? abandonedVehicleCsv.getVehicleMakeModel() : null);
        abandonedVehicleRequest.setVehicleColor(mapToOptional(abandonedVehicleCsv.getVehicleColor()).isPresent() ? abandonedVehicleCsv.getVehicleColor() : null);
        abandonedVehicleRequest.setHowManyDaysReportedAsParked(mapToOptional(abandonedVehicleCsv.getHowManyDaysReportedAsParked()).isPresent() ? Integer.valueOf(abandonedVehicleCsv.getHowManyDaysReportedAsParked()) : null);

        Activity activity = new Activity();
        activity.setCurrentActivity(mapToOptional(abandonedVehicleCsv.getCurrentActivity()).isPresent() ? abandonedVehicleCsv.getCurrentActivity() : null);
        activity.setMostRecentAction(mapToOptional(abandonedVehicleCsv.getMostRecentAction()).isPresent() ? abandonedVehicleCsv.getMostRecentAction() : null);
        abandonedVehicleRequest.setActivity((mapToOptional(activity.getCurrentActivity()).isPresent() || mapToOptional(activity.getMostRecentAction()).isPresent()) ? activity : null);

        if (mapToOptional(abandonedVehicleCsv.getSsa()).isPresent()) {
            SpecialServiceArea specialServiceArea = new SpecialServiceArea();
            specialServiceArea.setSsa(Integer.valueOf(abandonedVehicleCsv.getSsa()));
            abandonedVehicleRequest.setSpecialServiceArea(specialServiceArea);
        }

        return abandonedVehicleRequest;
    }

    private Optional<String> mapToOptional(String value) {
        return value == null || value.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(value);
    }
}
