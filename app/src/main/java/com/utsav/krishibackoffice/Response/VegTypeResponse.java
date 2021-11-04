package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.VegTypeListModel;

import java.util.List;

public class VegTypeResponse {
    @SerializedName("VegTypeId")
    @Expose
    private int VegTypeId;
    @SerializedName("VegTypeName")
    @Expose
    private String VegTypeName;

    @SerializedName("VegTypeList")
    @Expose
    private List<VegTypeListModel> vegType = null;

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

    public List<VegTypeListModel> getVegType() {
        return vegType;
    }

    public void setVegType(List<VegTypeListModel> vegType) {
        this.vegType = vegType;
    }

}
