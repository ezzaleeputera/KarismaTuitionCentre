package com.example.karismatuitioncentre.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.Jadual_Activity;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Activity_Pelajar_IbuBapa;

public class Home_Activity_Pengajar extends AppCompatActivity {
    TextView btnJadual, btnKehadiran, btnYuran, btnPendaftaran, btnLporanPrestasi, btnMaklumBalas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pengajar);

        btnJadual = findViewById(R.id.btn_Jadual);
        btnKehadiran = findViewById(R.id.btn_Kehadiran);
        btnYuran = findViewById(R.id.btn_Yuran);
        btnPendaftaran = findViewById(R.id.btn_Pendaftaran);
        btnLporanPrestasi = findViewById(R.id.btn_LPrestasi);
        btnMaklumBalas = findViewById(R.id.btn_MaklumBalas);

        btnJadual.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Jadual_Activity.class));
        });
        btnKehadiran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
        });
        btnYuran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
        });
        btnPendaftaran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
        });
        btnLporanPrestasi.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity_Pengajar.class));
        });
        btnMaklumBalas.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MaklumBalas_Activity_Pelajar_IbuBapa.class));
        });
    }
}