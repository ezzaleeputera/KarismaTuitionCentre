package com.example.karismatuitioncentre.kehadiran.k_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.kehadiran.k_pelajar.Kehadiran_Activity_QRScanner_Pelajar;
import com.example.karismatuitioncentre.kehadiran.k_pelajar.Kehadiran_Activity_ViewKehadiran_Pelajar;
import com.example.karismatuitioncentre.yuran.y_ibubapa.Yuran_Activity_SearchStudent_IbuBapa;
import com.example.karismatuitioncentre.yuran.y_ibubapa.Yuran_Activity_ViewMaklumatPembayaran_IbuBapa;

import java.util.Objects;

public class Kehadiran_Activity_Home_Pengajar extends AppCompatActivity {
    TextView btn_ScanKehadiran, btn_SejarahKehadiran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_home_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Kehadiran");

        btn_ScanKehadiran = findViewById(R.id.btn_ScanKehadiran);
        btn_SejarahKehadiran = findViewById(R.id.btn_SejarahKehadiran);


        btn_ScanKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_AttendanceMaking_Pengajar.class)));
        btn_SejarahKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_SearchStudent_Pengajar.class)));

    }
}
