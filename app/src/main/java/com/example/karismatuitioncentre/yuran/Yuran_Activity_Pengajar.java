package com.example.karismatuitioncentre.yuran;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Adapter_Pelajar_IbuBapa;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Yuran_Activity_Pengajar extends AppCompatActivity{
/*        EditText mSearchField;
        ImageButton mSearchBtn;*/

        RecyclerView mResultList;
        Yuran_Adapter adapter;
/*        DatabaseReference mUserDatabase;*/


        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_yuran_pengajar);
/*
            mSearchField=findViewById(R.id.txtSearch);
            mSearchBtn=findViewById(R.id.ibSearch);*/

            mResultList=findViewById(R.id.student_list);
            mResultList.setLayoutManager(new LinearLayoutManager(this));

            FirebaseRecyclerOptions<Users_Model> options= new FirebaseRecyclerOptions
                    .Builder<Users_Model>()
                    .setQuery(FirebaseDatabase.getInstance().getReference()
                            .child("User_list"),Users_Model.class).build();

            adapter= new Yuran_Adapter(options);
            mResultList.setAdapter(adapter);


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
