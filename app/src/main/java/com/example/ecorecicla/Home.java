package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    public ImageButton userSettings;
    public Button PaperButton;
    public Button CartonButton;
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userSettings = findViewById(R.id.button4);
        userSettings.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(Home.this, settingsUser.class);
            startActivity(intent);
        });

        PaperButton = findViewById(R.id.buttonPaper);
        PaperButton.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(Home.this, categoryPapel.class);
            startActivity(intent);
        });

        CartonButton = findViewById(R.id.buttonCarton);
        CartonButton.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(Home.this, categoryCarton.class);
            startActivity(intent);
        });

        // Get references to the buttons
        homeButton = findViewById(R.id.imageButtonHome);
        categoriesButton = findViewById(R.id.imageButtonCategorys);
        statisticsButton = findViewById(R.id.imageButtonEstadistcs);
        communityButton = findViewById(R.id.imageButtonComunity);

        // Create an instance of BarMenu
        BarMenu barMenu = new BarMenu(homeButton, categoriesButton, statisticsButton, communityButton);

        // Call the methods for each button
        barMenu.goToHome(homeButton, this);
        barMenu.goToCategories(categoriesButton, this);
        barMenu.goToEstadistics(statisticsButton, this);
        barMenu.goToConsejos(communityButton, this);
    }
}