package com.example.karismatuitioncentre.kehadiran.k_pelajar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Kehadiran_MyViewHolder_ViewKehadiran_Pelajar extends RecyclerView.ViewHolder {
    TextView subjekHist,pengajarHist,masaSHist,masaEHist,tarikhSHist;
    View v;

    public Kehadiran_MyViewHolder_ViewKehadiran_Pelajar(@NonNull View itemView) {
        super(itemView);
        subjekHist= itemView.findViewById(R.id.subjekHist);
        pengajarHist= itemView.findViewById(R.id.pengajarHist);
        masaSHist= itemView.findViewById(R.id.masaSHist);
        masaEHist= itemView.findViewById(R.id.masaEHist);
        tarikhSHist= itemView.findViewById(R.id.tarikhSHist);

        v=itemView;

    }
}
