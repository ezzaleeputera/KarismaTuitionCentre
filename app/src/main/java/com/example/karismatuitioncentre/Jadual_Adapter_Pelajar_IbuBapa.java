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

public class Jadual_Adapter_Pelajar_IbuBapa extends FirebaseRecyclerAdapter<Jadual_Model, Jadual_Adapter_Pelajar_IbuBapa.myviewholder>
{


    public Jadual_Adapter_Pelajar_IbuBapa(@NonNull FirebaseRecyclerOptions<Jadual_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull Jadual_Model model)
    {
        holder.subjek.setText(model.getSubjek());
        holder.pengajar.setText(model.getPengajar());
        holder.masa.setText(model.getMasa());


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_hari_pelajar_ibubapa,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView subjek,pengajar,masa;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            subjek=(TextView)itemView.findViewById(R.id.textView_jSubjek);
            pengajar=(TextView)itemView.findViewById(R.id.textView_jPengajar);
            masa=(TextView)itemView.findViewById(R.id.textView_jMasa);
        }
    }
}

