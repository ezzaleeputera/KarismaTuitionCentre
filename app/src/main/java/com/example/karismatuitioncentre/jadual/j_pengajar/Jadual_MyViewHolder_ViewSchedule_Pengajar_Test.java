package com.example.karismatuitioncentre.jadual.j_pengajar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Jadual_MyViewHolder_ViewSchedule_Pengajar_Test extends RecyclerView.ViewHolder {
    TextView subjek_P,pengajar_P,masaS_P,masaE_P;
    ImageButton delete_P,edit_P;
    View v;

    public Jadual_MyViewHolder_ViewSchedule_Pengajar_Test(@NonNull View itemView) {
        super(itemView);
        subjek_P=(TextView)itemView.findViewById(R.id.textView_jSubjek_P);
        pengajar_P=(TextView)itemView.findViewById(R.id.textView_jPengajar_P);
        masaS_P=(TextView)itemView.findViewById(R.id.tvShow_masaStart_P);
        masaE_P=(TextView)itemView.findViewById(R.id.tvShow_masaEnd_P);
        edit_P= itemView.findViewById(R.id.btnEditSlot_P);
        delete_P= itemView.findViewById(R.id.btnDeleteSlot_P);
        v=itemView;

    }
}
