 package com.example.karismatuitioncentre.login;

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

import com.example.karismatuitioncentre.home.Home_Activity_IbuBapa;
import com.example.karismatuitioncentre.home.Home_Activity_Pelajar;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

 public class Login_Activity extends AppCompatActivity {
    EditText lEmail,lPassword;
    TextView lLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setSubtitle("Selamat Datang!");

        lEmail = findViewById(R.id.emel_LogMasuk);
        lPassword = findViewById(R.id.kataLaluan_LogMasuk);
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

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(Login_Activity.this, "Log Masuk Berjaya", Toast.LENGTH_SHORT).show();

                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                    assert user != null;
                    String userId=user.getUid();


                    ref = FirebaseDatabase.getInstance().getReference("User_list");

                    ref.orderByChild("userid").equalTo(userId).addValueEventListener(new ValueEventListener() {


                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            for(DataSnapshot datas: dataSnapshot.getChildren()) {
                                String userType= (String) datas.child("to_User").getValue();



                                Toast.makeText(Login_Activity.this, userType, Toast.LENGTH_SHORT).show();
                                assert userType != null;
                                switch (userType) {
                                    case "0":
                                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
                                        break;
                                    case "1":

                                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pelajar.class));
                                        break;
                                    case "2":
                                        startActivity(new Intent(getApplicationContext(), Home_Activity_IbuBapa.class));
                                        break;
                                }
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }});



                    } else {
                    Toast.makeText(Login_Activity.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });

        });

    }
}