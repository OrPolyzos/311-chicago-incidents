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
    private Long numberOfPremisesBaited;

    @Column(name = "premises_with_garbage")
    private Long numberOfPremisesWithGarbage;

    @Column(name = "premises_with_rats")
    private Long numberOfPremisesWithRats;

    @OneToOne
    private Activity activity;

    @OneToOne
    private SpecialServiceArea specialServiceArea;

    public Long getNumberOfPremisesBaited() {
        return numberOfPremisesBaited;
    }

    public void setNumberOfPremisesBaited(Long numberOfPremisesBaited) {
        this.numberOfPremisesBaited = numberOfPremisesBaited;
    }

    public Long getNumberOfPremisesWithGarbage() {
        return numberOfPremisesWithGarbage;
    }

    public void setNumberOfPremisesWithGarbage(Long numberOfPremisesWithGarbage) {
        this.numberOfPremisesWithGarbage = numberOfPremisesWithGarbage;
    }

    public Long getNumberOfPremisesWithRats() {
        return numberOfPremisesWithRats;
    }

    public void setNumberOfPremisesWithRats(Long numberOfPremisesWithRats) {
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
