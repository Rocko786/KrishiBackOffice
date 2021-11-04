package com.utsav.krishibackoffice.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.krishibackoffice.Repository.UserRepository;
import com.utsav.krishibackoffice.Response.UserResponse;

public class UserViewModel  extends ViewModel {
    private MutableLiveData<UserResponse> usertResponseMutableLiveData;
    private UserRepository userRepository;

    public void userlogin(String usdercode,String userpassword) {
        usertResponseMutableLiveData=null;
        if (usertResponseMutableLiveData != null) {
            return;
        }
        userRepository = UserRepository.getInstance();
        usertResponseMutableLiveData = userRepository.userlogin(usdercode, userpassword);
    }

    public LiveData<UserResponse> getUserRepository() {
        return usertResponseMutableLiveData;
    }

}
