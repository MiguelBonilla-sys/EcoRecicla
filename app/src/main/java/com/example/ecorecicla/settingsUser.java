package com.example.ecorecicla;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class settingsUser extends AppCompatActivity {
    public ImageButton homeButton;
    public ImageButton categoriesButton;
    public ImageButton statisticsButton;
    public ImageButton communityButton;
    public EditText nameED, emailED, passwordED;
    public Button saveButton;
    public TextView nameTV;
    public Button DownButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);

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

        nameED = findViewById(R.id.editTextTextPersonName);
        emailED = findViewById(R.id.editTextTextEmailAddress2);
        passwordED = findViewById(R.id.edittextPassword);
        nameTV = findViewById(R.id.textViewNameUser);
        saveButton = findViewById(R.id.btnActua);
        DownButton = findViewById(R.id.btnDownSession);

        File UserFile = new File("userData.txt");
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            String name = sharedPreferences.getString("name", "");
            String email = sharedPreferences.getString("email", "");
            String password = sharedPreferences.getString("password", "");

            nameTV.setText(name);
            nameED.setText(name);
            emailED.setText(email);
            passwordED.setText(password);
        } else {
            nameED.setText("");
            emailED.setText("");
            passwordED.setText("");
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén los datos de los campos EditText
                String name = nameED.getText().toString();
                String email = emailED.getText().toString();
                String password = passwordED.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.apply();
                try {
                    File file = new File(getFilesDir(), "userData.txt");
                    FileWriter writer = new FileWriter(file, false); // false to overwrite the file
                    writer.write(name + "," + email + "," + password);
                    writer.close();
                } catch (IOException e) {
                    Toast.makeText(settingsUser.this, "Error al guardar los datos en el archivo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                nameTV.setText(name);
                Toast.makeText(settingsUser.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
            }
        });
        DownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Establecer isLoggedIn en false en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Opcional: Muestra un mensaje de confirmación
                Toast.makeText(settingsUser.this, "Sesión cerrada", Toast.LENGTH_SHORT).show();

                // Opcional: Redirige al usuario a la pantalla de inicio de sesión
                Intent intent = new Intent(settingsUser.this, loginApp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}