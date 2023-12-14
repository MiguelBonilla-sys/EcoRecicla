package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class loginApp extends AppCompatActivity {
    Button login, backInicio;
    EditText emailLogin, passLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login =findViewById(R.id.InciarSesionLogin);
        emailLogin=findViewById(R.id.editTextTextEmailAddress);
        passLogin=findViewById(R.id.editTextTextPassword2);
        backInicio=findViewById(R.id.backInicio);
        backInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginApp.this, mainApp.class);
                startActivity(intent);
            }
        });

        Intent home= new Intent(this, Home.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emailLogin.getText().toString().isEmpty() &&
                        !passLogin.getText().toString().isEmpty()){
                    if(checkUser(emailLogin.getText().toString(),passLogin.getText().toString())){
                        startActivity(home);
                    }else {
                        Toast.makeText(getApplicationContext(),"El Email o contraseña no validos",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Los campos deben estar completos",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public boolean checkUser(String user, String pass){
    File file= new File(getFilesDir(), "userData.txt");
    if (!file.exists()) {
        Toast.makeText(getApplicationContext(),"El archivo de datos del usuario no existe",Toast.LENGTH_LONG).show();
        return false;
    }
    try{
        BufferedReader reader= new BufferedReader(new FileReader(file));
        String line;
        while((line=reader.readLine())!= null){
            String [] userData=line.split(",");
            String Name=userData[0];
            String email=userData[1];
            String password=userData[2];

            if(email.equals(user) || Name.equals(user) && password.equals(pass)){
                return true;
            }
        }
    }catch (Exception e){
        Toast.makeText(getApplicationContext(),"Error al leer el archivo de datos del usuario: " + e.getMessage(),Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
    return false;
}
}