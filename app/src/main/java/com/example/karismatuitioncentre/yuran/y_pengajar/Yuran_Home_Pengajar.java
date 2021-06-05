package com.example.karismatuitioncentre.yuran.y_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_Pengajar;


public class Yuran_Home_Pengajar extends AppCompatActivity {
    TextView btn_VStatusYuran, btn_VMaklumatYuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran);

        btn_VStatusYuran = findViewById(R.id.btn_VStatusYuran);
        btn_VMaklumatYuran = findViewById(R.id.btn_VMaklumatYuran);


        btn_VStatusYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_Pengajar.class)));
        btn_VMaklumatYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_SetMaklumatYuran_Pengajar.class)));

    }
}