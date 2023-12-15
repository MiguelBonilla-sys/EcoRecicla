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

public class categoryCarton extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;
    public EditText kg, month;
    public TextView price;
    public Button registerCart, btnPapel;

    public String type = "carton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_carton);

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

        month = findViewById(R.id.editTextDate);
        kg = findViewById(R.id.editTextNumberDecimal);
        price = findViewById(R.id.textView15);
        registerCart = findViewById(R.id.button3);
        Double FACTOR = 1850.0;

        registerCart.setOnClickListener(view -> {
            if (!month.getText().toString().isEmpty() &&
                    !kg.getText().toString().isEmpty() && !price.getText().toString().isEmpty() ) {
                type = "Carton"; // Set type to "Carton" before writing to the file
                File file = new File(getFilesDir(), "Paper.txt");
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


        btnPapel = findViewById(R.id.button);
        btnPapel.setOnClickListener(v -> {
            Intent intent = new Intent(categoryCarton.this, categoryPapel.class);
            startActivity(intent);
        });
    }
}