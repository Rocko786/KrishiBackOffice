package com.utsav.krishibackoffice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.models.UserModel;

public class SpalshScreenActivity extends AppCompatActivity {
    AppCompatImageView img_applogo;
    AppCompatTextView txt_title,txt_version;
    LocalStorage localStorage;
    String userString;
    UserModel userModel;
    String version = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        instance();
        setNextScreen();
    }

    private String getVersionName(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    private void instance() {

        localStorage = new LocalStorage(getApplicationContext());
        img_applogo=(AppCompatImageView)findViewById(R.id.img_applogo);
        txt_title=(AppCompatTextView)findViewById(R.id.txt_title);
        txt_version=(AppCompatTextView)findViewById(R.id.txt_version);

        txt_version.setText(getVersionName(SpalshScreenActivity.this));

        img_applogo.animate().alpha(0f).setDuration(0);
        txt_title.animate().alpha(0f).setDuration(0);
       // txt_version.animate().alpha(0f).setDuration(0);
        img_applogo.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                txt_title.animate().alpha(1f).setDuration(800);
            }
        });


        Gson gson = new Gson();
        userString = localStorage.getUserLogin();
        userModel = gson.fromJson(userString, UserModel.class);
    }
    private void setNextScreen() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(userString!=""){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), LoginScreenActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }
}