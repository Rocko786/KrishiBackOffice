package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.DataEntryReportRepository;
import com.utsav.krishibackoffice.Repository.VegCategoryRepository;
import com.utsav.krishibackoffice.Response.DataEntryReportResponse;
import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.models.DataEntryModel;

public class DataEntryReportViewModel extends ViewModel {
    private MutableLiveData<DataEntryReportResponse> dataEntryReportResponseMutableLiveData;
    private DataEntryReportRepository dataEntryReportRepository;

    public LiveData<DataEntryReportResponse> getDataEntryReportGetAll(DataEntryModel model) {
        dataEntryReportResponseMutableLiveData=null;
        if (dataEntryReportResponseMutableLiveData != null) {
            return dataEntryReportResponseMutableLiveData;
        }
        dataEntryReportRepository = DataEntryReportRepository.getInstance();
        dataEntryReportResponseMutableLiveData = dataEntryReportRepository.getDataEntryReportGetAll(model);
        return dataEntryReportResponseMutableLiveData;
    }

    public LiveData<DataEntryReportResponse> entryDataSave(DataEntryModel model) {
        dataEntryReportResponseMutableLiveData=null;
        if (dataEntryReportResponseMutableLiveData != null) {
            return dataEntryReportResponseMutableLiveData;
        }
        dataEntryReportRepository = DataEntryReportRepository.getInstance();
        dataEntryReportResponseMutableLiveData = dataEntryReportRepository.entryDataSave(model);
        return dataEntryReportResponseMutableLiveData;
    }


}
