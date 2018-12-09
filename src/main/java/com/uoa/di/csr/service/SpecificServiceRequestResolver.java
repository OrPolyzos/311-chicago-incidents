package com.uoa.di.csr.service;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.exception.service_request.ServiceRequestDataInconsistencyException;
import com.uoa.di.csr.repository.AbandonedVehicleRequestRepository;
import com.uoa.di.csr.repository.GarbageCartRequestRepository;
import com.uoa.di.csr.repository.PotHoleRequestRepository;
import com.uoa.di.csr.repository.RodentBaitingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecificServiceRequestResolver {

    @Autowired
    private AbandonedVehicleRequestRepository abandonedVehicleRequestRepository;

    @Autowired
    private GarbageCartRequestRepository garbageCartRequestRepository;

    @Autowired
    private RodentBaitingRequestRepository rodentBaitingRequestRepository;

    @Autowired
    private PotHoleRequestRepository potHoleRequestRepository;

    public ServiceRequest mapToSpecificType(ServiceRequest serviceRequest) throws ServiceRequestDataInconsistencyException {
        switch (serviceRequest.getSrType()) {
            case ABANDONED_VEHICLE_COMPLAINT:
                return abandonedVehicleRequestRepository.findBySrId(serviceRequest.getSrId()).orElseThrow(() -> new ServiceRequestDataInconsistencyException(serviceRequest.getSrId()));
            case GARBAGE_CART:
                return garbageCartRequestRepository.findBySrId(serviceRequest.getSrId()).orElseThrow(() -> new ServiceRequestDataInconsistencyException(serviceRequest.getSrId()));
            case RODENT_BAITING:
                return rodentBaitingRequestRepository.findBySrId(serviceRequest.getSrId()).orElseThrow(() -> new ServiceRequestDataInconsistencyException(serviceRequest.getSrId()));
            case POT_HOLE:
                return potHoleRequestRepository.findBySrId(serviceRequest.getSrId()).orElseThrow(() -> new ServiceRequestDataInconsistencyException(serviceRequest.getSrId()));
            default:
                return serviceRequest;
        }
    }
}
