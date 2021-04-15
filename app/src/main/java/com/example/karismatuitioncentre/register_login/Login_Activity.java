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

import com.example.karismatuitioncentre.home.Home_Activity_IbuBapa;
import com.example.karismatuitioncentre.home.Home_Activity_Pelajar;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Activity extends AppCompatActivity {
    EditText lEmail,lPassword;
    TextView lLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    FirebaseUser user = fAuth.getCurrentUser();
    String userID = user.getUid();

    public static class userAccess {

        String to_User;

        userAccess() {

        }

        public userAccess(String to_User) {
            this.to_User = to_User;

        }

        public String getuserAccess() {
            return to_User;
        }

        public void setuserAccess(String pengajar) {
            this.to_User = pengajar;
        }


    }
/*    mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                toastMessage("Successfully signed in with: " + user.getEmail());
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out");
                toastMessage("Successfully signed out.");
            }
            // ...
        }
    };*/

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




                        ValueEventListener postListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // Get Post object and use the values to update the UI
                                userAccess userAccess = dataSnapshot.getValue(userAccess.class);
                                String userType = dataSnapshot.getRef().toString();

                                if (userType == "0") {
                                    startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
                                } else if (userType == "1") {
                                    startActivity(new Intent(getApplicationContext(), Home_Activity_Pelajar.class));
                                } else if (userType == "2") {
                                    startActivity(new Intent(getApplicationContext(), Home_Activity_IbuBapa.class));
                                }
                            }


                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }};

                        } else {
                        Toast.makeText(Login_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        });

    }
}