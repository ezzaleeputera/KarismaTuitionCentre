package com.example.karismatuitioncentre.prestasi.p_ibubapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_Activity_ViewRemarks_Pelajar;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_Activity_ViewTestResult_Pelajar;

import java.util.Objects;

public class Prestasi_Activity_Home_ViewTestRemark_IbuBapa extends AppCompatActivity {
    Button btn_ViewRemark,btn_ViewTestResult,btn_EditPerformance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_home_viewedit_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Prestasi");
        getSupportActionBar().setSubtitle("Pilih untuk melihat ujian atau rumusan");

        String Sub_Key=getIntent().getStringExtra("Sub_Key");
        String User_Key=getIntent().getStringExtra("User_Key");

        btn_ViewTestResult = findViewById(R.id.btn_ViewTestResult);
        btn_ViewRemark = findViewById(R.id.btn_ViewRemark);
        btn_EditPerformance = findViewById(R.id.btn_EditPerformance);
        btn_EditPerformance.setVisibility(View.GONE);

        btn_ViewTestResult.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewTestResult_IbuBapa.class);
            intent.putExtra("Sub_Key", Sub_Key);
            intent.putExtra("User_Key",User_Key);
            startActivity(intent);
            finish();

        } );

        btn_ViewRemark.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewRemarks_IbuBapa.class);
            intent.putExtra("Sub_Key", Sub_Key);
            intent.putExtra("User_Key",User_Key);
            startActivity(intent);
            finish();

        } );


    }
}