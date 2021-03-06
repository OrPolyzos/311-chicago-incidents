package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.RodentBaitingRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RodentBaitingRequestRepository extends CrudRepository<RodentBaitingRequest, Long> {

    Optional<RodentBaitingRequest> findBySrId(Long id);

    List<RodentBaitingRequest> findAllByNumberOfPremisesBaitedLessThan(Number limit);

    List<RodentBaitingRequest> findAllByNumberOfPremisesWithGarbageLessThan(Number limit);

    List<RodentBaitingRequest> findAllByNumberOfPremisesWithRatsLessThan(Number limit);
}
