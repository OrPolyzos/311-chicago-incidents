package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "special_service_area",
        indexes = {
                @Index(name = "ssa_index", columnList = "ssa", unique = true)
        })
public class SpecialServiceArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
