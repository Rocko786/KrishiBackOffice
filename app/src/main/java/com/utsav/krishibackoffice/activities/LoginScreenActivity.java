package com.utsav.krishibackoffice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
    int UserId=0;
    String Username,UserContact;

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
        progressDialog=new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.setCancelable(false);
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

    private void dologin() {
       // progressDialog.show();
        try{
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.userlogin(usercode,userpassword);
        userViewModel.getUserRepository().observe(this, userResponse -> {
             UserId=userResponse.getUserId();
             Username=userResponse.getUserName();
             UserContact=userResponse.getContactNo();
             userModel=new UserModel(UserId,Username,UserContact);

            if(UserId!=0){
               // progressDialog.dismiss();

                Gson gson = new Gson();
                String userString = gson.toJson(userModel);
                localStorage.createUserLoginSession(userString);
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
               // progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"User not found ",Toast.LENGTH_LONG).show();
            }

        });
        }
        catch (Exception ex){
            //progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        finally {
           // progressDialog.dismiss();
        }


    }
}