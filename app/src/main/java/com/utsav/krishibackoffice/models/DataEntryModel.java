package com.utsav.krishibackoffice.models;

import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.Model.VegListModel;

import java.util.List;

public class DataEntryModel {
    private String FromDate;
    private String ToDate;

    public DataEntryModel(String vegDateFormat, int climateId, int vegPhaseId, int vegCategoryId, int vegTypeId, int vegSubCategoryId, int userId, List<VegListModel> dataItemList) {
        VegDateFormat = vegDateFormat;
        ClimateId = climateId;
        VegPhaseId = vegPhaseId;
        VegCategoryId = vegCategoryId;
        VegTypeId = vegTypeId;
        VegSubCategoryId = vegSubCategoryId;
        UserId = userId;
        DataItemList = dataItemList;
    }

    private String VegDateFormat;
    private int ClimateId;
    private int VegPhaseId;
    private int VegCategoryId;
    private int VegTypeId;
    private int VegSubCategoryId;
    private int VegId;
    private int UserId;

    private List<VegListModel> DataItemList ;


    public DataEntryModel(String fromDate, String toDate, int climateId, int vegPhaseId, int vegCategoryId, int vegTypeId, int vegSubCategoryId, int vegId, int userId) {
        FromDate = fromDate;
        ToDate = toDate;
        ClimateId = climateId;
        VegPhaseId = vegPhaseId;
        VegCategoryId = vegCategoryId;
        VegTypeId = vegTypeId;
        VegSubCategoryId = vegSubCategoryId;
        VegId = vegId;
        UserId = userId;
    }


    public String getFromDate() {
        return FromDate;
    }

    public void setFromDate(String fromDate) {
        FromDate = fromDate;
    }

    public String getToDate() {
        return ToDate;
    }

    public void setToDate(String toDate) {
        ToDate = toDate;
    }

    public int getClimateId() {
        return ClimateId;
    }

    public void setClimateId(int climateId) {
        ClimateId = climateId;
    }

    public int getVegPhaseId() {
        return VegPhaseId;
    }

    public void setVegPhaseId(int vegPhaseId) {
        VegPhaseId = vegPhaseId;
    }

    public int getVegCategoryId() {
        return VegCategoryId;
    }

    public void setVegCategoryId(int vegCategoryId) {
        VegCategoryId = vegCategoryId;
    }

    public int getVegTypeId() {
        return VegTypeId;
    }

    public void setVegTypeId(int vegTypeId) {
        VegTypeId = vegTypeId;
    }

    public int getVegSubCategoryId() {
        return VegSubCategoryId;
    }

    public void setVegSubCategoryId(int vegSubCategoryId) {
        VegSubCategoryId = vegSubCategoryId;
    }

    public int getVegId() {
        return VegId;
    }

    public void setVegId(int vegId) {
        VegId = vegId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }


    public String getVegDateFormat() {
        return VegDateFormat;
    }

    public void setVegDateFormat(String vegDateFormat) {
        VegDateFormat = vegDateFormat;
    }
    public List<VegListModel> getDataItemList() {
        return DataItemList;
    }

    public void setDataItemList(List<VegListModel> dataItemList) {
        DataItemList = dataItemList;
    }



}
