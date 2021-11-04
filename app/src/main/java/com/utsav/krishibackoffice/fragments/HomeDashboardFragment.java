package com.utsav.krishibackoffice.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utsav.krishibackoffice.R;


public class HomeDashboardFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_home_dashboard, container, false);
    }


}