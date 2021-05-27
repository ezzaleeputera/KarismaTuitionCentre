package com.example.karismatuitioncentre.jadual.j_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Activity_Pelajar_IbuBapa;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Isnin_AddData_Pengajar extends AppCompatActivity
{
    EditText subjek,pengajar,masa;
    Button submit,back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari_adddata_pengajar);

        subjek= findViewById(R.id.add_subjek);
        pengajar= findViewById(R.id.add_pengajar);
        masa= findViewById(R.id.add_masa);


        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),
                    Isnin_Activity_Pengajar.class));
            finish();
        });

        submit= findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> processinsert());
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("subjek",subjek.getText().toString());
        map.put("pengajar",pengajar.getText().toString());
        map.put("masa",masa.getText().toString());

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
}