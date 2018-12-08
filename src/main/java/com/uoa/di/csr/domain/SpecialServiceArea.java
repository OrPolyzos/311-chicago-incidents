package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "special_service_area")
public class SpecialServiceArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ssa")
    private Integer ssa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSsa() {
        return ssa;
    }

    public void setSsa(Integer ssa) {
        this.ssa = ssa;
    }
}
