package com.uoa.di.csr.repository;

import com.uoa.di.csr.model.sp.CountPerServiceRequest;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ServiceRequestRepositoryImpl implements ServiceRequestProcedureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CountPerServiceRequest> getTotalRequestsPerTypeInRange(LocalDate startDate, LocalDate endDate) {
        StoredProcedureQuery storedProcedureQuery =
                entityManager.createStoredProcedureQuery("get_total_requests_per_type_in_range")
                        .registerStoredProcedureParameter(1, Date.class, ParameterMode.IN)
                        .registerStoredProcedureParameter(2, Date.class, ParameterMode.IN)
                        .setParameter(1, Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), TemporalType.DATE)
                        .setParameter(2, Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), TemporalType.DATE);

        return storedProcedureQuery.getResultList();
    }
}
