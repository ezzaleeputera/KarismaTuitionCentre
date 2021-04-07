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

public class Register_Activity extends AppCompatActivity {

    EditText emel_regP,nama_regP,rIC_P,rKL_P;
    EditText rEmel_IB,rName_IB,rIC_IB,rKL_IB;
    TextView rbtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        emel_regP = findViewById(R.id.emel_regP);
        nama_regP = findViewById(R.id.nama_regP);
        rIC_P = findViewById(R.id.ic_regP);
        rKL_P=findViewById(R.id.katalaluan_regP);

        rEmel_IB = findViewById(R.id.emel_regIB );
        rName_IB = findViewById(R.id.nama_regIB);
        rIC_IB = findViewById(R.id.ic_regIB);
        rKL_IB=findViewById(R.id.katalaluan_regIB);

        rbtn = findViewById(R.id.btn_reg);



        fAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);


        rbtn.setOnClickListener(view -> {

            String emailIB = rEmel_IB.getText().toString().trim();
            String namaIB = rName_IB.getText().toString().trim();
            String icIB = rIC_IB.getText().toString().trim();

            String emailP = emel_regP.getText().toString().trim();
            String namaP = nama_regP.getText().toString().trim();
            String icP = rIC_P.getText().toString().trim();

            if (TextUtils.isEmpty(emailIB)) {
                emel_regP.setError("Email required");

                return;
            }
            if (TextUtils.isEmpty(emailIB)) {
                rEmel_IB.setError("Email required");

                return;
            }
            if (TextUtils.isEmpty(namaP)) {
                rName_IB.setError("Name required");

                return;
            }
            if (TextUtils.isEmpty(namaIB)) {
                rName_IB.setError("Name required");

                return;
            }
            if (TextUtils.isEmpty(icP)) {
                rIC_P.setError("Password required");

                return;
            }
            if (TextUtils.isEmpty(icIB)) {
                rIC_IB.setError("Password required");
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(emailIB, String.valueOf(rName_IB)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Register_Activity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();


                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                    } else {
                        Toast.makeText(Register_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        });

    }
}

