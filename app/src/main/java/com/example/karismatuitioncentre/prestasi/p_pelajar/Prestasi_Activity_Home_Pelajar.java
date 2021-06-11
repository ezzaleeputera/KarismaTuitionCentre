package com.example.karismatuitioncentre.prestasi.p_pelajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pelajaribubapa.Jadual_Activity_Home_Pelajar_IbuBapa_Test;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jadual_Activity_ViewSchedule_Pengajar_Test;
import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Activity_Pelajar_IbuBapa;
import com.example.karismatuitioncentre.yuran.y_ibubapa.Yuran_Activity_ViewMaklumatPemabayaran_IbuBapa;

import java.util.Objects;

public class Prestasi_Activity_Home_Pelajar extends AppCompatActivity {
    Button btnPerfBM,btnPerfBI, btnPerfMath, btnPerfMathAdd,btnPerfPhy,btnPerfBio,btnPerfPp,btnPerfSai,btnPerfKim,btnPerfBC;
    String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_home_pelajar);
        Objects.requireNonNull(getSupportActionBar()).hide();


        btnPerfBM = findViewById(R.id.btnPerfBM);
        btnPerfBI = findViewById(R.id.btnPerfBI);
        btnPerfMath = findViewById(R.id.btnPerfMath);
        btnPerfPhy = findViewById(R.id.btnPerfPhy);
        btnPerfMathAdd = findViewById(R.id.btnPerfMathAdd);
        btnPerfBio = findViewById(R.id.btnPerfBio);
        btnPerfPp = findViewById(R.id.btnPerfPp);
        btnPerfSai = findViewById(R.id.btnPerfSai);
        btnPerfKim = findViewById(R.id.btnPerfKim);
        btnPerfBC = findViewById(R.id.btnPerfBC);

        btnPerfBM.setOnClickListener(view ->{
            sub="BM_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        } );
        btnPerfBI.setOnClickListener(view ->{
            sub="BI_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        } );
        btnPerfMath.setOnClickListener(view -> {
            sub = "Mt_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfPhy.setOnClickListener(view ->{
            sub="Phy_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        } );


        btnPerfMathAdd.setOnClickListener(view ->{
            sub="AMt_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfBio.setOnClickListener(view ->{
            sub="Bio_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfPp.setOnClickListener(view ->{
            sub="Pp_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfSai.setOnClickListener(view ->{
            sub="Sai_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfKim.setOnClickListener(view ->{
            sub="Kim_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });

        btnPerfBC.setOnClickListener(view ->{
            sub="BC_Perf";
            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_ViewPerformance_Pelajar.class);
            intent.putExtra("Sub_Key", sub);
            startActivity(intent);
            finish();
        });
    }
}