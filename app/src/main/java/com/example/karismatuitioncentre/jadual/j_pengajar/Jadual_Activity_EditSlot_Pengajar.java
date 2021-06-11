package com.example.karismatuitioncentre.jadual.j_pengajar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.karismatuitioncentre.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Jadual_Activity_EditSlot_Pengajar extends AppCompatActivity
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
        String slot_key=getIntent().getStringExtra("slot_key");
        Objects.requireNonNull(getSupportActionBar()).setTitle("Mengubah Maklumat Slot Jadual");
        getSupportActionBar().setSubtitle("Sila Isi Maklumat jika terdapat perubahan");


        subjek= findViewById(R.id.add_subjek);
        pengajar= findViewById(R.id.add_pengajar);
        masaS= findViewById(R.id.tvAddSlot_masaStart);
        masaE= findViewById(R.id.tvAddSlot_masaEnd);
        tvSubjectSet= findViewById(R.id.tvSubjectSet);
        tvPengajarSet= findViewById(R.id.tvPengajarSet);
        tvTimeBeforeSet= findViewById(R.id.tvTimeBeforeSet);
        tvTimeAfterSet= findViewById(R.id.tvTimeAfterSet);

        FirebaseDatabase.getInstance().getReference().child(day_key).child(slot_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String SubjectSet= Objects.requireNonNull(snapshot.child("subjek").getValue()).toString();

                    String PengajarSet= Objects.requireNonNull(snapshot.child("pengajar").getValue()).toString();
                    String HourBeforeSet= Objects.requireNonNull(snapshot.child("masaSHour").getValue()).toString();
                    String MinuteBeforeSet= Objects.requireNonNull(snapshot.child("masaSMin").getValue()).toString();
                    String HourAfterSet= Objects.requireNonNull(snapshot.child("masaEHour").getValue()).toString();
                    String MinuteAfterSet= Objects.requireNonNull(snapshot.child("masaEMin").getValue()).toString();


                    int startH=Integer.parseInt(HourBeforeSet);
                    int startM=Integer.parseInt(MinuteBeforeSet);
                    int endH=Integer.parseInt(HourAfterSet);
                    int endM=Integer.parseInt(MinuteAfterSet);


                    tvSubjectSet.setText(SubjectSet);
                    tvPengajarSet.setText(PengajarSet);

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(0,0,0,startH,startM);
                    tvTimeBeforeSet.setText(DateFormat.format("hh:mm aa",calendar));

                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(0,0,0,endH,endM);
                    tvTimeAfterSet.setText(DateFormat.format("hh:mm aa",calendar1));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            });
        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pengajar_Test.class);
            intent.putExtra("day_key", day_key);
            startActivity(intent);
            finish();
        });



        masaS.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(
                    Jadual_Activity_EditSlot_Pengajar.this,
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
                    Jadual_Activity_EditSlot_Pengajar.this,
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

            Map<String,Object> map=new HashMap<>();
            map.put("subjek",subjek.getText().toString());
            map.put("pengajar",pengajar.getText().toString());
            map.put("masaSHour",Integer.toString(t1Hour));
            map.put("masaEHour",Integer.toString(t2Hour));
            map.put("masaSMin",Integer.toString(t1Minute));
            map.put("masaEMin",Integer.toString(t2Minute));


            FirebaseDatabase.getInstance().getReference().child(day_key).child(slot_key)
                    .setValue(map)
                    .addOnSuccessListener(aVoid -> {
                        tvSubjectSet.setText("");
                        tvPengajarSet.setText("");
                        tvSubjectSet.setVisibility(View.GONE);
                        tvPengajarSet.setVisibility(View.GONE);
                        tvTimeBeforeSet.setVisibility(View.GONE);
                        tvTimeAfterSet.setVisibility(View.GONE);

                        Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pengajar_Test.class);
                        intent.putExtra("day_key", day_key);
                        startActivity(intent);
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

        });

    }


}