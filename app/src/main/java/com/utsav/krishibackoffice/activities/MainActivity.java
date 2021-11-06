package com.utsav.krishibackoffice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance();

        setupscreen(new HomeDashboardFragment());

    }

    private void setupscreen(Fragment fragment) {
        txt_title.setText("Home");
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
                        setupscreen(new HomeDashboardFragment());
                        Title="Home";
                        txt_title.setText("Home");
                        return true;

                    case R.id.nav_data_entry:
                        setupscreen(new DataEntryFragment());
                        Title="Data Entry";
                       // toolbar.setTitle("Data Entry");
                        txt_title.setText("Data Entry");
                        return true;

                    case R.id.nav_report:
                        setupscreen(new DataReportFragment());
                        Title="Data Report";
                        //toolbar.setTitle("Data Report");
                        txt_title.setText("Data Report");
                        return true;

                    case R.id.nav_profile:
                        setupscreen(new MyProfileFragment());
                        Title="My Profile";
                       // toolbar.setTitle("My Profile");
                        txt_title.setText("My Profile");
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(!Title.equals("Home")){
            setupscreen(new HomeDashboardFragment());
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
}