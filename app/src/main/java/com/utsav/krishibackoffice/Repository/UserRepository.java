package com.utsav.krishibackoffice.Repository;

import androidx.lifecycle.MutableLiveData;

import com.utsav.krishibackoffice.Response.UserResponse;
import com.utsav.krishibackoffice.networking.KrishiApi;
import com.utsav.krishibackoffice.networking.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private KrishiApi krishiApi;

    private static UserRepository userRepository;
    public static UserRepository getInstance(){
        if (userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public UserRepository(){
        krishiApi = RetrofitService.cteateService(KrishiApi.class);

    }

    public MutableLiveData<UserResponse> userlogin(String usercode, String userpassword){
        MutableLiveData<UserResponse> useData = new MutableLiveData<>();
        krishiApi.userlogin(usercode, userpassword).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call,
                                   Response<UserResponse> response) {
                if (response.isSuccessful()){
                    useData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                useData.setValue(null);
            }
        });
        return useData;
    }

}
