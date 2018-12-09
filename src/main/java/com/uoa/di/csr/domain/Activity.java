package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "activity",
        indexes = {
                @Index(name = "activity_index", columnList = "current_activity,most_recent_action", unique = true)
        })
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "current_activity")
    private String currentActivity;

    @Column(name = "most_recent_action")
    private String mostRecentAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getMostRecentAction() {
        return mostRecentAction;
    }

    public void setMostRecentAction(String mostRecentAction) {
        this.mostRecentAction = mostRecentAction;
    }
}
