package com.uoa.di.csr.repository;

import com.uoa.di.csr.model.sf_response.CountPerServiceRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface StoredFunctionRepository {

    List<CountPerServiceRequest> getTotalRequestsPerTypeInRange(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
