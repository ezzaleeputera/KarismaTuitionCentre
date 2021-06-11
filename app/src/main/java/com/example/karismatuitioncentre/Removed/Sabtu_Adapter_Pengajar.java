/*

package com.example.karismatuitioncentre.Removed;


        import android.app.AlertDialog;
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

        import java.util.Objects;


public class Sabtu_Adapter_Pengajar extends FirebaseRecyclerAdapter<Jadual_Model_Pengajar,
        Sabtu_Adapter_Pengajar.myviewholder>
{
    public Sabtu_Adapter_Pengajar(@NonNull FirebaseRecyclerOptions<Jadual_Model_Pengajar> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int a, @NonNull Jadual_Model_Pengajar model)
    {
        holder.subjek.setText(model.getSubjek());
        holder.pengajar.setText(model.getPengajar());
        holder.masa.setText(model.getMasa());

        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(holder.subjek.getContext());
            builder.setTitle("Panel Delete");
            builder.setMessage("Anda pasti mahu buang(delete) subjek tersebut bagi hari ini?");

            builder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("Jadual_Sabtu")
                    .child(Objects.requireNonNull(getRef(a).getKey())).removeValue());

            builder.setNegativeButton("No", (dialogInterface, i) -> {

            });

            builder.show();
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_hari_pengajar,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView subjek,pengajar,masa;
        ImageView delete;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            subjek=(TextView)itemView.findViewById(R.id.textView_jSubjek);
            pengajar=(TextView)itemView.findViewById(R.id.textView_jPengajar);
            masa=(TextView)itemView.findViewById(R.id.tvShow_masaStart);
            delete=(ImageView)itemView.findViewById(R.id.deleteiconMB);
        }
    }
}

*/
