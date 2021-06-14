/*
package com.example.karismatuitioncentre.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.j_pengajar.Jadual_Activity_Home_Pengajar_Test;
import com.example.karismatuitioncentre.login.Login_Activity;
import com.example.karismatuitioncentre.maklumbalas.MaklumBalas_Model;
import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Activity_AddData_Pelajar_IbuBapa;
import com.example.karismatuitioncentre.maklumbalas.mb_pelajaribubapa.MaklumBalas_Adapter_Pelajar_IbuBapa;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class ChangePassword_Activity extends AppCompatActivity {
    EditText curr_pass,new_pass,con_pass;
    Button add_submit,add_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
//        Objects.requireNonNull(getSupportActionBar()).setTitle("Senarai Maklum Balas");
//        getSupportActionBar().setSubtitle("Tekan butang + untuk menambah maklum balas");
        FirebaseAuth auth=FirebaseAuth.getInstance();

        curr_pass=findViewById(R.id.curr_pass);
        new_pass=findViewById(R.id.new_pass);
        con_pass=findViewById(R.id.con_pass);
        add_submit=findViewById(R.id.add_submit);
        add_back=findViewById(R.id.add_back);

        String newPassword = new_pass.getText().toString().trim();
        String conPassword = con_pass.getText().toString().trim();
        String currPassword=curr_pass.getText().toString().trim();
add_submit.setOnClickListener(view -> {
    if(newPassword.isEmpty() && conPassword.isEmpty() && currPassword.isEmpty()) {
        if(newPassword.equals(conPassword)) {
            FirebaseUser user=auth.getCurrentUser();
            if(user !=null && user.getEmail() != null){
                AuthCredential credential = EmailAuthProvider
                        .getCredential(Objects.requireNonNull(user.getEmail()), currPassword);
                user.reauthenticate(credential).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(this, "Re-authentication Success",Toast.LENGTH_SHORT).show();
                        user.updatePassword(newPassword).addOnCompleteListener(task1 -> {
                            if(task1.isSuccessful()){
                                Toast.makeText(this, "Password Change Success",Toast.LENGTH_SHORT).show();
                                auth.signOut();
                                startActivity(new Intent(getApplicationContext(), Login_Activity.class));
                                finish();
                            }
                        });

                    }
                });
            }else{
                startActivity(new Intent(getApplicationContext(), Login_Activity.class));
                finish();

            }
        }else{
            Toast.makeText(this, "Password mismatching.", Toast.LENGTH_SHORT).show();

        }


    }else{
        Toast.makeText(this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();

    }
});

}
}



*/
