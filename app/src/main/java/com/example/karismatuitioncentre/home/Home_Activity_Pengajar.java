package com.example.karismatuitioncentre.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jadual_Activity_Home_Pengajar_Test;
import com.example.karismatuitioncentre.kehadiran.k_pengajar.Kehadiran_Activity_Home_Pengajar;
import com.example.karismatuitioncentre.maklumbalas.mb_pengajar.MaklumBalas_Activity_Pengajar;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_Activity_Home_Pelajar;
import com.example.karismatuitioncentre.prestasi.p_pengajar.Prestasi_Activity_Home_Pengajar;
import com.example.karismatuitioncentre.register.reg_ibubapa.Register_Activity_HomeExistingNewParent_Pengajar;
import com.example.karismatuitioncentre.register.reg_ibubapa.Register_Activity_RegIbubapa_Pengajar;
import com.example.karismatuitioncentre.register.reg_pelajar.Register_Activity_RegPelajar_Pengajar;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_Home_Pengajar;

import java.util.Objects;


public class Home_Activity_Pengajar extends AppCompatActivity {
    TextView btnJadual, btnKehadiran, btnYuran, btnPendaftaran, btnLporanPrestasi, btnMaklumBalas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pengajar);
        Objects.requireNonNull(getSupportActionBar()).hide();


        btnJadual = findViewById(R.id.btn_Jadual);
        btnKehadiran = findViewById(R.id.btn_Kehadiran);
        btnYuran = findViewById(R.id.btn_Yuran);
        btnPendaftaran = findViewById(R.id.btn_Pendaftaran);
        btnLporanPrestasi = findViewById(R.id.btn_LPrestasi);
        btnMaklumBalas = findViewById(R.id.btn_MaklumBalas);

        btnJadual.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Jadual_Activity_Home_Pengajar_Test.class)));
        btnKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_Home_Pengajar.class)));
        btnYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_Home_Pengajar.class)));
        btnPendaftaran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Register_Activity_HomeExistingNewParent_Pengajar.class)));
        btnLporanPrestasi.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Prestasi_Activity_Home_Pengajar.class)));
        btnMaklumBalas.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MaklumBalas_Activity_Pengajar.class)));
    }
}