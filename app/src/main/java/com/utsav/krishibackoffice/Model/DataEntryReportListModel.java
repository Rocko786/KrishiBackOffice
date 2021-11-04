package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataEntryReportListModel {

    @SerializedName("VegDateModify")
    @Expose
    private String VegDateModify;
    @SerializedName("Quantity")
    @Expose
    private String Quantity;

    public String getVegDateModify() {
        return VegDateModify;
    }

    public void setVegDateModify(String vegDateModify) {
        VegDateModify = vegDateModify;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }


}
