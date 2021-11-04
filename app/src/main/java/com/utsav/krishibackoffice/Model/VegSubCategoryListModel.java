package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegSubCategoryListModel {
    @SerializedName("VegSubCategoryId")
    @Expose
    private int VegSubCategoryId;
    @SerializedName("VegSubCategoryName")
    @Expose
    private String VegSubCategoryName;

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

    @Override
    public String toString() {
        return VegSubCategoryName;
    }

}
