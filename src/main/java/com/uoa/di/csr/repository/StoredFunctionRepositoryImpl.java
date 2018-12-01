package com.uoa.di.csr.repository;

import com.uoa.di.csr.model.sf_response.CountPerServiceRequest;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoredFunctionRepositoryImpl implements StoredFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override //SP_1
    public List<CountPerServiceRequest> getTotalRequestsPerTypeInRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Object[]> resultList = entityManager.createStoredProcedureQuery("chicago_service_requests.get_total_requests_per_type_in_range")
                .registerStoredProcedureParameter(1, LocalDateTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, LocalDateTime.class, ParameterMode.IN)
                .setParameter(1, startDate)
                .setParameter(2, endDate).getResultList();
        return resultList.stream().map(objArr -> new CountPerServiceRequest(objArr[0], objArr[1])).collect(Collectors.toList());
    }
}
