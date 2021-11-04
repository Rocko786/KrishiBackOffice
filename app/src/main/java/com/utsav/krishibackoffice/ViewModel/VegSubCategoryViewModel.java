package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.VegSubCategoryRepository;
import com.utsav.krishibackoffice.Response.VegSubCategoryResponse;

public class VegSubCategoryViewModel extends ViewModel {
    private MutableLiveData<VegSubCategoryResponse> vegSubCategoryResponseMutableLiveData;
    private VegSubCategoryRepository vegSubCategoryRepository;


    public LiveData<VegSubCategoryResponse> getVegSubCategoryRepository(int VegCategoryId) {
        vegSubCategoryResponseMutableLiveData=null;
        if (vegSubCategoryResponseMutableLiveData != null) {
            return vegSubCategoryResponseMutableLiveData;
        }
        vegSubCategoryRepository = VegSubCategoryRepository.getInstance();
        vegSubCategoryResponseMutableLiveData = vegSubCategoryRepository.getVegSubCategory(VegCategoryId);
        return vegSubCategoryResponseMutableLiveData;
    }
}
