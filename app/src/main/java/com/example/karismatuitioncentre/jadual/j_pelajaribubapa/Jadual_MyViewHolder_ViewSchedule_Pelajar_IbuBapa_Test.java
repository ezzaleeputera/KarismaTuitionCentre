package com.example.karismatuitioncentre.jadual.j_pelajaribubapa;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test extends RecyclerView.ViewHolder {
    TextView subjek,pengajar,masaS,masaE;
//    ImageButton btnEditSlot,btnDeleteSlot;
    View v;

    public Jadual_MyViewHolder_ViewSchedule_Pelajar_IbuBapa_Test(@NonNull View itemView) {
        super(itemView);
        subjek=(TextView)itemView.findViewById(R.id.textView_jSubjek_S);
        pengajar=(TextView)itemView.findViewById(R.id.textView_jPengajar_S);
        masaS=(TextView)itemView.findViewById(R.id.tvShow_masaStart_S);
        masaE=(TextView)itemView.findViewById(R.id.tvShow_masaEnd_S);
//        btnEditSlot=itemView.findViewById(R.id.btnEditSlot);
//        btnDeleteSlot=itemView.findViewById(R.id.btnDeleteSlot);
        v=itemView;

    }
}
