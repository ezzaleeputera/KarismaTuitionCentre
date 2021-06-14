package com.example.karismatuitioncentre.kehadiran.k_pengajar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Kehadiran_MyViewHolder_SearchStudent_Pengajar extends RecyclerView.ViewHolder {
    TextView nama,kp,email;
    View v;

    public Kehadiran_MyViewHolder_SearchStudent_Pengajar(@NonNull View itemView) {
        super(itemView);
        nama= itemView.findViewById(R.id.nametext);
        kp= itemView.findViewById(R.id.KPtext);
        email= itemView.findViewById(R.id.emailtext);
        v=itemView;


    }
}
