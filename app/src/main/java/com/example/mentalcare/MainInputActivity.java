package com.example.mentalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainInputActivity extends AppCompatActivity {
    int index = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        final Button MoodDec = findViewById(R.id.MoodDec);
        final Button MoodInc = findViewById(R.id.MoodInc);
        final TextView MoodDisplay = findViewById(R.id.MoodDisplay);
        final EditText commentBox = findViewById(R.id.commentBox);
        final ImageView InputImage = findViewById(R.id.InputImage);

        //Mood counter
        String listOfMoods[] = {"Stressed", "Angry", "Sad", "Okay", "Relaxed","Happy", "Very Happy"};
        MoodDisplay.setText(listOfMoods[index]);
        InputImage.setImageResource(R.drawable.normalemoji);

        MoodDec.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    MoodDisplay.setText(listOfMoods[index]);
                } else {
                    index--;
                    MoodDisplay.setText(listOfMoods[index]);
                }
                if (index == 0.0) {
                    InputImage.setImageResource(R.drawable.stressedemoji);
                } else if (index == 1.0) {
                    InputImage.setImageResource(R.drawable.angryemoji);
                } else if (index == 2.0) {
                    InputImage.setImageResource(R.drawable.sademoji);
                } else if (index == 3.0) {
                    InputImage.setImageResource(R.drawable.normalemoji);
                } else if (index == 4.0) {
                    InputImage.setImageResource(R.drawable.relaxedemoji);
                } else if (index == 5.0) {
                    InputImage.setImageResource(R.drawable.happyemoji);
                } else if (index == 6.0) {
                    InputImage.setImageResource(R.drawable.veryhappyemoji);
                }
            }
        }));
        MoodInc.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != 6) {
                    index++;
                    MoodDisplay.setText(listOfMoods[index]);
                } else {
                    MoodDisplay.setText(listOfMoods[index]);
                }
                if (index == 0.0) {
                    InputImage.setImageResource(R.drawable.stressedemoji);
                } else if (index == 1.0) {
                    InputImage.setImageResource(R.drawable.angryemoji);
                } else if (index == 2.0) {
                    InputImage.setImageResource(R.drawable.sademoji);
                } else if (index == 3.0) {
                    InputImage.setImageResource(R.drawable.normalemoji);
                } else if (index == 4.0) {
                    InputImage.setImageResource(R.drawable.relaxedemoji);
                } else if (index == 5.0) {
                    InputImage.setImageResource(R.drawable.happyemoji);
                } else if (index == 6.0) {
                    InputImage.setImageResource(R.drawable.veryhappyemoji);
                }
            }
        }));


        //Button back to main page
        final ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DataActivity = new Intent(MainInputActivity.this, DataActivity.class);
                startActivity(DataActivity);
            }
        });

        //Submit button
        final Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntryModel entryModel;
                try {
                    entryModel = new EntryModel(-1,MoodDisplay.getText().toString(),3,commentBox.getText().toString());
                    Intent DataActivity = new Intent(MainInputActivity.this, DataActivity.class);
                    startActivity(DataActivity);
                } catch(Exception e) {
                    entryModel = new EntryModel(-1,"Error",0,"Error");
                    Toast toast = Toast.makeText(MainInputActivity.this,"Error creating entry, try again", Toast.LENGTH_LONG);
                    toast.show();
                }
                //Adds entry to database
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainInputActivity.this);
                boolean success = dataBaseHelper.addOne(entryModel);
                if (success) {
                    Toast.makeText(MainInputActivity.this, "Added", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}