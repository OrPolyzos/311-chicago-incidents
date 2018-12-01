package com.uoa.di.csr.repository;

import com.uoa.di.csr.model.sp.CountPerServiceRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ServiceRequestProcedureRepository {

    List<CountPerServiceRequest> getTotalRequestsPerTypeInRange(LocalDate startDateTime, LocalDate endDateTime);
}
