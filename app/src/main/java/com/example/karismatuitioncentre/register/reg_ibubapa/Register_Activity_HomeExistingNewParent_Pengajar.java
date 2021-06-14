package com.example.karismatuitioncentre.register.reg_ibubapa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.karismatuitioncentre.R;
import java.util.Objects;

public class Register_Activity_HomeExistingNewParent_Pengajar extends AppCompatActivity {
    Button btn_NewParents,btn_ExistingParents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_home_existingnewparent_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Pendaftaran");
        getSupportActionBar().setSubtitle("Pilih ibu bapa baru atau sedia ada");

        btn_NewParents = findViewById(R.id.btn_NewParents);
        btn_ExistingParents = findViewById(R.id.btn_ExistingParents);

        btn_NewParents.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), Register_Activity_RegIbubapa_Pengajar.class);
            startActivity(intent);
            finish();

        } );

        btn_ExistingParents.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), Register_Activity_ExistingParent_Pengajar.class);
            startActivity(intent);
            finish();

        } );

    }
}