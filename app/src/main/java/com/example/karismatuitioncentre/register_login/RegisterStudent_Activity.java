package com.example.karismatuitioncentre.register_login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterStudent_Activity extends AppCompatActivity {

    EditText emel_regP,nama_regP,noKP_regP,kl_regP;
    CheckBox cbBM,cbBI,cbMt,cbAMt,cbPhy,cbBio,cbPp,cbSai,cbKim,cbBC;
    TextView btn_reg;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pelajar);

        emel_regP = findViewById(R.id.emel_regP);
        nama_regP = findViewById(R.id.nama_regP);
        noKP_regP = findViewById(R.id.noKP_regP);
        kl_regP = findViewById(R.id.kl_regP);

        cbBM= findViewById(R.id.cb_BM);
        cbBI= findViewById(R.id.cb_BI);
        cbMt= findViewById(R.id.cb_Mt);
        cbAMt= findViewById(R.id.cb_AMt);
        cbPhy= findViewById(R.id.cb_Phy);
        cbBio = findViewById(R.id.cb_Bio);
        cbPp= findViewById(R.id.cb_Pp);
        cbSai= findViewById(R.id.cb_Sai);
        cbKim= findViewById(R.id.cb_Kim);
        cbBC= findViewById(R.id.cb_BC);
        btn_reg = findViewById(R.id.btn_reg);

        final String[] cbBMStatus = {"0"};
        final String[] cbBIStatus = {"0"};
        final String[] cbMtStatus = {"0"};
        final String[] cbAMtStatus = {"0"};
        final String[] cbPhyStatus = {"0"};
        final String[] cbBioStatus = {"0"};
        final String[] cbPpStatus = {"0"};
        final String[] cbSaiStatus = {"0"};
        final String[] cbKimStatus = {"0"};
        final String[] cbBCStatus = {"0"};
        String QuizGradePast="Empty";
        String QuizGradeLatest="Empty";
        String TestGradePast="Empty";
        String TestGradeLatest="Empty";
        String TeacherStatement="Empty";



        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        cbBM.setOnClickListener(view -> {
            if(cbBM.isChecked()){
                cbBMStatus[0] ="1";
            }
        });
        cbBI.setOnClickListener(view -> {
            if(cbBI.isChecked()){
                cbBIStatus[0] ="1";
            }
        });
        cbMt.setOnClickListener(view -> {
            if(cbMt.isChecked()){
                cbMtStatus[0] ="1";
            }
        });
        cbAMt.setOnClickListener(view -> {
            if(cbAMt.isChecked()){
                cbAMtStatus[0] ="1";
            }
        });
        cbPhy.setOnClickListener(view -> {
            if(cbPhy.isChecked()){
                cbPhyStatus[0] ="1";
            }
        });
        cbBio.setOnClickListener(view -> {
            if(cbBio.isChecked()){
                cbBioStatus[0] ="1";
            }
        });
        cbPp.setOnClickListener(view -> {
            if(cbPp.isChecked()){
                cbPpStatus[0] ="1";
            }
        });
        cbSai.setOnClickListener(view -> {
            if(cbSai.isChecked()){
                cbSaiStatus[0] ="1";
            }
        });
        cbKim.setOnClickListener(view -> {
            if(cbKim.isChecked()){
                cbKimStatus[0] ="1";
            }
        });cbBC.setOnClickListener(view -> {
            if(cbBC.isChecked()){
                cbBCStatus[0] ="1";
            }
        });


        btn_reg.setOnClickListener(view -> {


            String emailP = emel_regP.getText().toString().trim();
            String namaP = nama_regP.getText().toString().trim();
            String kpP = noKP_regP.getText().toString().trim();
            String klP = kl_regP.getText().toString().trim();
            String eP = "empty";
            String idP = "empty";
            String toUser = "1";// 1 refer to student

            //CheckBoxes






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
            if (klP.length() < 6) {
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

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                        String userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();


                        Map<String, Object> user = new HashMap<>();
                        user.put("email", emailP);
                        user.put("nama", namaP);
                        user.put("kp", kpP);
                        user.put("kl", klP);
                        user.put("email_Parent", eP);
                        user.put("Parent_ID", idP);
                        user.put("to_User", toUser);
                        user.put("userid", userID);
                        ref.child("User_list").push()
                                .setValue(user)
                                .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                        if(cbBMStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("BM_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbBIStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("BI_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbMtStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Mt_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbAMtStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("AMt_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbPhyStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Phy_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbBioStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Bio_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbPpStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Pp_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbSaiStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Sai_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show();
                                        }
                                    });
                        }
                        if(cbKimStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("Kim_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }
                        if(cbBCStatus[0].equals("1")) {
                            Map<String, Object> subject = new HashMap<>();
                            subject.put("userid", userID);
                            subject.put("QuizGradePast", QuizGradePast);
                            subject.put("TestGradePast", TestGradePast);
                            subject.put("QuizGradeLatest", QuizGradeLatest);
                            subject.put("TestGradeLatest", TestGradeLatest);
                            subject.put("TeacherStatement", TeacherStatement);
                            ref.child("BC_Perf").push()
                                    .setValue(subject)
                                    .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                        }


                        startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                    } else {
                        Toast.makeText(RegisterStudent_Activity.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        });

    }


}

