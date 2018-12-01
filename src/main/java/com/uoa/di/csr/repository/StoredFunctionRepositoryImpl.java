package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.model.sf_response.CountPerDay;
import com.uoa.di.csr.model.sf_response.CountPerServiceRequestType;
import com.uoa.di.csr.model.sf_response.MostCommonServiceRequestPerZipCode;

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
    public List<CountPerServiceRequestType> getTotalRequestsPerTypeInRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Object[]> resultList = entityManager.createStoredProcedureQuery("chicago_service_requests.get_total_requests_per_type_in_range")
                .registerStoredProcedureParameter(1, LocalDateTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, LocalDateTime.class, ParameterMode.IN)
                .setParameter(1, startDate)
                .setParameter(2, endDate).getResultList();
        return resultList.stream().map(objArr -> new CountPerServiceRequestType(objArr[0], objArr[1])).collect(Collectors.toList());
    }

    @Override
    public List<CountPerDay> getTotalRequestsPerDayWithTypeInRange(ServiceRequestType serviceRequestType, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Object[]> resultList = entityManager.createStoredProcedureQuery("chicago_service_requests.get_total_requests_per_day_for_type_in_range")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, LocalDateTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, LocalDateTime.class, ParameterMode.IN)
                .setParameter(1, serviceRequestType.getValue())
                .setParameter(2, startDateTime)
                .setParameter(3, endDateTime).getResultList();
        return resultList.stream().map(objArr -> new CountPerDay(objArr[0], objArr[1])).collect(Collectors.toList());
    }

    @Override
    public List<MostCommonServiceRequestPerZipCode> getMostCommonRequestTypesPerZipCodeForDay(LocalDateTime localDateTime) {
        List<Object[]> resultList = entityManager.createStoredProcedureQuery("chicago_service_requests.get_most_common_type_per_zip_code_for_day")
                .registerStoredProcedureParameter(1, LocalDateTime.class, ParameterMode.IN)
                .setParameter(1, localDateTime).getResultList();
        return resultList.stream().map(objArr -> new MostCommonServiceRequestPerZipCode(objArr[0], objArr[1], objArr[2])).collect(Collectors.toList());
    }
}
