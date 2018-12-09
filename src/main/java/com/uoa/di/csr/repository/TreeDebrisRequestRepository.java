package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.TreeDebrisRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreeDebrisRequestRepository extends CrudRepository<TreeDebrisRequest, Long> {

    Optional<TreeDebrisRequest> findBySrId(Long id);
}
