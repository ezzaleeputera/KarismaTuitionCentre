package com.example.karismatuitioncentre.prestasi.p_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;

import java.util.Objects;

public class Prestasi_Activity_Home_UpdateView_Pengajar extends AppCompatActivity {
    Button btn_ViewPerformance,btn_EditPerformance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_home_viewedit_pengajar);
        Objects.requireNonNull(getSupportActionBar()).hide();
        String Sub_Key=getIntent().getStringExtra("Sub_Key");
        String User_Key=getIntent().getStringExtra("User_Key");

        btn_ViewPerformance = findViewById(R.id.btn_ViewPerformance);
        btn_EditPerformance = findViewById(R.id.btn_EditPerformance);


        btn_ViewPerformance.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewTestResult_Pengajar.class);
            intent.putExtra("Sub_Key", Sub_Key);
            intent.putExtra("User_Key",User_Key);
            startActivity(intent);
            finish();

        } );
        btn_EditPerformance.setOnClickListener(view ->{

            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_UpdatePerformance_Pengajar.class);
            intent.putExtra("Sub_Key",Sub_Key);
            intent.putExtra("User_Key",User_Key);
            startActivity(intent);
            finish();
        } );
/*        btnPerfBM.setOnClickListener(view ->{
            sub="BM_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_SearchStudent_Pengajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();

        } );*/

    }
}