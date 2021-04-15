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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterStudent_Activity extends AppCompatActivity {

    EditText emel_regP,nama_regP,noKP_regP,kl_regP;
//    EditText rEmel_IB,rName_IB,rIC_IB,rKL_IB;
    TextView btn_reg;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = fAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pelajar);

        emel_regP = findViewById(R.id.emel_regP);
        nama_regP = findViewById(R.id.nama_regP);
        noKP_regP = findViewById(R.id.noKP_regP);
        kl_regP=findViewById(R.id.kl_regP);


        btn_reg = findViewById(R.id.btn_reg);



        fAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);


        btn_reg.setOnClickListener(view -> {



            String emailP = emel_regP.getText().toString().trim();
            String namaP = nama_regP.getText().toString().trim();
            String kpP = noKP_regP.getText().toString().trim();
            String klP = kl_regP.getText().toString().trim();
            String toUser="1";// 1 refer to student


            if (TextUtils.isEmpty(emailP)) {
                emel_regP.setError("Emel Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(namaP)) {
                nama_regP.setError("Nama Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(kpP)) {
                noKP_regP.setError("No. IC Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(klP)) {
                kl_regP.setError("Kata Laluan Diperlukan");

                return;
            }
            if(klP.length() < 6){
                kl_regP.setError("Kata Laluan perlu >= 6 aksara");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(emailP, String.valueOf(klP)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterStudent_Activity.this, "Berjaya didaftarkan", Toast.LENGTH_SHORT).show();

                        String userID = fAuth.getCurrentUser().getUid();
                        Map<String,Object> user=new HashMap<>();
                        user.put("email",emailP);
                        user.put("nama",namaP);
                        user.put("kp",kpP);
                        user.put("kl",klP);
                        user.put("to_User",klP);

                        FirebaseDatabase.getInstance().getReference().child("User_list").push()
                                .setValue(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e)
                                    {
                                        Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show();
                                    }
                                });

                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                    } else {
                        Toast.makeText(RegisterStudent_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        });

    }
}

