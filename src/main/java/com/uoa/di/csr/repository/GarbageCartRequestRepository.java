package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.GarbageCartRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GarbageCartRequestRepository extends CrudRepository<GarbageCartRequest, Long> {

    Optional<GarbageCartRequest> findBySrId(Long id);
}
