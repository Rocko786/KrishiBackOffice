package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.ClimateRepository;
import com.utsav.krishibackoffice.Repository.UserRepository;
import com.utsav.krishibackoffice.Response.ClimateReponse;
import com.utsav.krishibackoffice.Response.UserResponse;

public class ClimateViewModel extends ViewModel {
    private MutableLiveData<ClimateReponse> climateReponseMutableLiveData;
    private ClimateRepository climateRepository;

    public void getClimates() {
        climateReponseMutableLiveData=null;
        if (climateReponseMutableLiveData != null) {
            return;
        }
        climateRepository = ClimateRepository.getInstance();
        climateReponseMutableLiveData = climateRepository.getClimates();
    }
    public LiveData<ClimateReponse> getClimateRepository() {
        return climateReponseMutableLiveData;
    }

}
