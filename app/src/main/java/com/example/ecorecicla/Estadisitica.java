package com.example.ecorecicla;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Models.GlassDataRecycling;
import com.example.ecorecicla.Models.MetalDataRecycling;
import com.example.ecorecicla.Models.PaperDataRecycling;
import com.example.ecorecicla.Models.PlasticDataRecycling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estadisitica extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;
    public TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisitica);

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

        table = findViewById(R.id.tableEstadistic);
        File GlassFile = new File(getFilesDir(), "Glass.txt");
        File MetalFile = new File(getFilesDir(), "Metal.txt");
        File PaperFile = new File(getFilesDir(), "Paper.txt");
        File PlasticFile = new File(getFilesDir(), "Plastic.txt");
        File TextilFile = new File(getFilesDir(), "Textil.txt");

        List<GlassDataRecycling> GlassList = readGlassFile(GlassFile);
        addGlassData(GlassList);

        List<MetalDataRecycling> MetalList = readMetalFile(MetalFile);
        addMetalData(MetalList);

        List<PaperDataRecycling> PaperList = readPaperFile(PaperFile);
        addPaperData(PaperList);

        List<PlasticDataRecycling> PlasticList = readPlasticFile(PlasticFile);
        addPlasticData(PlasticList);

        List<PlasticDataRecycling> TextilList = readTextilFile(TextilFile);
        addTextilData(TextilList);
    }

    public static List<GlassDataRecycling> readGlassFile(File file){
        List<GlassDataRecycling> GlassList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                GlassDataRecycling glassDataRecycling = new GlassDataRecycling(parts[0], parts[1], parts[2], parts[3]);
                GlassList.add(glassDataRecycling);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GlassList;
    }

    public void addGlassData(List<GlassDataRecycling> GlassList){
        for (GlassDataRecycling i:GlassList) {
            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setText(i.getDate());
            date.setWidth(80);
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setBackgroundResource(R.color.white);

            TextView Type = new TextView(this);
            Type.setText(i.getType());
            Type.setWidth(90);
            Type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Type.setBackgroundResource(R.color.white);

            TextView Weight = new TextView(this);
            Weight.setText(i.getWeight());
            Weight.setWidth(50);
            Weight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Weight.setBackgroundResource(R.color.white);

            TextView Precio = new TextView(this);
            String precioText = i.getPrecio();
            if (precioText != null && !precioText.isEmpty()) {
                Precio.setText(precioText);
            } else {
                Precio.setText("N/A"); // or any default value
            }
            Precio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Precio.setWidth(90);
            Precio.setBackgroundResource(R.color.white);

            row.addView(date);
            row.addView(Type);
            row.addView(Weight);
            row.addView(Precio);
            table.addView(row);
        }
    }

    public static List<MetalDataRecycling> readMetalFile(File file){
        List<MetalDataRecycling> MetalList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                MetalDataRecycling metalDataRecycling = new MetalDataRecycling(parts[0], parts[1], parts[2], parts[3]);
                MetalList.add(metalDataRecycling);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MetalList;
    }

    public void addMetalData(List<MetalDataRecycling> MetalList){
        for (MetalDataRecycling i:MetalList) {
            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setText(i.getDate());
            date.setWidth(80);
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setBackgroundResource(R.color.white);

            TextView Type = new TextView(this);
            Type.setText(i.getType());
            Type.setWidth(90);
            Type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Type.setBackgroundResource(R.color.white);

            TextView Weight = new TextView(this);
            Weight.setText(i.getWeight());
            Weight.setWidth(50);
            Weight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Weight.setBackgroundResource(R.color.white);

            TextView Precio = new TextView(this);
            String precioText = i.getPrecio();
            if (precioText != null && !precioText.isEmpty()) {
                Precio.setText(precioText);
            } else {
                Precio.setText("N/A"); // or any default value
            }
            Precio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Precio.setWidth(90);
            Precio.setBackgroundResource(R.color.white);

            row.addView(date);
            row.addView(Type);
            row.addView(Weight);
            row.addView(Precio);
            table.addView(row);
        }
    }

    public static List<PaperDataRecycling> readPaperFile(File file){
        List<PaperDataRecycling> PaperList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                PaperDataRecycling paperDataRecycling = new PaperDataRecycling(parts[0], parts[1], parts[2], parts[3]);
                PaperList.add(paperDataRecycling);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PaperList;
    }

    public void addPaperData(List<PaperDataRecycling> PaperList){
        for (PaperDataRecycling i:PaperList) {
            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setText(i.getDate());
            date.setWidth(80);
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setBackgroundResource(R.color.white);

            TextView Type = new TextView(this);
            Type.setText(i.getType());
            Type.setWidth(90);
            Type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Type.setBackgroundResource(R.color.white);

            TextView Weight = new TextView(this);
            Weight.setText(i.getWeight());
            Weight.setWidth(50);
            Weight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Weight.setBackgroundResource(R.color.white);

            TextView Precio = new TextView(this);
            String precioText = i.getPrecio();
            if (precioText != null && !precioText.isEmpty()) {
                Precio.setText(precioText);
            } else {
                Precio.setText("N/A"); // or any default value
            }
            Precio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Precio.setWidth(90);
            Precio.setBackgroundResource(R.color.white);

            row.addView(date);
            row.addView(Type);
            row.addView(Weight);
            row.addView(Precio);
            table.addView(row);
        }
    }

    public static List<PlasticDataRecycling> readPlasticFile(File file){
        List<PlasticDataRecycling> PlasticList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                PlasticDataRecycling plasticDataRecycling = new PlasticDataRecycling(parts[0], parts[1], parts[2], parts[3]);
                PlasticList.add(plasticDataRecycling);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PlasticList;
    }

    public void addPlasticData(List<PlasticDataRecycling> PlasticList){
        for (PlasticDataRecycling i:PlasticList) {
            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setText(i.getDate());
            date.setWidth(80);
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setBackgroundResource(R.color.white);

            TextView Type = new TextView(this);
            Type.setText(i.getType());
            Type.setWidth(90);
            Type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Type.setBackgroundResource(R.color.white);

            TextView Weight = new TextView(this);
            Weight.setText(i.getWeight());
            Weight.setWidth(50);
            Weight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Weight.setBackgroundResource(R.color.white);

            TextView Precio = new TextView(this);
            String precioText = i.getPrecio();
            if (precioText != null && !precioText.isEmpty()) {
                Precio.setText(precioText);
            } else {
                Precio.setText("N/A"); // or any default value
            }
            Precio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Precio.setWidth(90);
            Precio.setBackgroundResource(R.color.white);

            row.addView(date);
            row.addView(Type);
            row.addView(Weight);
            row.addView(Precio);
            table.addView(row);
        }
    }

    public static List<PlasticDataRecycling> readTextilFile(File file){
        List<PlasticDataRecycling> TextilList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                PlasticDataRecycling plasticDataRecycling = new PlasticDataRecycling(parts[0], parts[1], parts[2], parts[3]);
                TextilList.add(plasticDataRecycling);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TextilList;
    }

    public void addTextilData(List<PlasticDataRecycling> TextilList){
        for (PlasticDataRecycling i:TextilList) {
            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setText(i.getDate());
            date.setWidth(80);
            date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            date.setBackgroundResource(R.color.white);

            TextView Type = new TextView(this);
            Type.setText(i.getType());
            Type.setWidth(90);
            Type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Type.setBackgroundResource(R.color.white);

            TextView Weight = new TextView(this);
            Weight.setText(i.getWeight());
            Weight.setWidth(50);
            Weight.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Weight.setBackgroundResource(R.color.white);

            TextView Precio = new TextView(this);
            String precioText = i.getPrecio();
            if (precioText != null && !precioText.isEmpty()) {
                Precio.setText(precioText);
            } else {
                Precio.setText("N/A"); // or any default value
            }
            Precio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Precio.setWidth(90);
            Precio.setBackgroundResource(R.color.white);

            row.addView(date);
            row.addView(Type);
            row.addView(Weight);
            row.addView(Precio);
            table.addView(row);
        }
    }
}