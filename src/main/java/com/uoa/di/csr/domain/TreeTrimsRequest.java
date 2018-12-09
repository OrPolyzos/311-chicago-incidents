package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "tree_trims_requests")
@DiscriminatorValue(value = "TreeTrimsRequest")
public class TreeTrimsRequest extends ServiceRequest {

    @Column(name = "location_of_trees")
    private String whereAreTreesLocated;

    public String getWhereAreTreesLocated() {
        return whereAreTreesLocated;
    }

    public void setWhereAreTreesLocated(String whereAreTreesLocated) {
        this.whereAreTreesLocated = whereAreTreesLocated;
    }
}
