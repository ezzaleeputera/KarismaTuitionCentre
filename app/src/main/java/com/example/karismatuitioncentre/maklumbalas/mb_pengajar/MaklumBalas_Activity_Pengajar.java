package com.example.karismatuitioncentre.maklumbalas.mb_pengajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MaklumBalas_Activity_Pengajar extends AppCompatActivity {

    RecyclerView recyclerView;
    MaklumBalas_Adapter_Pengajar adapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maklumbalas_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Maklum Balas");
        getSupportActionBar().setSubtitle("Tekan x untuk membuang maklum balas");

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MaklumBalas_Model> options= new FirebaseRecyclerOptions
                .Builder<MaklumBalas_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                .child("MaklumBalas_List"),MaklumBalas_Model.class).build();

        adapter= new MaklumBalas_Adapter_Pengajar(options);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){

        super.onStop();
        adapter.stopListening();
    }
}
