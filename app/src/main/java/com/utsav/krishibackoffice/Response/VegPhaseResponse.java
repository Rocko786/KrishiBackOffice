package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.VegPhaseListModel;

import java.util.List;

public class VegPhaseResponse {
    @SerializedName("VegPhaseId")
    @Expose
    private int VegPhaseId;
    @SerializedName("VegPhaseName")
    @Expose
    private String VegPhaseName;

    @SerializedName("VegPhaseList")
    @Expose
    private List<VegPhaseListModel> VegPhaseList = null;


    public int getVegPhaseId() {
        return VegPhaseId;
    }

    public void setVegPhaseId(int vegPhaseId) {
        VegPhaseId = vegPhaseId;
    }

    public String getVegPhaseName() {
        return VegPhaseName;
    }

    public void setVegPhaseName(String vegPhaseName) {
        VegPhaseName = vegPhaseName;
    }

    public List<VegPhaseListModel> getVegPhaseList() {
        return VegPhaseList;
    }

    public void setVegPhaseList(List<VegPhaseListModel> vegPhaseList) {
        VegPhaseList = vegPhaseList;
    }

}
