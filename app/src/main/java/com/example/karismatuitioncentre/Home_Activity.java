package com.example.karismatuitioncentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {
    TextView btnJadual, btnKehadiran, btnYuran, btnPendaftaran, btnLporanPrestasi, btnMaklumBalas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnJadual = findViewById(R.id.btn_Jadual);
        btnKehadiran = findViewById(R.id.btn_Kehadiran);
        btnYuran = findViewById(R.id.btn_Yuran);
        btnPendaftaran = findViewById(R.id.btn_Pendaftaran);
        btnLporanPrestasi = findViewById(R.id.btn_LPrestasi);
        btnMaklumBalas = findViewById(R.id.btn_MaklumBalas);

        btnJadual.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
        btnKehadiran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
        btnYuran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
        btnPendaftaran.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
        btnLporanPrestasi.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
        btnMaklumBalas.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Home_Activity.class));
        });
    }
}