package com.example.karismatuitioncentre.register_login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {
    EditText lEmail,lPassword;
    TextView lLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lEmail = findViewById(R.id.emel_LogMasuk);
        lPassword = findViewById(R.id.kataLaluan_LogMAsuk);
        lLoginBtn = findViewById(R.id.btn_LogMasuk);


        fAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);


        lLoginBtn.setOnClickListener(view -> {

            String email = lEmail.getText().toString().trim();
            String password = lPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                lEmail.setError("Emel diperlukan");

                return;
            }
            if (TextUtils.isEmpty(password)) {
                lPassword.setError("Kata Laluan Diperlukan");

                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Login_Activity.this, "Log Masuk Berjaya", Toast.LENGTH_SHORT).show();


                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                    } else {
                        Toast.makeText(Login_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        });

    }
}