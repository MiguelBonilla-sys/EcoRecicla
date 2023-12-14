package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;

public class CategoryMetal extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;

    public EditText kg, month;
    public TextView price;
    public Button registerCob, btnAluminio;

    public String type = "cobre";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_metal);
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

        month = findViewById(R.id.editTextDateMetal);
        kg = findViewById(R.id.editTextNumberDecimalMetal);
        price = findViewById(R.id.textViewTotalMetal);
        registerCob = findViewById(R.id.buttonSaveMetal);
        Double FACTOR = 3850.0;

        registerCob.setOnClickListener(view -> {
            if (!month.getText().toString().isEmpty() &&
                    !kg.getText().toString().isEmpty() && !price.getText().toString().isEmpty() ) {
                type = "Cobre"; // Set type to "Carton" before writing to the file
                File file = new File(getFilesDir(), "Metal.txt");
                double priceValue = 0.0;
                try{
                    FileWriter writer = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    priceValue = Double.parseDouble(kg.getText().toString()) * FACTOR;
                    String consumo = type + ";" +month.getText().toString() + ";" +
                            kg.getText().toString() + ";" +
                            String.format(Locale.getDefault(), "%.2f", priceValue) + ";";
                    bufferedWriter.write(consumo);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (Exception e) {
                    Toast.makeText(this, "Error saving record: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                price.setText(String.format(Locale.getDefault(), "%.2f", priceValue));
                kg.setText("");
                month.setText("");

            } else {
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
            }
        });


        btnAluminio = findViewById(R.id.buttonAluminio);
        btnAluminio.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryMetal.this, CategoryMetal2Al.class);
            startActivity(intent);
        });

    }
}