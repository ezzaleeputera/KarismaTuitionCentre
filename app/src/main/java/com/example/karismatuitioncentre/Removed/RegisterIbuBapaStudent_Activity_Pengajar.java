/*
package com.example.karismatuitioncentre.register_login.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterIbuBapaStudent_Activity_Pengajar extends AppCompatActivity {

    EditText emel_regP,nama_regP,noKP_regP,kl_regP,emel_regIB,nama_regIB,noKP_regIB,kl_regIB;
    CheckBox cbBM,cbBI,cbMt,cbAMt,cbPhy,cbBio,cbPp,cbSai,cbKim,cbBC;
    TextView btn_regP;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pelajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pendaftaran");
        getSupportActionBar().setSubtitle("Isi maklumat pelajar dan IbuBapa");
        emel_regP = findViewById(R.id.emel_regP);
        nama_regP = findViewById(R.id.nama_regP);
        noKP_regP = findViewById(R.id.noKP_regP);
        kl_regP = findViewById(R.id.kl_regP);
        emel_regIB = findViewById(R.id.emel_regIB);
        nama_regIB = findViewById(R.id.nama_regIB);
        noKP_regIB = findViewById(R.id.noKP_regIB);
        kl_regIB = findViewById(R.id.kl_regIB);

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
        btn_regP = findViewById(R.id.btn_regP);

        //Values of subject
        final String[] cbBMStatus = {"0"},cbBIStatus = {"0"},cbMtStatus = {"0"},cbAMtStatus = {"0"},cbPhyStatus = {"0"},cbBioStatus = {"0"},cbPpStatus = {"0"},cbSaiStatus = {"0"},cbKimStatus = {"0"},cbBCStatus = {"0"};

        //Values of Performance
        String QuizGradePast="Empty",QuizGradeLatest="Empty",TestGradePast="Empty",TestGradeLatest="Empty",TeacherStatement="Empty";

        //Values of Fee
        String JanFee="Unpaid",FebFee="Unpaid",MarFee="Unpaid",AprFee="Unpaid",MayFee="Unpaid",JunFee="Unpaid",JulFee="Unpaid",AugFee="Unpaid",SepFee="Unpaid",OctFee="Unpaid",NovFee="Unpaid",DecFee="Unpaid";





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


        btn_regP.setOnClickListener(view -> {


            String emailP = emel_regP.getText().toString().trim();
            String namaP = nama_regP.getText().toString().trim();
            String kpP = noKP_regP.getText().toString().trim();
            String klP = kl_regP.getText().toString().trim();
            String eP = "empty";
            String idP = "empty";
            String emailIB = emel_regIB.getText().toString().trim();
            String namaIB = nama_regIB.getText().toString().trim();
            String kpIB = noKP_regIB.getText().toString().trim();
            String klIB = kl_regIB.getText().toString().trim();




            if (TextUtils.isEmpty(emailP)) {
                emel_regP.setError("Emel Diperlukan");

                return;
            }            if (TextUtils.isEmpty(emailP)) {
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
            if (kpP.length() < 12) {
                kl_regP.setError("Kad Pengenalan perlu >= 6 aksara");
                return;
            }
            if (klP.length() < 6) {
                kl_regP.setError("Kata Laluan perlu >= 6 aksara");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);


            fAuth.createUserWithEmailAndPassword(emailP, String.valueOf(klP)).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(RegisterIbuBapaStudent_Activity_Pengajar.this, "Berjaya didaftarkan", Toast.LENGTH_SHORT).show();

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                    String userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();



                    //User (Student) Info Mapping
                    Map<String, Object> userP = new HashMap<>();
//                    userP.put("email", emailP);
//                    userP.put("kl", klP);
                    userP.put("to_User", "1");  // to_user "1" refer to student
                    userP.put("userid", userID);
                    ref.child("User_list").push()
                            .setValue(userP)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    //User (Parents) Info Mapping
                    Map<String, Object> userIB = new HashMap<>();
//                    userIB.put("email", emailIB);
//                    userIB.put("kl", klIB);
                    userIB.put("to_User", "2"); // to_user "2" refer to student
                    userIB.put("userid", userID);
                    ref.child("User_list").push()
                            .setValue(userIB)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    //Student Specific Info Mapping
                    Map<String, Object> student = new HashMap<>();
                    student.put("email", emailP);
                    student.put("nama", namaP);
                    student.put("kp", kpP);
                    student.put("kl", klP);
                    student.put("email_Parent", emailIB);
                    student.put("Parent_ID", idP);
                    student.put("to_User", "1");
                    student.put("userid", userID);
                    ref.child("Student_list").push()
                            .setValue(student)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    //Student Specific Info Mapping
                    Map<String, Object> parent = new HashMap<>();
                    parent.put("email", emailIB);
                    parent.put("nama", namaIB);
                    parent.put("kp", kpIB);
                    parent.put("kl", klIB);
                    parent.put("email_Parent", emailIB);
                    parent.put("to_User", "2");
                    parent.put("userid", userID);
                    ref.child("Parent_list").push()
                            .setValue(parent)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());




                    //Student Subjects Mapping
                    if(cbBMStatus[0].equals("1")) {
                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
                        subject.put("QuizGradePast", QuizGradePast);
                        subject.put("TestGradePast", TestGradePast);
                        subject.put("QuizGradeLatest", QuizGradeLatest);
                        subject.put("TestGradeLatest", TestGradeLatest);
                        subject.put("TeacherStatement", TeacherStatement);
                        ref.child("Sai_Perf").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                    }
                    if(cbKimStatus[0].equals("1")) {
                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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
                        subject.put("nama", namaP);
                        subject.put("email", emailP);
                        subject.put("kp", kpP);
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

                    //Student Fee Mapping
                    Map<String, Object> fee = new HashMap<>();
                    fee.put("userid", userID);
                    fee.put("nama", namaP);
                    fee.put("email", emailP);
                    fee.put("kp", kpP);
                    fee.put("JanFee", JanFee);
                    fee.put("FebFee", FebFee);
                    fee.put("MarFee", MarFee);
                    fee.put("AprFee", AprFee);
                    fee.put("MayFee", MayFee);
                    fee.put("JunFee", JunFee);
                    fee.put("JulFee", JulFee);
                    fee.put("AugFee", AugFee);
                    fee.put("SepFee", SepFee);
                    fee.put("OctFee", OctFee);
                    fee.put("NovFee", NovFee);
                    fee.put("DecFee", DecFee);
                    ref.child("Stud_Fee").push()
                            .setValue(fee)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());
                    finish();
                    startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));

                } else {
                    Toast.makeText(RegisterIbuBapaStudent_Activity_Pengajar.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });

        });

    }


}

*/
