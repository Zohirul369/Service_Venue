package com.example.service_venue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalProfessionalSignup extends AppCompatActivity {

    Button personal, Professonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_professional_signup);

        personal = findViewById(R.id.PersonalButton);
        Professonal = findViewById(R.id.ProfessonalButton);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalIntent;
                personalIntent = new Intent(PersonalProfessionalSignup.this, PersonalSignup.class);
                startActivity(personalIntent);
            }
        });
        Professonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProfessonalIntent;
                ProfessonalIntent = new Intent(PersonalProfessionalSignup.this, PersonalSignup.class);
                startActivity(ProfessonalIntent);
            }
        });

    }
}