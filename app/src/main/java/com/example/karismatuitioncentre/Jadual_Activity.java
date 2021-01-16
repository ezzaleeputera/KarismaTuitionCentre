package com.example.karismatuitioncentre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Jadual_Activity extends AppCompatActivity {
TextView btnIsnin, btnSelasa,btnRabu,btnKhamis,btnJumaat,btnSabtu,btnAhad;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadual);

        btnIsnin=findViewById(R.id.btn_Isnin);
        btnSelasa=findViewById(R.id.btn_Selasa);
        btnRabu=findViewById(R.id.btn_Rabu);
        btnKhamis=findViewById(R.id.btn_Khamis);
        btnJumaat=findViewById(R.id.btn_Jumaat);
        btnSabtu=findViewById(R.id.btn_Sabtu);
        btnAhad=findViewById(R.id.btn_Ahad);

        btnIsnin.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnSelasa.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnRabu.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnKhamis.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnSelasa.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnSelasa.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
        btnSelasa.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Hari_Activity.class));
        });
    }
}
