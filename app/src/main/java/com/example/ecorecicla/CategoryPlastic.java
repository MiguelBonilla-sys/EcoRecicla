package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryPlastic extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_plastic);

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