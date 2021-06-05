/*
package com.example.karismatuitioncentre.yuran.y_ibubapa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.karismatuitioncentre.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;

public class Yuran_Activity_IbuBapa extends AppCompatActivity {
    StorageReference storageReference;
    DatabaseReference databaseReference;
    EditText etNamaPembayar,etNamaBank,etJumlah,etTarikh,etUploadURL;
    Button */
/*btnSubmit,*//*
btnUpload;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran);

        etNamaPembayar=findViewById(R.id.namaPembayar);
        etNamaBank=findViewById(R.id.namaBank);
        etJumlah=findViewById(R.id.jumlahPembayaran);
        etTarikh=findViewById(R.id.tarikhPembayaran);
        etUploadURL=findViewById(R.id.etUploadURL);
//        btnSubmit=findViewById(R.id.btn_selesaiPembayaran);
        btnUpload=findViewById(R.id.btn_buktiPembayaran);
        
        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("uploadPdf");
        
    btnUpload.setEnabled(false);
    
    etUploadURL.setOnClickListener(view -> selectPdF());
    }

    private void selectPdF() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF File SELECT"),12);
    }
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            btnUpload.setEnabled(true);
            etUploadURL.setText(data.getDataString().substring(data.getDataString().lastIndexOf(".")+1));

            btnUpload.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    uploadPDFFileFirebase(data.getData());
                }
            });

        }
    }

    private void uploadPDFFileFirebase(Uri data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("PDF File: Loading......");
        progressDialog.show();

        StorageReference reference=storageReference.child("upload"+System.currentTimeMillis()+".pdf");

        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri= uriTask.getResult();
                assert uri != null;
//                putPdf_USEDTOBE putPdf =new putPdf_USEDTOBE(etNamaPembayar.getText().toString(),etNamaBank.getText().toString(),etJumlah.getText().toString(),etTarikh.getText().toString(),uri.toString());
//                databaseReference.child(Objects.requireNonNull(databaseReference.push().getKey())).setValue(putPdf);
//                Toast.makeText(Yuran_Activity_IbuBapa.this, "PDF File: Uploading......", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("PDF File: Uploaded"+(int) progress+ "%");

            }
        });
    }
}
*/
