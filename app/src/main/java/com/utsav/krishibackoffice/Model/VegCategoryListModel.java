package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegCategoryListModel {
    @SerializedName("VegCategoryId")
    @Expose
    private int VegCategoryId;
    @SerializedName("VegCategoryName")
    @Expose
    private String VegCategoryName;

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






    @Override
    public String toString() {
        return VegCategoryName;
    }
}
