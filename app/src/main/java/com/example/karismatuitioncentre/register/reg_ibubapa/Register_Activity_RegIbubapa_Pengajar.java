package com.example.karismatuitioncentre.register.reg_ibubapa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.register.reg_pelajar.Register_Activity_RegPelajar_Pengajar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register_Activity_RegIbubapa_Pengajar extends AppCompatActivity {

    EditText emel_regIB,nama_regIB,noKP_regIB,kl_regIB;
    TextView btn_regIB/*,testSnap1,testSnap2*/;
    DatabaseReference dataSnapshot;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
/*    String namaStudent,emelStudent,icStudent,useridStudent;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_ibubapa);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pendaftaran(Ibu Bapa)");
        getSupportActionBar().setSubtitle("Isi maklumat IbuBapa");


        emel_regIB = findViewById(R.id.emel_regIB);
        nama_regIB = findViewById(R.id.nama_regIB);
        noKP_regIB = findViewById(R.id.noKP_regIB);
        kl_regIB = findViewById(R.id.kl_regIB);
        btn_regIB = findViewById(R.id.btn_regIB);

/*        testSnap1=findViewById(R.id.testSnapshot1);
        testSnap2=findViewById(R.id.testSnapshot2);*/

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBarIB);

        dataSnapshot=FirebaseDatabase.getInstance().getReference().child("Student_list");
//        String studentID_key=getIntent().getStringExtra("studentID_key");
//        final String[] namaS ;
//        final String[]  emelS;
//        final String[]  icS;
//        final String[]  useridS;



        btn_regIB.setOnClickListener(view -> {


            String emailIB = emel_regIB.getText().toString().trim();
            String namaIB = nama_regIB.getText().toString().trim();
            String kpIB = noKP_regIB.getText().toString().trim();
            String klIB = kl_regIB.getText().toString().trim();




            if (TextUtils.isEmpty(emailIB)) {
                emel_regIB.setError("Emel Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(namaIB)) {
                nama_regIB.setError("Nama Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(kpIB)) {
                noKP_regIB.setError("No. IC Diperlukan");

                return;
            }
            if (TextUtils.isEmpty(klIB)) {
                kl_regIB.setError("Kata Laluan Diperlukan");

                return;
            }
            if (kpIB.length() < 12) {
                noKP_regIB.setError("Kad Pengenalan perlu >= 6 aksara");
                return;
            }
            if (klIB.length() < 6) {
                kl_regIB.setError("Kata Laluan perlu >= 6 aksara");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(emailIB, klIB).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(Register_Activity_RegIbubapa_Pengajar.this, "Berjaya didaftarkan", Toast.LENGTH_SHORT).show();

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                    String userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();


                    //User (Parents) Info Mapping
                    Map<String, Object> userIB = new HashMap<>();
                    userIB.put("to_User", "2"); // to_user "2" refer to student
                    userIB.put("email", emailIB);
                    userIB.put("userid", userID);
                    userIB.put("parentid", userID);
                    ref.child("User_list").push()
                            .setValue(userIB)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());


                    //Parent Specific Info Mapping
                    Map<String, Object> parent = new HashMap<>();
                    parent.put("email", emailIB);
                    parent.put("nama", namaIB);
                    parent.put("kp", kpIB);
                    parent.put("kl", klIB);
                    parent.put("to_User", "2");
                    parent.put("parentid", userID);
                    ref.child("Parent_list").push()
                            .setValue(parent)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat IbuBapa berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());


//                    finish();
//                    startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                    finish();
                    Intent intent = new Intent(getApplicationContext(), Register_Activity_RegPelajar_Pengajar.class);
                    intent.putExtra("parentID_key", userID);
                    startActivity(intent);

                } else {
                    Toast.makeText(Register_Activity_RegIbubapa_Pengajar.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        });
    }


}

