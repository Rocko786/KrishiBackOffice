package com.utsav.krishibackoffice.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.activities.MainActivity;
import com.utsav.krishibackoffice.models.UserModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileFragment extends Fragment {

    TextView txt_name,txt_email,txt_mobile,txt_usertype,txt_usercode;

    LocalStorage localStorage;
    UserModel user;
    int UserId;
    String Username,UserContact,UserCode,Email,UserType,UserImage;
    MainActivity mainActivity;
    public MyProfileFragment() {
        // Required empty public constructor
    }


    public static MyProfileFragment newInstance(String param1, String param2) {
        MyProfileFragment fragment = new MyProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_profile, container, false);
        intance(view);
        setValue();
        return view;
    }

    private void setValue() {
        txt_name.setText(Username);
        txt_email.setText(Email);
        txt_usertype.setText(UserType);
        txt_mobile.setText(UserContact);
        txt_usercode.setText(UserCode);

    }

    private void intance(View view) {

        mainActivity=(MainActivity)getActivity();
        localStorage = new LocalStorage(mainActivity);
        String userString = localStorage.getUserLogin();
        Gson gson = new Gson();
        user = gson.fromJson(userString, UserModel.class);
        if (user != null) {
            UserId=user.getUserId();
            Username=user.getUserName();
            UserContact=user.getContactNo();
            Email=user.getEmail();
            UserCode=user.getUserCode();
            UserImage=user.getUserImage();
            UserType=user.getUserType();
        }
        txt_name=view.findViewById(R.id.txt_name);
        txt_usercode=view.findViewById(R.id.txt_usercode);
        txt_email=view.findViewById(R.id.txt_email);
        txt_mobile=view.findViewById(R.id.txt_mobile);
        txt_usertype=view.findViewById(R.id.txt_usertype);
    }


}