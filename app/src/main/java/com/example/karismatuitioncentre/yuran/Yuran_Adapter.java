package com.example.karismatuitioncentre.yuran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Yuran_Adapter extends FirebaseRecyclerAdapter<Users_Model,
        Yuran_Adapter.myviewholder>
{
    public Yuran_Adapter(@NonNull FirebaseRecyclerOptions<Users_Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int mbID, @NonNull Users_Model model)
    {
        holder.userName.setText(model.getNama());
        holder.userIC.setText(model.getKp());
        holder.userEmail.setText(model.getEmail());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_user_list,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView userName,userEmail,userIC;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            userName= itemView.findViewById(R.id.tvName);
            userEmail= itemView.findViewById(R.id.tvEmail);
            userIC= itemView.findViewById(R.id.tvIC);


        }
    }
}

