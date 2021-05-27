package com.example.karismatuitioncentre.yuran;


        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.EditText;
        import android.widget.SearchView;
        import android.widget.Toast;

        import com.example.karismatuitioncentre.R;
        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;

public class Yuran_Activity_Test extends AppCompatActivity
{
    RecyclerView recview;
    YuranAdapter_test adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuran_test);
        setTitle("");

        recview= findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<yuran_model_test> options =
                new FirebaseRecyclerOptions.Builder<yuran_model_test>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("User_list"), yuran_model_test.class)
                        .build();

        adapter=new YuranAdapter_test(options);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<yuran_model_test> options =
                new FirebaseRecyclerOptions.Builder<yuran_model_test>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("User_list").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), yuran_model_test.class)
                        .build();

        adapter=new YuranAdapter_test(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}