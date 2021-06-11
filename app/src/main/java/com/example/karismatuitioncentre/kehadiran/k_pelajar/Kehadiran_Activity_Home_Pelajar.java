package com.example.karismatuitioncentre.kehadiran.k_pelajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;

import java.util.Objects;


public class Kehadiran_Activity_Home_Pelajar extends AppCompatActivity {
    TextView btn_ScanKehadiran, btn_SejarahKehadiran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_home_pelajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Yuran");


        btn_ScanKehadiran = findViewById(R.id.btn_ScanKehadiran);
        btn_SejarahKehadiran = findViewById(R.id.btn_SejarahKehadiran);


        btn_ScanKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_QRScanner_Pelajar.class)));
        btn_SejarahKehadiran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Kehadiran_Activity_ViewKehadiran_Pelajar.class)));

    }
}