package com.example.karismatuitioncentre.prestasi.p_ibubapa;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karismatuitioncentre.R;
import com.example.karismatuitioncentre.prestasi.Prestasi_TestMarks_Model;
import com.example.karismatuitioncentre.prestasi.p_pelajar.Prestasi_MyViewHolder_ViewTestResult_Pelajar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Prestasi_Activity_ViewTestResult_IbuBapa extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    LineChart lineChart;
    LineDataSet lineDataSet= new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets= new ArrayList<>();
    LineData lineData;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Prestasi_TestMarks_Model> options;
    FirebaseRecyclerAdapter<Prestasi_TestMarks_Model, Prestasi_MyViewHolder_ViewTestResult_IbuBapa> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi_linechart_pelajar_test);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Laman Markah Ujian");
        String Sub_Key=getIntent().getStringExtra("Sub_Key");
        String User_Key=getIntent().getStringExtra("User_Key");



        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        options= new FirebaseRecyclerOptions.Builder<Prestasi_TestMarks_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child(Sub_Key)
                        .child("Test_List").orderByChild("userid").equalTo(User_Key), Prestasi_TestMarks_Model.class)
                .build();

        lineChart=findViewById(R.id.lineChartView);
        databaseReference= FirebaseDatabase.getInstance().getReference(Sub_Key);
        retrieveData(User_Key);
        lineChart.setDrawGridBackground(true);
        lineChart.setDrawBorders(true);
        lineChart.setBorderWidth(5);
        lineChart.animateXY(1000, 3000);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisRight().setAxisMinimum(0);
        lineChart.getAxisLeft().setAxisMinimum(0);
        lineChart.setNoDataText("Tiada rekod ujian lagi");
        lineChart.setNoDataTextColor(ContextCompat.getColor(this, R.color.black));

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(13, true);
        xAxis.setAxisMaximum(12f);
//        xAxis.setAxisMinimum(0f);

        YAxis yAxis = new YAxis();


        lineDataSet.setMode(LineDataSet.Mode.LINEAR);//Set the display mode of the line graph, you can set the above values ​​to see the difference.
        lineDataSet.setColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));//Set the color of the line
        lineDataSet.setLineWidth(2.5f);//Set the width of the line
        lineDataSet.setCircleColor(ContextCompat.getColor(this, android.R.color.holo_red_light));//Set the color of the circle
        lineDataSet.setCircleHoleColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));//Set the color of the inner hole of the circle
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);//Set line data depends on the left y axis
        lineDataSet.setDrawFilled(true);//Set the shadow layer without data overlay
        lineDataSet.setDrawValues(true);//Do not draw line data
        // lineDataSet.setValueTextColor(ContextCompat.getColor(this, R.color.text_color));//Set the text color of the data, if you do not draw the data of the line, this code does not need to be set.
        lineDataSet.setValueTextSize(0f);//If you do not draw the data of the line, this code does not need to be set.
        lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);//I didn’t see the effect
        lineDataSet.setFormLineWidth(10f);//only when lineDataSet.setForm(Legend.LegendForm.LINE); is useful. Here we set the circle so the code directly comments
        lineDataSet.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));//Set the dotted line, only when lineDataSet.setForm(Legend.LegendForm.LINE);
        lineDataSet.setCircleRadius(4f);//Set the size of each polyline point
        lineDataSet.setFormSize(15.f);//Set the size of the current line's legend
        lineDataSet.setForm(Legend.LegendForm.LINE);//Set the legend as a line

        Description description=new Description();
        description.setText("Prestasi");
        description.setTextColor(Color.BLUE);
        description.setTextSize(20);
        description.setXOffset(10);
        description.setYOffset(10);
        lineChart.setDescription(description);

        adapter=new FirebaseRecyclerAdapter<Prestasi_TestMarks_Model, Prestasi_MyViewHolder_ViewTestResult_IbuBapa>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Prestasi_MyViewHolder_ViewTestResult_IbuBapa holder, int position, @NonNull Prestasi_TestMarks_Model model) {
                holder.tvNoTest.setText(Integer.toString(model.getxValue()));
                holder.tvTestMarks.setText(Integer.toString(model.getyValue()));
                holder.tvtarikh.setText(model.getDateTest());

            }

            @NonNull
            @Override
            public Prestasi_MyViewHolder_ViewTestResult_IbuBapa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_prestasi_viewtest,parent,false);


                return new Prestasi_MyViewHolder_ViewTestResult_IbuBapa(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
    private void retrieveData(String User_Key){
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();



        databaseReference.child("Test_List").orderByChild("userid").equalTo(User_Key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Entry> dataVals= new ArrayList<>();

                if(snapshot.hasChildren()){
                    for(DataSnapshot myDataSnapshot : snapshot.getChildren()){
                        Prestasi_TestMarks_Model prestasi=myDataSnapshot.getValue(Prestasi_TestMarks_Model.class);
                        assert prestasi != null;
                        dataVals.add(new Entry(prestasi.getxValue(),prestasi.getyValue()));
                    }

                    showChart(dataVals);
                }else{
                    lineChart.clear();
                    lineChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void showChart(ArrayList<Entry> dataVals){
        lineDataSet.setValues(dataVals);
        lineDataSet.setLabel("BM Performance");
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData=new LineData(iLineDataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();

    }
}