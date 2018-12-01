package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.model.sf_response.CountPerDay;
import com.uoa.di.csr.model.sf_response.CountPerServiceRequestType;
import com.uoa.di.csr.model.sf_response.MostCommonServiceRequestPerZipCode;

import java.time.LocalDateTime;
import java.util.List;

public interface StoredFunctionRepository {

    List<CountPerServiceRequestType> getTotalRequestsPerTypeInRange(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<CountPerDay> getTotalRequestsPerDayWithTypeInRange(ServiceRequestType serviceRequestType, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<MostCommonServiceRequestPerZipCode> getMostCommonRequestTypesPerZipCodeForDay(LocalDateTime localDateTime);
}
