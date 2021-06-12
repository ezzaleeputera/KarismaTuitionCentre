package com.example.karismatuitioncentre.register.reg_ibubapa;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Register_MyViewHolder_SearchExisting_Pengajar extends RecyclerView.ViewHolder {
    TextView nama,kp,email;
    View v;

    public Register_MyViewHolder_SearchExisting_Pengajar(@NonNull View itemView) {
        super(itemView);
        nama= itemView.findViewById(R.id.nametext);
        email= itemView.findViewById(R.id.emailtext);
        kp= itemView.findViewById(R.id.KPtext);
        v=itemView;


    }
}
