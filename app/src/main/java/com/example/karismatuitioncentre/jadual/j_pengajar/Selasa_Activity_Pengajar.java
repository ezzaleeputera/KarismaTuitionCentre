
package com.example.karismatuitioncentre.jadual.j_pengajar;

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

public class Selasa_Activity_Pengajar extends AppCompatActivity {

    Selasa_Adapter_Pengajar adapter;
    RecyclerView recyclerView;
    FloatingActionButton fb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari_pengajar);

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Jadual_Model_Pengajar> options= new FirebaseRecyclerOptions
                .Builder<Jadual_Model_Pengajar>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("Jadual_Selasa"), Jadual_Model_Pengajar.class).build();

        adapter= new Selasa_Adapter_Pengajar(options);
        recyclerView.setAdapter(adapter);

        fb= findViewById(R.id.fabAdd);
        fb.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),
                Selasa_AddData_Pengajar.class)));

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

