package com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;

import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Activity_Pelajar_IbuBapa;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MaklumBalas_Activity_AddData_Pelajar_IbuBapa extends AppCompatActivity
{
    EditText title,desc;
    Button submit,back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maklumbalas_adddata_pelajar_ibubapa);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Penambahan Maklum Balas");
        getSupportActionBar().setSubtitle("Isi maklum balas");

        title=findViewById(R.id.add_title);
        desc=findViewById(R.id.add_desc);


        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),
                    MaklumBalas_Activity_Pelajar_IbuBapa.class));
            finish();
        });

        submit=findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> {

            String Title = title.getText().toString().trim();
            String Desc = desc.getText().toString().trim();

            if (TextUtils.isEmpty(Title)) {
                title.setError("Tajuk diperlukan");

                return;
            }
            if (Title.length() < 4) {
                title.setError("Tajuk pendek: perlu >3 aksara");
                return;
            }
            if (TextUtils.isEmpty(Desc)) {
                desc.setError("Isi Maklum Balas diperlukan");

                return;
            }
            if (Desc.length() < 12) {
                desc.setError("Maklum Balas pendek: perlu >11 aksara");
                return;
            }

            Map<String,Object> map=new HashMap<>();
            map.put("title",Title);
            map.put("desc",Desc);

            FirebaseDatabase.getInstance().getReference().child("MaklumBalas_List").push()
                    .setValue(map)
                    .addOnSuccessListener(aVoid -> {
                        title.setText("");
                        desc.setText("");

                        Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

        });
    }



}