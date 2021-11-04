package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.VegTypeRepository;
import com.utsav.krishibackoffice.Response.VegTypeResponse;

public class VegTypeViewModel extends ViewModel {
    private MutableLiveData<VegTypeResponse> vegTypeResponseMutableLiveData;
    private VegTypeRepository vegTypeRepository;

    public void getVegType() {
        vegTypeResponseMutableLiveData=null;
        if (vegTypeResponseMutableLiveData != null) {
            return;
        }
        vegTypeRepository = VegTypeRepository.getInstance();
        vegTypeResponseMutableLiveData = vegTypeRepository.getVegType();
    }
    public LiveData<VegTypeResponse> getVegTypeRepository() {
        return vegTypeResponseMutableLiveData;
    }

}
