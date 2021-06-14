package com.example.karismatuitioncentre.register.reg_pelajar;

import androidx.annotation.NonNull;
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


import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.register.reg_ibubapa.Register_Activity_RegIbubapa_Pengajar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register_Activity_RegPelajar_Pengajar extends AppCompatActivity {

    EditText emel_regP,nama_regP,noKP_regP,kl_regP;
    CheckBox cbBM,cbBI,cbMt,cbAMt,cbPhy,cbBio,cbPp,cbSai,cbKim,cbBC;
    TextView btn_regP;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    int numTest=0;
    String subPushKey;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pelajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pendaftaran(Pelajar)");
        getSupportActionBar().setSubtitle("Isi maklumat Pelajar");


        String parentID_key=getIntent().getStringExtra("parentID_key");
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
        btn_regP = findViewById(R.id.btn_regP);

        //Values of subject
        final String[] cbBMStatus = {"0"},cbBIStatus = {"0"},cbMtStatus = {"0"},cbAMtStatus = {"0"},cbPhyStatus = {"0"},cbBioStatus = {"0"},cbPpStatus = {"0"},cbSaiStatus = {"0"},cbKimStatus = {"0"},cbBCStatus = {"0"};

        //Values of Performance
        String QuizGradePast="Empty",QuizGradeLatest="Empty",TestGradePast="Empty",TestGradeLatest="Empty",TeacherStatement="Empty";

        //Values of Fee
        String JanFee="Belum Dibayar",FebFee="Belum Dibayar",MarFee="Belum Dibayar",AprFee="Belum Dibayar",MayFee="Belum Dibayar",JunFee="Belum Dibayar",JulFee="Belum Dibayar",AugFee="Belum Dibayar",SepFee="Belum Dibayar",OctFee="Belum Dibayar",NovFee="Belum Dibayar",DecFee="Belum Dibayar";

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        cbBM.setOnClickListener(view -> {
            if(cbBM.isChecked()){
                cbBMStatus[0] ="1";
            }else{
                cbBMStatus[0] ="0";

            }
        });
        cbBI.setOnClickListener(view -> {
            if(cbBI.isChecked()){
                cbBIStatus[0] ="1";
            }else{
                cbBIStatus[0] ="0";

            }
        });
        cbMt.setOnClickListener(view -> {
            if(cbMt.isChecked()){
                cbMtStatus[0] ="1";
            }else{
                cbMtStatus[0] ="0";

            }
        });
        cbAMt.setOnClickListener(view -> {
            if(cbAMt.isChecked()){
                cbAMtStatus[0] ="1";
            }else{
                cbAMtStatus[0] ="0";

            }
        });
        cbPhy.setOnClickListener(view -> {
            if(cbPhy.isChecked()){
                cbPhyStatus[0] ="1";
            }else{
                cbPhyStatus[0] ="0";

            }
        });
        cbBio.setOnClickListener(view -> {
            if(cbBio.isChecked()){
                cbBioStatus[0] ="1";
            }else{
                cbBioStatus[0] ="0";

            }
        });
        cbPp.setOnClickListener(view -> {
            if(cbPp.isChecked()){
                cbPpStatus[0] ="1";
            }else{
                cbPpStatus[0] ="0";

            }
        });
        cbSai.setOnClickListener(view -> {
            if(cbSai.isChecked()){
                cbSaiStatus[0] ="1";
            }else{
                cbSaiStatus[0] ="0";

            }
        });
        cbKim.setOnClickListener(view -> {
            if(cbKim.isChecked()){
                cbKimStatus[0] ="1";
            }else{
                cbKimStatus[0] ="0";

            }
        });cbBC.setOnClickListener(view -> {
            if(cbBC.isChecked()){
                cbBCStatus[0] ="1";
            }else{
                cbBCStatus[0] ="0";

            }
        });


        btn_regP.setOnClickListener(view -> {

            String emailP = emel_regP.getText().toString().trim();
            String namaP = nama_regP.getText().toString().trim();
            String kpP = noKP_regP.getText().toString().trim();
            String klP = kl_regP.getText().toString().trim();



            if (TextUtils.isEmpty(namaP)) {
                nama_regP.setError("Nama Diperlukan");

                return;
            }
            if (namaP.length() < 6) {
                noKP_regP.setError("nama perlu >=6  aksara");
                return;
            }



            if (TextUtils.isEmpty(emailP)) {
                emel_regP.setError("Emel Diperlukan");

                return;
            }


            if (TextUtils.isEmpty(emailP)) {
                emel_regP.setError("Emel Diperlukan");

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
                noKP_regP.setError("Kad Pengenalan perlu >=12  aksara");
                return;
            }
            if (klP.length() < 6) {
                kl_regP.setError("Kata Laluan perlu >= 6 aksara");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);


            fAuth.createUserWithEmailAndPassword(emailP, klP).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(Register_Activity_RegPelajar_Pengajar.this, "Berjaya didaftarkan", Toast.LENGTH_SHORT).show();

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                    String userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();



                    //User (Student) Info Mapping
                    Map<String, Object> userP = new HashMap<>();
                    userP.put("to_User", "1");  // to_user "1" refer to student
                    userP.put("userid", userID);
                    userP.put("parentid", parentID_key);
                    userP.put("email", emailP);
                    ref.child("User_list").push()
                            .setValue(userP)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());


                    //Student Specific Info Mapping
                    Map<String, Object> student = new HashMap<>();
                    student.put("email", emailP);
                    student.put("nama", namaP);
                    student.put("kp", kpP);
                    student.put("kl", klP);
                    student.put("to_User", "1");
                    student.put("userid", userID);
                    student.put("parentid", parentID_key);
                    ref.child("Student_list").push()
                            .setValue(student)
                            .addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(), "Penambahan maklumat pelajar berjaya", Toast.LENGTH_LONG).show())
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());


                    //Student Subjects Mapping
                    if(cbBMStatus[0].equals("1")) {
                        subPushKey=ref.child("BM_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("BM_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                            ref.child("BM_Perf").child("List_Student").child(subPushKey).child("numTest").setValue(numTest);
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbBIStatus[0].equals("1")) {
                        subPushKey=ref.child("BI_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("numTest", numTest);
                        subject.put("kp", kpP);
                        ref.child("BI_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbMtStatus[0].equals("1")) {
                        subPushKey=ref.child("Mt_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Mt_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbAMtStatus[0].equals("1")) {
                        subPushKey=ref.child("AMt_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("AMt_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbPhyStatus[0].equals("1")) {
                        subPushKey=ref.child("Phy_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Phy_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbBioStatus[0].equals("1")) {
                        subPushKey=ref.child("Bio_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Bio_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }
                    if(cbPpStatus[0].equals("1")) {
                        subPushKey=ref.child("Pp_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Pp_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }

                    if(cbSaiStatus[0].equals("1")) {
                        subPushKey=ref.child("Kim_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Sai_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }

                    if(cbKimStatus[0].equals("1")) {
                        subPushKey=ref.child("Kim_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        subject.put("numTest", numTest);
                        ref.child("Kim_Perf").child("List_Student").push()
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                        }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }

                    if(cbBCStatus[0].equals("1")) {
                        subPushKey=ref.child("BC_Perf").child("List_Student").push().getKey();

                        Map<String, Object> subject = new HashMap<>();
                        subject.put("userid", userID);
                        subject.put("parentid", parentID_key);
                        subject.put("nama", namaP);
                        subject.put("kp", kpP);
                        assert subPushKey != null;
                        ref.child("BC_Perf").child("List_Student").child(subPushKey)
                                .setValue(subject)
                                .addOnSuccessListener(aVoid -> {
                                    Toast.makeText(getApplicationContext(), "Penambahan subjek berjaya", Toast.LENGTH_LONG).show();
                                }



                                )
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Tidak Berjaya", Toast.LENGTH_LONG).show());

                    }

                    //Student Fee Mapping
                    Map<String, Object> fee = new HashMap<>();
                    fee.put("userid", userID);
                    fee.put("parentid", parentID_key);
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
                    Intent intent = new Intent(getApplicationContext(), Home_Activity_Pengajar.class);

                } else {
                    Toast.makeText(Register_Activity_RegPelajar_Pengajar.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });

        });

    }


}




