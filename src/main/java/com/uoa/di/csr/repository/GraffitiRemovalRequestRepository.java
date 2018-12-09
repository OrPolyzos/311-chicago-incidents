package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.GraffitiRemovalRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GraffitiRemovalRequestRepository extends CrudRepository<GraffitiRemovalRequest, Long> {

    Optional<GraffitiRemovalRequest> findBySrId(Long id);
}
