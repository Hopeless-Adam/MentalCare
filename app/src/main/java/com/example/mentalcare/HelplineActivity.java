package com.example.mentalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HelplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        final TextView HelplineText = findViewById(R.id.HelplineText);

        HelplineText.setText("United Kingdom:\n" +
                "https://www.nhs.uk/mental-health/nhs-voluntary-charity-services/charity-and-voluntary-services/get-help-from-mental-health-helplines/\n" +
                "\n" +
                "United States:\n" +
                "https://www.nami.org/Support-Education/NAMI-HelpLine/Top-HelpLine-Resources\n" +
                "\n" +
                "Europe:\n" +
                "https://www.mhe-sme.org/library/youth-helplines/\\n" +
                "\"");

        HelplineText.setMovementMethod(LinkMovementMethod.getInstance());

        //Button back to main page
        final ImageButton backButton = findViewById(R.id.helplineBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DataActivity = new Intent(HelplineActivity.this, DataActivity.class);
                startActivity(DataActivity);
            }
        });



    }
}