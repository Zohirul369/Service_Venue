package com.example.service_venue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    private DrawerLayout drawerLayout;

    ImageView profileDoubleCircle;
    ImageView profileBack;

    ImageView profile_pen;
    ImageView profileImg;
    TextView profileJob;
    ImageView profileRating;
    TextView profileNameTxt;
    EditText profileNameEdt;
    TextView profilePhoneTxt;
    TextView profilePhoneEdt;
    TextView profileEmailTxt;
    EditText profileEmailEdt;
    TextView profileGenderTxt;
    RadioGroup radioGender;
    RadioButton radioMale;
    RadioButton radioFemale;
    private TextView profiile_showTxt;
    private TextView profile_dateTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        profileDoubleCircle = findViewById(R.id.profile_double_circle);
        profileBack = findViewById(R.id.profile_back);
        profileImg = findViewById(R.id.profile_img);
        profileJob = findViewById(R.id.profile_job);
        profileRating = findViewById(R.id.profile_rating);
        profileNameTxt = findViewById(R.id.profile_name_txt);
        profileNameEdt = findViewById(R.id.profile_name_edt);
        profilePhoneTxt = findViewById(R.id.profile_phone_txt);
        profilePhoneEdt = findViewById(R.id.profile_phone_edt);
        profileEmailTxt = findViewById(R.id.profile_email_txt);
        profileEmailEdt = findViewById(R.id.profile_email_edt);
        profileGenderTxt = findViewById(R.id.profile_gender_txt);
        radioGender = findViewById(R.id.radioGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        profiile_showTxt = findViewById(R.id.profiile_showTxt);
        profile_dateTxt = findViewById(R.id.profile_dateTxt);
        profile_pen = findViewById(R.id.profile_pen);

        profile_pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });


        profile_dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        profileGenderTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the visibility of radio buttons
                if (radioGender.getVisibility() == View.VISIBLE){
                    radioGender.setVisibility(View.VISIBLE);
                } else {
                    radioGender.setVisibility(View.VISIBLE);
                }
            }
        });

        // Handle radio button selection
        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioMale) {
                    profileGenderTxt.setText("Gender \nMale");

                } else if (checkedId == R.id.radioFemale) {
                    profileGenderTxt.setText("Gender \nFemale");

                }
                // Hide the radio buttons
                radioGender.setVisibility(View.GONE);
            }
        });



        Toolbar toolbar = findViewById(R.layout.activity_main);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }


    //Here end the onCreate Method


    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){
            Uri selectedImageUri = data.getData();


            Picasso.get().load(selectedImageUri).into(profileImg);
        }
    }



    private void openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int Year, int Month, int Day) {
                // Handle the selected date
                String selectedDate = Year + "-" + (Month + 1) + "-" + Day;
//                profiile_showTxt.setText("Date of Birth: " + selectedDate);
                profile_dateTxt.setText(selectedDate); // Set text in the TextView
            }
        }, 2023, 0, 1);

        dialog.show();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
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
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}