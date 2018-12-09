package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.PotHoleRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PotHoleRequestRepository extends CrudRepository<PotHoleRequest, Long> {

    Optional<PotHoleRequest> findBySrId(Long id);
}
