package com.example.karismatuitioncentre.jadual;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pengajar.Ahad_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Isnin_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jumaat_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Khamis_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Rabu_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Sabtu_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Selasa_Activity_Pengajar;


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
            startActivity(new Intent(getApplicationContext(), Isnin_Activity_Pengajar.class));
        });
        btnSelasa.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Selasa_Activity_Pengajar.class));
        });
        btnRabu.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Rabu_Activity_Pengajar.class));
        });
        btnKhamis.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Khamis_Activity_Pengajar.class));
        });
        btnJumaat.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Jumaat_Activity_Pengajar.class));
        });
        btnSabtu.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Sabtu_Activity_Pengajar.class));
        });
        btnAhad.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Ahad_Activity_Pengajar.class));
        });
    }
}
