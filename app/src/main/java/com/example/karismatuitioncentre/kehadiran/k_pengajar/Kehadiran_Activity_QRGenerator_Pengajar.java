package com.example.karismatuitioncentre.kehadiran.k_pengajar;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.Random;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class Kehadiran_Activity_QRGenerator_Pengajar extends AppCompatActivity {
    EditText etCode;
    TextView tvCodeSet;
    Button btnGenerateQR,btnGenerateQRRandom;
    ImageView qrCodePlaceholder;
    DatabaseReference databaseReference;

    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_generateqr_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Penjana Kod QR Kehadiran");
        String attKey=getIntent().getStringExtra("attKey");

        etCode=findViewById(R.id.etCode);
        btnGenerateQR=findViewById(R.id.btnGenerateQRSpecific);
        btnGenerateQRRandom=findViewById(R.id.btnGenerateQRRandom);
        tvCodeSet=findViewById(R.id.tvCodeSet);
        qrCodePlaceholder=findViewById(R.id.qrCodePlaceholder);
        tvCodeSet.setVisibility(View.INVISIBLE);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Kehadiran").child(attKey).child("kodQR");

        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nbInput=etCode.getText().toString().trim();
                btnGenerateQR.setEnabled(!nbInput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnGenerateQR.setOnClickListener(view -> {
            String code =etCode.getText().toString().trim();
            if (TextUtils.isEmpty(code)) {
                etCode.setError("Emel diperlukan");

                return;
            }

            databaseReference.setValue(code).addOnSuccessListener(aVoid -> {
                etCode.setText("");
                Toast.makeText(getApplicationContext(),"Penjanaan Kod QR Berjaya",Toast.LENGTH_LONG).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            String kod= Objects.requireNonNull(snapshot.getValue()).toString();

//                            FirebaseDatabase.getInstance().getReference().child("Kehadiran").child("kehadiranKod").setValue(code);
                            tvCodeSet.setText(kod);
                            tvCodeSet.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            });


            QRGEncoder qrgEncoder = new QRGEncoder(code, null, QRGContents.Type.TEXT, 10);
            qrgEncoder.setColorBlack(Color.BLACK);
            qrgEncoder.setColorWhite(Color.WHITE);
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.getBitmap();
            // Setting Bitmap to ImageView
            qrCodePlaceholder.setImageBitmap(bitmap);

        });

        btnGenerateQRRandom.setOnClickListener(view -> {
            String code =getRandomString(6);
            databaseReference.setValue(code).addOnSuccessListener(aVoid -> {
                etCode.setText("");
                Toast.makeText(getApplicationContext(),"Penjanaan Kod QR Berjaya",Toast.LENGTH_LONG).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            String kod= Objects.requireNonNull(snapshot.getValue()).toString();
//                            FirebaseDatabase.getInstance().getReference().child("Kehadiran").child("kehadiranKod").setValue(code);
                            tvCodeSet.setText(kod);
                            tvCodeSet.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            });


            QRGEncoder qrgEncoder = new QRGEncoder(code, null, QRGContents.Type.TEXT, 10);
            qrgEncoder.setColorBlack(Color.BLACK);
            qrgEncoder.setColorWhite(Color.WHITE);
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.getBitmap();
            // Setting Bitmap to ImageView
            qrCodePlaceholder.setImageBitmap(bitmap);

        });

    }
    public static String getRandomString(int i){
        final String characters="abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result= new StringBuilder();
        while(i>0){
            Random random =new Random();
            result.append(characters.charAt(random.nextInt(characters.length())));
            i--;
        }
        return result.toString();
    }
}
