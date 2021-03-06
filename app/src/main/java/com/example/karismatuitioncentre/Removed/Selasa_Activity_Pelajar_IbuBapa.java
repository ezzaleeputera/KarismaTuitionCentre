/*

package com.example.karismatuitioncentre.jadual.j_pelajaribubapa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.Jadual_Model_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Selasa_Activity_Pelajar_IbuBapa extends AppCompatActivity {

    Selasa_Adapter_Pelajar_IbuBapa adapter;
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari_pelajar_ibubapa);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Jadual_Model_Pengajar> options= new FirebaseRecyclerOptions
                .Builder<Jadual_Model_Pengajar>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("Jadual Selasa"), Jadual_Model_Pengajar.class).build();

        adapter= new Selasa_Adapter_Pelajar_IbuBapa(options);
        recyclerView.setAdapter(adapter);

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

*/
