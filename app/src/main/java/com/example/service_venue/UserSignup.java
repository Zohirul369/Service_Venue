package com.example.service_venue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class UserSignup extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText signup_mobileno;
    Button user_signup_send_otpBtn;
    ProgressBar progressBar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        countryCodePicker=findViewById(R.id.user_signup_countrycode);
        signup_mobileno=findViewById(R.id.signup_mobileno);
        user_signup_send_otpBtn=findViewById(R.id.user_signup_send_otpBtn);
        progressBar=findViewById(R.id.user_signup_progressbar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(signup_mobileno);

        user_signup_send_otpBtn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                signup_mobileno.setError("Phone number not valid");
                return;
            }
            Intent intent = new Intent(UserSignup.this,UserSignupOTP.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });

    }
}