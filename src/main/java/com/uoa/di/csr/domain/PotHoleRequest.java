package com.uoa.di.csr.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "pot_hole_requests")
@DiscriminatorValue(value = "PotHoleRequest")
public class PotHoleRequest extends ServiceRequest {

    @Column(name = "pot_holes_filled_on_block")
    private Integer numberOfPotholesFilledOnBlock;

    @OneToOne(cascade = CascadeType.ALL)
    private Activity activity;

    @OneToOne(cascade = CascadeType.ALL)
    private SpecialServiceArea specialServiceArea;

    public Integer getNumberOfPotholesFilledOnBlock() {
        return numberOfPotholesFilledOnBlock;
    }

    public void setNumberOfPotholesFilledOnBlock(Integer numberOfPotholesFilledOnBlock) {
        this.numberOfPotholesFilledOnBlock = numberOfPotholesFilledOnBlock;
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
