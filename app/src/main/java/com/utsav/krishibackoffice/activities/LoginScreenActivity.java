package com.utsav.krishibackoffice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.utsav.krishibackoffice.Model.ClimateListModel;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.ViewModel.UserViewModel;
import com.utsav.krishibackoffice.models.UserModel;

import java.util.ArrayList;

public class LoginScreenActivity extends AppCompatActivity {
    TextInputEditText edit_usercode,edit_password;
    TextView btn_login;
    String usercode,userpassword;
    UserViewModel userViewModel;
    UserModel userModel;
    int UserId=0,UserTypeId;
    RelativeLayout relative_btn,relative_pro;
    ProgressBar pro_cir;

    String Username,UserContact,UserCode,Email,UserType,UserImage,BlockName;

    ProgressDialog progressDialog;
    LocalStorage localStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        instance();
        clickevent();
    }

    private void clickevent() {
        btn_login.setOnClickListener(v -> {
            validFields();
        });
    }

    private void instance() {
        localStorage = new LocalStorage(getApplicationContext());

        edit_usercode=findViewById(R.id.edit_usercode);
        edit_password=findViewById(R.id.edit_password);
        btn_login=findViewById(R.id.btn_login);
        relative_pro=findViewById(R.id.relative_pro);
        relative_btn=findViewById(R.id.relative_btn);
        pro_cir=findViewById(R.id.pro_cir);


        /*progressDialog=new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.setCancelable(false);*/
    }
    private void validFields()
    {
        usercode=edit_usercode.getText().toString();
        userpassword=edit_password.getText().toString();
        if(usercode.length()==0){
            edit_usercode.setError("Please Enter User Code");
        }
        else if(userpassword.length()==0){
            edit_password.setError("Please Enter User Password");
        }
        else {
            dologin();
        }
    }
    private void setprogessbarVisibilty(Boolean check){
        if(check==true){
            pro_cir.getProgress();
            relative_btn.setVisibility(View.GONE);
            relative_pro.setVisibility(View.VISIBLE);
        }
        else {
            relative_btn.setVisibility(View.VISIBLE);
            relative_pro.setVisibility(View.GONE);
        }
    }

    private void dologin() {
        setprogessbarVisibilty(true);
        try{
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.userlogin(usercode,userpassword);
        userViewModel.getUserRepository().observe(this, userResponse -> {

             UserId=userResponse.getUserId();
             Username=userResponse.getUserName();
             UserContact=userResponse.getContactNo();
             Email=userResponse.getEmail();
             UserTypeId=userResponse.getUserTypeId();
             UserCode=userResponse.getUserCode();
             UserImage=userResponse.getUserImage();
             UserType=userResponse.getUserType();
             BlockName=userResponse.getBlockName();
             userModel=new UserModel(UserId,Username,UserContact,Email,UserTypeId,UserCode,UserImage,UserType,BlockName);

            if(UserId!=0){
              //  setprogessbarVisibilty(false);

                Gson gson = new Gson();
                String userString = gson.toJson(userModel);
                localStorage.createUserLoginSession(userString);
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                setprogessbarVisibilty(false);
                Toast.makeText(getApplicationContext(),"User not found ",Toast.LENGTH_LONG).show();
            }

        });
        }
        catch (Exception ex){
            setprogessbarVisibilty(false);
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        finally {
            //setprogessbarVisibilty(false);
        }


    }
}