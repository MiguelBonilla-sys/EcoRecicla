package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Consejos extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;
    public TextView consejos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

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

        File file = new File(getFilesDir(), "consejos.txt");
        try{
            FileWriter writer = new FileWriter(file);
            String[] consejos = {
                    "Separa papel, plástico, vidrio y metal para facilitar el reciclaje.",
                    "Reduce y reutiliza antes de reciclar, minimizando residuos.",
                    "Conoce las normativas locales para un reciclaje eficiente.",
                    "Recicla dispositivos electrónicos en centros especializados.",
            };
            writer.append("Mantente informado para adoptar prácticas más sostenibles."+"\n");
            for(String consejo : consejos){
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        consejos = findViewById(R.id.textView13);
        List<String> consejosList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                consejosList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!consejosList.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(consejosList.size());
            String randomConsejo = consejosList.get(randomIndex);
            consejos.setText(randomConsejo);
        }
    }

}