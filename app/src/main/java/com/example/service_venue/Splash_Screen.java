package com.example.service_venue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 3000; // Splash screen timeout in milliseconds

    Animation LeftAnimation, RightAnimation, Bottomanimation;
    TextView Service, Venue, Slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start LoginActivity after the splash screen timeout
                Intent loginIntent = new Intent(Splash_Screen.this, MainActivity.class);
                 startActivity(loginIntent);

                // Close the splash screen activity
                finish();
            }
        }, SPLASH_TIMEOUT);

    }
}