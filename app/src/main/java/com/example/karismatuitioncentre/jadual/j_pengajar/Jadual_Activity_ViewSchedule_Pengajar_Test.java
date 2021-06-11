package com.example.karismatuitioncentre.jadual.j_pengajar;

import android.app.AlertDialog;
import android.content.Intent;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;
import java.util.Objects;


public class Jadual_Activity_ViewSchedule_Pengajar_Test extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseRecyclerOptions <Jadual_Model> options;
    FirebaseRecyclerAdapter<Jadual_Model, Jadual_MyViewHolder_ViewSchedule_Pengajar_Test> adapter;
    FloatingActionButton fb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadual_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Slot Jadual");
        getSupportActionBar().setSubtitle("day_key");
        String day_key=getIntent().getStringExtra("day_key");

        Objects.requireNonNull(getSupportActionBar()).setTitle("Jadual Kelas");
        getSupportActionBar().setSubtitle(day_key);

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fb=(FloatingActionButton)findViewById(R.id.fabAdd);
        fb.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Jadual_Activity_AddSlot_Pengajar_Test.class);
            intent.putExtra("day_key", day_key);
            startActivity(intent);
            finish();
        });

        options= new FirebaseRecyclerOptions.Builder<Jadual_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child(day_key), Jadual_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Jadual_Model, Jadual_MyViewHolder_ViewSchedule_Pengajar_Test>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Jadual_MyViewHolder_ViewSchedule_Pengajar_Test holder, int position, @NonNull Jadual_Model model) {
                holder.subjek_P.setText(model.getSubjek());
                holder.pengajar_P.setText(model.getPengajar());

                int startH=Integer.parseInt(model.getMasaSHour());
                int startM=Integer.parseInt(model.getMasaSMin());
                int endH=Integer.parseInt(model.getMasaEHour());
                int endM=Integer.parseInt(model.getMasaEMin());

                Calendar calendar = Calendar.getInstance();
                Calendar calendar1 = Calendar.getInstance();
                calendar.set(0,0,0,startH,startM);
                calendar1.set(0,0,0,endH,endM);
                holder.masaS_P.setText(DateFormat.format("hh:mm aa",calendar));
                holder.masaE_P.setText(DateFormat.format("hh:mm aa",calendar1));
                holder.edit_P.setOnClickListener(view -> {

                        Intent intent = new Intent(getApplicationContext(), Jadual_Activity_EditSlot_Pengajar.class);
                        intent.putExtra("day_key", day_key);
                        String slot_key=Objects.requireNonNull(getRef(position).getKey());
                        intent.putExtra("slot_key", slot_key);
                        startActivity(intent);
                        finish();
                    });



//                String SlotKey=Objects.requireNonNull(getRef(position).getKey());
                holder.delete_P.setOnClickListener(view -> {
                    AlertDialog.Builder builder=new AlertDialog.Builder(holder.subjek_P.getContext());
                    builder.setTitle("Padam slot ini daripada jadual:");
                    builder.setMessage("Anda pasti untuk memadam slot ini?");

                    builder.setPositiveButton("Ya", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child(day_key)
                            .child(Objects.requireNonNull(getRef(position).getKey())).removeValue());

                    builder.setNegativeButton("Tidak", (dialogInterface, i) -> {

                    });

                    builder.show();
                });

            }

            @NonNull
            @Override
            public Jadual_MyViewHolder_ViewSchedule_Pengajar_Test onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_jadual_pengajar,parent,false);


                return new Jadual_MyViewHolder_ViewSchedule_Pengajar_Test(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }


}


