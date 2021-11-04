package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClimateListModel {
    @SerializedName("ClimateId")
    @Expose
    private int ClimateId;
    @SerializedName("ClimateName")
    @Expose
    private String ClimateName;

    public int getClimateId() {
        return ClimateId;
    }

    public void setClimateId(int climateId) {
        ClimateId = climateId;
    }

    public String getClimateName() {
        return ClimateName;
    }

    public void setClimateName(String climateName) {
        ClimateName = climateName;
    }

    @Override
    public String toString() {
        return ClimateName;
    }


}
