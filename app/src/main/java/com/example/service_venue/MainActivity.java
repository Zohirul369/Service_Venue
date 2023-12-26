package com.example.service_venue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity  {

//    NavigationView navigationView;
//    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
//    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);




        bottomNavigationView = findViewById(R.id.bottomNavigationView);
       // navigationView= findViewById(R.id.nav_view);


      //  bottomNavigationView.bringToFront();



      /*  drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

     /*   if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
*/
        replaceFragment(new Home_Fragment());
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.bm_home) {
                replaceFragment(new Home_Fragment());
            } else if (itemId == R.id.bm_top_review) {
                replaceFragment(new InboxFragment());
            } else if (itemId == R.id.bm_order) {
                replaceFragment(new OrderFragment());
            } else if (itemId == R.id.bm_help) {
                replaceFragment(new HelpFragment());
            } else if (itemId == R.id.bm_settings) {
                replaceFragment(new SettingsFragment());
            }

            return true;
        });

    }

    //=========================Here end the onCreate Method============================
//=====================================================================================
//=====================================================================================









/*    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
        } else if (itemId == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
        } else if (itemId == R.id.nav_logout) {
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }*/




    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}