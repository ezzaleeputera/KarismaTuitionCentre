package com.example.karismatuitioncentre.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pelajaribubapa.Jadual_Activity_Home_Pelajar_IbuBapa_Test;
import com.example.karismatuitioncentre.kehadiran.k_ibubapa.Kehadiran_Activity_SearchStudent_IbuBapa;
import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Activity_Pelajar_IbuBapa;
import com.example.karismatuitioncentre.prestasi.p_ibubapa.Prestasi_Activity_Home_IbuBapa;
import com.example.karismatuitioncentre.yuran.y_ibubapa.Yuran_Activity_Home_IbuBapa;
import com.example.karismatuitioncentre.yuran.y_ibubapa.Yuran_Activity_ViewMaklumatPembayaran_IbuBapa;

import java.util.Objects;

public class Home_Activity_IbuBapa extends AppCompatActivity {
    TextView btnJadual,btnYuran, btnLporanPrestasi, btnMaklumBalas,btnKehadiran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ibubapa);
        Objects.requireNonNull(getSupportActionBar()).hide();


        btnJadual = findViewById(R.id.btn_Jadual);
        btnYuran = findViewById(R.id.btn_Yuran);
        btnLporanPrestasi = findViewById(R.id.btn_LPrestasi);
        btnMaklumBalas = findViewById(R.id.btn_MaklumBalas);
        btnKehadiran = findViewById(R.id.btn_Kehadiran);


//        btnJadual.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Jadual_Activity_Home_Pelajar.class)));
        btnJadual.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Jadual_Activity_Home_Pelajar_IbuBapa_Test.class)));
        btnYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_Home_IbuBapa.class)));
        btnKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_SearchStudent_IbuBapa.class)));
        btnLporanPrestasi.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Prestasi_Activity_Home_IbuBapa.class)));
        btnMaklumBalas.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MaklumBalas_Activity_Pelajar_IbuBapa.class)));
    }
}