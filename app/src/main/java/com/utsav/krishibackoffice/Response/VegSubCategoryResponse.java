package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.VegSubCategoryListModel;

import java.util.List;

public class VegSubCategoryResponse {
    @SerializedName("VegSubCategoryId")
    @Expose
    private int VegSubCategoryId;
    @SerializedName("VegSubCategoryName")
    @Expose
    private String VegSubCategoryName;

    @SerializedName("VegSubCategoryList")
    @Expose
    private List<VegSubCategoryListModel> VegSubCategoryList = null;

    public int getVegSubCategoryId() {
        return VegSubCategoryId;
    }

    public void setVegSubCategoryId(int vegSubCategoryId) {
        VegSubCategoryId = vegSubCategoryId;
    }

    public String getVegSubCategoryName() {
        return VegSubCategoryName;
    }

    public void setVegSubCategoryName(String vegSubCategoryName) {
        VegSubCategoryName = vegSubCategoryName;
    }

    public List<VegSubCategoryListModel> getVegSubCategoryList() {
        return VegSubCategoryList;
    }

    public void setVegSubCategoryList(List<VegSubCategoryListModel> vegSubCategoryList) {
        VegSubCategoryList = vegSubCategoryList;
    }


}
