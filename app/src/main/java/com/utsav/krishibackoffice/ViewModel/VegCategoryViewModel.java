package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.VegCategoryRepository;
import com.utsav.krishibackoffice.Repository.VegTypeRepository;
import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.Response.VegTypeResponse;

public class VegCategoryViewModel extends ViewModel {
    private MutableLiveData<VegCategoryResponse> vegCategoryResponseMutableLiveData;
    private VegCategoryRepository vegCategoryRepository;


    public LiveData<VegCategoryResponse> getVegCategoryRepository(int ClimateId,int VegTypeId) {
        vegCategoryResponseMutableLiveData=null;
        if (vegCategoryResponseMutableLiveData != null) {
            return vegCategoryResponseMutableLiveData;
        }
        vegCategoryRepository = VegCategoryRepository.getInstance();
        vegCategoryResponseMutableLiveData = vegCategoryRepository.getVegCategory(ClimateId,VegTypeId);
        return vegCategoryResponseMutableLiveData;
    }
}
