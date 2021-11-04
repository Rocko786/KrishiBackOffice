package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.VegResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VegRepository {
    private KrishiApi krishiApi;
    private static VegRepository vegRepository;
    public static VegRepository getInstance(){
        if (vegRepository == null){
            vegRepository = new VegRepository();
        }
        return vegRepository;
    }
    public VegRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }

    public MutableLiveData<VegResponse> getVeg(int VegCategoryId, int VegSubCategoryId){
        MutableLiveData<VegResponse> useData = new MutableLiveData<>();
        krishiApi.getVeg(VegCategoryId,VegSubCategoryId).enqueue(new Callback<VegResponse>() {
            @Override
            public void onResponse(Call<VegResponse> call,
                                   Response<VegResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VegResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
