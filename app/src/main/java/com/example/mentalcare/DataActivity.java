package com.example.mentalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {
    String listOfMoods[] = {"Stressed", "Angry", "Sad", "Okay", "Relaxed","Happy", "Very Happy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(DataActivity.this);
        List<Integer> XCoordList = dataBaseHelper.getAllEntryXCoords();
        List<String> allEntryMoods = dataBaseHelper.getAllEntryMoods();
        List<Integer> YCoordList = new ArrayList<>();



        // Navigation buttons from main page
        final Button newdayButton= findViewById(R.id.newdayButton);
        newdayButton.setOnClickListener((new View.OnClickListener() {
                public void onClick(View v) {
                Intent MainInputActivity = new Intent(DataActivity.this, MainInputActivity.class);
                startActivity(MainInputActivity);
            }
        }));

        final Button helplineButton= findViewById(R.id.helplineButton);
        helplineButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent HelplineActivity = new Intent(DataActivity.this, HelplineActivity.class);
                    startActivity(HelplineActivity);

            }
        });

        for (String value: allEntryMoods) {
            if (value.equals("Stressed")) {
                YCoordList.add(1);
            } else if (value.equals("Angry")) {
                YCoordList.add(2);
            } else if (value.equals("Sad")) {
                YCoordList.add(3);
            } else if (value.equals("Okay")) {
                YCoordList.add(4);
            } else if (value.equals("Relaxed")) {
                YCoordList.add(5);
            } else if (value.equals("Happy")) {
                YCoordList.add(6);
            } else if (value.equals("Very Happy")) {
                YCoordList.add(7);
            }
        }


        //creating and filling the graph
        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        int numOfEntrys = XCoordList.size();
        for (int i=0; i<numOfEntrys;i++) {
            Double X = Double.valueOf(i);
            Double Y=Double.valueOf(YCoordList.get(i));
            series.appendData(new DataPoint(X,Y),true,31);
        }
        graph.addSeries(series);
        graph.getViewport().setScalable(true);

        //styling series
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);


        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Intent DailyActivity = new Intent(DataActivity.this, DailyActivity.class);

                Double XCoord_Daily = dataPoint.getX();
                Double YCoord_Daily = dataPoint.getY();

                DailyActivity.putExtra("XCoord_Daily", XCoord_Daily);
                DailyActivity.putExtra("YCoord_Daily", YCoord_Daily);

                startActivity(DailyActivity);
            }
        });


    }
}