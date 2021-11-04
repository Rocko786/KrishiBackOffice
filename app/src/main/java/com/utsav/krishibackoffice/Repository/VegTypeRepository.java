package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.VegTypeResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VegTypeRepository {
    private KrishiApi krishiApi;
    private static VegTypeRepository vegTypeRepository;
    public static VegTypeRepository getInstance(){
        if (vegTypeRepository == null){
            vegTypeRepository = new VegTypeRepository();
        }
        return vegTypeRepository;
    }
    public VegTypeRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }


    public MutableLiveData<VegTypeResponse> getVegType(){
        MutableLiveData<VegTypeResponse> useData = new MutableLiveData<>();
        krishiApi.getVegType().enqueue(new Callback<VegTypeResponse>() {
            @Override
            public void onResponse(Call<VegTypeResponse> call,
                                   Response<VegTypeResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VegTypeResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }
}
