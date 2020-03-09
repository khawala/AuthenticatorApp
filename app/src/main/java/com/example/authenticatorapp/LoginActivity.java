package com.example.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
EditText userName,password;
Button loginBut;
FirebaseAuth firebaseAuth;

ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=findViewById(R.id.userName);
        password=findViewById(R.id.passward);
        loginBut=findViewById(R.id.loginBut);
        progressBar=findViewById(R.id.progressBar);
loginBut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name = userName.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            userName.setError("User name is Required.");
            return;
        }
        if (TextUtils.isEmpty(userPassword)) {
            password.setError("Password is Required.");
            return;
        }
        if (password.length() < 6) {
            password.setError("Password must be >= 6 characters");
            return;
        }
        progressBar.setVisibility(View.VISIBLE);


    }
});
    }
    }

