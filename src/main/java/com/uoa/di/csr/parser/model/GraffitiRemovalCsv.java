package com.uoa.di.csr.parser.model;

import com.opencsv.bean.CsvBindByName;

public class GraffitiRemovalCsv extends ServiceRequestCsv implements SsaCsv {

    @CsvBindByName(column = "What Type of Surface is the Graffiti on?")
    private String whatTypeOfSurfaceTheGraffitiIsOn;

    @CsvBindByName(column = "Where is the Graffiti located?")
    private String whereIsTheGraffitiLocated;

    @CsvBindByName(column = "SSA")
    private String ssa;

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

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }
}
