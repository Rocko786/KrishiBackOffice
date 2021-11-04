package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegPhaseListModel {
    @SerializedName("VegPhaseId")
    @Expose
    private int VegPhaseId;
    @SerializedName("VegPhaseName")
    @Expose
    private String VegPhaseName;

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

    @Override
    public String toString() {
        return VegPhaseName;
    }
}
