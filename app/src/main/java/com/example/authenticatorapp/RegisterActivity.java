package com.example.authenticatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
public FirebaseAuth firebaseAuth;
    EditText userName,password;
    Button loginBut;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.passward);
        loginBut=findViewById(R.id.loginBut);
        progressBar=findViewById(R.id.progressBar);
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=userName.getText().toString().trim();
                String userPassword =password.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    userName.setError("User name is Required.");
                    return;
                }
                if(TextUtils.isEmpty(userPassword)){
                    password.setError("Password is Required.");
                    return;
                }
                if(password.length()<6){
                    password.setError("Password must be >= 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        firebaseAuth.createUserWithEmailAndPassword("alyaa@gmail.com","akjshs")
                .addOnCanceledListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }

                    @Override
                    public void onCanceled() {

                    }
                }
        )
    }

    public void haveAccount(View view){
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}
