package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.VegListModel;

import java.util.List;

public class VegResponse {
    @SerializedName("VegId")
    @Expose
    private int VegId;
    @SerializedName("VegName")
    @Expose
    private String VegName;

    @SerializedName("VegList")
    @Expose
    private List<VegListModel> VegList = null;

    public int getVegId() {
        return VegId;
    }

    public void setVegId(int vegId) {
        VegId = vegId;
    }

    public String getVegName() {
        return VegName;
    }

    public void setVegName(String vegName) {
        VegName = vegName;
    }

    public List<VegListModel> getVegList() {
        return VegList;
    }

    public void setVegList(List<VegListModel> vegList) {
        VegList = vegList;
    }


}
