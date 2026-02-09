package com.example.lab2_4443;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //This ArrayList holds all the content we will send to the RecyclerView for binding
    ArrayList<ItemModel> itemModel = new ArrayList<>();
    //This int list stores all the images
    //R gives each image in R.drawable a unique identifier ID therefore associated to numbers rather than an image
    int [] itemImages = {R.drawable.annabeth, R.drawable.ares, R.drawable.athena, R.drawable.chiron, R.drawable.clarisse,
            R.drawable.dionysus, R.drawable.grover, R.drawable.hermes, R.drawable.luke, R.drawable.medusa,
            R.drawable.percy, R.drawable.poseidon, R.drawable.tantalus, R.drawable.thalia, R.drawable.tyson};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupItemModel();

        SimpleAdapter adapter = new SimpleAdapter(this, itemModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    //Pulling out hardcoded values(image, title, description) and placing them into arraylist
    //Passing in using R java//TEST TEST TEST
    private void setupItemModel(){
        String [] title = getResources().getStringArray(R.array.list_title_txt);
        String [] desc = getResources().getStringArray(R.array.list_desc_txt);
        String [] detailedDesc = getResources().getStringArray(R.array.list_desc_detailed_text);
        String [] detailedTitle = getResources().getStringArray(R.array.list_title_full_txt);
        //This for loop goes through each text file and adds to the arrayList
        for(int i=0; i<title.length; i++){
            itemModel.add(new ItemModel(title[i], desc[i], itemImages[i], detailedDesc[i], detailedTitle[i]));

        }
    }
}