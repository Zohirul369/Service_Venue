package com.example.service_venue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PersonalSignup extends AppCompatActivity {

    private FirebaseAuth auth;

    private EditText Name, Email, Number, Pass, ConfPass, Add;
    private Button PerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_signup);

        auth = FirebaseAuth.getInstance();
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Number = findViewById(R.id.Number);
        Pass = findViewById(R.id.password);
        ConfPass = findViewById(R.id.confirm_password);
        Add = findViewById(R.id.address);
        PerButton = findViewById(R.id.PersonalSignupButton);

        PerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().trim();
                String email  = Email.getText().toString().trim();
                String num = Number.getText().toString().trim();
                String pas = Pass.getText().toString().trim();
                String conpass =  ConfPass.getText().toString().trim();
                String adds = Add.getText().toString().trim();

                if(name.isEmpty()){
                    Name.setError("Name cannot empty");
                }
                if(email.isEmpty()){
                    Email.setError("Email cannot empty");
                }
                if(num.isEmpty()){
                    Number.setError("Number cannot empty");
                }
                if(pas.isEmpty()){
                    Pass.setError("Password cannot empty");
                }
                if(conpass.isEmpty()){
                    ConfPass.setError("Confirm Password cannot empty");
                }
                if(adds.isEmpty()){
                    Add.setError("Address cannot empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(email, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(PersonalSignup.this,"Signup Seccessful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(PersonalSignup.this, Login.class));
                            }else {
                                Toast.makeText(PersonalSignup.this,"Signup Fail"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }
}