package com.example.karismatuitioncentre.maklumbalas;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.karismatuitioncentre.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class MaklumBalas_Adapter_Pengajar extends FirebaseRecyclerAdapter<MaklumBalas_Model,
        MaklumBalas_Adapter_Pengajar.myviewholder>
{
    public MaklumBalas_Adapter_Pengajar(@NonNull FirebaseRecyclerOptions<MaklumBalas_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull MaklumBalas_Model model)
    {
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(holder.title.getContext());
            builder.setTitle("Padam Maklum Balas");
            builder.setMessage("Anda pasti untuk memadam maklum balas ini?");

            builder.setPositiveButton("Ya", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("MaklumBalas_List")
                    .child(Objects.requireNonNull(getRef(mbID).getKey())).removeValue());

            builder.setNegativeButton("Tidak", (dialogInterface, i) -> {

            });

            builder.show();
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_maklumbalas_pengajar,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView title,desc;
        ImageView delete;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            title= itemView.findViewById(R.id.textView_mbTitle);
            desc= itemView.findViewById(R.id.textView_mbDesc);
            delete= itemView.findViewById(R.id.deleteicon);
        }
    }
}

