package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.ServiceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, Long> {

    Page<ServiceRequest> findAll(Pageable pageable);

    @Query("SELECT " + " new com.uoa.di.csr.repository.IntObj(serviceRequest.serviceRequestType, COUNT(serviceRequest)) " +
            "FROM " +
            " ServiceRequest serviceRequest " +
            "GROUP BY " +
            "serviceRequest.serviceRequestType")
    List<IntObj> testQuery();

    @Query(value = "SELECT SERVICE_REQUEST_TYPE, COUNT(*) FROM SERVICE_REQUESTS GROUP BY SERVICE_REQUEST_TYPE", nativeQuery = true)
    Map<String, Long> testQuery2();

    long count();
}
