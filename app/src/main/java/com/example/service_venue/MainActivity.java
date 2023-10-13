package com.example.service_venue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variable Declearation
    Animation LeftAnimation, RightAnimation,Bottomanimation;
    TextView Service, Venue, Slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        LeftAnimation = AnimationUtils.loadAnimation(this, R.anim.left_animation);
        RightAnimation = AnimationUtils.loadAnimation(this, R.anim.right_animation);
        Bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hook
        Service = findViewById(R.id.logo_service);
        Venue = findViewById(R.id.logo_venue);
        Slogan = findViewById(R.id.slogan);

        Service.setAnimation(LeftAnimation);
        Venue.setAnimation(RightAnimation);
        Slogan.setAnimation(Bottomanimation);

    }
}