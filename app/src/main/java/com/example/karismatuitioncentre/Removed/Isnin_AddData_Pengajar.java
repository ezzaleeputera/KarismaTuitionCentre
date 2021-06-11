/*
package com.example.karismatuitioncentre.Removed;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
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


public class Isnin_AddData_Pengajar extends AppCompatActivity
{
    EditText subjek,pengajar;
    Button submit,back;
    TextView masa;
    int t1Hour,t1Minute*/
/*,t2Hour,t2Minute*//*
;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari_adddata_pengajar);

        subjek= findViewById(R.id.add_subjek);
        pengajar= findViewById(R.id.et_editSlot_pengajar);
        masa= findViewById(R.id.tvEditSlot_masaStart);


        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),
                    Isnin_Activity_Pengajar.class));
            finish();
        });
        masa.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Isnin_AddData_Pengajar.this,
                    (view1, hourOfDay, minute) -> {
                        t1Hour=hourOfDay;
                        t1Minute=minute;
    //                    t2Hour=hourOfDay;
    //                    t2Minute=hourOfDay;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t1Hour,t1Minute);
                        masa.setText(DateFormat.format("hh:mm aa",calendar));


                    },12,0,false
            );
            timePickerDialog.updateTime(t1Hour,t1Minute);

            timePickerDialog.show();
        });
        submit= findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> processinsert());
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("subjek",subjek.getText().toString());
        map.put("pengajar",pengajar.getText().toString());
//        map.put("masa",masa.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Jadual_Isnin").push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    subjek.setText("");
                    pengajar.setText("");
                    masa.setText("");

                    Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

    }
}*/
