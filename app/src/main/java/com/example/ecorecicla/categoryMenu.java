package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Models.GlassDataRecycling;
import com.example.ecorecicla.Models.MetalDataRecycling;
import com.example.ecorecicla.Models.PaperDataRecycling;
import com.example.ecorecicla.Models.PlasticDataRecycling;
import com.example.ecorecicla.Models.TextilDataRecycling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class categoryMenu extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;

    public Button Glass, Paper, Plastic, Metals, Textiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);

        // Get references to the buttons
        homeButton = findViewById(R.id.imageButtonHome);
        categoriesButton = findViewById(R.id.imageButtonCategorys);
        statisticsButton = findViewById(R.id.imageButtonEstadistcs);
        communityButton = findViewById(R.id.imageButtonCommunity);

        // Create an instance of BarMenu
        BarMenu barMenu = new BarMenu(homeButton, categoriesButton, statisticsButton, communityButton);

        // Call the methods for each button
        barMenu.goToHome(homeButton, this);
        barMenu.goToCategories(categoriesButton, this);
        barMenu.goToEstadistics(statisticsButton, this);
        barMenu.goToConsejos(communityButton, this);

        Glass = findViewById(R.id.buttonNextGlass);
        Paper = findViewById(R.id.buttonNextPaper);
        Plastic = findViewById(R.id.buttonNextPlastic);
        Textiles = findViewById(R.id.buttonNextTextile);
        Metals = findViewById(R.id.buttonNextMetal);

        Glass.setOnClickListener(v -> {
            Intent intent = new Intent(categoryMenu.this, CategoryGlass.class);
            startActivity(intent);
        });

        Paper.setOnClickListener(v -> {
            Intent intent = new Intent(categoryMenu.this, categoryPapel.class);
            startActivity(intent);
        });

        Plastic.setOnClickListener(v -> {
            Intent intent = new Intent(categoryMenu.this, CategoryPlastic.class);
            startActivity(intent);
        });

        Textiles.setOnClickListener(v -> {
            Intent intent = new Intent(categoryMenu.this, CategoryTextil.class);
            startActivity(intent);
        });

        Metals.setOnClickListener(v -> {
            Intent intent = new Intent(categoryMenu.this, CategoryMetal.class);
            startActivity(intent);
        });

        File fileGlass=new File(getFilesDir(), "Glass.txt");
        getGlass(fileGlass);

        File fileMetal=new File(getFilesDir(), "Metal.txt");
        getMetal(fileMetal);

        File filePaper=new File(getFilesDir(), "Paper.txt");
        getPaper(filePaper);

        File filePlastic=new File(getFilesDir(), "Plastic.txt");
        getPlastic(filePlastic);

        File fileTextil=new File(getFilesDir(), "Textil.txt");
        getTextil(fileTextil);
    }

    public void getGlass(File glass){
        try (BufferedReader br = new BufferedReader(new FileReader(glass))){
            String line;
            while ((line=br.readLine())!=null){
                String[] values=line.split(",");
                GlassDataRecycling glassDataRecycling= new GlassDataRecycling(values[0],values[1],values[2],values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMetal(File metal){
        try (BufferedReader br = new BufferedReader(new FileReader(metal))){
            String line;
            while ((line=br.readLine())!=null){
                String[] values=line.split(",");
                MetalDataRecycling metalDataRecycling= new MetalDataRecycling(values[0],values[1],values[2],values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPaper(File paper){
        try (BufferedReader br = new BufferedReader(new FileReader(paper))){
            String line;
            while ((line=br.readLine())!=null){
                String[] values=line.split(",");
                PaperDataRecycling paperDataRecycling= new PaperDataRecycling(values[0],values[1],values[2],values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPlastic(File plastic){
        try (BufferedReader br = new BufferedReader(new FileReader(plastic))){
            String line;
            while ((line=br.readLine())!=null){
                String[] values=line.split(",");
                PlasticDataRecycling plasticDataRecycling= new PlasticDataRecycling(values[0],values[1],values[2],values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTextil(File textil){
        try (BufferedReader br = new BufferedReader(new FileReader(textil))){
            String line;
            while ((line=br.readLine())!=null){
                String[] values=line.split(",");
                TextilDataRecycling textilDataRecycling= new TextilDataRecycling(values[0],values[1],values[2],values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}