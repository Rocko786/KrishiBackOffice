package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.VegSubCategoryResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VegSubCategoryRepository {
    private KrishiApi krishiApi;
    private static VegSubCategoryRepository vegSubCategoryRepository;
    public static VegSubCategoryRepository getInstance(){
        if (vegSubCategoryRepository == null){
            vegSubCategoryRepository = new VegSubCategoryRepository();
        }
        return vegSubCategoryRepository;
    }
    public VegSubCategoryRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }

    public MutableLiveData<VegSubCategoryResponse> getVegSubCategory(int VegCategoryId){
        MutableLiveData<VegSubCategoryResponse> useData = new MutableLiveData<>();
        krishiApi.getVegSubCategory(VegCategoryId).enqueue(new Callback<VegSubCategoryResponse>() {
            @Override
            public void onResponse(Call<VegSubCategoryResponse> call,
                                   Response<VegSubCategoryResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VegSubCategoryResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
