package com.example.service_venue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PersonalProfessionalSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_professional_signup);

        Button personalbtn, professonalbtn;

        personalbtn = findViewById(R.id.personal);
        professonalbtn = findViewById(R.id.professional);

        personalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalIntent;
                personalIntent = new Intent(PersonalProfessionalSignup.this, personal_signup.class);
                startActivity(personalIntent);
            }
        });

        professonalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent professonalIntent;
                professonalIntent = new Intent(PersonalProfessionalSignup.this, professional_signup.class);
                startActivity(professonalIntent);
            }
        });



    }
}