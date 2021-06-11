package com.example.karismatuitioncentre.yuran.y_pengajar;

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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class Yuran_Activity_SearchStudent_Pengajar extends AppCompatActivity
{
    EditText inputSearch;
    RecyclerView recview;
    FirebaseRecyclerOptions <Yuran_Model>options;
    FirebaseRecyclerAdapter<Yuran_Model, Yuran_MyViewHolder_SearchStudent_Pengajar>adapter;
    DatabaseReference DataRef;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_search_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Pelajar(Yuran)");
        getSupportActionBar().setSubtitle("Tekan untuk memilih pelajar tertentu");

        DataRef=FirebaseDatabase.getInstance().getReference().child("Stud_Fee");
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
                if(s.toString()!=null){
                    LoadData(s.toString());
                }
                else {
                    LoadData("");
                }

            }
        });

    }

    private void LoadData(String data) {
        Query query=DataRef.orderByChild("nama").startAt(data).endAt(data+"\uf8ff");
        options= new FirebaseRecyclerOptions.Builder<Yuran_Model>()
                .setQuery(query, Yuran_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Yuran_Model, Yuran_MyViewHolder_SearchStudent_Pengajar>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Yuran_MyViewHolder_SearchStudent_Pengajar holder, int position, @NonNull Yuran_Model model) {
                holder.nama.setText(model.getNama());
                holder.kp.setText(model.getKp());
                holder.email.setText(model.getEmail());
                holder.v.setOnClickListener(view -> {
                    Intent intent=new Intent(Yuran_Activity_SearchStudent_Pengajar.this, Yuran_Activity_SetStatus_Pengajar.class);
                    intent.putExtra("CarKey",getRef(position).getKey());
                    startActivity(intent);
                });

            }

            @NonNull
            @Override
            public Yuran_MyViewHolder_SearchStudent_Pengajar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_yuran_pengajar,parent,false);


                return new Yuran_MyViewHolder_SearchStudent_Pengajar(v);
            }
        };
        adapter.startListening();
        recview.setAdapter(adapter);
    }

}


