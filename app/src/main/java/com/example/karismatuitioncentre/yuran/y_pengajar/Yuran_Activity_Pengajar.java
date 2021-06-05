package com.example.karismatuitioncentre.yuran.y_pengajar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

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

public class Yuran_Activity_Pengajar extends AppCompatActivity
{
    EditText inputSearch;
    RecyclerView recview;
    FirebaseRecyclerOptions <Yuran_Model_Pengajar>options;
    FirebaseRecyclerAdapter<Yuran_Model_Pengajar, Yuran_MyViewHolder_Pengajar>adapter;
    DatabaseReference DataRef;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_pengajar);
        getSupportActionBar().setTitle("Yuran Pelajar");
        getSupportActionBar().setSubtitle("Tekan untuk mengemaskini yuran");
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
        options= new FirebaseRecyclerOptions.Builder<Yuran_Model_Pengajar>()
                .setQuery(query, Yuran_Model_Pengajar.class)
                .build();
        adapter=new FirebaseRecyclerAdapter<Yuran_Model_Pengajar, Yuran_MyViewHolder_Pengajar>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Yuran_MyViewHolder_Pengajar holder, int position, @NonNull Yuran_Model_Pengajar model) {
                holder.nama.setText(model.getNama());
                holder.kp.setText(model.getKp());
                holder.email.setText(model.getEmail());
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(Yuran_Activity_Pengajar.this, Yuran_ViewActivity_Pengajar.class);
                        intent.putExtra("CarKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public Yuran_MyViewHolder_Pengajar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_yuran_pengajar,parent,false);


                return new Yuran_MyViewHolder_Pengajar(v);
            }
        };
        adapter.startListening();
        recview.setAdapter(adapter);
    }

}


