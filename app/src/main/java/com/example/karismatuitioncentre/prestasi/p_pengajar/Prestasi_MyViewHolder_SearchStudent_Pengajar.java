package com.example.karismatuitioncentre.prestasi.p_pengajar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Prestasi_MyViewHolder_SearchStudent_Pengajar extends RecyclerView.ViewHolder {
    TextView nama,kp;
    View v;

    public Prestasi_MyViewHolder_SearchStudent_Pengajar(@NonNull View itemView) {
        super(itemView);
        nama= itemView.findViewById(R.id.nametext);
        kp= itemView.findViewById(R.id.KPtext);
        v=itemView;


    }
}
