package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.ClimateReponse;
import com.utsav.krishibackoffice.Response.UserResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClimateRepository {
    private KrishiApi krishiApi;
    private static ClimateRepository climateRepository;
    public static ClimateRepository getInstance(){
        if (climateRepository == null){
            climateRepository = new ClimateRepository();
        }
        return climateRepository;
    }
    public ClimateRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }


    public MutableLiveData<ClimateReponse> getClimates(){
        MutableLiveData<ClimateReponse> useData = new MutableLiveData<>();
        krishiApi.getClimates().enqueue(new Callback<ClimateReponse>() {
            @Override
            public void onResponse(Call<ClimateReponse> call,
                                   Response<ClimateReponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ClimateReponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
