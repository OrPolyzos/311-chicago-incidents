package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pot_hole_requests",
        indexes = {
                @Index(name = "pot_holes_filled_on_block_index", columnList = "pot_holes_filled_on_block")
        })
@DiscriminatorValue(value = "PotHoleRequest")
public class PotHoleRequest extends ServiceRequest implements SsaRequest, ActivityRequest {

    @Column(name = "pot_holes_filled_on_block")
    private Long numberOfPotholesFilledOnBlock;

    @OneToOne
    private Activity activity;

    @OneToOne
    private SpecialServiceArea specialServiceArea;

    public Long getNumberOfPotholesFilledOnBlock() {
        return numberOfPotholesFilledOnBlock;
    }

    public void setNumberOfPotholesFilledOnBlock(Long numberOfPotholesFilledOnBlock) {
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
