package com.example.karismatuitioncentre.yuran;


        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.karismatuitioncentre.R;
        import com.firebase.ui.database.FirebaseRecyclerAdapter;
        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.google.firebase.database.FirebaseDatabase;


public class YuranAdapter_test extends FirebaseRecyclerAdapter<yuran_model_test,YuranAdapter_test.myviewholder>
{
    public YuranAdapter_test(@NonNull FirebaseRecyclerOptions<yuran_model_test> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull yuran_model_test model) {
        holder.nama.setText(model.getNama());
        holder.kp.setText(model.getKp());
        holder.email.setText(model.getEmail());
    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_yuran_test,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView nama,kp,email;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            nama= itemView.findViewById(R.id.nametext);
            kp= itemView.findViewById(R.id.KPtext);
            email= itemView.findViewById(R.id.emailtext);
        }
    }
}
