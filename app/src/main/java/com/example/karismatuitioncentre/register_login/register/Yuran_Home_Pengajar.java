package com.example.karismatuitioncentre.register_login.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jadual_Activity_Pengajar;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_Pengajar;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_SetMaklumatYuran_Pengajar;

public class Yuran_Home_Pengajar extends AppCompatActivity {
    TextView btnStatusYuran, btnMaklumatYuran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pengajar);

        btnStatusYuran = findViewById(R.id.btn_Jadual);
        btnMaklumatYuran = findViewById(R.id.btn_Kehadiran);


        btnStatusYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_Pengajar.class)));
        btnMaklumatYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_SetMaklumatYuran_Pengajar.class)));

    }
}