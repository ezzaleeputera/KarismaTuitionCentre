package com.example.karismatuitioncentre.prestasi.p_pelajar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Prestasi_MyViewHolder_ViewRemarks_Pelajar extends RecyclerView.ViewHolder {
    TextView tvTitleRemarks,tvRemarks,tvtarikh;

    View v;

    public Prestasi_MyViewHolder_ViewRemarks_Pelajar(@NonNull View itemView) {
        super(itemView);
        tvTitleRemarks= itemView.findViewById(R.id.tvTitleRemarks);
        tvRemarks= itemView.findViewById(R.id.tvRemarks);
        tvtarikh= itemView.findViewById(R.id.tvtarikh);
        v=itemView;

    }
}
