package com.example.karismatuitioncentre.prestasi.p_pengajar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.prestasi.Prestasi_Remarks_Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class Prestasi_Activity_ViewRemarks_Pengajar extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    LineChart lineChart;
    LineDataSet lineDataSet= new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets= new ArrayList<>();
    LineData lineData;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Prestasi_Remarks_Model> options;
    FirebaseRecyclerAdapter<Prestasi_Remarks_Model, Prestasi_MyViewHolder_ViewRemarks_Pengajar> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_linechart_pelajar_test);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Lihat Prestasi Pelajar");
        String Sub_Key=getIntent().getStringExtra("Sub_Key");
        String User_Key=getIntent().getStringExtra("User_Key");

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        options= new FirebaseRecyclerOptions.Builder<Prestasi_Remarks_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child(Sub_Key)
                        .child("Remark_List").orderByChild("userid").equalTo(User_Key), Prestasi_Remarks_Model.class)
                .build();



        adapter=new FirebaseRecyclerAdapter<Prestasi_Remarks_Model, Prestasi_MyViewHolder_ViewRemarks_Pengajar>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Prestasi_MyViewHolder_ViewRemarks_Pengajar holder, int position, @NonNull Prestasi_Remarks_Model model) {
                holder.tvTitleRemarks.setText(model.getTitleR());
                holder.tvRemarks.setText(model.getDescR());
                holder.tvtarikh.setText(model.getDateR());

            }

            @NonNull
            @Override
            public Prestasi_MyViewHolder_ViewRemarks_Pengajar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_prestasi,parent,false);


                return new Prestasi_MyViewHolder_ViewRemarks_Pengajar(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }



}