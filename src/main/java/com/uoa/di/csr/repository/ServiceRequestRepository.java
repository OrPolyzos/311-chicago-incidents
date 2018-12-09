package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.ServiceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, Long>, ServiceRequestCriteriaRepository, StoredFunctionRepository {

    Page<ServiceRequest> findAll(Pageable pageable);

    long count();
}
