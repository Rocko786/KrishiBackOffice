package com.utsav.krishibackoffice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.fragments.DataEntryFragment;
import com.utsav.krishibackoffice.fragments.DataReportFragment;
import com.utsav.krishibackoffice.fragments.HomeDashboardFragment;
import com.utsav.krishibackoffice.fragments.MyProfileFragment;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    Toolbar toolbar;
    TextView txt_title;
    LocalStorage localStorage;
    String Title;
    private AlertDialog alertDialog;
    private AlertDialog.Builder dialogBuilder;
    //private TextView textView;
    private Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance();

        setupscreen(new HomeDashboardFragment(),"Home");

    }

    private void setupscreen(Fragment fragment,String pageTitle) {
        txt_title.setText(pageTitle);
        Title=pageTitle;
       // toolbar.setTitle("Home");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void instance() {
        localStorage = new LocalStorage(this);
        bottomNav = findViewById(R.id.bottomNav);
        toolbar = findViewById(R.id.toolbar);
        txt_title=findViewById(R.id.txt_title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setUpBottomNav();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void setUpBottomNav() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        setupscreen(new HomeDashboardFragment(),"Home");
                        return true;

                    case R.id.nav_data_entry:
                        setupscreen(new DataEntryFragment(),"Data Entry");
                        return true;

                    case R.id.nav_report:
                        setupscreen(new DataReportFragment(),"Data Report");
                        return true;

                    case R.id.nav_profile:
                        setupscreen(new MyProfileFragment(),"My Profile");
                        return true;


                }
                return false;

            }


       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            localStorage.logoutUser();
            startActivity(new Intent(getApplicationContext(), LoginScreenActivity.class));
            finish();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            return true;
        }

        if (id == R.id.action_info) {
            //Toast.makeText(getApplicationContext(),"FAG",Toast.LENGTH_LONG).show();
            //return true;
            createNewFaqDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
     //   super.onBackPressed();
        System.out.println(Title);
        if(!Title.equals("Home")){
            View view = bottomNav.findViewById(R.id.nav_home);
            view.performClick();
            Title="Home";
            txt_title.setText("Home");
            toolbar.setTitle("");
        }
        else {
            showWarningMessage("You won't be exit from application");
        }
    }

    private void showWarningMessage(String msg) {
        // 2. Confirmation message
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText(msg)
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        finish();
                    }
                })
                .setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    public void createNewFaqDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View faqpopupView= getLayoutInflater().inflate(R.layout.popup,null);
        btn_ok = (Button) faqpopupView.findViewById(R.id.btn_ok);

        dialogBuilder.setView(faqpopupView);
        alertDialog =dialogBuilder.create();
        alertDialog.show();
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}