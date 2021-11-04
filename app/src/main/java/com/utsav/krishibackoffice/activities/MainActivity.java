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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.fragments.DataEntryFragment;
import com.utsav.krishibackoffice.fragments.DataReportFragment;
import com.utsav.krishibackoffice.fragments.HomeDashboardFragment;
import com.utsav.krishibackoffice.fragments.MyProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    Toolbar toolbar;
    LocalStorage localStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance();
        setupscreen(new HomeDashboardFragment());
        toolbar.setTitle("Home");
    }

    private void setupscreen(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void instance() {
        localStorage = new LocalStorage(this);
        bottomNav = findViewById(R.id.bottomNav);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setUpBottomNav();
        setSupportActionBar(toolbar);
    }

    private void setUpBottomNav() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        setupscreen(new HomeDashboardFragment());
                        toolbar.setTitle("Home");
                        return true;

                    case R.id.nav_data_entry:
                        setupscreen(new DataEntryFragment());
                        toolbar.setTitle("Data Entry");
                        return true;

                    case R.id.nav_report:
                        setupscreen(new DataReportFragment());
                        toolbar.setTitle("Data Report");
                        return true;

                    case R.id.nav_profile:
                        setupscreen(new MyProfileFragment());
                        toolbar.setTitle("My Profile");
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
    } @Override
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


}