/*
package com.example.karismatuitioncentre.jadual.j_pelajaribubapa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.jadual.Jadual_Model_Pengajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Jadual_Adapter_ViewSchedule_Pelajar_IbuBapa_Test extends FirebaseRecyclerAdapter<Jadual_Model_Pengajar,
        Jadual_MyViewHolder_ViewSchedule_Pengajar_Test.myviewholder>
{


    public Jadual_Adapter_ViewSchedule_Pelajar_IbuBapa_Test(@NonNull FirebaseRecyclerOptions<Jadual_Model_Pengajar> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull Jadual_Model_Pengajar model)
    {
        holder.subjek.setText(model.getSubjek());
        holder.pengajar.setText(model.getPengajar());
        holder.masa.setText(model.getMasa());


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_hari_pelajar_ibubapa,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView subjek,pengajar,masa;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            subjek=(TextView)itemView.findViewById(R.id.textView_jSubjek);
            pengajar=(TextView)itemView.findViewById(R.id.textView_jPengajar);
            masa=(TextView)itemView.findViewById(R.id.textView_jMasa);
        }
    }
}

*/
