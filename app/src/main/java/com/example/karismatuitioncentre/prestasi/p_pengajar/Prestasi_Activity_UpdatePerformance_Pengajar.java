package com.example.karismatuitioncentre.prestasi.p_pengajar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.home.Home_Activity_IbuBapa;
import com.example.karismatuitioncentre.home.Home_Activity_Pelajar;
import com.example.karismatuitioncentre.home.Home_Activity_Pengajar;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jadual_Activity_ViewSchedule_Pengajar_Test;
import com.example.karismatuitioncentre.login.Login_Activity;
import com.example.karismatuitioncentre.prestasi.Prestasi_StudentList_Model;
import com.example.karismatuitioncentre.prestasi.Prestasi_TestMarks_Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prestasi_Activity_UpdatePerformance_Pengajar extends AppCompatActivity
{
    EditText add_titleR,add_descR,add_testM;
    Button btn_Send,btn_Send2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_setperformance_pengajar);
        String Sub_Key=getIntent().getStringExtra("Sub_Key");
        String User_Key=getIntent().getStringExtra("User_Key");
        Objects.requireNonNull(getSupportActionBar()).setTitle("Mengisi Prestasi Pelajar");

        add_titleR= findViewById(R.id.add_titleR);
        add_descR= findViewById(R.id.add_descR);
        add_testM= findViewById(R.id.add_testM);
        btn_Send= findViewById(R.id.btn_Send);
        btn_Send2= findViewById(R.id.btn_Send2);

        btn_Send.setOnClickListener(view -> {
            String titleR=add_titleR.getText().toString();
            String descR=add_descR.getText().toString();
            if (TextUtils.isEmpty(titleR)) {
                add_titleR.setError("Tajuk Rumusan diperlukan");

                return;
            }

            if (TextUtils.isEmpty(descR)) {
                add_descR.setError("Isi Rumusan Diperlukan");

                return;
            }
            if (titleR.length() < 4) {
                add_titleR.setError("Tajuk Rumusan terlalu pendek: perlu lebih 4 aksara");

                return;
            }
            if (descR.length() < 10) {
                add_titleR.setError("Rumusan terlalu pendek: perlu lebih 10 aksara");

                return;
            }

            Calendar calendar=Calendar.getInstance();
            String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
            FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("List_Student").orderByChild("userid").equalTo(User_Key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String parentid= snapshot.child("parentid").toString();

                    Map<String,Object> map=new HashMap<>();
                    map.put("titleR",titleR);
                    map.put("descR",descR);
                    map.put("date",currentDate);
                    map.put("userid",User_Key);
                    map.put("parentid",parentid);

                    FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("Remark_List").push()
                            .setValue(map)
                            .addOnSuccessListener(aVoid -> {
                                add_titleR.setText("");
                                add_descR.setText("");

                                Toast.makeText(getApplicationContext(),"Penambahan berjaya",Toast.LENGTH_LONG).show();
                            })
                            .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        });

        btn_Send2.setOnClickListener(view -> {

            String testM=add_testM.getText().toString().trim();
            if (TextUtils.isEmpty(testM)) {
                add_testM.setError("Markah Ujian diperlukan");

                return;
            }

            if (Integer.parseInt(testM) >100) {
                add_testM.setError("Markah lebih maksima: perlu kurang/tepat 100");

                return;
            }

            Calendar calendar=Calendar.getInstance();
            String dateTest = DateFormat.getDateInstance().format(calendar.getTime());

            int y= Integer.parseInt(add_testM.getText().toString());
            final int[] x = new int[1];
            final String[] SecKey = new String[1];
//            String key=FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("List_Student").child("userid").equalTo(User_Key).getRef().getKey();
            FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("List_Student").orderByChild("userid").equalTo(User_Key).addListenerForSingleValueEvent(new ValueEventListener() {


                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot datas: dataSnapshot.getChildren()) {
                        String parentid=dataSnapshot.child("parentid").toString();
                        Prestasi_StudentList_Model prestasi_studentList_model= datas.getValue(Prestasi_StudentList_Model.class);
                        assert prestasi_studentList_model != null;
                        int numTest= Math.toIntExact(prestasi_studentList_model.getNumTest());

                        x[0]= numTest;
                        String key=datas.getKey();
                        SecKey[0] =key;
                        assert key != null;
                        Prestasi_TestMarks_Model prestasi_testMarks_model=new Prestasi_TestMarks_Model(x[0]+1,y,User_Key,dateTest,parentid);

                        FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("Test_List").push(). setValue(prestasi_testMarks_model).addOnSuccessListener(aVoid -> {
                            add_testM.setText("");

                            FirebaseDatabase.getInstance().getReference().child(Sub_Key).child("List_Student").child(SecKey[0]).child("numTest").setValue((x[0]+1));

                            Toast.makeText(getApplicationContext(),"Penambahan Markah Ujian berjaya",Toast.LENGTH_LONG).show();
                            finish();
                            Intent intent = new Intent(getApplicationContext(), Prestasi_Activity_Home_UpdateView_Pengajar.class);
                            intent.putExtra("Sub_Key",Sub_Key);
                            intent.putExtra("User_Key",User_Key);
                            startActivity(intent);

                        })
                                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Tidak Berjaya",Toast.LENGTH_LONG).show());
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }});


        });

    }
}


