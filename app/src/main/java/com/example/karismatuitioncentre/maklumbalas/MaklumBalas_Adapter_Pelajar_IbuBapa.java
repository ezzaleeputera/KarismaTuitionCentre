package com.example.karismatuitioncentre.maklumbalas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MaklumBalas_Adapter_Pelajar_IbuBapa extends FirebaseRecyclerAdapter<MaklumBalas_Model,
        MaklumBalas_Adapter_Pelajar_IbuBapa.myviewholder>
{
    public MaklumBalas_Adapter_Pelajar_IbuBapa(@NonNull FirebaseRecyclerOptions<MaklumBalas_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull MaklumBalas_Model model)
    {
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_maklumbalas_pelajar_ibubapa,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView title,desc;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            title= itemView.findViewById(R.id.textView_mbTitle);
            desc= itemView.findViewById(R.id.textView_mbDesc);

        }
    }
}

