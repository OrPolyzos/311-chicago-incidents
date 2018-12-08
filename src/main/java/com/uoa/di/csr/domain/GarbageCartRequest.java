package com.uoa.di.csr.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "garbage_carts")
@DiscriminatorValue(value = "GarbageCartRequest")
public class GarbageCartRequest extends ServiceRequest {

    @Column(name = "black_carts_delivered")
    private Integer numberOfBlackCartsDelivered;

    @OneToOne(cascade = CascadeType.ALL)
    private Activity activity;

    @OneToOne(cascade = CascadeType.ALL)
    private SpecialServiceArea specialServiceArea;

    public Integer getNumberOfBlackCartsDelivered() {
        return numberOfBlackCartsDelivered;
    }

    public void setNumberOfBlackCartsDelivered(Integer numberOfBlackCartsDelivered) {
        this.numberOfBlackCartsDelivered = numberOfBlackCartsDelivered;
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
