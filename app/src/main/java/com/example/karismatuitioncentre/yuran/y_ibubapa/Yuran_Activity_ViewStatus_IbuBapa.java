package com.example.karismatuitioncentre.yuran.y_ibubapa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Yuran_Activity_ViewStatus_IbuBapa extends AppCompatActivity {
    TextView txtNama,txtJan,txtFeb,txtMar,txtApr,txtMei,txtJun,txtJul,txtAug,txtSep,txtOct,txtNov,txtDec,tvMonthlyFee,tvMonthFee;
    DatabaseReference dataSnapshot,ref;
    String paid="Paid",unpaid="Unpaid";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_status_ibubapa);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sejarah Yuran Pelajar");

        //TextView for Fee Status
        txtJan=findViewById(R.id.tvJanFee);
        txtFeb=findViewById(R.id.tvFebFee);
        txtMar=findViewById(R.id.tvMarFee);
        txtApr=findViewById(R.id.tvAprFee);
        txtMei=findViewById(R.id.tvMyFee);
        txtJun=findViewById(R.id.tvJnFee);
        txtJul=findViewById(R.id.tvJulFee);
        txtAug=findViewById(R.id.tvAugFee);
        txtSep=findViewById(R.id.tvSepFee);
        txtOct=findViewById(R.id.tvOctFee);
        txtNov=findViewById(R.id.tvNovFee);
        txtDec=findViewById(R.id.tvDecFee);

        //DatabaseReference for Student fee
        dataSnapshot= FirebaseDatabase.getInstance().getReference().child("Stud_Fee");
        ref=dataSnapshot;
        String CarKey=getIntent().getStringExtra("CarKey");

        //DataSnapshot for retrieving data from database and store in a String
        dataSnapshot.child(CarKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){


                    String nama= Objects.requireNonNull(dataSnapshot.child("nama").getValue()).toString();
                    String janFee= Objects.requireNonNull(dataSnapshot.child("JanFee").getValue()).toString();
                    String febFee= Objects.requireNonNull(dataSnapshot.child("FebFee").getValue()).toString();
                    String marFee= Objects.requireNonNull(dataSnapshot.child("MarFee").getValue()).toString();
                    String aprFee= Objects.requireNonNull(dataSnapshot.child("AprFee").getValue()).toString();
                    String myFee= Objects.requireNonNull(dataSnapshot.child("MayFee").getValue()).toString();
                    String jnFee= Objects.requireNonNull(dataSnapshot.child("JunFee").getValue()).toString();
                    String julFee= Objects.requireNonNull(dataSnapshot.child("JulFee").getValue()).toString();
                    String augFee= Objects.requireNonNull(dataSnapshot.child("AugFee").getValue()).toString();
                    String sepFee= Objects.requireNonNull(dataSnapshot.child("SepFee").getValue()).toString();
                    String octFee= Objects.requireNonNull(dataSnapshot.child("OctFee").getValue()).toString();
                    String novFee= Objects.requireNonNull(dataSnapshot.child("NovFee").getValue()).toString();
                    String decFee= Objects.requireNonNull(dataSnapshot.child("DecFee").getValue()).toString();



                    Objects.requireNonNull(getSupportActionBar()).setSubtitle(nama);

                    //Displaying status of fee of the month onto TextView
                    txtJan.setText(janFee);
                    txtFeb.setText(febFee);
                    txtMar.setText(marFee);
                    txtApr.setText(aprFee);
                    txtMei.setText(myFee);
                    txtJun.setText(jnFee);
                    txtJul.setText(julFee);
                    txtAug.setText(augFee);
                    txtSep.setText(sepFee);
                    txtOct.setText(octFee);
                    txtNov.setText(novFee);
                    txtDec.setText(decFee);





                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

}
