package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.TreeTrimsRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreeTrimsRequestRepository extends CrudRepository<TreeTrimsRequest, Long> {

    Optional<TreeTrimsRequest> findBySrId(Long id);
}
