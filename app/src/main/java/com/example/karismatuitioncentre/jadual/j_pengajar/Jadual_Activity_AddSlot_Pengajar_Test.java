package com.example.karismatuitioncentre.jadual.j_pengajar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Jadual_Activity_AddSlot_Pengajar_Test extends AppCompatActivity
{
    EditText subjek,pengajar;
    Button submit,back;
    TextView masaS,masaE,tvSubjectSet,tvPengajarSet,tvTimeBeforeSet,tvTimeAfterSet;
    int t1Hour,t1Minute,t2Hour,t2Minute;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadual_addslot_pengajar);
        String day_key=getIntent().getStringExtra("day_key");
        Objects.requireNonNull(getSupportActionBar()).setTitle("Menambah Maklumat Slot Jadual");
        getSupportActionBar().setSubtitle("day_key");


        subjek= findViewById(R.id.add_subjek);
        pengajar= findViewById(R.id.add_pengajar);
        masaS= findViewById(R.id.tvAddSlot_masaStart);
        masaE= findViewById(R.id.tvAddSlot_masaEnd);
        tvSubjectSet= findViewById(R.id.tvSubjectSet);
        tvPengajarSet= findViewById(R.id.tvPengajarSet);
        tvTimeBeforeSet= findViewById(R.id.tvTimeBeforeSet);
        tvTimeAfterSet= findViewById(R.id.tvTimeAfterSet);

        tvSubjectSet.setVisibility(View.GONE);
        tvPengajarSet.setVisibility(View.GONE);
        tvTimeBeforeSet.setVisibility(View.GONE);
        tvTimeAfterSet.setVisibility(View.GONE);

        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pengajar_Test.class);
            intent.putExtra("day_key", day_key);
            startActivity(intent);
            finish();
        });

        masaS.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Jadual_Activity_AddSlot_Pengajar_Test.this,
                    (view1, hourOfDay, minute) -> {
                        t1Hour=hourOfDay;
                        t1Minute=minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t1Hour,t1Minute);
                        masaS.setText(DateFormat.format("hh:mm aa",calendar));


                    },12,0,false
            );
            timePickerDialog.updateTime(t1Hour,t1Minute);

            timePickerDialog.show();
        });

        masaE.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Jadual_Activity_AddSlot_Pengajar_Test.this,
                    (view1, hourOfDay, minute) -> {
                        t2Hour=hourOfDay;
                        t2Minute=minute;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t2Hour,t2Minute);
                        masaE.setText(DateFormat.format("hh:mm aa",calendar));

                    },12,0,false
            );
            timePickerDialog.updateTime(t2Hour,t2Minute);

            timePickerDialog.show();
        });
        submit= findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> {
            String Subjek=subjek.getText().toString();
            String Pengajar=pengajar.getText().toString();
            if (TextUtils.isEmpty(Subjek)) {
                subjek.setError("Nama Pengajar diperlukan");

                return;
            }
            if (TextUtils.isEmpty(Pengajar)) {
                pengajar.setError("Kata Laluan Diperlukan");

                return;
            }

            Map<String,Object> map=new HashMap<>();
            map.put("subjek",Subjek);
            map.put("pengajar",Pengajar);
            map.put("masaSHour",Integer.toString(t1Hour) );
            map.put("masaEHour",Integer.toString(t2Hour) );
            map.put("masaSMin",Integer.toString(t1Minute));
            map.put("masaEMin",Integer.toString(t2Minute));


            FirebaseDatabase.getInstance().getReference().child(day_key).push()
                    .setValue(map)
                    .addOnSuccessListener(aVoid -> {
                        subjek.setText("");
                        pengajar.setText("");

                        Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

        });

    }


}