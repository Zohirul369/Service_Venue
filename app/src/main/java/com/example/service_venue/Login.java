package com.example.service_venue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText  email,  pass;

    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth =  FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String  passw = pass.getText().toString().trim();

                if(!mail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    if(!passw.isEmpty()){
                        auth.signInWithEmailAndPassword(mail,passw).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();

                               // login.setVisibility(View.GONE);
                               // Fragment fragment = new Home_Fragment();
                              //  FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                             //   fragmentTransaction.replace(R.id.home,fragment).commit();
                               // startActivity(new Intent(Login.this, Home_Fragment.class));
                               //finish();


                                
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,"Enter Correct Email & Password",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        pass.setError("Password cannot Empty");
                    }
                }else if (mail.isEmpty()){
                    email.setError("Email cannot Empty");
                }else {
                    email.setError("Please Enter valid email");
                }
            }
        });
    }
}