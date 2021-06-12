package com.example.karismatuitioncentre.yuran.y_pengajar;

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

public class Yuran_Activity_SetStatus_Pengajar extends AppCompatActivity {
    TextView txtNama,txtJan,txtFeb,txtMar,txtApr,txtMei,txtJun,txtJul,txtAug,txtSep,txtOct,txtNov,txtDec,tvMonthlyFee,tvMonthFee;
    Button btnJanCon,btnJanCan,btnFebCon,btnFebCan,btnMarCon,btnMarCan,btnAprCon,btnAprCan,btnMayCon,btnMayCan,btnJunCon,btnJunCan,btnJulCon,btnJulCan,btnAugCon,btnAugCan,btnSepCon,btnSepCan,btnOctCon,btnOctCan,btnNovCon,btnNovCan,btnDecCon,btnDecCan;
    DatabaseReference dataSnapshot,ref;
    String paid="Paid",unpaid="Unpaid";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_status_pengajar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sejarah Yuran Pelajar");
        getSupportActionBar().setSubtitle("Tekan untuk mengemaskini yuran");



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


        //Button for Fee Status
        btnJanCan=findViewById(R.id.btnJanCan);
        btnJanCon=findViewById(R.id.btnJanCon);

        btnFebCan=findViewById(R.id.btnFebCan);
        btnFebCon=findViewById(R.id.btnFebCon);

        btnMarCan=findViewById(R.id.btnMarCan);
        btnMarCon=findViewById(R.id.btnMarCon);

        btnAprCan=findViewById(R.id.btnAprCan);
        btnAprCon=findViewById(R.id.btnAprCon);

        btnMayCan=findViewById(R.id.btnMayCan);
        btnMayCon=findViewById(R.id.btnMayCon);

        btnJunCan=findViewById(R.id.btnJunCan);
        btnJunCon=findViewById(R.id.btnJunCon);

        btnJulCan=findViewById(R.id.btnJulCan);
        btnJulCon=findViewById(R.id.btnJulCon);

        btnAugCan=findViewById(R.id.btnAugCan);
        btnAugCon=findViewById(R.id.btnAugCon);

        btnSepCan=findViewById(R.id.btnSepCan);
        btnSepCon=findViewById(R.id.btnSepCon);

        btnOctCan=findViewById(R.id.btnOctCan);
        btnOctCon=findViewById(R.id.btnOctCon);

        btnNovCan=findViewById(R.id.btnNovCan);
        btnNovCon=findViewById(R.id.btnNovCon);

        btnDecCan=findViewById(R.id.btnDecCan);
        btnDecCon=findViewById(R.id.btnDecCon);



        //DatabaseReference for Student fee
        dataSnapshot=FirebaseDatabase.getInstance().getReference().child("Stud_Fee");
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


                    //Button Yuran_Individual: Button Visibility
                    if(janFee.equals("Unpaid")){
                        btnJanCan.setVisibility(View.GONE);
                    }if(janFee.equals("Paid")){
                        btnJanCon.setVisibility(View.GONE);
                    }


                    if(febFee.equals("Unpaid")){
                        btnFebCan.setVisibility(View.GONE);
                    }if(febFee.equals("Paid")){
                        btnFebCon.setVisibility(View.GONE);
                    }


                    if(marFee.equals("Unpaid")){
                        btnMarCan.setVisibility(View.GONE);
                    }
                    if(marFee.equals("Paid")){
                        btnMarCon.setVisibility(View.GONE);
                    }

                    if(aprFee.equals("Unpaid")){
                        btnAprCan.setVisibility(View.GONE);
                    }
                    if(aprFee.equals("Paid")){
                        btnAprCon.setVisibility(View.GONE);
                    }

                    if(myFee.equals("Unpaid")){
                        btnMayCan.setVisibility(View.GONE);
                    }
                    if(myFee.equals("Paid")){
                        btnMayCon.setVisibility(View.GONE);
                    }

                    if(jnFee.equals("Unpaid")){
                        btnJunCan.setVisibility(View.GONE);
                    }
                    if(jnFee.equals("Paid")){
                        btnJunCon.setVisibility(View.GONE);
                    }

                    if(julFee.equals("Unpaid")){
                        btnJulCan.setVisibility(View.GONE);
                    }
                    if(julFee.equals("Paid")){
                        btnJulCon.setVisibility(View.GONE);
                    }

                    if(augFee.equals("Unpaid")){
                        btnAugCan.setVisibility(View.GONE);
                    }
                    if(augFee.equals("Paid")){
                        btnAugCon.setVisibility(View.GONE);
                    }

                    if(sepFee.equals("Unpaid")){
                        btnSepCan.setVisibility(View.GONE);
                    }
                    if(sepFee.equals("Paid")){
                        btnSepCon.setVisibility(View.GONE);
                    }

                    if(octFee.equals("Unpaid")){
                        btnOctCan.setVisibility(View.GONE);
                    }
                    if(octFee.equals("Paid")){
                        btnOctCon.setVisibility(View.GONE);
                    }

                    if(novFee.equals("Unpaid")){
                        btnNovCan.setVisibility(View.GONE);
                    }
                    if(novFee.equals("Paid")){
                        btnNovCon.setVisibility(View.GONE);
                    }

                    if(decFee.equals("Unpaid")){
                        btnDecCan.setVisibility(View.GONE);
                    }
                    if(decFee.equals("Paid")){
                        btnDecCon.setVisibility(View.GONE);
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Button Yuran Individual January: Paid and Unpaid
        btnJanCan.setOnClickListener(view -> {
            ref.child(CarKey).child("JanFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnJanCon.setOnClickListener(view -> {
            ref.child(CarKey).child("JanFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual February: Paid and Unpaid
        btnFebCan.setOnClickListener(view -> {
            ref.child(CarKey).child("FebFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnFebCon.setOnClickListener(view -> {
            ref.child(CarKey).child("FebFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual March: Paid and Unpaid
        btnMarCan.setOnClickListener(view -> {
            ref.child(CarKey).child("MarFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnMarCon.setOnClickListener(view -> {
            ref.child(CarKey).child("MarFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual April: Paid and Unpaid
        btnAprCan.setOnClickListener(view -> {
            ref.child(CarKey).child("AprFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnAprCon.setOnClickListener(view -> {
            ref.child(CarKey).child("AprFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual May: Paid and Unpaid
        btnMayCan.setOnClickListener(view -> {
            ref.child(CarKey).child("MayFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnMayCon.setOnClickListener(view -> {
            ref.child(CarKey).child("MayFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual June: Paid and Unpaid
        btnJunCan.setOnClickListener(view -> {
            ref.child(CarKey).child("JunFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnJunCon.setOnClickListener(view -> {
            ref.child(CarKey).child("JunFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual July: Paid and Unpaid
        btnJulCan.setOnClickListener(view -> {
            ref.child(CarKey).child("JulFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnJulCon.setOnClickListener(view -> {
            ref.child(CarKey).child("JulFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual August: Paid and Unpaid
        btnAugCan.setOnClickListener(view -> {
            ref.child(CarKey).child("AugFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnAugCon.setOnClickListener(view -> {
            ref.child(CarKey).child("AugFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual September: Paid and Unpaid
        btnSepCan.setOnClickListener(view -> {
            ref.child(CarKey).child("SepFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnSepCon.setOnClickListener(view -> {
            ref.child(CarKey).child("SepFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual October: Paid and Unpaid
        btnOctCan.setOnClickListener(view -> {
            ref.child(CarKey).child("OctFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnOctCon.setOnClickListener(view -> {
            ref.child(CarKey).child("OctFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual November: Paid and Unpaid
        btnNovCan.setOnClickListener(view -> {
            ref.child(CarKey).child("NovFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnNovCon.setOnClickListener(view -> {
            ref.child(CarKey).child("NovFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });

        //Button Yuran Individual December: Paid and Unpaid
        btnDecCan.setOnClickListener(view -> {
            ref.child(CarKey).child("DecFee").setValue(unpaid);
            finish();
            startActivity(getIntent());
        });
        btnDecCon.setOnClickListener(view -> {
            ref.child(CarKey).child("DecFee").setValue(paid);
            finish();
            startActivity(getIntent());
        });


    }

}
