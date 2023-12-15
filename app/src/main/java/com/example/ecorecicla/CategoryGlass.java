package com.example.ecorecicla;

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

public class CategoryGlass extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;
    public EditText kg, month;
    public TextView price;
    public Button registerGlass;
    public String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_glass);

        homeButton = findViewById(R.id.imageButtonHome);
        categoriesButton = findViewById(R.id.imageButtonCategorys);
        statisticsButton = findViewById(R.id.imageButtonEstadistcs);
        communityButton = findViewById(R.id.imageButtonComunity);

        BarMenu barMenu = new BarMenu(homeButton, categoriesButton, statisticsButton, communityButton);

        barMenu.goToHome(homeButton, this);
        barMenu.goToCategories(categoriesButton, this);
        barMenu.goToEstadistics(statisticsButton, this);
        barMenu.goToConsejos(communityButton, this);

        month = findViewById(R.id.editDateGlass);
        kg = findViewById(R.id.editNumberGlassWeight);
        price = findViewById(R.id.textView15);
        registerGlass = findViewById(R.id.buttonSaveSellGlass);
        Double FACTOR = 2000.0;

        registerGlass.setOnClickListener(view -> {
            if (!month.getText().toString().isEmpty() &&
                    !kg.getText().toString().isEmpty() && !price.getText().toString().isEmpty() ) {
                type = "Glass"; // Set type to "Carton" before writing to the file
                File file = new File(getFilesDir(), "Glass.txt");
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

    }
}