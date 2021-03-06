package com.example.karismatuitioncentre.prestasi.p_ibubapa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.prestasi.Prestasi_StudentList_Model;
import com.example.karismatuitioncentre.prestasi.p_pengajar.Prestasi_Activity_Home_UpdateView_Pengajar;
import com.example.karismatuitioncentre.prestasi.p_pengajar.Prestasi_MyViewHolder_SearchStudent_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class Prestasi_Activity_SearchStudent_IbuBapa extends AppCompatActivity
{
    EditText inputSearch;
    RecyclerView recview;
    FirebaseRecyclerOptions<Prestasi_StudentList_Model> options;
    FirebaseRecyclerAdapter<Prestasi_StudentList_Model, Prestasi_MyViewHolder_SearchStudent_IbuBapa> adapter;
    DatabaseReference DataRef;
    ImageButton ibSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_search_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Pelajar(Prestasi)");
        getSupportActionBar().setSubtitle("Tekan untuk memilih pelajar tertentu");
        String Sub_Key=getIntent().getStringExtra("Sub_Key");


        DataRef= FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("List_Student");
        inputSearch=findViewById(R.id.txtSearch);
        recview= findViewById(R.id.student_list);
        recview.setLayoutManager(new LinearLayoutManager(this));
        ibSearch=findViewById(R.id.ibSearch);
        ibSearch.setVisibility(View.GONE);
        inputSearch.setVisibility(View.GONE);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
                   String pid= user.getUid();

        Query query=DataRef.orderByChild("parentid").equalTo(pid);
        options= new FirebaseRecyclerOptions.Builder<Prestasi_StudentList_Model>()
                .setQuery(query, Prestasi_StudentList_Model.class)
                .build();


        adapter=new FirebaseRecyclerAdapter<Prestasi_StudentList_Model, Prestasi_MyViewHolder_SearchStudent_IbuBapa>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Prestasi_MyViewHolder_SearchStudent_IbuBapa holder, int position, @NonNull Prestasi_StudentList_Model model) {
                holder.nama.setText(model.getNama());
                holder.kp.setText(model.getKp());
                holder.v.setOnClickListener(view -> {
                    Intent intent=new Intent(Prestasi_Activity_SearchStudent_IbuBapa.this, Prestasi_Activity_Home_ViewTestRemark_IbuBapa.class);
                    intent.putExtra("Sub_Key",Sub_Key);
                    intent.putExtra("User_Key",model.getUserid());
                    startActivity(intent);
                });

            }

            @NonNull
            @Override
            public Prestasi_MyViewHolder_SearchStudent_IbuBapa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_prestasi_search_pengajar,parent,false);


                return new Prestasi_MyViewHolder_SearchStudent_IbuBapa(v);
            }
        };
        adapter.startListening();
        recview.setAdapter(adapter);
    }

}


