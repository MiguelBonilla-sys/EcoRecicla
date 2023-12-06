package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class loginApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button EntrarApp = findViewById(R.id.InciarSesionLogin);

        EntrarApp.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(loginApp.this, Home.class);
                startActivity(intent);
            }
        });

        // Button RecordarContraseña = findViewById(R.id.offPassword);
        // Button VolverInicio = findViewById(R.id.backInicio);



    }
}