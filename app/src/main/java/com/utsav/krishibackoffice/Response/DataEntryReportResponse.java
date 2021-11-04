package com.utsav.krishibackoffice.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.Model.VegListModel;

import java.util.List;

public class DataEntryReportResponse {

    @SerializedName("ReportDetailsList")
    @Expose
    private List<DataEntryReportListModel> dataEntryReportListModels = null;

    public List<DataEntryReportListModel> getDataEntryReportListModels() {
        return dataEntryReportListModels;
    }

    public void setDataEntryReportListModels(List<DataEntryReportListModel> dataEntryReportListModels) {
        this.dataEntryReportListModels = dataEntryReportListModels;
    }


}
