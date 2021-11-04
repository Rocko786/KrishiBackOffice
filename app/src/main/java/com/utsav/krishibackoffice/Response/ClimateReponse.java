package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.ClimateListModel;

import java.util.List;

public class ClimateReponse {
    @SerializedName("ClimateId")
    @Expose
    private int ClimateId;
    @SerializedName("ClimateName")
    @Expose
    private String ClimateName;

    @SerializedName("ClimateList")
    @Expose
    private List<ClimateListModel> climates = null;

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

    public List<ClimateListModel> getClimates() {
        return climates;
    }

    public void setClimates(List<ClimateListModel> climates) {
        this.climates = climates;
    }

}
