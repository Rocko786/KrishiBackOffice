package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.Model.VegListModel;

import java.util.List;

public class DataEntryReportResponse {
    @SerializedName("VegDataId")
    @Expose
    private int VegDataId ;

    @SerializedName("Msg")
    @Expose
    private String Msg;

    @SerializedName("ReportDetailsList")
    @Expose
    private List<DataEntryReportListModel> dataEntryReportListModels = null;

    public int getVegDataId() {
        return VegDataId;
    }

    public void setVegDataId(int vegDataId) {
        VegDataId = vegDataId;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public List<DataEntryReportListModel> getDataEntryReportListModels() {
        return dataEntryReportListModels;
    }

    public void setDataEntryReportListModels(List<DataEntryReportListModel> dataEntryReportListModels) {
        this.dataEntryReportListModels = dataEntryReportListModels;
    }


}
