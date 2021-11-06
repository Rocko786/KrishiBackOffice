package com.utsav.krishibackoffice.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.activities.MainActivity;
import com.utsav.krishibackoffice.models.UserModel;


public class HomeDashboardFragment extends Fragment {

    LocalStorage localStorage;
    UserModel user;
    int UserId;
    String Username,UserContact,UserCode,Email,UserType,UserImage,BlockName;

    TextView txt_username,txt_blockname;
    ImageView image_user;
    MainActivity mainActivity;

    public static HomeDashboardFragment newInstance(String param1, String param2) {
        HomeDashboardFragment fragment = new HomeDashboardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_dashboard, container, false);
        instance(view);
        setValue();
        return view;
    }

    private void setValue() {
        txt_username.setText(Username);
        txt_blockname.setText(BlockName);

        Glide
                .with(this)
                .load(UserImage)
                .centerCrop()
                .into(image_user);
    }

    private void instance(View view) {
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
            BlockName=user.getBlockName();
        }
        txt_username=view.findViewById(R.id.txt_username);
        txt_blockname=view.findViewById(R.id.txt_blockname);
        image_user=view.findViewById(R.id.image_user);
    }


}