package com.uoa.di.csr.service;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.model.search.GeneralSearchForm;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRequest.class);

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public List<ServiceRequest> findAllByIdOrStreetOrZipCode(GeneralSearchForm generalSearchForm) {
        return serviceRequestRepository.criteriaSearch(generalSearchForm);
    }

}
