package com.example.karismatuitioncentre.jadual.j_pelajaribubapa;

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
import com.example.karismatuitioncentre.jadual.Jadual_Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Objects;


public class Jadual_Activity_ViewSchedule_Pelajar_IbuBapa_Test extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseRecyclerOptions <Jadual_Model> options;
    FirebaseRecyclerAdapter<Jadual_Model, Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadual_pelajar_ibubapa);
        String day_key=getIntent().getStringExtra("day_key");
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Slot Jadual");
        getSupportActionBar().setSubtitle("day_key");

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        options= new FirebaseRecyclerOptions.Builder<Jadual_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child(day_key), Jadual_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Jadual_Model, Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test holder, int position, @NonNull Jadual_Model model) {
                holder.subjek.setText(model.getSubjek());
                holder.pengajar.setText(model.getPengajar());

                int startH=Integer.parseInt(model.getMasaSHour());
                int startM=Integer.parseInt(model.getMasaSMin());
                int endH=Integer.parseInt(model.getMasaEHour());
                int endM=Integer.parseInt(model.getMasaEMin());
                Calendar calendar = Calendar.getInstance();
                Calendar calendar1 = Calendar.getInstance();
                calendar.set(0,0,0,startH,startM);
                calendar1.set(0,0,0,endH,endM);
                holder.masaS.setText(DateFormat.format("hh:mm aa",calendar));
                holder.masaE.setText(DateFormat.format("hh:mm aa",calendar1));

            }

            @NonNull
            @Override
            public Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_jadual_pelajar_ibubapa,parent,false);


                return new Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }


}


