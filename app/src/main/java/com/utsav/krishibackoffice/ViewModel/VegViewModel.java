package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.VegRepository;
import com.utsav.krishibackoffice.Response.VegResponse;

public class VegViewModel extends ViewModel {
    private MutableLiveData<VegResponse> vegResponseMutableLiveData;
    private VegRepository vegRepository;


    public LiveData<VegResponse> getVegRepository(int VegCategoryId, int VegSubCategoryId) {
        vegResponseMutableLiveData=null;
        if (vegResponseMutableLiveData != null) {
            return vegResponseMutableLiveData;
        }
        vegRepository = VegRepository.getInstance();
        vegResponseMutableLiveData = vegRepository.getVeg(VegCategoryId,VegSubCategoryId);
        return vegResponseMutableLiveData;
    }
}
