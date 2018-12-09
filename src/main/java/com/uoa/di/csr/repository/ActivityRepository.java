package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    Optional<Activity> findByCurrentActivityAndMostRecentAction(String currentActivity, String mostRecentAction);

    Optional<Activity> findByCurrentActivityAndMostRecentActionIsNull(String currentActivity);

    Optional<Activity> findByMostRecentActionAndCurrentActivityIsNull(String mostRecentAction);
}
