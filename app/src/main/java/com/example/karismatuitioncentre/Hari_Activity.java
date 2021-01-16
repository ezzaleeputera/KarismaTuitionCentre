package com.example.karismatuitioncentre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;

public class Hari_Activity extends AppCompatActivity {
    private EditText etSubjek, etPengajar,etMasa;
//    private EditText etSlot;
    private FirebaseRecyclerAdapter adapter;
    private DatabaseReference reference;
    private FirebaseDatabase rootNode;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maklumbalas_pelajar_ibubapa);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MaklumBalas_Model> options= new FirebaseRecyclerOptions
                .Builder<MaklumBalas_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("MaklumBalas_List"),MaklumBalas_Model.class).build();

        adapter= new MaklumBalas_Adapter_Pengajar(options);
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

//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hari);
//        Button btnSetKelas = findViewById(R.id.btnSetKelas);
//        etMasa=findViewById(R.id.etpengajar);
//        etSubjek=findViewById(R.id.etsubjek);
////        etSlot=findViewById(R.id.etslot);
//        reference= FirebaseDatabase.getInstance().getReference().child("Jadual_Isnin");
//        reference.keepSynced(true);
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerviewHari);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        btnSetKelas.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View view) {
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Jadual_Isnin").push();
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", databaseReference.getKey());
//                map.put("subjek", etMasa.getText().toString());
//                map.put("pengajar", etPengajar.getText().toString());
//                map.put("masa", etSubjek.getText().toString());
//
//                databaseReference.setValue(map);
//
//            }
//        });
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        fetch();
//    }
//
//    private void fetch() {
//        Query query=FirebaseDatabase.getInstance().getReference().child("Jadual_Isnin");
//        FirebaseRecyclerOptions<Kelas_Hari> options =
//                new FirebaseRecyclerOptions.Builder<Kelas_Hari>()
//                        .setQuery(query, new SnapshotParser<Kelas_Hari>() {
//                            @NonNull
//                            @Override
//                            public Kelas_Hari parseSnapshot(@NonNull DataSnapshot snapshot) {
////                                 return new Kelas_Hari(snapshot.child("slot").getValue().toString(),
//                                return new Kelas_Hari(snapshot.child("id").getValue().toString(),
//                                        snapshot.child("subjek").getValue().toString(),
//                                        snapshot.child("pengajar").getValue().toString(),
//                                        snapshot.child("masa").getValue().toString());
//                            }
//                        })
//                        .build();
//
//        adapter = new FirebaseRecyclerAdapter<Kelas_Hari, ViewHolder>(options) {
//            @Override
//            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.activity_hari, parent, false);
//
//                return new ViewHolder(view);
//            }
//
//            @Override
//            protected void onBindViewHolder(ViewHolder holder, final int position, Kelas_Hari model) {
////                holder.setTxtPengajar(model.getSlot());
//                holder.setTxtSubjek(model.getSubjek());
//                holder.setTxtPengajar(model.getPengajar());
//                holder.setTxtMasa(model.getMasa());
//
//
//                holder.root.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(Hari_Activity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//        };
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public LinearLayout root;
//        public TextView txtSubjek;
//        public TextView txtMasa,txtPengajar;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            root = itemView.findViewById(R.id.list_root);
//            txtSubjek = itemView.findViewById(R.id.textViewSubjek);
//            txtPengajar = itemView.findViewById(R.id.textViewPengajar);
//            txtMasa = itemView.findViewById(R.id.textViewMasa);
//        }
//
//        public void setTxtSubjek(String string) {
//            txtSubjek.setText(string);
//        }
//
//
//        public void setTxtPengajar(String string) {
//            txtPengajar.setText(string);
//        }public void setTxtMasa(String string) {
//            txtMasa.setText(string);
//        }
////        public void setTxtSlot(String string) {
////            txtMasa.setText(string);
////        }
//    }
//}

