package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.AbandonedVehicleRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbandonedVehicleRequestRepository extends CrudRepository<AbandonedVehicleRequest, Long> {

    Optional<AbandonedVehicleRequest> findBySrId(Long id);
}
