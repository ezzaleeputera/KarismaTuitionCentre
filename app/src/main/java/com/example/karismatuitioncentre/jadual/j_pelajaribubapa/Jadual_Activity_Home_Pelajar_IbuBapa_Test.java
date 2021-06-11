package com.example.karismatuitioncentre.jadual.j_pelajaribubapa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.karismatuitioncentre.R;

import java.util.Objects;

public class Jadual_Activity_Home_Pelajar_IbuBapa_Test extends AppCompatActivity {


    TextView btnIsnin, btnSelasa,btnRabu,btnKhamis,btnJumaat,btnSabtu,btnAhad;
    String day;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadual_home);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Halaman Yuran");

        btnIsnin=findViewById(R.id.btn_Isnin);
        btnSelasa=findViewById(R.id.btn_Selasa);
        btnRabu=findViewById(R.id.btn_Rabu);
        btnKhamis=findViewById(R.id.btn_Khamis);
        btnJumaat=findViewById(R.id.btn_Jumaat);
        btnSabtu=findViewById(R.id.btn_Sabtu);
        btnAhad=findViewById(R.id.btn_Ahad);

        btnIsnin.setOnClickListener(view -> {
            day="Jadual_Isnin";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();

        });
        btnSelasa.setOnClickListener(view -> {
            day="Jadual_Selasa";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();
        });
        btnRabu.setOnClickListener(view -> {
            day="Jadual_Rabu";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();

        });
        btnKhamis.setOnClickListener(view -> {
            day="Jadual_Khamis";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();

        });
        btnJumaat.setOnClickListener(view -> {
            day="Jadual_Jumaat";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();

        });
        btnSabtu.setOnClickListener(view -> {
            day="Jadual_Sabtu";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();
        });
        btnAhad.setOnClickListener(view -> {
            day="Jadual_Ahad";
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test.class);
            intent.putExtra("day_key", day);
            startActivity(intent);
            finish();
        });


    }
}
