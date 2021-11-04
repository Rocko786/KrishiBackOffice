package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.ClimateReponse;
import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VegCategoryRepository {
    private KrishiApi krishiApi;
    private static VegCategoryRepository vegCategoryRepository;
    public static VegCategoryRepository getInstance(){
        if (vegCategoryRepository == null){
            vegCategoryRepository = new VegCategoryRepository();
        }
        return vegCategoryRepository;
    }
    public VegCategoryRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }

    public MutableLiveData<VegCategoryResponse> getVegCategory(int ClimateId,int VegTypeId){
        MutableLiveData<VegCategoryResponse> useData = new MutableLiveData<>();
        krishiApi.getVegCategory(ClimateId,VegTypeId).enqueue(new Callback<VegCategoryResponse>() {
            @Override
            public void onResponse(Call<VegCategoryResponse> call,
                                   Response<VegCategoryResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VegCategoryResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
