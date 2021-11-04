package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.Response.VegPhaseResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VegPhaseRepository {
    private KrishiApi krishiApi;
    private static VegPhaseRepository vegPhaseRepository;
    public static VegPhaseRepository getInstance(){
        if (vegPhaseRepository == null){
            vegPhaseRepository = new VegPhaseRepository();
        }
        return vegPhaseRepository;
    }
    public VegPhaseRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }

    public MutableLiveData<VegPhaseResponse> getVegPhase(int VegCategoryId){
        MutableLiveData<VegPhaseResponse> useData = new MutableLiveData<>();
        krishiApi.getVegPhase(VegCategoryId).enqueue(new Callback<VegPhaseResponse>() {
            @Override
            public void onResponse(Call<VegPhaseResponse> call,
                                   Response<VegPhaseResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VegPhaseResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
