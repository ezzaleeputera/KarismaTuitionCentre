package com.example.karismatuitioncentre.kehadiran.k_pengajar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Kehadiran_Activity_AttendanceMaking_Pengajar extends AppCompatActivity  {
    TextView tv_SpinnerSupport,tvMasa_Start,tvMasa_End;
    EditText etNamaPengajar,etNamaSubjekAttendance;
    Button btn_createAttendance;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    int t1Hour,t1Minute,t2Hour,t2Minute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_maklumatkehadiran_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Kehadiran");
        getSupportActionBar().setSubtitle("Isi maklumat kehadiran");


        etNamaPengajar=findViewById(R.id.etNamaPengajar);
        etNamaSubjekAttendance=findViewById(R.id.etNamaSubjekAttendance);
        tvMasa_Start=findViewById(R.id.tvMasa_Start);
        tvMasa_End=findViewById(R.id.tvMasa_End);
        btn_createAttendance=findViewById(R.id.btn_createAttendance);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Kehadiran");


        tvMasa_Start.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Kehadiran_Activity_AttendanceMaking_Pengajar.this,
                    (view1, hourOfDay, minute) -> {
                        t1Hour=hourOfDay;
                        t1Minute=minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t1Hour,t1Minute);
                        tvMasa_Start.setText(DateFormat.format("hh:mm aa",calendar));


                    },12,0,false
            );
            timePickerDialog.updateTime(t1Hour,t1Minute);

            timePickerDialog.show();
        });

        tvMasa_End.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Kehadiran_Activity_AttendanceMaking_Pengajar.this,
                    (view1, hourOfDay, minute) -> {
                        t2Hour=hourOfDay;
                        t2Minute=minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t2Hour,t2Minute);
                        tvMasa_End.setText(DateFormat.format("hh:mm aa",calendar));


                    },12,0,false
            );
            timePickerDialog.updateTime(t2Hour,t2Minute);

            timePickerDialog.show();
        });

        btn_createAttendance.setOnClickListener(view -> {
            String Nama_Pengajar=etNamaPengajar.getText().toString();

            if (TextUtils.isEmpty(Nama_Pengajar)) {
                etNamaPengajar.setError("Nama Pengajar diperlukan");

                return;
            }
            String Nama_Subjek=etNamaSubjekAttendance.getText().toString();

            if (TextUtils.isEmpty(Nama_Pengajar)) {
                etNamaSubjekAttendance.setError("Nama Subjek diperlukan");

                return;
            }



            Map<String,Object> map=new HashMap<>();
            map.put("nama_pengajar",Nama_Pengajar);
            map.put("nama_subjek",Nama_Subjek);
            map.put("masaSHour",Integer.toString(t1Hour) );
            map.put("masaEHour",Integer.toString(t2Hour) );
            map.put("masaSMin",Integer.toString(t1Minute));
            map.put("masaEMin",Integer.toString(t2Minute));
            map.put("kodQR","");

            String attKey=FirebaseDatabase.getInstance().getReference().child("Kehadiran").push().getKey();
            assert attKey != null;
            FirebaseDatabase.getInstance().getReference().child("Kehadiran").child(attKey)
                    .setValue(map)
                    .addOnSuccessListener(aVoid -> {
                        Intent intent = new Intent(getApplicationContext(), Kehadiran_Activity_QRGenerator_Pengajar.class);
                        intent.putExtra("attKey", attKey);
                        startActivity(intent);
                        finish();

                        Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

        });
    }
}

