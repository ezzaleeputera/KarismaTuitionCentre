 package com.example.karismatuitioncentre.maklumbalas;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

        import com.example.karismatuitioncentre.R;
        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.firebase.database.FirebaseDatabase;

public class MaklumBalas_Activity_Pelajar_IbuBapa extends AppCompatActivity {

    RecyclerView recyclerView;
    MaklumBalas_Adapter_Pelajar_IbuBapa adapter;
    FloatingActionButton fb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maklumbalas_pelajar_ibubapa);

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MaklumBalas_Model> options= new FirebaseRecyclerOptions
                .Builder<MaklumBalas_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("MaklumBalas_List"),MaklumBalas_Model.class).build();

        adapter= new MaklumBalas_Adapter_Pelajar_IbuBapa(options);
        recyclerView.setAdapter(adapter);

        fb= findViewById(R.id.fabAdd);
        fb.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),
                MaklumBalas_AddData_Pelajar_IbuBapa.class)));

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
