package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.VegPhaseRepository;
import com.utsav.krishibackoffice.Response.VegPhaseResponse;

public class VegPhaseViewModel extends ViewModel {
    private MutableLiveData<VegPhaseResponse> vegPhaseResponseMutableLiveData;
    private VegPhaseRepository vegPhaseRepository;


    public LiveData<VegPhaseResponse> getVegPhaseRepository(int VegCategoryId) {
        vegPhaseResponseMutableLiveData=null;
        if (vegPhaseResponseMutableLiveData != null) {
            return vegPhaseResponseMutableLiveData;
        }
        vegPhaseRepository = VegPhaseRepository.getInstance();
        vegPhaseResponseMutableLiveData = vegPhaseRepository.getVegPhase(VegCategoryId);
        return vegPhaseResponseMutableLiveData;
    }
}
