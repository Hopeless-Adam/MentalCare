package com.example.mentalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DailyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        final TextView DailyText= findViewById(R.id.DailyText);
        final ImageView DailyImage = findViewById(R.id.DailyMoodImage);

        Double XVal = getIntent().getExtras().getDouble("XCoord_Daily");
        Double YVal = getIntent().getExtras().getDouble("YCoord_Daily");

        if (YVal == 1.0) {
            DailyImage.setImageResource(R.drawable.stressedemoji);
        } else if (YVal == 2.0) {
            DailyImage.setImageResource(R.drawable.angryemoji);
        } else if (YVal == 3.0) {
            DailyImage.setImageResource(R.drawable.sademoji);
        } else if (YVal == 4.0) {
            DailyImage.setImageResource(R.drawable.normalemoji);
        } else if (YVal == 5.0) {
            DailyImage.setImageResource(R.drawable.relaxedemoji);
        } else if (YVal == 6.0) {
            DailyImage.setImageResource(R.drawable.happyemoji);
        } else if (YVal == 7.0) {
            DailyImage.setImageResource(R.drawable.veryhappyemoji);
        }

        DataBaseHelper dataBaseHelper = new DataBaseHelper(DailyActivity.this);
        List<EntryModel> all = dataBaseHelper.getAllEntrys();

        DailyText.setText(all.get(XVal.intValue()).toString());








        //Button back to main page
        final ImageButton backButton = findViewById(R.id.DailyBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DataActivity = new Intent(DailyActivity.this, DataActivity.class);
                startActivity(DataActivity);
            }
        });

    }
}