package com.example.karismatuitioncentre;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class MaklumBalas_Adapter_Pengajar extends FirebaseRecyclerAdapter<MaklumBalas_Model, MaklumBalas_Adapter_Pengajar.myviewholder>
{
    public MaklumBalas_Adapter_Pengajar(@NonNull FirebaseRecyclerOptions<MaklumBalas_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull MaklumBalas_Model model)
    {
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.title.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("MaklumBalas_List")
                                .child(getRef(mbID).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
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

            title=(TextView)itemView.findViewById(R.id.textView_mbTitle);
            desc=(TextView)itemView.findViewById(R.id.textView_mbDesc);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }
}

