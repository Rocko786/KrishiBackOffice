package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegTypeListModel {
    @SerializedName("VegTypeId")
    @Expose
    private int VegTypeId;
    @SerializedName("VegTypeName")
    @Expose
    private String VegTypeName;

    public int getVegTypeId() {
        return VegTypeId;
    }

    public void setVegTypeId(int vegTypeId) {
        VegTypeId = vegTypeId;
    }

    public String getVegTypeName() {
        return VegTypeName;
    }

    public void setVegTypeName(String vegTypeName) {
        VegTypeName = vegTypeName;
    }

    @Override
    public String toString() {
        return VegTypeName;
    }
}
