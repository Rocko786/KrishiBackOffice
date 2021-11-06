package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.DataEntryReportResponse;
import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.models.DataEntryModel;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataEntryReportRepository {
    private KrishiApi krishiApi;
    private static DataEntryReportRepository dataEntryReportRepository;
    public static DataEntryReportRepository getInstance(){
        if (dataEntryReportRepository == null){
            dataEntryReportRepository = new DataEntryReportRepository();
        }
        return dataEntryReportRepository;
    }
    public DataEntryReportRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);
    }

    public MutableLiveData<DataEntryReportResponse> getDataEntryReportGetAll(DataEntryModel model){


        MutableLiveData<DataEntryReportResponse> useData = new MutableLiveData<>();
        krishiApi.getDataEntryReportGetAll(model.getFromDate(), model.getToDate(),model.getClimateId(), model.getVegPhaseId(), model.getVegCategoryId(),model.getVegTypeId(),model.getVegSubCategoryId(),model.getVegId(),model.getUserId()).enqueue(new Callback<DataEntryReportResponse>() {
            @Override
            public void onResponse(Call<DataEntryReportResponse> call,
                                   Response<DataEntryReportResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataEntryReportResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

    public MutableLiveData<DataEntryReportResponse> entryDataSave(DataEntryModel model){


        MutableLiveData<DataEntryReportResponse> useData = new MutableLiveData<>();
        krishiApi.dataEntrySave(model).enqueue(new Callback<DataEntryReportResponse>() {
            @Override
            public void onResponse(Call<DataEntryReportResponse> call,
                                   Response<DataEntryReportResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataEntryReportResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }




}
