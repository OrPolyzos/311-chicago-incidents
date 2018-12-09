package com.uoa.di.csr.service;

import com.uoa.di.csr.domain.Activity;
import com.uoa.di.csr.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity save(Activity activityToInsert) {
        if (activityToInsert.getCurrentActivity() == null && activityToInsert.getMostRecentAction() == null) {
            return null;
        } else if (activityToInsert.getCurrentActivity() == null) {
            Optional<Activity> optionalActivity = activityRepository.findByMostRecentActionAndCurrentActivityIsNull(activityToInsert.getMostRecentAction());
            return optionalActivity.orElseGet(() -> activityRepository.save(activityToInsert));
        } else if (activityToInsert.getMostRecentAction() == null) {
            Optional<Activity> optionalActivity = activityRepository.findByCurrentActivityAndMostRecentActionIsNull(activityToInsert.getCurrentActivity());
            return optionalActivity.orElseGet(() -> activityRepository.save(activityToInsert));
        }
        Optional<Activity> optionalActivity = activityRepository.findByCurrentActivityAndMostRecentAction(activityToInsert.getCurrentActivity(), activityToInsert.getMostRecentAction());
        return optionalActivity.orElseGet(() -> activityRepository.save(activityToInsert));
    }

}
