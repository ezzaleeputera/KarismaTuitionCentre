package com.example.karismatuitioncentre.kehadiran.k_pelajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_Pelajar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Kehadiran_Activity_QRScanner_Pelajar extends AppCompatActivity {
TextView resultQRscanned;
private CodeScanner mCodeScanner;
FirebaseDatabase database;
DatabaseReference databaseReference;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kehadiran_scanqr_pelajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pengimbas Kod QR Kehadiran");
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Kehadiran");

        mCodeScanner = new CodeScanner(this, scannerView);
        resultQRscanned=findViewById(R.id.resultQRscanned);
        resultQRscanned.setVisibility(View.GONE);
        mCodeScanner.setDecodeCallback(result -> runOnUiThread(() -> {
            resultQRscanned.setVisibility(View.VISIBLE);
            String qrScan=result.getText();
                databaseReference.orderByChild("kodQR").equalTo(qrScan).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                    for(DataSnapshot datas: dataSnapshot.getChildren()) {
                          String subjek= (String) datas.child("nama_subjek").getValue();
                          String pengajar= (String) datas.child("nama_pengajar").getValue();
                          String sHour= (String) datas.child("masaSHour").getValue();
                          String sMin= (String) datas.child("masaSMin").getValue();
                          String eHour= (String) datas.child("masaEHour").getValue();
                          String eMin= (String) datas.child("masaEMin").getValue();
                          Calendar calendar=Calendar.getInstance();
                          String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

                          FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                          assert user != null;
                          String uid = user.getUid();
                          Map<String,Object> map=new HashMap<>();
                          map.put("userid",uid);
                          map.put("qrScan",qrScan);
                          map.put("subjek",subjek);
                          map.put("pengajar",pengajar);
                          map.put("date",currentDate);
                          map.put("masaSHour",sHour );
                          map.put("masaEHour",eHour);
                          map.put("masaSMin",sMin);
                          map.put("masaEMin",eMin);

                          FirebaseDatabase.getInstance().getReference().child("Kehadiran_List").push()
                                  .setValue(map)
                                  .addOnSuccessListener(aVoid -> {
                                      Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                                      Intent intent = new Intent(getApplicationContext(), Home_Activity_Pelajar.class);
                                      startActivity(intent);
                                      finish();
                                  })
                                  .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());

                      }
                  }



                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {

                  }
                  });

                Toast.makeText(Kehadiran_Activity_QRScanner_Pelajar.this, qrScan, Toast.LENGTH_SHORT).show();

                }));
        scannerView.setOnClickListener(view -> mCodeScanner.startPreview());
        }

@Override
protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
        }

@Override
protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
        }
        }