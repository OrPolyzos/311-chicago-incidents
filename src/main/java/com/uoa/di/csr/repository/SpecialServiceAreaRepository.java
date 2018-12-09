package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.SpecialServiceArea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialServiceAreaRepository extends CrudRepository<SpecialServiceArea, Long> {

    Optional<SpecialServiceArea> findBySsa(Integer ssa);
}
