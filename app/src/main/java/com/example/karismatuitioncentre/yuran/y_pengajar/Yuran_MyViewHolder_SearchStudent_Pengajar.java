package com.example.karismatuitioncentre.yuran.y_pengajar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Yuran_MyViewHolder_SearchStudent_Pengajar extends RecyclerView.ViewHolder {
    TextView nama,kp,email;
    View v;

    public Yuran_MyViewHolder_SearchStudent_Pengajar(@NonNull View itemView) {
        super(itemView);
        nama= itemView.findViewById(R.id.nametext);
        kp= itemView.findViewById(R.id.KPtext);
        email= itemView.findViewById(R.id.emailtext);
        v=itemView;


    }
}
