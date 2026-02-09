package com.example.lab2_4443;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
// This activity displays detailed information about a selected item
public class DetailActivity extends AppCompatActivity {
//TEST
    // Keys used to receive data passed from another activity via Intent
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_DESC  = "extra_desc";
    public static final String EXTRA_IMAGE = "extra_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enables edge-to-edge display (content can draw behind system bars)
        EdgeToEdge.enable(this);

        // Connects this Java file to the XML layout (activity_detail.xml)
        setContentView(R.layout.activity_detail);

        // Link UI elements from XML to Java variables
        ImageView img = findViewById(R.id.detailImage);
        TextView title = findViewById(R.id.detailTitle);
        TextView desc = findViewById(R.id.detailDesc);
        Button backButton = findViewById((R.id.backBtn));

        // Intent carried data to the other webpage, get the Intent that started this activity
        Intent intent = getIntent();

        // Retrieve the data sent from the previous activity
        String t = intent.getStringExtra(EXTRA_TITLE);   // Item title
        String d = intent.getStringExtra(EXTRA_DESC);    //Item description
        int imageRes = intent.getIntExtra(EXTRA_IMAGE, 0);    // Image resource ID (0 = default if missing)

        //Check for Nulls
        if (t == null || t.trim().isEmpty()) {
            t = "Untitled";
        }
        if (d == null || d.trim().isEmpty()) {
            d = "No description available.";
        }

        // Set the received data into the UI
        title.setText(t);
        desc.setText(d);

        // Sets placeholder icon when value is 0
        if (imageRes != 0) {
            img.setImageResource(imageRes);
        } else {
            img.setImageResource(android.R.drawable.ic_menu_report_image);
        }

        //Go back to main activity when back button is clicked
        backButton.setOnClickListener(v -> finish());

    }
}
