package com.example.karismatuitioncentre.maklumbalas;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;



public class MaklumBalas_AddData_Pelajar_IbuBapa extends AppCompatActivity
{
    EditText title,desc;
    Button submit,back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maklumbalas_adddata_pelajar_ibubapa);

        title=findViewById(R.id.add_title);
        desc=findViewById(R.id.add_desc);


        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),
                    MaklumBalas_Activity_Pelajar_IbuBapa.class));
            finish();
        });

        submit=findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> processinsert());
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("title",title.getText().toString());
        map.put("desc",desc.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("MaklumBalas_List").push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    title.setText("");
                    desc.setText("");

                    Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

    }
}