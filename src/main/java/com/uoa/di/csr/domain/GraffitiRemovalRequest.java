package com.uoa.di.csr.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "graffiti_removal_requests")
@DiscriminatorValue(value = "GraffitiRemovalRequest")
public class GraffitiRemovalRequest extends ServiceRequest implements SsaRequest {

    @Column(name = "type_of_surface")
    private String whatTypeOfSurfaceTheGraffitiIsOn;

    @Column(name = "where_is_located")
    private String whereIsTheGraffitiLocated;

    @OneToOne
    private SpecialServiceArea specialServiceArea;

    public String getWhatTypeOfSurfaceTheGraffitiIsOn() {
        return whatTypeOfSurfaceTheGraffitiIsOn;
    }

    public void setWhatTypeOfSurfaceTheGraffitiIsOn(String whatTypeOfSurfaceTheGraffitiIsOn) {
        this.whatTypeOfSurfaceTheGraffitiIsOn = whatTypeOfSurfaceTheGraffitiIsOn;
    }

    public String getWhereIsTheGraffitiLocated() {
        return whereIsTheGraffitiLocated;
    }

    public void setWhereIsTheGraffitiLocated(String whereIsTheGraffitiLocated) {
        this.whereIsTheGraffitiLocated = whereIsTheGraffitiLocated;
    }

    public SpecialServiceArea getSpecialServiceArea() {
        return specialServiceArea;
    }

    public void setSpecialServiceArea(SpecialServiceArea specialServiceArea) {
        this.specialServiceArea = specialServiceArea;
    }
}
