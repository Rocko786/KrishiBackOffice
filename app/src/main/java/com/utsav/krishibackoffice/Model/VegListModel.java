package com.utsav.krishibackoffice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegListModel {
    @SerializedName("VegId")
    @Expose
    private int VegId;

    @SerializedName("VegName")
    @Expose
    private String VegName;

    @SerializedName("Quantity")
    @Expose
    private String Quantity;

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
    @Override
    public String toString() {
        return VegName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
