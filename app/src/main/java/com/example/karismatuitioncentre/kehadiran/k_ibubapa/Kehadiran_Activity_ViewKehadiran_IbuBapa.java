package com.example.karismatuitioncentre.kehadiran.k_ibubapa;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.kehadiran.Kehadiran_Model;
import com.example.karismatuitioncentre.kehadiran.k_pengajar.Kehadiran_MyViewHolder_ViewKehadiran_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Objects;

public class Kehadiran_Activity_ViewKehadiran_IbuBapa extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Kehadiran_Model> options;
    FirebaseRecyclerAdapter<Kehadiran_Model, Kehadiran_MyViewHolder_ViewKehadiran_IbuBapa> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_sejarahkehadiran_pelajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sejarah Kehadiran");
        String Student_Key=getIntent().getStringExtra("Student_Key");

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        options= new FirebaseRecyclerOptions.Builder<Kehadiran_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("Kehadiran_List").orderByChild("userid").equalTo(Student_Key), Kehadiran_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Kehadiran_Model, Kehadiran_MyViewHolder_ViewKehadiran_IbuBapa>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Kehadiran_MyViewHolder_ViewKehadiran_IbuBapa holder, int position, @NonNull Kehadiran_Model model) {
                holder.subjekHist.setText(model.getSubjek());
                holder.pengajarHist.setText(model.getPengajar());

                int startH=Integer.parseInt(model.getMasaSHour());
                int startM=Integer.parseInt(model.getMasaSMin());
                int endH=Integer.parseInt(model.getMasaEHour());
                int endM=Integer.parseInt(model.getMasaEMin());

                Calendar calendar = Calendar.getInstance();
                Calendar calendar1 = Calendar.getInstance();
                calendar.set(0,0,0,startH,startM);
                calendar1.set(0,0,0,endH,endM);
                holder.masaSHist.setText(DateFormat.format("hh:mm aa",calendar));
                holder.masaEHist.setText(DateFormat.format("hh:mm aa",calendar1));
                holder.tarikhSHist.setText(model.getDate());
            }

            @NonNull
            @Override
            public Kehadiran_MyViewHolder_ViewKehadiran_IbuBapa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_kehadiran_sejarahkehadiran_pelajar,parent,false);


                return new Kehadiran_MyViewHolder_ViewKehadiran_IbuBapa(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }


}


