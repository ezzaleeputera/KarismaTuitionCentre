package com.example.karismatuitioncentre.yuran.y_ibubapa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Yuran_Activity_ViewMaklumatPembayaran_IbuBapa extends AppCompatActivity {
    TextView tvNB,tvNPA,tvNAB;
    DatabaseReference databaseReference;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_maklumatpembayaran_ibubapa);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pembayaran Yuran");
        getSupportActionBar().setSubtitle("Maklumat Pembayaran seperti berikut");

        tvNB=findViewById(R.id.tvNB);
        tvNPA=findViewById(R.id.tvNPA);
        tvNAB=findViewById(R.id.tvNAB);


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Fee_list");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nb= Objects.requireNonNull(snapshot.child("namaBank").getValue()).toString();
                    String npa= Objects.requireNonNull(snapshot.child("namaPemilikAkaun").getValue()).toString();
                    String nab= Objects.requireNonNull(snapshot.child("noAkaunBank").getValue()).toString();

                    tvNB.setText(nb);
                    tvNPA.setText(npa);
                    tvNAB.setText(nab);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
