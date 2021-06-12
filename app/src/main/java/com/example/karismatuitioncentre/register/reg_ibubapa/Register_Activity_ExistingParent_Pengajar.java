package com.example.karismatuitioncentre.register.reg_ibubapa;

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

import com.example.karismatuitioncentre.register.Register_ParentList_Model;
import com.example.karismatuitioncentre.register.reg_pelajar.Register_Activity_RegPelajar_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class Register_Activity_ExistingParent_Pengajar extends AppCompatActivity
{
    EditText inputSearch;
    RecyclerView recview;
    FirebaseRecyclerOptions<Register_ParentList_Model> options;
    FirebaseRecyclerAdapter<Register_ParentList_Model, Register_MyViewHolder_SearchExisting_Pengajar> adapter;
    DatabaseReference DataRef;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai IbuBapa(Pendaftaran)");
        getSupportActionBar().setSubtitle("Tekan untuk memilih IbuBapa tertentu");

        DataRef= FirebaseDatabase.getInstance().getReference().child("Parent_list");
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
                LoadData(s.toString());

            }
        });

    }

    private void LoadData(String data) {
        Query query=DataRef.orderByChild("nama").startAt(data).endAt(data+"\uf8ff");
        options= new FirebaseRecyclerOptions.Builder<Register_ParentList_Model>()
                .setQuery(query, Register_ParentList_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Register_ParentList_Model, Register_MyViewHolder_SearchExisting_Pengajar>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Register_MyViewHolder_SearchExisting_Pengajar holder, int position, @NonNull Register_ParentList_Model model) {
                holder.nama.setText(model.getNama());
                holder.email.setText(model.getEmail());
                holder.kp.setText(model.getKp());
                holder.v.setOnClickListener(view -> {
                    Intent intent=new Intent(Register_Activity_ExistingParent_Pengajar.this, Register_Activity_RegPelajar_Pengajar.class);
                    intent.putExtra("parentID_key",model.getParentid());
                    startActivity(intent);
                });

            }

            @NonNull
            @Override
            public Register_MyViewHolder_SearchExisting_Pengajar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_register_searchexistingparent_pengajar,parent,false);


                return new Register_MyViewHolder_SearchExisting_Pengajar(v);
            }
        };
        adapter.startListening();
        recview.setAdapter(adapter);
    }

}


