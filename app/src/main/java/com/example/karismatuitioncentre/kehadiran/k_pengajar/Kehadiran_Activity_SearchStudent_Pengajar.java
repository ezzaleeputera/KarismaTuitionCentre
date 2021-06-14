package com.example.karismatuitioncentre.kehadiran.k_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.kehadiran.Kehadiran_Model;
import com.example.karismatuitioncentre.kehadiran.User_Kehadiran_Model;
import com.example.karismatuitioncentre.kehadiran.k_pelajar.Kehadiran_MyViewHolder_ViewKehadiran_Pelajar;
import com.example.karismatuitioncentre.yuran.Yuran_Model;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_Activity_SetStatus_Pengajar;
import com.example.karismatuitioncentre.yuran.y_pengajar.Yuran_MyViewHolder_SearchStudent_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class Kehadiran_Activity_SearchStudent_Pengajar extends AppCompatActivity
{
    EditText inputSearch;
    RecyclerView recview;
    FirebaseRecyclerOptions<User_Kehadiran_Model> options;
    FirebaseRecyclerAdapter<User_Kehadiran_Model, Kehadiran_MyViewHolder_SearchStudent_Pengajar> adapter;
    DatabaseReference DataRef;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_search_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Pelajar(Kehadiran)");
        getSupportActionBar().setSubtitle("Tekan untuk memilih pelajar tertentu");

        DataRef= FirebaseDatabase.getInstance().getReference().child("Student_list");
        inputSearch=findViewById(R.id.txtSearch);
        recview= findViewById(R.id.student_list);
        recview.setLayoutManager(new LinearLayoutManager(this));



        LoadData("");

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                s.toString();
                LoadData(s.toString());

            }
        });

    }

    private void LoadData(String data) {
        Query query=DataRef.orderByChild("nama").startAt(data).endAt(data+"\uf8ff");
        options= new FirebaseRecyclerOptions.Builder<User_Kehadiran_Model>()
                .setQuery(query, User_Kehadiran_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<User_Kehadiran_Model, Kehadiran_MyViewHolder_SearchStudent_Pengajar>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Kehadiran_MyViewHolder_SearchStudent_Pengajar holder, int position, @NonNull User_Kehadiran_Model model) {
                holder.nama.setText(model.getNama());
                holder.kp.setText(model.getKp());
                holder.email.setText(model.getEmail());
                holder.v.setOnClickListener(view -> {
                    Intent intent=new Intent(Kehadiran_Activity_SearchStudent_Pengajar.this, Kehadiran_Activity_ViewKehadiran_Pengajar.class);
                    intent.putExtra("Student_Key",model.getUserid());
                    startActivity(intent);
                });

            }

            @NonNull
            @Override
            public Kehadiran_MyViewHolder_SearchStudent_Pengajar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_yuran_pengajar,parent,false);


                return new Kehadiran_MyViewHolder_SearchStudent_Pengajar(v);
            }
        };
        adapter.startListening();
        recview.setAdapter(adapter);
    }

}


