package com.example.karismatuitioncentre.prestasi.p_pengajar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;

public class Prestasi_MyViewHolder_ViewTestResult_Pengajar extends RecyclerView.ViewHolder {
    TextView tvNoTest,tvTestMarks,tvtarikh;

    View v;

    public Prestasi_MyViewHolder_ViewTestResult_Pengajar(@NonNull View itemView) {
        super(itemView);
        tvNoTest= itemView.findViewById(R.id.tvNoTest);
        tvTestMarks= itemView.findViewById(R.id.tvTestMarks);
        tvtarikh= itemView.findViewById(R.id.tvtarikh);
        v=itemView;

    }
}
