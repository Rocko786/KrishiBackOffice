package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.VegCategoryListModel;

import java.util.List;

public class VegCategoryResponse {

    @SerializedName("VegCategoryId")
    @Expose
    private int VegCategoryId;
    @SerializedName("VegCategoryName")
    @Expose
    private String VegCategoryName;

    @SerializedName("VegCategoryList")
    @Expose
    private List<VegCategoryListModel> VegCategoryList = null;

    public int getVegCategoryId() {
        return VegCategoryId;
    }

    public void setVegCategoryId(int vegCategoryId) {
        VegCategoryId = vegCategoryId;
    }

    public String getVegCategoryName() {
        return VegCategoryName;
    }

    public void setVegCategoryName(String vegCategoryName) {
        VegCategoryName = vegCategoryName;
    }

    public List<VegCategoryListModel> getVegCategoryList() {
        return VegCategoryList;
    }

    public void setVegCategoryList(List<VegCategoryListModel> vegCategoryList) {
        VegCategoryList = vegCategoryList;
    }


}
