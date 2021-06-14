package com.example.karismatuitioncentre.yuran.y_ibubapa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_SearchStudent_Pengajar;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_SetMaklumatPembayaran_Pengajar;

import java.util.Objects;

public class Yuran_Activity_Home_IbuBapa extends AppCompatActivity {
    TextView btn_VStatusYuran, btn_VMaklumatYuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_home_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Yuran");


        btn_VStatusYuran = findViewById(R.id.btn_VStatusYuran);
        btn_VMaklumatYuran = findViewById(R.id.btn_VMaklumatYuran);


        btn_VStatusYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_SearchStudent_IbuBapa.class)));
        btn_VMaklumatYuran.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Yuran_Activity_ViewMaklumatPembayaran_IbuBapa.class)));

    }
}