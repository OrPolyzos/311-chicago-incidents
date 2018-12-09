package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rodent_baiting_requests",
        indexes = {
                @Index(name = "premises_baited_index", columnList = "premises_baited"),
                @Index(name = "premises_with_garbage_index", columnList = "premises_with_garbage"),
                @Index(name = "premises_with_rats_index", columnList = "premises_with_rats"),
        })
@DiscriminatorValue(value = "RodentBaitingRequest")
public class RodentBaitingRequest extends ServiceRequest implements SsaRequest, ActivityRequest {

    @Column(name = "premises_baited")
    private Integer numberOfPremisesBaited;

    @Column(name = "premises_with_garbage")
    private Integer numberOfPremisesWithGarbage;

    @Column(name = "premises_with_rats")
    private Integer numberOfPremisesWithRats;

    @OneToOne
    private Activity activity;

    @OneToOne
    private SpecialServiceArea specialServiceArea;

    public Integer getNumberOfPremisesBaited() {
        return numberOfPremisesBaited;
    }

    public void setNumberOfPremisesBaited(Integer numberOfPremisesBaited) {
        this.numberOfPremisesBaited = numberOfPremisesBaited;
    }

    public Integer getNumberOfPremisesWithGarbage() {
        return numberOfPremisesWithGarbage;
    }

    public void setNumberOfPremisesWithGarbage(Integer numberOfPremisesWithGarbage) {
        this.numberOfPremisesWithGarbage = numberOfPremisesWithGarbage;
    }

    public Integer getNumberOfPremisesWithRats() {
        return numberOfPremisesWithRats;
    }

    public void setNumberOfPremisesWithRats(Integer numberOfPremisesWithRats) {
        this.numberOfPremisesWithRats = numberOfPremisesWithRats;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public SpecialServiceArea getSpecialServiceArea() {
        return specialServiceArea;
    }

    public void setSpecialServiceArea(SpecialServiceArea specialServiceArea) {
        this.specialServiceArea = specialServiceArea;
    }
}
