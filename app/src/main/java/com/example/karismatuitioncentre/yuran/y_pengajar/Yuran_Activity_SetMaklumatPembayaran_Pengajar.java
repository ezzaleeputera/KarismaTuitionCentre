package com.example.karismatuitioncentre.yuran.y_pengajar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Yuran_Activity_SetMaklumatPembayaran_Pengajar extends AppCompatActivity {
    TextView NBsmy,NPAsmy,NABsmy;
    EditText etNBsmy,etNPAsmy,etNABsmy;
    Button btnNBsmy,btnNPAsmy,btnNABsmy;

    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Fee_list");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_setyuran_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Maklumat Pembayaran Yuran");
        getSupportActionBar().setSubtitle("Isi Maklumat jika terdapat perubahan");


        NBsmy=findViewById(R.id.NBsmy);
        NPAsmy=findViewById(R.id.NPAsmy);
        NABsmy=findViewById(R.id.NABsmy);
        etNBsmy=findViewById(R.id.etNBsmy);
        etNPAsmy=findViewById(R.id.etNPAsmy);
        etNABsmy=findViewById(R.id.etNABsmy);
        btnNBsmy=findViewById(R.id.btnNBsmy);
        btnNPAsmy=findViewById(R.id.btnNPAsmy);
        btnNABsmy=findViewById(R.id.btnNABsmy);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nb= Objects.requireNonNull(snapshot.child("namaBank").getValue()).toString();
                    String npa= Objects.requireNonNull(snapshot.child("namaPemilikAkaun").getValue()).toString();
                    String nab= Objects.requireNonNull(snapshot.child("noAkaunBank").getValue()).toString();

                    NBsmy.setText(nb);
                    NPAsmy.setText(npa);
                    NABsmy.setText(nab);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(etNBsmy.length() == 0){
            btnNBsmy.setEnabled(false);
        }
       if(etNABsmy.length() == 0){
           btnNABsmy.setEnabled(false);
        }
       if(etNPAsmy.length() == 0){
           btnNPAsmy.setEnabled(false);
        }

       etNBsmy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nbInput=etNBsmy.getText().toString().trim();
                btnNBsmy.setEnabled(!nbInput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etNPAsmy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String npaInput=etNPAsmy.getText().toString().trim();
                btnNPAsmy.setEnabled(!npaInput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etNABsmy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nabInput=etNABsmy.getText().toString().trim();
                btnNABsmy.setEnabled(!nabInput.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnNBsmy.setOnClickListener(view -> {
            String nbInput=etNBsmy.getText().toString().trim();
            if (TextUtils.isEmpty(nbInput)) {
                etNBsmy.setError("Nama Bank perlu diisi diperlukan");

                return;
            }
            databaseReference.child("namaBank").setValue(nbInput).addOnSuccessListener(aVoid -> {
                etNBsmy.setText("");
                Toast.makeText(getApplicationContext(),"Nama bank Ditukar",Toast.LENGTH_LONG).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            String nb= Objects.requireNonNull(snapshot.child("namaBank").getValue()).toString();
                            String npa= Objects.requireNonNull(snapshot.child("namaPemilikAkaun").getValue()).toString();
                            String nab= Objects.requireNonNull(snapshot.child("noAkaunBank").getValue()).toString();

                            NBsmy.setText(nb);
                            NPAsmy.setText(npa);
                            NABsmy.setText(nab);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            });

        });
        btnNPAsmy.setOnClickListener(view -> {
            String nbInput=etNPAsmy.getText().toString().trim();
            if (TextUtils.isEmpty(nbInput)) {
                btnNPAsmy.setError("Nama Pemilik Akaun perlu diisi");

                return;
            }

            databaseReference.child("namaPemilikAkaun").setValue(nbInput).addOnSuccessListener(aVoid -> {
                etNPAsmy.setText("");
                Toast.makeText(getApplicationContext(),"Nama Pemilik Akaun Ditukar",Toast.LENGTH_LONG).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            String nb= Objects.requireNonNull(snapshot.child("namaBank").getValue()).toString();
                            String npa= Objects.requireNonNull(snapshot.child("namaPemilikAkaun").getValue()).toString();
                            String nab= Objects.requireNonNull(snapshot.child("noAkaunBank").getValue()).toString();

                            NBsmy.setText(nb);
                            NPAsmy.setText(npa);
                            NABsmy.setText(nab);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            });

        });
        btnNABsmy.setOnClickListener(view -> {
            String nbInput=etNABsmy.getText().toString().trim();
            if (TextUtils.isEmpty(nbInput)) {
                btnNABsmy.setError("Nombor Akaun Bank perlu diisi");

                return;
            }

            databaseReference.child("noAkaunBank").setValue(nbInput).addOnSuccessListener(aVoid -> {
                etNABsmy.setText("");
                Toast.makeText(getApplicationContext(),"No.Akaun Bank Ditukar",Toast.LENGTH_LONG).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            String nb= Objects.requireNonNull(snapshot.child("namaBank").getValue()).toString();
                            String npa= Objects.requireNonNull(snapshot.child("namaPemilikAkaun").getValue()).toString();
                            String nab= Objects.requireNonNull(snapshot.child("noAkaunBank").getValue()).toString();

                            NBsmy.setText(nb);
                            NPAsmy.setText(npa);
                            NABsmy.setText(nab);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            });

        });




    }
}
