package com.example.karismatuitioncentre.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pelajaribubapa.Jadual_Activity_Home_Pelajar_IbuBapa_Test;
import com.example.karismatuitioncentre.kehadiran.k_pelajar.Kehadiran_Activity_Home_Pelajar;
import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Activity_Pelajar_IbuBapa;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_Activity_Home_Pelajar;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_Activity_Home_Pelajar;

import java.util.Objects;

public class Home_Activity_Pelajar extends AppCompatActivity {
    TextView btnJadual, btnKehadiran,/* btnYuran, btnPendaftaran,*/ btnLporanPrestasi, btnMaklumBalas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pelajar);
        Objects.requireNonNull(getSupportActionBar()).hide();


        btnJadual = findViewById(R.id.btn_Jadual);
        btnKehadiran = findViewById(R.id.btn_Kehadiran);
        btnLporanPrestasi = findViewById(R.id.btn_LPrestasi);
        btnMaklumBalas = findViewById(R.id.btn_MaklumBalas);

        btnJadual.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Jadual_Activity_Home_Pelajar_IbuBapa_Test.class)));
        btnKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_Home_Pelajar.class)));
        btnLporanPrestasi.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Prestasi_Activity_Home_Pelajar.class)));
        btnMaklumBalas.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MaklumBalas_Activity_Pelajar_IbuBapa.class)));
    }
}