package com.utsav.krishibackoffice.models;

public class DataEntryModel {
    private String FromDate;
    private String ToDate;
    private int ClimateId;
    private int VegPhaseId;
    private int VegCategoryId;
    private int VegTypeId;
    private int VegSubCategoryId;
    private int VegId;
    private int UserId;

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



}
